package main;

import moteurJeu.Commande;

public class Jeu implements moteurJeu.Jeu {
    private Labyrinth laby;
    private Personnage joueur;
    public Jeu(){
        this.laby = new Labyrinth();
        this.joueur = new Joueur();
    }
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
    }

    @Override
    public boolean etreFini() {
        return false;
    }
}
