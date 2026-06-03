package zldiablo;

import moteurJeu.Commande;

import java.io.File;
import java.io.IOException;

/**
 * Représente le jeu
 *
 * Cette classe contient le labyrinthe, le joueur et l'état de victoire.
 * Elle gère l'évolution du jeu en fonction des commandes du joueur.
 */
public class Jeu implements moteurJeu.Jeu {
    private Labyrinth laby;
    private Personnage joueur;
    private boolean gagne;

    /**
     * Crée une nouvelle partie de Zeldiablo.
     *
     * Le constructeur initialise le labyrinthe, le joueur et l'état de victoire.
     */
    public Jeu(){
        try {
            this.laby = new Labyrinth();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.joueur = new Joueur();
        this.gagne = false;
    }

    /**
     * Fait évoluer le jeu selon la commande donnée.
     *
     * Cette méthode déplace le joueur, active la sortie si le score atteint
     * 1000 points, puis vérifie si le joueur se trouve sur une sortie active.
     *
     * @param c la commande entrée par le joueur.
     */
    @Override
    public void evoluer(Commande c){
        if(c.haut){
            this.joueur.deplacement('N', this.laby);
        } else if (c.bas) {
            this.joueur.deplacement('S', this.laby);
        } else if (c.droite) {
            this.joueur.deplacement('E', this.laby);
        } else if (c.gauche){
            this.joueur.deplacement('O', this.laby);
        }
        if (this.joueur.getScore() >= 1000) {
            this.laby.activerSortie();
        }
        if (this.laby.estUneSortieActive(this.joueur.getPosX(), this.joueur.getPosY())) {
            this.gagne = true;
        }
    }

    /**
     * Retourne le joueur de la partie.
     *
     * @return le personnage contrôlé par le joueur.
     */
    public Personnage getJoueur(){
        return this.joueur;
    }

    /**
     * Retourne le labyrinthe de la partie.
     *
     * @return le labyrinthe utilisé dans le jeu.
     */
    public Labyrinth getLaby(){
        return this.laby;
    }

    /**
     * Indique si la partie est terminée.
     *
     * La partie se termine si le joueur est mort ou s'il a gagné.
     *
     * @return true si la partie est finie, false sinon.
     */
    public boolean aGagne() {
        return this.gagne;
    }

    /**
     * Indique si la partie est terminée.
     *
     * La partie se termine si le joueur est mort ou s'il a gagné.
     *
     * @return true si la partie est finie, false sinon.
     */
    @Override
    public boolean etreFini() {
        return this.joueur.estMort() || this.gagne;
    }
}
