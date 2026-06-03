import zldiablo.DessinJeu;
import zldiablo.Jeu;
import moteurJeu.MoteurGraphique;

import java.util.Scanner;

/**
 * Classe principale permettant de lancer le jeu Zeldiablo.
 *
 * Elle crée le jeu, l'affichage graphique et le moteur graphique,
 * puis lance la partie dans une fenêtre de 500 par 500 pixels.
 */
public class MainZeldiablo {
    /**
     * Point d'entrée du programme.
     *
     * Cette méthode initialise les éléments nécessaires au lancement du jeu,
     * démarre le moteur graphique puis attend l'appui sur Entrée avant de fermer.
     *
     * @param args les arguments de lancement du programme.
     * @throws InterruptedException si l'exécution du moteur est interrompue.
     */
    public static void main(String[] args) throws InterruptedException {
        Jeu jeu = new Jeu();
        DessinJeu aff = new DessinJeu(jeu);
        MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
        moteur.lancerJeu(500, 500);
        System.out.println("Fin du Jeu - appuyer sur entree");
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        System.exit(1);
    }
}
