package zldiablo;

/**
 * Représente une pièce dans le labyrinthe.
 *
 * Une pièce est traversable et peut être récupérée par le joueur.
 * Lorsqu'elle est prise, elle ne doit plus rapporter de score.
 */

public class Piece implements Case{
    private boolean pris;

    /**
     * Indique qu'une pièce est traversable.
     *
     * @return toujours true.
     */
    public boolean etreTraversable(){
        return true;
    }

    /**
     * Retourne le caractère représentant une pièce.
     *
     * @return le caractère 'c'.
     */
    public char getNom(){
        return 'c';
    }

    /**
     * Marque la pièce comme déjà récupérée.
     */
    public void etrePris(){
        this.pris = true;
    }

    /**
     * Indique si la pièce a déjà été récupérée.
     *
     * @return true si la pièce est prise, false sinon.
     */
    public boolean getPris(){
        return this.pris;
    }
}
