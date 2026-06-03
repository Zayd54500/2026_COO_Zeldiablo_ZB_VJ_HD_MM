package zldiablo;

/**
 * Représente la sortie du labyrinthe.
 *
 * La sortie est inactive au début de la partie.
 * Elle devient active lorsque le joueur atteint le score nécessaire.
 * Une fois active, elle devient traversable et permet de gagner la partie.
 */
public class Sortie implements Case{
    private boolean active;

    /**
     * Crée une sortie inactive.
     */
    public Sortie() {
        this.active = false;
    }

    /**
     * Active la sortie du labyrinthe.
     */
    public void activer() {
        this.active = true;
    }

    /**
     * Indique si la sortie est active.
     *
     * @return true si la sortie est active, false sinon.
     */
    public boolean estActive() {
        return this.active;
    }

    /**
     * Indique si la sortie peut être traversée.
     *
     * La sortie est traversable uniquement lorsqu'elle est active.
     *
     * @return true si la sortie est active, false sinon.
     */
    public boolean etreTraversable() {
        return this.active;
    }

    /**
     * Retourne le caractère représentant la sortie.
     *
     * @return le caractère 's'.
     */
    public char getNom() {
        return 's';
    }

    /**
     * Ne fait rien car la sortie ne peut pas être prise.
     */
    public void etrePris() {
        //vide
    }

    /**
     * Indique que la sortie n'est jamais considérée comme prise.
     *
     * @return toujours false.
     */
    public boolean getPris() {
        return false;
    }
}
