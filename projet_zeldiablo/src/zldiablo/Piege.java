package zldiablo;

public class Piege implements Case{
    public boolean etreTraversable(){
        return true;
    }
    public char getNom(){
        return 'p';
    }
    public void etrePris(){}
    public boolean getPris(){
        return false;
    }
}
