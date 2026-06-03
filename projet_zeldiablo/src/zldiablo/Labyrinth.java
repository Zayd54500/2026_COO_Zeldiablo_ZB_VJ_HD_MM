package zldiablo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Représente le labyrinthe du jeu.
 *
 * Le labyrinthe est construit à partir d'un fichier texte.
 * Chaque caractère du fichier correspond à un type de case :
 * mur, case vide, piège, pièce ou sortie.
 */

public class Labyrinth {
    private Case[][] grille;
    private int tailleX;
    private int tailleY;

    /**
     * Crée un labyrinthe à partir du fichier texte laby.txt.
     *
     * Le fichier est lu ligne par ligne, puis chaque caractère est transformé
     * en objet de type Case.
     *
     * @throws IOException si le fichier du labyrinthe ne peut pas être lu.
     */

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
                    this.grille[y][x] = new Piece();
                } else if (caractere == 'S') {
                    this.grille[y][x] = new Sortie();
                }
            }
        }
    }

    /**
     * Retourne la largeur du labyrinthe.
     *
     * @return le nombre de cases en largeur.
     */
    public int getTailleX(){
        return this.tailleX;
    }

    /**
     * Retourne la hauteur du labyrinthe.
     *
     * @return le nombre de cases en hauteur.
     */
    public int getTailleY(){
        return this.tailleY;
    }

    /**
     * Retourne la case située aux coordonnées données.
     *
     * @param x la coordonnée horizontale de la case.
     * @param y la coordonnée verticale de la case.
     * @return la case située en position (x, y).
     */
    public Case getCase(int x, int y) {
        return this.grille[y][x];
    }


    /**
     * Active toutes les sorties présentes dans le labyrinthe.
     *
     * Cette méthode est utilisée lorsque le joueur atteint le score nécessaire
     * pour pouvoir terminer la partie.
     */
    public void activerSortie() {
        for (int y = 0; y < this.tailleY; y++) {
            for (int x = 0; x < this.tailleX; x++) {
                if (this.grille[y][x] instanceof Sortie) {
                    Sortie sortie = (Sortie) this.grille[y][x];
                    sortie.activer();
                }
            }
        }
    }

    /**
     * Vérifie si la case située aux coordonnées données est une sortie active.
     *
     * @param x la coordonnée horizontale de la case.
     * @param y la coordonnée verticale de la case.
     * @return true si la case est une sortie active, false sinon.
     */
    public boolean estUneSortieActive(int x, int y) {
        if (this.grille[y][x] instanceof Sortie) {
            Sortie sortie = (Sortie) this.grille[y][x];
            return sortie.estActive();
        }
        return false;
    }
}
