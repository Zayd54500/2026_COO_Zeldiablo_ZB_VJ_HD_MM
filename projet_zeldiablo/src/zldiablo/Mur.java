package zldiablo;

/**
 * Représente un mur dans le labyrinthe
 *
 * Un mur bloque le déplacement du joueur et ne peut pas être traversé
 */
public class Mur implements Case {
    /**
     * Indique qu'un mur n'est pas traversable.
     *
     * @return toujours false.
     */
    public boolean etreTraversable(){
        return false;
    }

    /**
     * Retourne le caractère représentant un mur.
     *
     * @return le caractère 'm'.
     */
    public char getNom(){
        return 'm';
    }

    /**
     * Ne fait rien car un mur ne peut pas être pris.
     */
    public void etrePris(){}

    /**
     * Représente un piège dans le labyrinthe.
     *
     * Un piège est traversable, mais il inflige des dégâts au joueur
     * lorsqu'il marche dessus.
     */
    public boolean getPris(){
        return false;
    }
}
