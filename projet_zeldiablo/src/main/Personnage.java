package main;

public interface Personnage {
    public void deplacement(String dir, Labyrinth laby);
    public void attaquer(Monstre monstre);
}
