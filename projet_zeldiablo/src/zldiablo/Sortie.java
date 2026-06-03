package zldiablo;

public class Sortie implements Case{
    private boolean active;

    public Sortie() {
        this.active = false;
    }

    public void activer() {
        this.active = true;
    }

    public boolean estActive() {
        return this.active;
    }

    public boolean etreTraversable() {
        return this.active;
    }

    public char getNom() {
        return 's';
    }

    public void etrePris() {
        //vide
    }

    public boolean getPris() {
        return false;
    }
}
