package zldiablo;

/**
 * Représente un piège dans le labyrinthe.
 *
 * Un piège est traversable, mais il inflige des dégâts au joueur
 * lorsqu'il marche dessus.
 */
public class Piege implements Case{

    /**
     * Indique qu'un piège est traversable.
     *
     * @return toujours true.
     */
    public boolean etreTraversable(){
        return true;
    }

    /**
     * Retourne le caractère représentant un piège.
     *
     * @return le caractère 'p'.
     */
    public char getNom(){
        return 'p';
    }

    /**
     * Indique qu'un piège n'est jamais considéré comme pris.
     *
     * @return toujours false.
     */
    public void etrePris(){}

    /**
     * Indique qu'un piège n'est jamais considéré comme pris.
     *
     * @return toujours false.
     */
    public boolean getPris(){
        return false;
    }
}
