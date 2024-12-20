package dirogue.example.rencontre;

import dirogue.example.code_squelette.RencontreType;

/**
 * sous class qui represente une rencontre avec un tresor de type Artefacte Magique
 * herite de la class {@link Tresor}
 */
public class ArtefactMagique extends Tresor {

    /**
     * Message a retourner en cas de rencontre avec un Artefacte Magique
     * @return message de rencontre
     */
    @Override
    public String rencontre() {
        return "Artefact Magique! Quelle chance!";
    }

    /**
     * chemin de l'image associe au type de rencontre "ArtefactMagique"
     * @return chemin du fichier vers l'image.
     */
    @Override
    public String getSprite() {
        return "distrib/src/main/resources/images/ArtefactMagique.png";
    }

    /**
     * essence de ArtefactMagique
     * @return retourne le type de rencontre
     */
    @Override
    public RencontreType essence() {
        return RencontreType.TRESOR;
    }

}
