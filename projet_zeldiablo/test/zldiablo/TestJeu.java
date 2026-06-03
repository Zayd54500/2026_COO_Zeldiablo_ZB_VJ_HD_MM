package zldiablo;

import moteurJeu.Commande;
import org.junit.Test;
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
}
