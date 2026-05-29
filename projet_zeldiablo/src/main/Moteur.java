package main;

import arkanoidJeu.ArkanoidDessin;
import arkanoidJeu.ArkanoidJeu;
import moteurJeu.MoteurGraphique;

import java.util.Scanner;

public class Moteur {
    public static void main(String[] args) throws InterruptedException {
        Jeu jeu = new Jeu();
        DessinJeu aff = new DessinJeu(jeu);
        MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
        moteur.lancerJeu(400, 400);
        System.out.println("Fin du Jeu - appuyer sur entree");
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        System.exit(1);
    }
}
