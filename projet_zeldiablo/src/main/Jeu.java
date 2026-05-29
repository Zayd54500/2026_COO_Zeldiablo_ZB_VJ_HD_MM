package main;

import moteurJeu.Commande;

public class Jeu implements moteurJeu.Jeu {
    private Labyrinth laby;
    private Personnage joueur;
    public Jeu(Joueur pj, Labyrinth l){
        this.laby = l;
        this.joueur = pj;
    }


    @Override
    public void evoluer(Commande c){
        switch(c.hashCode()){
            case c.haut : this.joueur.deplacement('N', this.laby);
        }
    }

    @Override
    public boolean etreFini() {
        return false;
    }
}
