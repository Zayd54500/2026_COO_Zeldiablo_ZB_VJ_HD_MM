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


        for (int i = 0; i < laby.getTailleY(); i++) {
            for (int j = 0; j < laby.getTailleX(); j++) {
                if (laby.getCase(j, i).getNom() == 'm') {
                    g.setColor(Color.gray);
                    g.fillRect(j * tailleCaseX, i * tailleCaseY, tailleCaseX, tailleCaseY);
                } else if (laby.getCase(j, i).getNom() == 'p') {
                    g.setColor(Color.yellow);
                    g.fillRect(j * tailleCaseX, i * tailleCaseY, tailleCaseX, tailleCaseY);
                } else if (laby.getCase(j, i).getNom() == 'c'&&!laby.getCase(j, i).getPris()) {
                    g.setColor(Color.ORANGE);
                    g.fillOval(
                        j * tailleCaseX + tailleCaseY / 4,
                        i * tailleCaseY + tailleCaseY / 4,
                        tailleCaseX / 2,
                        tailleCaseY / 2
                    );
                } else if (laby.getCase(j,i).getNom() == 's') {
                    Sortie sortie = (Sortie) laby.getCase(j,i);
                    if(sortie.estActive()) {
                        g.setColor(Color.green);
                        g.fillRect(
                                j * tailleCaseX,
                                i * tailleCaseY,
                                tailleCaseX,
                                tailleCaseY
                                );
                    }
                }
            }

            if (joueur.estMort()) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.blue);
            }
        }

        g.fillRect(joueur.getPosX()*tailleCaseX, joueur.getPosY()*tailleCaseY, tailleCaseX, tailleCaseY);
        g.setColor(Color.RED);
        g.drawString("VIE : "+joueur.getVie(), 40, 20);
        g.drawString("SCORE : " + joueur.getScore(), 100, 20);
        if (joueur.estMort()) {
            Font fonte = new Font(" TimesRoman ",Font.BOLD,30);
            g.setFont(fonte);
            g.setColor(Color.red);
            g.drawString("GameOver", 190,250);
        }

        if (jeu.aGagne()) {
            Font fonte = new Font(" TimesRoman ",Font.BOLD,30);
            g.setFont(fonte);
            g.setColor(Color.green);
            g.drawString("You Win", 190,250);
        }
        g.dispose();
    }
}
