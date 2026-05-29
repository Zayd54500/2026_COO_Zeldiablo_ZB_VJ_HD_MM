package main;

public class Joueur implements Personnage{
    int vie;
    int degats;
    private int posX;
    private int posY;
    public Joueur(int x, int y, int vie, int degat){
        this.vie = vie;
        this.degats = degat;
        this.posX = x;
        this.posY = y;
    }

    @Override
    public void deplacement(char dir, Labyrinth laby) {
        switch (dir){
            case 'N' :
                if(laby.getCase(this.posX+1, this.posY).etreTraversable()){
                    this.posX+=1;
                }
            case 'S' :
                if(laby.getCase(this.posX-1, this.posY).etreTraversable()){
                    this.posX-=1;
                }
            case 'O' :
                if(laby.getCase(this.posX, this.posY-1).etreTraversable()){
                    this.posY-=1;
                }
            case 'E' :
                if(laby.getCase(this.posX, this.posY+1).etreTraversable()){
                    this.posY+=1;
                }
        }
    }

    public boolean etreMort() {
        if (vie == 0) {
            return true;
        }
        return false;
    }

    public void subirDegat(int degats){
        this.vie = this.vie - degats;
    }

    public void attaquer(Personnage cible) {
        if(!cible.etreMort()) {
            cible.subirDegat(this.degats);
        }
    }
}
