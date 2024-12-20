package dirogue.example.rencontre;

import dirogue.example.code_squelette.RencontreType;

/**
 * Sous class qui represente une rencontre de type Orque
 * class qui herite de {@link Monstre}
 */
public class Orque extends Monstre {

    /**
     * Message a retourner en cas de rencontre
     * @return message de rencontre
     */
    @Override
    public String rencontre() {
        return "Un Orque affreux!";
    }

    /**
     * chemin de l'image associe a Orque
     * @return chemin du fichier vers l'image qui represente une Orque.
     */
    @Override
    public String getSprite() {
        return "src/main/resources/images/Orque.png";
    }


    /**
     * essence de Orque
     * @return retourne le type de rencontre
     */
    @Override
    public RencontreType essence() {
        return RencontreType.MONSTRE;
    }
    
}
