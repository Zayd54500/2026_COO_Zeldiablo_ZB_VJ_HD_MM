package main;

import moteurJeu.Commande;

public class Jeu {
    private Labyrinth laby;
    private Personnage joueur;
    public Jeu(Joueur pj, Labyrinth l){
        this.laby = l;
        this.joueur = pj;
    }


}
