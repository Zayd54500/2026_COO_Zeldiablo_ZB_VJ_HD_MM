package main;

import java.util.ArrayList;

public class Labyrinth {
    private ArrayList<ArrayList<Case>> listeCase;
    public ArrayList<ArrayList<Case>> getListeCase(){
        return this.listeCase;
    }
    public Case getCase(int x, int y){
        return listeCase.get(x).get(y);
    }
}
