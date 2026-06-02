package zldiablo;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class TestLabyrinthe {
    @Test
    public void testTailleLabyrinthe() throws IOException {
        Labyrinth laby = new Labyrinth();

        assertEquals("Le labyrinthe doit avoir 20 colonnes",20, laby.getTailleX());
        assertEquals("Le labyrinthe doit avoir 20 lignes", 20, laby.getTailleY());
    }

    public void testMurExterieurNonTraversable() throws IOException {
        Labyrinth laby = new Labyrinth();

        assertEquals("La case en haut à gauche doit être un mur", "mur", laby.getCase(0,0).getNom());
        assertFalse("Le mur extérieur ne doit pas être traversable", laby.getCase(0,0).etreTraversable());
    }

    @Test
    public void testCaseVideTraversable() throws IOException {
        Labyrinth laby = new Labyrinth();

        assertEquals("La case(1,1) doit être vide", "vide", laby.getCase(1,1).getNom());
        assertTrue("La case vide doit être traversable", laby.getCase(1,1).etreTraversable());
    }

    @Test
    public void testMurInterieurExiste() throws IOException {
        Labyrinth laby = new Labyrinth();

        assertEquals("La case (10,1) doit être un mur intérieur", "mur", laby.getCase(10,1).getNom());
        assertFalse("Le mur intérieur ne doit pas être traversable", laby.getCase(10,1).etreTraversable());
    }
}
