package zldiablo;

public class Labyrinth {
    private Case[][] grille;
    private int tailleX;
    private int tailleY;



    public int getTailleX(){
        return this.tailleX;
    }
    public int getTailleY(){
        return this.tailleY;
    }
    public Case getCase(int x, int y) {
        return this.grille[y][x];
    }

    public boolean estTraversable(int x, int y) {
       if (x < 0 || y < 0 || x >= this.tailleX || y >= this.tailleY) {
           return false;
       }
       return this.grille[y][x].etreTraversable();
    }
}
