package zldiablo;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class TestJoueur {
    public void testPositionInitialJoueur() {
        Joueur joueur = new Joueur();

        assertEquals("Le joueur doit commencer en X = 1", 1, joueur.getPosX());
        assertEquals("Le joueur doit commencer en Y = 1", 1, joueur.getPosY());
    }

    @Test
    public void deplacementDroite() throws IOException{
        Labyrinth laby = new Labyrinth();
        Joueur joueur = new Joueur();

        joueur.deplacement('E', laby);
        assertEquals("Le joueur doit avancer vers la droite", 2, joueur.getPosX());
        assertEquals("Le Y ne doit pas changer", 1, joueur.getPosY());
    }

    @Test
    public void deplacementGauche() throws IOException {
        Labyrinth laby = new Labyrinth();
        Joueur joueur = new Joueur();

        joueur.deplacement('E', laby);
        joueur.deplacement('O', laby);

        assertEquals("Le joueur doit revenir vers la gauche",1, joueur.getPosX());
        assertEquals("Le joueur doit revenir vers la droite", 1, joueur.getPosY());
    }

    @Test
    public void testDeplacementBas() throws IOException {
        Labyrinth laby = new Labyrinth();
        Joueur joueur = new Joueur();

        joueur.deplacement('S', laby);

        assertEquals("Le X ne doit pas changer", 1, joueur.getPosX());
        assertEquals("Le Y ne doit pas changer", 2, joueur.getPosY());
    }

    @Test
    public void testDeplacementHaut() throws IOException {
        Labyrinth laby = new Labyrinth();
        Joueur joueur = new Joueur();

        joueur.deplacement('S', laby);
        joueur.deplacement('N', laby);

        assertEquals("Le X ne doit pas changer", 1, joueur.getPosX());
        assertEquals("Le joueur doit remonter", 1, joueur.getPosY());
    }

    @Test
    public void testNeSortPasParLeHaut() throws IOException {
        Labyrinth laby = new Labyrinth();
        Joueur joueur = new Joueur();

        joueur.deplacement('N', laby);

        assertEquals("Le joueur ne doit pas sortir par le haut", 1, joueur.getPosX());
        assertEquals("Le joueur ne doit pas sortir par le haut", 1, joueur.getPosY());
    }

    @Test
    public void testNeSortPasParLeGauche() throws IOException {
        Labyrinth laby = new Labyrinth();
        Joueur joueur = new Joueur();

        joueur.deplacement('O', laby);

        assertEquals("Le joueur ne doit pas sortir par le haut", 1, joueur.getPosX());
        assertEquals("Le joueur ne doit pas sortir par le haut", 1, joueur.getPosY());
    }

    @Test
    public void testJoueurNeTraversePasMurInterieur() throws IOException {
        Labyrinth laby = new Labyrinth();
        Joueur joueur = new Joueur();

        for (int i = 0; i < 9; i++) {
            joueur.deplacement('E', laby);
        }

        assertEquals("Le joueur doit être juste avant le mur intérieur", 9, joueur.getPosX());
        assertEquals("Le joueur doit être sur la ligne 1", 1, joueur.getPosY());

        joueur.deplacement('E', laby);

        assertEquals("Le joueur ne doit pas traverser le mur intérieur", 9, joueur.getPosX());
        assertEquals("Le joueur ne doit pas traverser le mur intérieur", 1, joueur.getPosY());
    }
}
