package main;

public interface Personnage {
    public void deplacement(char dir, Labyrinth laby);
    public void attaquer(Monstre monstre);
}
