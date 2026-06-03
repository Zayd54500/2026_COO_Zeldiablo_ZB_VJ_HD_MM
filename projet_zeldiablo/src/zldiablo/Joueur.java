package zldiablo;

/**
 * Représente le joueur contrôlé dans le jeu.
 *
 * Le joueur possède une position, des points de vie et un score.
 * Il peut se déplacer dans le labyrinthe, récupérer des pièces,
 * subir des dégâts et mourir si sa vie atteint 0.
 */

public class Joueur implements Personnage{
    private int posX;
    private int posY;
    private int vie;
    private int score;

    /**
     * Crée un joueur avec 3 points de vie et une position de départ en (1, 1).
     */
    public Joueur(){
        this.vie = 3;
        this.posX = 1;
        this.posY = 1;
    }

    /**
     * Déplace le joueur dans le labyrinthe selon la direction donnée.
     *
     * Le déplacement est effectué uniquement si la case visée est traversable.
     * Après le déplacement, la méthode vérifie si le joueur marche sur un piège
     * ou récupère une pièce.
     *
     * @param dir la direction du déplacement : 'N' pour nord, 'S' pour sud,
     *            'E' pour est ou 'O' pour ouest.
     * @param laby le labyrinthe dans lequel le joueur se déplace.
     */
    public void deplacement(char dir, Labyrinth laby) {
        switch (dir){
            case 'N' :
                if(this.posY>0 && laby.getCase(this.posX, this.posY-1).etreTraversable()){
                    this.posY-=1;
                }
                break;
            case 'S' :
                if(this.posY<laby.getTailleY()-1 && laby.getCase(this.posX, this.posY+1).etreTraversable()){
                    this.posY+=1;
                }
                break;
            case 'O' :
                if(this.posX>0 && laby.getCase(this.posX-1, this.posY).etreTraversable()){
                    this.posX-=1;
                }
                break;
            case 'E' :
                if(this.posX<laby.getTailleX()-1 && laby.getCase(this.posX+1, this.posY).etreTraversable()){
                    this.posX+=1;
                }
                break;
        }
        if(laby.getCase(this.posX, this.posY).getNom()=='p'){
            this.subirDegats(1);
        } else {
            if(laby.getCase(this.posX, this.posY).getNom()=='c' && !laby.getCase(this.posX, this.posY).getPris()) {
                this.augmenterScore(100);
                laby.getCase(this.posX, this.posY).etrePris();
            }
        }
    }

    /**
     * Augmente le score du joueur.
     *
     * @param s le nombre de points à ajouter au score.
     */
    public void augmenterScore(int s){
        this.score += s;
        System.out.println("Le joueur à gagner " + s + " de score !");
    }

    /**
     * Retire des points de vie au joueur.
     *
     * Si les points de vie deviennent négatifs, ils sont remis à 0.
     * Un message est affiché si le joueur meurt.
     *
     * @param degats le nombre de dégâts subis.
     */
    public void subirDegats(int degats) {
        if (degats > 0) {
            this.vie -= degats;
            if (this.vie < 0) {
                this.vie = 0;
            }
            System.out.println("Le joueur à subit " + degats + " degats");
            if (this.estMort()) {
                System.out.println("Le joueur est décédé");
            }
        }
    }

    /**
     * Indique si le joueur est mort.
     *
     * @return true si la vie du joueur est inférieure ou égale à 0, false sinon.
     */
    public boolean estMort() {
        if (this.vie <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Retourne les points de vie du joueur.
     *
     * @return la vie actuelle du joueur.
     */
    public int getVie() {
        return this.vie;
    }

    /**
     * Retourne la position horizontale du joueur.
     *
     * @return la coordonnée X du joueur.
     */
    public int getPosX(){
        return this.posX;
    }

    /**
     * Retourne la position verticale du joueur.
     *
     * @return la coordonnée Y du joueur.
     */
    public int getPosY(){
        return this.posY;
    }

    /**
     * Retourne le score actuel du joueur.
     *
     * @return le score du joueur.
     */
    public int getScore(){
        return this.score;
    }
}
