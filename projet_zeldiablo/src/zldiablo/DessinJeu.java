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
        g.fillRect(joueur.getPosX()*10, joueur.getPosY()*10, 10, 10);
        g.setColor(Color.blue);
        g.dispose();
    }
}
