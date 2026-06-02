package zldiablo;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class TestLabyrinthe {
    @Test
    public void testTailleLabyrinthe() throws IOException {
        Labyrinth laby = new Labyrinth();

        assertEquals("Le labyrinthe doit avoir 7 colonnes",7, laby.getTailleX());
        assertEquals("Le labyrinthe doit avoir 5 lignes", 5, laby.getTailleY());
    }
}
