package dirogue.example.rencontre;

import dirogue.example.code_squelette.RencontreType;

/**
 * Sous class qui represente une rencontre de type Gobelin
 * herite de la class {@link Monstre}
 */
public class Gobelin extends Monstre {

    /**
     * Message a retourner en cas de rencontre
     * @return message de rencontre
     */
    @Override
    public String rencontre() {
        return "Un Gobelin affreux!";
    }

    /**
     * chemin de l'image associe a Gobelin
     * @return chemin du fichier vers l'image qui represente un Gobelin.
     */
    @Override
    public String getSprite() {
        return "src/main/resources/images/Gobelin.png";
    }

    /**
     * essence de Gobelin
     * @return retourne le type de rencontre
     */
    @Override
    public RencontreType essence() {
        return RencontreType.MONSTRE;
    }
}
