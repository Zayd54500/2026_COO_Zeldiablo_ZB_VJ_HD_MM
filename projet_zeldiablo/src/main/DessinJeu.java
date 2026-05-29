package main;

import java.awt.image.BufferedImage;

public class DessinJeu implements moteurJeu.DessinJeu {
    private Jeu jeu;
    public DessinJeu(Jeu j){
        this.jeu = j;
    }
    @Override
    public void dessiner(BufferedImage image) {

    }
}
