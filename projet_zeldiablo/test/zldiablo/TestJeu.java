package zldiablo;

import moteurJeu.Commande;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestJeu {

    @Test
    public void testJeuCreeJoueurEtLabyrinthe() {
        Jeu jeu = new Jeu();

        assertNotNull("Le jeu doit créer un joueur", jeu.getJoueur());
        assertNotNull("Le jeu doit créer un labyrinthe", jeu.getLaby());
    }

    @Test
    public void testCommandeDroiteDeplacerJoueur() {
        Jeu jeu = new Jeu();
        Commande commande = new Commande();

        commande.droite = true;
        jeu.evoluer(commande);

        assertEquals("Le joueur doit se déplacer à droite", 2, jeu.getJoueur().getPosX());
        assertEquals("Le Y ne doit pas changer", 1, jeu.getJoueur().getPosY());
    }

    @Test
    public void testCommandeBasDeplacerJoueur() {
        Jeu jeu = new Jeu();
        Commande commande = new Commande();

        commande.bas = true;
        jeu.evoluer(commande);

        assertEquals("Le X ne doit pas changer", 1, jeu.getJoueur().getPosX());
        assertEquals("Le joueur doit se déplacer en bas", 2, jeu.getJoueur().getPosY());
    }

    @Test
    public void testCommandeHautNeSortPasDuLabyrinthe() {
        Jeu jeu = new Jeu();
        Commande commande = new Commande();

        commande.haut = true;
        jeu.evoluer(commande);

        assertEquals("Le joueur ne doit pas sortir du labyrinthe", 1, jeu.getJoueur().getPosX());
        assertEquals("Le joueur ne doit pas sortir du labyrinthe", 1, jeu.getJoueur().getPosX());
    }

    @Test
    public void testCommandeGaucheNeSortPasDuLabyrithe() {
        Jeu jeu = new Jeu();
        Commande commande = new Commande();

        commande.gauche = true;
        jeu.evoluer(commande);

        assertEquals("Le joueur ne doit pas sortir du labyrinthe", 1, jeu.getJoueur().getPosX());
        assertEquals("Le joueur ne doit pas sortir du labyrinthe", 1, jeu.getJoueur().getPosX());
    }

    @Test
    public void testJeuPasFiniAuDebut() {
        Jeu jeu = new Jeu();
        assertFalse("Le jeu ne doit pas être fini au début/lancement", jeu.etreFini());
    }

    @Test
    public void testJeuFiniQuandJoueurMort() {
        Jeu jeu = new Jeu();

        jeu.getJoueur().subirDegats(100);

        assertTrue("Le jeu doit être finis quand le joueur est mort", jeu.etreFini());
    }

    @Test
    public void testJeuPasGagnatAuDepart() {
        Jeu jeu = new Jeu();
        Commande commande = new Commande();

        assertFalse("Le jeu ne doit pas être gagné au départ", jeu.aGagne());
        assertFalse("le jeu ne doit pas être finis au départ", jeu.etreFini());
    }

    @Test
    public void testScore1000ActiverSortie() {
        Jeu jeu = new Jeu();
        Commande commande = new Commande();

        Joueur joueur = (Joueur) jeu.getJoueur();
        joueur.augmenterScore(1000);
        jeu.evoluer(commande);

        assertTrue("La sortie doit s'activer une fois le score de 1000 atteint", jeu.getLaby().estUneSortieActive(18,19));
        assertFalse("Activer la sortie ne veut pas dire que le joueur a déjà gagné", jeu.aGagne());
    }

    @Test
    public void testScoreInferieur1000NactivePasSortie() {
        Jeu jeu = new Jeu();
        Commande commande = new Commande();

        Joueur joueur = (Joueur) jeu.getJoueur();
        joueur.augmenterScore(1);
        jeu.evoluer(commande);

        assertFalse("La sortie ne doit pas s'activer si le score est inférieur à 1000", jeu.getLaby().estUneSortieActive(18,19));
        assertFalse("Le jeu ne doit pas gagné", jeu.aGagne());
    }
}
