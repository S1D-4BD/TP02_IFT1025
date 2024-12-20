package dirogue.example.rencontre;

import dirogue.example.code_squelette.RencontreType;

/**
 * Sous class representant une rencontre avec une Potion
 * Herite de la classe {@link Potion}
 */
public class Potion extends Tresor {


    /**
     * Message a retourner en cas de rencontre avec Potion
     * @return message de rencontre
     */
    @Override
    public String rencontre() {
        return "Potion! Quelle chance!";
    }


    /**
     * chemin de l'image associe a la Potion
     * @return chemin du fichier vers l'image qui represente une Potion.
     */
    @Override
    public String getSprite() {
        return "src/main/resources/images/Potion.png";
    }


    /**
     * essence de Potion
     * @return retourne le type de rencontre
     */
    @Override
    public RencontreType essence() {
        return RencontreType.TRESOR;
    }
}
