package zldiablo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMain {
    @Test
    // verification que retour retourne bien 1
    public void testRetour() {
        // preparation des donnees
        Main m = new Main();
        // appel de la methode
        int val = m.retour();
        // verifications
        assertEquals("devrait etre egal à 1", 1, val);
    }

}
