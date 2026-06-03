package zldiablo;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Gère l'affichage graphique du jeu Zeldiablo.
 *
 * Cette classe dessine le labyrinthe, les murs, les pièges, les pièces,
 * la sortie, le joueur, la vie, le score ainsi que les messages de fin.
 */
public class DessinJeu implements moteurJeu.DessinJeu {
    private Jeu jeu;
    final int largeurDispo = 500;
    final int hauteurDisponible = 500;

    /**
     * Crée l'affichage graphique associé à une partie.
     *
     * @param j le jeu à afficher.
     */
    public DessinJeu(Jeu j){
        this.jeu = j;
    }

    /**
     * Dessine l'état actuel du jeu dans une image.
     *
     * La méthode parcourt toutes les cases du labyrinthe et dessine chaque élément
     * avec une couleur différente. Elle affiche aussi le joueur, sa vie, son score,
     * puis les messages GameOver ou You Win si la partie est terminée.
     *
     * @param image l'image sur laquelle le jeu est dessiné.
     */
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
                    g.setColor(Color.magenta);
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
                    } else {
                        g.setColor(new Color(101, 67, 33));
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
