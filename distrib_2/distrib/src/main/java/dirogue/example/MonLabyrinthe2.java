package dirogue.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dirogue.example.code_squelette.*;

/**
 * La classe MonLabyrinthe2 implémente l'interface Labyrinthe et Serializable.
 * Elle représente un labyrinthe composé de pièces et de corridors qui les
 * relient.
 * Cette classe gère les pièces, les corridors, et fournit des méthodes pour
 * ajouter
 * de nouvelles pièces, relier des pièces par des corridors, obtenir des
 * informations
 * sur les pièces connectées et vérifier l'existence de corridors entre des
 * pièces.
 */
public class MonLabyrinthe2 implements Labyrinthe, Serializable {
    private List<Piece> pieces;
    private Map<Integer, List<Integer>> adjList;

     /**
     * Constructeur de la classe MonLabyrinthe2 initialisant la liste des pièces et l'adjacence.
     */
    public MonLabyrinthe2() {
        pieces = new ArrayList<>();
        adjList = new HashMap<>();
    }

    public Piece[] getPieces() {
        return pieces.toArray(new Piece[0]);
    }

    public int nombreDePieces() {
        return pieces.size();
    }

    public void ajouteEntree(Exterieur out, Piece e) {
        pieces.add(out);
        pieces.add(e);
        addEdge(out, e);
    }

    public void ajouteCorridor(Piece e1, Piece e2) {
        if (getPieceByID(e1.getID()) == null)
            pieces.add(e1);

        if (getPieceByID(e2.getID()) == null)
            pieces.add(e2);

        addEdge(e1, e2);
    }

    public void ajouteCorridor(int e1ID, int e2ID) throws PieceNotFoundException {
        //TODO: Ajouter un corridor entre deux pièces avec les identifiants fournis FAIT

        if (e1ID < 0 || e2ID < 0){ //on ne trouvera JAMAIS de piece negative pas logique ca
            throw new PieceNotFoundException();
        }
        Piece e1 = getPieceByID(e1ID); //je pet la piece avec ce id (si elle existe hein)
        if (e1 == null){
            throw new PieceNotFoundException(); //on ajoutera pas de corridor avec un p1 = existe pas
        }

        Piece e2 = getPieceByID(e2ID);
        if (e2 == null){
            throw new PieceNotFoundException(); //On ajoutera pas de corridor avec p2 = existe pas
        }

        //SINON C'EST BON
        addEdge(e1, e2);
    }

    /**
     * Méthode pour ajouter une nouvelle pièce au labyrinthe.
     *
     * @param e La pièce à ajouter.
     * @return L'index de la pièce ajoutée.
     */
    public int ajoutePiece(Piece e) {
        if (!pieces.contains(e)) {
            pieces.add(e);
        }
        return pieces.indexOf(e);
    }

    public boolean existeCorridorEntre(Piece e1, Piece e2) {
        return adjList.containsKey(e1.getID()) && adjList.get(e1.getID()).contains(e2.getID());
    }

    /**
     * Méthode pour obtenir les pièces connectées à une pièce spécifique.
     *
     * @param e La pièce dont les pièces connectées sont recherchées.
     * @return Un tableau de pièces connectées à la pièce donnée.
     */
    public Piece[] getPiecesConnectees(Piece e) {
        //TODO: Trouver les pièces connectées

        ArrayList<Piece> PiecesConnecteesAL= new ArrayList<Piece>(0); //initialement jai une arraylist de Pieces vide
        List<Integer> IdPiecesConnectees = adjList.get(e.getID()); // la jai la liste des id des pieces connectee a e via la methode get des adjacences du labyrinthe

        for(Integer i : IdPiecesConnectees){ // a ce stade j'ai un array [id1 id2 id...] qui sont les id des pieces connectees
            PiecesConnecteesAL.add(getPieceByID(i)); //pour chaque id, je l'Ajoute dans l'Arraylist des pieces
        }
        //la jai un arraylist de pieces, mais je dois retourner un ARRAY SIMPLE de pieces

        Piece[] PiecesConnectees = new Piece[PiecesConnecteesAL.size()];
        for (int i = 0; i < PiecesConnecteesAL.size(); i++) {
            PiecesConnectees[i] = PiecesConnecteesAL.get(i);
        }
        //a ce stade jai mit toutes les pieces du arraylist dans l'array
        return PiecesConnectees;
    }

    private void addEdge(Piece e1, Piece e2) {
        adjList.computeIfAbsent(e1.getID(), k -> new ArrayList<>()).add(e2.getID());
        adjList.computeIfAbsent(e2.getID(), k -> new ArrayList<>()).add(e1.getID());
    }

    private Piece getPieceByID(int ID) {
        for (Piece piece : pieces) {
            if (piece.getID() == ID) {
                return piece;
            }
        }
        return null;
    }
}
