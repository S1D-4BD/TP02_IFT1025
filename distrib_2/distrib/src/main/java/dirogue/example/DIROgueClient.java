package dirogue.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Classe représentant un client pour l'application DIROgue. Ce client se
 * connecte à un serveur spécifique et peut envoyer des commandes pour charger,
 * sauvegarder des fichiers ou quitter l'application.
 */
public class DIROgueClient {
	public static void main(String[] args) {
		String serverAddress = "127.0.0.1";
		int serverPort = 1370;

		Socket socket = null;
		PrintWriter out = null; // utilisé pour écrire dans le socket avec des commandes comme println()

		// TODO: Se connecter au serveur FAIT.

		try{
			socket = new Socket(serverAddress, serverPort);
			System.out.println("Connexion a " + serverAddress);

			out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch(IOException e){
			e.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);
		String input;

		while (true) {
			System.out.println("Entrer une commande (load, save, exit):");
			input = scanner.nextLine().trim();

			if (input.equals("load")) {
				System.out.println("Entrez le chemin du fichier que vous souhaitez charger :");

				// TODO: Lire le fichier et envoyer les commandes au serveur ligne par ligne.
				//donc je dois m assurer que le fichier existe et que ya pas d erreurs

				//la je trim la COMMANDE du fichier, pas la commande cote client
				String cheminCommande = scanner.nextLine().trim();
				try {
					BufferedReader br = new BufferedReader(new FileReader(cheminCommande));
					String s;

					while((s= br.readLine())!=null){
						out.println(s); //ici on envoie au serveur la ligne lue
						System.out.println(s); //pour tester cest pas utile sinon
					}

					br.close();

				} catch (FileNotFoundException e) {
					System.out.println("Erreur de fichier : pas existant " + e.getMessage());
                    throw new RuntimeException(e);//l erreur si le fichier est pas trouve
                } catch (IOException e) {
					System.out.println("Erreur de fichier : mauvaise lecture qqpart " + e.getMessage());
                    throw new RuntimeException(e);//l erreur de lecture (s pas correct)
                }


            } else if (input.equals("save")) {
				System.out.println(" Entrez le chemin où vous voulez sauvegarder le rapport :");
				var reportPath = scanner.nextLine().trim();
				out.println(input + " " + reportPath);

			} else if (input.equals("exit")) {
				out.println(input);
				break;
			} else {
				System.out.println("Commande non valide. Veuillez entrer 'load', 'save' ou 'exit'.");
			}
		}

		System.out.println("Sortie du programme.");
        scanner.close();
        if (out != null) {
            out.close();
        }
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
