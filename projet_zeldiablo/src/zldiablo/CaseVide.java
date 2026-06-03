package zldiablo;

public class CaseVide implements Case {
    public boolean etreTraversable() {
        return true;
    }
    public char getNom(){
        return 'v';
    }
    public void etrePris(){
    }
    public boolean getPris(){
        return false;
    }
}
