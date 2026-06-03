package zldiablo;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class TestSortie {
    @Test
    public void testSortieInnactiveAuDepart() {
        Sortie sortie = new Sortie();

        assertFalse("La sortie ne doit pas être active au départ", sortie.estActive());
        assertFalse("Une sortie ne doit pas être traversable", sortie.etreTraversable());
        assertEquals("Le nom de la sortie doit être 's'", 's', sortie.getNom());
    }

    @Test
    public void testSortieActiveDevientTraversable() {
        Sortie sortie = new Sortie();
        sortie.activer();

        assertTrue("La sortie doit être active après activer()", sortie.estActive());
        assertTrue("Une sortie active doit être traversable", sortie.etreTraversable());
    }

    @Test
    public void testActivationSortieDansLabyrinthe() throws IOException {
        Labyrinth laby = new Labyrinth();

        laby.activerSortie();

        assertTrue("La sortie doit être active après activer()", laby.estUneSortieActive(24,25));
        assertTrue("Une sortie active doit être traversable", laby.getCase(24,25).etreTraversable());
    }
}
