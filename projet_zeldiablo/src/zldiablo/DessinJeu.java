package zldiablo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinJeu implements moteurJeu.DessinJeu {
    private Jeu jeu;
    final int largeurDispo = 500;
    final int hauteurDisponible = 500;
    public DessinJeu(Jeu j){
        this.jeu = j;
    }
    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        Personnage joueur = jeu.getJoueur();
        Labyrinth laby = jeu.getLaby();
        int tailleCaseX = largeurDispo / laby.getTailleX();
        int tailleCaseY = hauteurDisponible / laby.getTailleY();
        int tailleCase = Math.min(tailleCaseX, tailleCaseY);

        for(int i = 0; i<laby.getTailleY(); i++){
            for(int j = 0; j<laby.getTailleX(); j++){
                if(laby.getCase(j, i).getNom().equals("mur")){
                    g.setColor(Color.gray);
                    g.fillRect(j*tailleCaseX, i*tailleCaseY, tailleCaseX, tailleCaseY);
                }
            }
        }
        g.setColor(Color.blue);
        g.fillRect(joueur.getPosX()*tailleCaseX, joueur.getPosY()*tailleCaseY, tailleCaseX, tailleCaseY);
        g.dispose();
    }
}
