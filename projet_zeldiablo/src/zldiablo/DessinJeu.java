package zldiablo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinJeu implements moteurJeu.DessinJeu {
    private Jeu jeu;
    public DessinJeu(Jeu j){
        this.jeu = j;
    }
    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        Personnage joueur = jeu.getJoueur();
        Labyrinth laby = jeu.getLaby();
        for(int i = 0; i<laby.getTailleY(); i++){
            for(int j = 0; j<laby.getTailleX(); j++){
                if(laby.getCase(i, j).getNom().equals("mur")){
                    g.setColor(Color.gray);
                    g.fillRect(j*50, i*50, 50, 50);
                }
            }
        }
        g.setColor(Color.blue);
        g.fillRect(joueur.getPosX()*50, joueur.getPosY()*50, 50, 50);
        g.dispose();
    }
}
