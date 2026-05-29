package main;

public class Joueur implements Personnage{
    private int posX;
    private int posY;
    public Joueur(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    @Override
    public void deplacement(String dir, Labyrinth laby) {
        switch (dir){
            
        }
    }
}
