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
}
