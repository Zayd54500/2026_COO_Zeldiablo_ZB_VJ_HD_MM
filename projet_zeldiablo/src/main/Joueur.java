package main;

public class Joueur implements Personnage{
    int vie;
    int degats;
    private int posX;
    private int posY;
    public Joueur(int x, int y){
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

    public void attaquer(Monstre monstre) {
        if(!monstre.etreMort()) {
            monstre.setVie(monstre.getVie() - this.degats);
        }
    }
}
