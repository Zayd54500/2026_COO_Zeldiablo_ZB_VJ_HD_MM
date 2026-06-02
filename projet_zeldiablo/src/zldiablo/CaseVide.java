package zldiablo;

public class CaseVide implements Case {
    public boolean etreTraversable() {
        return true;
    }
    public String getNom(){
        return "vide";
    }
}
