package dirogue.example;

import java.io.IOException;

import dirogue.example.code_squelette.*;

/**
 * Classe représentant le serveur pour l'application DIROgue.
 * Ce serveur écoute les commandes provenant du client, telles que la création
 * de pièces, l'ajout de corridors, la fin de la création du labyrinthe, la
 * sauvegarde du rapport d'aventure, etc.
 */
public class DIROgueServer {
	static boolean exterieurAjoute = false;
	static MonLabyrinthe2 l = new MonLabyrinthe2();
	static MonAventure m = null;

	public static void main(String[] args) {

		try {
			Server s = new Server(1370);

			s.addEventHandler((cmd, cmdArgs) -> {
				if (cmd.equals("piece")) {
					if (cmdArgs.length == 2) {
						int id = Integer.parseInt(cmdArgs[0]);
						RencontreType type = RencontreType.valueOf(cmdArgs[1].toUpperCase());
						if (!exterieurAjoute) {
							l.ajouteEntree(Exterieur.getExterieur(), new Piece(id, type));
							exterieurAjoute = true;
						} else {
							l.ajoutePiece(new Piece(id, type));
						}
					}
				}
			});

			s.addEventHandler((cmd, cmdArgs) -> {
				if (cmd.equals("CORRIDORS")) {
					System.out.println("CORRIDORS commande recue...");
				}
			});

			s.addEventHandler((cmd, cmdArgs) -> {
				if (cmd.equals("corridor")) {
					//TODO: Implémenter le handler et ajouter un corridor.
					int ide1 = Integer.parseInt(cmdArgs[0]);
					int ide2 = Integer.parseInt(cmdArgs[1]);

					try{
						l.ajouteCorridor(ide1, ide2); //C'EST ICI QUE JE CATCH LE THROW DE AJOUTECORRIDOR
					}
					catch (PieceNotFoundException e){
						System.out.println("PIECE INVALIDE : EXISTE PAS");
					}
				}
			});

			s.addEventHandler((cmd, cmdArgs) -> {
				if (cmd.equals("FIN")) {
					System.out.println("FIN commande recue...");
					m = new MonAventure(l);
				}
			});

			s.addEventHandler((cmd, cmdArgs) -> {
				//TODO: Sauvegarder le fichier de rapport de l'aventure.
				if (cmd.equals("save")) {
					try{
						//comme sauvegarderRapport peut potentiellement throw une excepton, je la catch ici
						//c'etait l erreur mentionnee dans un courriel que je voulais regler
						String cheminRapport = cmdArgs[0];  //le seul arg est le path du fichier, donc args[0] = /fichier/emplacement...txt
						m.sauvegarderRapport(cheminRapport); //no call la methode sur laventure m, qui a maintennt le param du fichier d ecriture
					}
					catch(IOException e){
						System.out.println("IO EXCEPTION"); //l exception qui est probably throwee dans sauvegarderrapp
					}

				}
			});

			s.listen();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
