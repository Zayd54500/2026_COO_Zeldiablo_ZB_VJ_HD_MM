package zldiablo;

/**
 * Représente un personnage du jeu.
 *
 * Cette interface définit les actions et informations communes
 * à un personnage, comme le déplacement, la position, la vie,
 * le score et la gestion des dégâts.
 */

public interface Personnage {

    /**
     * Déplace le personnage dans une direction donnée si le déplacement est possible.
     *
     * @param dir la direction du déplacement : 'N', 'S', 'E' ou 'O'.
     * @param laby le labyrinthe dans lequel le personnage se déplace.
     */
    public void deplacement(char dir, Labyrinth laby);

    /**
     * Retourne la position horizontale du personnage.
     *
     * @return la coordonnée X du personnage.
     */
    public int getPosX();

    /**
     * Retourne la position verticale du personnage.
     *
     * @return la coordonnée Y du personnage.
     */
    public int getPosY();


    /**
     * Retourne le nombre de points de vie du personnage.
     *
     * @return les points de vie du personnage.
     */
    public int getVie();

    /**
     * Retourne le score du personnage.
     *
     * @return le score actuel du personnage.
     */
    public int getScore();

    /**
     * Inflige des dégâts au personnage.
     *
     * @param degats le nombre de points de vie à retirer.
     */
    public void subirDegats(int degats);

    /**
     * Indique si le personnage est mort.
     *
     * @return true si les points de vie sont inférieurs ou égaux à 0, false sinon.
     */
    public boolean estMort();
}
