package main;

public class Monstre implements Personnage{
    int vie;
    int degats;

    public Monstre(int vie, int degat) {
        this.vie = vie;
        this.degats = degat;
    }

    public boolean etreMort() {
        if (vie == 0) {
            return true;
        }
        return false;
    }

    public void deplacement(char dir, Labyrinth laby) {
    }

    public void subirDegat(int degats){
        this.vie = this.vie - degats;
    }

    public void attaquer(Personnage cible) {
        cible.subirDegat(this.degats);
    }

    public int getVie() {
        return this.vie;
    }

    public int getDegat() {
        return this.getDegat();
    }

    public void setVie(int valeur) {
        this.vie = valeur;
    }


}
