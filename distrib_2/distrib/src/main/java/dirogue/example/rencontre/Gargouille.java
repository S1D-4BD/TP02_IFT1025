package dirogue.example.rencontre;

import dirogue.example.code_squelette.RencontreType;

/**
 * Sous classe qui represente une rencontre avec une Gargouille
 * Herite de la class {@link Monstre}
 */
public class Gargouille extends Monstre {

    /**
     * Message a retourner en cas de rencontre avec Gargouille
     * @return message de rencontre
     */
    @Override
    public String rencontre() {
        return "Un Gargouille affreux!";
    }

    /**
     * chemin de l'image associe a Gargouille
     * @return chemin du fichier vers l'image qui represente une gargouille.
     */
    @Override
    public String getSprite() {
        return "src/main/resources/images/Gargouille.png";
    }

    /**
     * essence de Gargouille
     * @return retourne le type de rencontre
     */
    @Override
    public RencontreType essence() {
        return RencontreType.MONSTRE;
    }
    
}
