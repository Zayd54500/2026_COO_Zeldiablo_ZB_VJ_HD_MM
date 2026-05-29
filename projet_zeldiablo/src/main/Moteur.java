package main;

import arkanoidJeu.ArkanoidDessin;
import arkanoidJeu.ArkanoidJeu;

public class Moteur {
    public static void main(String[] args) throws InterruptedException {
        Jeu jeu = new Jeu();
        DessinJeu aff = new DessinJeu(jeu);
    }
}
