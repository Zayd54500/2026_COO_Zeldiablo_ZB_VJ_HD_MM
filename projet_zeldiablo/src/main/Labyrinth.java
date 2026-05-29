package main;

import java.util.ArrayList;

public class Labyrinth {
    private ArrayList<ArrayList<Case>> listeCase;

    public Case getCase(int x, int y){
        return listeCase.get(x).get(y);
    }
}
