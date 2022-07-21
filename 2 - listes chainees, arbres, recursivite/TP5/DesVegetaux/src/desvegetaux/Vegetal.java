package desvegetaux;

import java.awt.*;

public class Vegetal {

    Vegetal(int x, int y, Graphics g) {
        Branche(x, y, 40, 3, g);
    }

    private int Aleatoire(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public void Fruit(int x, int y, Graphics g) {
        g.setColor(AleaCouleur());
        g.fillOval(x, y, 6, 6);
        g.setColor(Color.black);
    }

    public Color AleaCouleur() {
        return new Color(Aleatoire(0, 255), Aleatoire(0, 255), Aleatoire(0, 255));
    }

    public void Attendre() {
        try {
            Thread.sleep(1000);//1s
        } catch (Exception e) {
        }
    }

    public void Branche(int x, int y, int longueur, int profondeur, Graphics g) {
        if (profondeur > 0) {
            double angle = Aleatoire(10, 13) / 10.0;		// calcul angle en radian aleatoire entre 1 rad et 1,3 rad

            int x1 = Math.round((float) (x - longueur * Math.cos(angle)));
            int y1 = Math.round((float) (y - longueur * Math.sin(angle)));
            g.drawLine(x, y, x1, y1);
            Branche(x1, y1, longueur - 15, profondeur - 1, g);

            int x2 = Math.round((float) (x + longueur * Math.cos(angle)));
            int y2 = Math.round((float) (y - longueur * Math.sin(angle)));
            g.drawLine(x, y, x2, y2);
            Branche(x2, y2, longueur - 15, profondeur - 1, g);
        } else {
            Fruit(x - 3, y - 3, g);
        }
    }
}
