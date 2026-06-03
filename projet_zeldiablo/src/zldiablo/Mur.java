package zldiablo;

public class Mur implements Case {
    public boolean etreTraversable(){
        return false;
    }
    public char getNom(){
        return 'm';
    }
    public void etrePris(){}
    public boolean getPris(){
        return false;
    }
}
