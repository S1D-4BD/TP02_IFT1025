package dirogue.example.rencontre;

import dirogue.example.code_squelette.*;

/**
 * sous class qui represente une rencontre avec un Boss
 * herite de la class {@link Gargouille} qui herite aussi de la class {@link Monstre}
 */
public class Boss extends Gargouille{

    /**
     * Message a retourner en cas de rencontre avec un boss.
     * @return message de rencontre
     */
    @Override
    public String rencontre() {
        return "La bataille finale!";
    }

    /**
     * chemin de l'image associee a Boss
     * @return chemin du fichier vers l'image qui represente le boss.
     */
    @Override
    public String getSprite() {
        return "src/main/resources/images/Boss.png";
    }


    /**
     * essence de Boss
     * @return retourne le type de rencontre
     */
    @Override
    public RencontreType essence() {
        return RencontreType.BOSS;
    }
}
