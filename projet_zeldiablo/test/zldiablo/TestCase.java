package zldiablo;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCase {

    @Test
    public void testCaseVidetraversable() {
        CaseVide caseVide = new CaseVide();

        assertTrue("Une case vide doit être traversable", caseVide.etreTraversable());
    }

    @Test
    public void testCaseVideNom(){
        CaseVide caseVide = new CaseVide();

        assertEquals('v', caseVide.getNom());
    }

    @Test
    public void testMurNonTraversable(){
        Mur mur = new Mur();

        assertFalse("Un mur ne doit pas être traversable", mur.etreTraversable());
    }

    @Test
    public void testMurNom(){
        Mur mur = new Mur();

        assertEquals('m', mur.getNom());
    }

}