package zldiablo;

import moteurJeu.Commande;

import java.io.File;
import java.io.IOException;

public class Jeu implements moteurJeu.Jeu {
    private Labyrinth laby;
    private Personnage joueur;
    public Jeu(){
        try {
            this.laby = new Labyrinth();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    public Personnage getJoueur(){
        return this.joueur;
    }
    public Labyrinth getLaby(){
        return this.laby;
    }
    @Override
    public boolean etreFini() {
        return false;
    }
}
