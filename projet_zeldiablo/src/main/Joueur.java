package main;

public class Joueur implements Personnage{
    private int posX;
    private int posY;
    public Joueur(){
        this.vie = 0;
        this.degats = 0;
        this.posX = 1;
        this.posY = 1;
    }
    public void deplacement(char dir, Labyrinth laby) {
        switch (dir){
            case 'N' :
                if(this.posX>0){
                    this.posX-=1;
                }
            case 'S' :
                if(this.posX<laby.getTailleX()){
                    this.posX+=1;
                }
            case 'O' :
                if(this.posY>0){
                    this.posY-=1;
                }
            case 'E' :
                if(this.posY<laby.getTailleY()){
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
