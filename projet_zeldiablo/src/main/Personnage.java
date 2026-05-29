package main;

public interface Personnage {
    public void deplacement(char dir, Labyrinth laby);
    public void attaquer(Personnage cible);
    public void subirDegat(int degats);
    public boolean etreMort();
}
