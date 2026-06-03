package zldiablo;

public interface Personnage {
    public void deplacement(char dir, Labyrinth laby);
    public int getPosX();
    public int getPosY();
    public int getVie();
    public int getScore();
    public void subirDegats(int degats);
    public boolean estMort();
}
