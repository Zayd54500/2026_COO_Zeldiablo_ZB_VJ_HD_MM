package zldiablo;

public class Joueur implements Personnage{
    private int posX;
    private int posY;
    private int vie;
    private int degats;
    public Joueur(){
        this.vie = 0;
        this.degats = 0;
        this.posX = 1;
        this.posY = 1;
    }
    public void deplacement(char dir, Labyrinth laby) {
        switch (dir){
            case 'N' :
                if(this.posY>0 && laby.getCase(this.posX, this.posY-1).etreTraversable()){
                    this.posY-=1;
                }
                break;
            case 'S' :
                if(this.posY<laby.getTailleY()-1 && laby.getCase(this.posX+1, this.posY).etreTraversable()){
                    this.posY+=1;
                }
                break;
            case 'O' :
                if(this.posX>0 && laby.getCase(this.posX-1, this.posY).etreTraversable()){
                    this.posX-=1;
                }
                break;
            case 'E' :
                if(this.posX<laby.getTailleY()-1 && laby.getCase(this.posX+1, this.posY).etreTraversable()){
                    this.posX+=1;
                }
                break;
        }
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
}
