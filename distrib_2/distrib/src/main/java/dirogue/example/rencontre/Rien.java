package dirogue.example.rencontre;

import dirogue.example.code_squelette.RencontreType;

/**
 * sous class qui represente une rencontre pacifique, ou il y a rien exactement qui se passe
 * herite de la class {@link Rencontre}
 */
public class Rien extends Rencontre {

    /**
     * Message a retourner en cas de rencontre pacifique
     * @return message de rencontre
     */
    @Override
    public String rencontre() {
        return "Un moment pacifique.";
    }


    /**
     * chemin de l'image associe au type de rencontre "Rien"
     * @return chemin du fichier vers l'image qui represente la rencontre paisible "Rien".
     */
    @Override
    public String getSprite() {
        return "src/main/resources/images/Rien.png";
    }


    /**
     * essence de Rien
     * @return retourne le type de rencontre
     */
    @Override
    public RencontreType essence() {
        return RencontreType.RIEN;
    }
}
