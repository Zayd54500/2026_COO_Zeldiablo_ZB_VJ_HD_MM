package main;

import java.util.ArrayList;

public class Labyrinth {
    private ArrayList<ArrayList<Case>> listeCase;
    public Labyrinth(ArrayList<ArrayList<Case>> cases){
        this.listeCase = cases;
    }
    public Case getCase(int x, int y){
        return listeCase.get(x).get(y);
    }
}
