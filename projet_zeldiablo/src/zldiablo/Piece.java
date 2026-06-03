package zldiablo;

public class Piece implements Case{
    private boolean pris;
    public boolean etreTraversable(){
        return true;
    }
    public char getNom(){
        return 'c';
    }
    public void etrePris(){
        this.pris = true;
    }
    public boolean getPris(){
        return this.pris;
    }
}
