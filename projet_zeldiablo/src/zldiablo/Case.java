package zldiablo;

/**
 * Représente une case du labyrinthe
 *
 * Une case peut être un mur, une case vide, un piège ou une pièce mais aussi une sortie
 * Chaque type de case définis son comportement : traversable ou non, symbole utilisé pour l'affichage
 */
public interface Case {
    /**
     * Retourne le caractère représentant le type de la case
     *
     * @return le caractère associé à la case
     */
    public boolean etreTraversable();

    /**
     * Retourne le caractère représentant le type de la case.
     *
     * @return le caractère associé à la case.
     */
    public char getNom();

    /**
     * Indique si la case a déjà été prise
     *
     * @return true si la case a déjà été prise, false sinon
     */
    public void etrePris();

    /**
     * Indique si la case a déjà été prise.
     *
     * @return true si la case a déjà été prise, false sinon.
     */
    public boolean getPris();
}
