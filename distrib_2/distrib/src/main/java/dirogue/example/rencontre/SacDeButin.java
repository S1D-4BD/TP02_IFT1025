package dirogue.example.rencontre;

import dirogue.example.code_squelette.RencontreType;

/**
 * sous class qui represente une rencontre avec un tresor de type SacDeButin
 * herite de la class {@link Tresor}
 */
public class SacDeButin extends Tresor{


    /**
     * Message a retourner en cas de rencontre avec un Sac de Butin
     * @return message de rencontre
     */
    @Override
    public String rencontre() {
        return "Sac de Butin! Quelle chance!";
    }


    /**
     * chemin de l'image associe au type de rencontre "SacDeButin"
     * @return chemin du fichier vers l'image.
     */
    @Override
    public String getSprite() {
        return "src/main/resources/images/SacDeButin.png";
    }


    /**
     * essence de Sac De Butin
     * @return retourne le type de rencontre
     */
    @Override
    public RencontreType essence() {
        return RencontreType.TRESOR;
    }
}
