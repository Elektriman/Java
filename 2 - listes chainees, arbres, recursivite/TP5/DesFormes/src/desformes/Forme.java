package desformes;

import java.awt.*;

public class Forme {

    Forme(int x, int y, Graphics g) {
        Figure(x, y, 100, 8, g);
    }

    private int Aleatoire(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public void Attendre() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

    public Color AleaCouleur() {
        return new Color(Aleatoire(0, 255), Aleatoire(0, 255), Aleatoire(0, 255));
    }

    public void Figure(int x, int y, int largeur, int profondeur, Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(x - (largeur / 2), y - (largeur / 2), largeur, largeur);
        
        int xa = (int) x - (largeur);
        int xb = (int) x + (largeur);
        int ya = (int) y - (largeur);
        int yb = (int) y + (largeur);
        
        if(profondeur>0){
            Figure(xa,ya,largeur/2,profondeur-1,g);
            Figure(xb,ya,largeur/2,profondeur-1,g);
            Figure(xa,yb,largeur/2,profondeur-1,g);
            Figure(xb,yb,largeur/2,profondeur-1,g);
        }
    }
}
