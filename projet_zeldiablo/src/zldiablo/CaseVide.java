package zldiablo;

/**
 * Représente une case vide du labyrinthe
 *
 * Une case vide est traversable, par le joueur et ne possède pas d'effet particulier
 */
public class CaseVide implements Case {

    /**
     * Indique qu'une case vide est traversable.
     *
     * @return toujours true.
     */
    public boolean etreTraversable() {
        return true;
    }

    /**
     * Retourne le caractère représentant une case vide.
     *
     * @return le caractère 'v'.
     */
    public char getNom(){
        return 'v';
    }

    /**
     * Ne fait rien car une case vide ne peut pas être prise.
     */
    public void etrePris(){
    }

    /**
     * Indique qu'une case vide n'est jamais prise.
     *
     * @return toujours false.
     */
    public boolean getPris(){
        return false;
    }
}
