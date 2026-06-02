package zldiablo;


import org.junit.Test;

import static org.junit.Assert.*;

public class TestMain {
    @Test
    public void testCaseVideTraversable() {
        CaseVide vide = new CaseVide();
        assertTrue("Une case vide doit être traversable", vide.etreTraversable());
    }

    @Test
    public void testCaseVideNom() {
        CaseVide vide = new CaseVide();
        assertEquals("vide", vide.getNom());
    }

    @Test
    public void testMurNonTraversable() {
        Mur mur = new Mur();
        assertFalse("Un mur ne doit pas être traversable", mur.etreTraversable());
    }

    @Test
    public void testMurNom() {
        Mur mur = new Mur();

        assertEquals("mur", mur.getNom());
    }
}
