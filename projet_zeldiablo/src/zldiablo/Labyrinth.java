package zldiablo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Labyrinth {
    private Case[][] grille;
    private int tailleX;
    private int tailleY;

    public Labyrinth() throws IOException {
        List<String> lignes = Files.readAllLines(Paths.get("src/data/laby.txt"));
        this.tailleY = lignes.size();
        this.tailleX = lignes.get(0).length();
        this.grille = new Case[this.tailleY][this.tailleX];
        for (int y = 0; y < this.tailleY; y++){
            String ligne = lignes.get(y);
            for (int x = 0; x < this.tailleX; x++){
                char caractere = ligne.charAt(x);
                if (caractere == '#'){
                    this.grille[y][x] = new Mur();
                } else if (caractere== '.') {
                    this.grille[y][x] = new CaseVide();
                } else if(caractere == 'P'){
                    this.grille[y][x] = new Piege();
                } else if(caractere == 'C'){
                    this.grille[y][x] = new Piege();
                }
            }
        }
    }

    public int getTailleX(){
        return this.tailleX;
    }
    public int getTailleY(){
        return this.tailleY;
    }
    public Case getCase(int x, int y) {
        return this.grille[y][x];
    }
}
