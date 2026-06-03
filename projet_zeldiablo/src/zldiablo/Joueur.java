package zldiablo;

public class Joueur implements Personnage{
    private int posX;
    private int posY;
    private int vie;
    private int degats;
    public Joueur(){
        this.vie = 3;
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
                if(this.posY<laby.getTailleY()-1 && laby.getCase(this.posX, this.posY+1).etreTraversable()){
                    this.posY+=1;
                }
                break;
            case 'O' :
                if(this.posX>0 && laby.getCase(this.posX-1, this.posY).etreTraversable()){
                    this.posX-=1;
                }
                break;
            case 'E' :
                if(this.posX<laby.getTailleX()-1 && laby.getCase(this.posX+1, this.posY).etreTraversable()){
                    this.posX+=1;
                }
                break;
        }
        if(laby.getCase(this.posX, this.posY).getNom()=='p'){
            this.subirDegats(1);
        }
    }

    public void subirDegats(int degats) {
        if (degats > 0) {
            this.vie -= degats;
            if (this.vie < 0) {
                this.vie = 0;
            }
            System.out.println("Le joueur à subit " + degats + " degats");
            if (this.estMort()) {
                System.out.println("Le joueur est décédé");
            }
        }
    }

    public boolean estMort() {
        if (this.vie <= 0) {
            return true;
        }
        return false;
    }

    public int getVie() {
        return this.vie;
    }

    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
}
