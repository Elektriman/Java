package desformes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*; // Pour pouvoir utiliser les fichiers

public class Fenetre extends JFrame implements ActionListener, MouseListener {

    // 3 panneaux constituant la fen�tre    
    private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
    private JPanel p1;                    // zone boutons hauts
    private JPanel p2;                    // zone boutons bas  

    private int X, Y;                     // lieu du dessin

// CONSTRUCTEUR 
    public Fenetre(String titre, int largeur, int hauteur) {
        super(titre);
        // placer ici l'initialisation de vos structures de donn�es ------------------------------        

        this.X = 500;
        this.Y = 400;

        //----------------------------------------------------------------------------------------
        // Construction de la fen�tre
        getContentPane().setLayout(new BorderLayout());   // gestionnaire de mise en page automatique
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mise_en_page(largeur, hauteur);   // on place les boutons et la zone de dessin ...

        repaint();                           // on dessine l'ensemble     
    }

// ASSEMBLAGE PARTIES FENETRE : la fenetre est constitu�e de trois parties Panel Nord : boutons ; Sud : boutons; Centre: zone de zoneDessin
    private void mise_en_page(int maxX, int maxY) {
        //--------------------------------------------------------------------
        // insertion boutons du haut
        this.p1 = new JPanel(new GridLayout());

        //--------------------------------------------------------------------
        // insertion boutons du bas
        this.p2 = new JPanel(new GridLayout());
        ajouteBouton("Dessine", p2);
        ajouteBouton("Effacer", p2);
        ajouteBouton("Quitter", p2);

        //--------------------------------------------------------------------
        // zone de dessin
        this.zoneDessin = new JPanel();
        this.zoneDessin.setSize(maxX, maxY);
        this.zoneDessin.setPreferredSize(new Dimension(maxX, maxY));

        //--------------------------------------------------------------------
        // on assemble le tout dans le fentre principale
        this.getContentPane().add(this.p1, "North");  // on ajoute le panel en haut de la fenetre frame
        this.getContentPane().add(this.zoneDessin, "Center");  // panel pour zoneDessiner au milieu
        this.getContentPane().add(this.p2, "South");  // on ajoute le panel en bas

        addMouseListener(this);           // on veut gerer les evenements des souris

        pack();
        setVisible(true);
    }

// AFFICHAGE A L ECRAN : tout ce qui est dans le paint() sera � l'ecran   
    public void paint(Graphics g) // dessin de la fen�tre g�n�rale
    {
        this.p1.repaint();  // on redessine les boutons hauts
        this.p2.repaint();  // on redessine les boutons bas

        g = this.zoneDessin.getGraphics(); // on recupere le contexte graphique du panel de dessin

        // c'est ici qu'il faut mettre les elements � afficher
        effacer();

        Forme f1 = new Forme(this.X, this.Y, g);

    }

// QUELQUES OUTILS
    // Proc�dure d'arr�t
    private void quitter() {
        System.exit(0);
    }

    // Effacer le plan de dessin
    private void effacer() {
        Graphics g = this.zoneDessin.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    // Permet d'ajouter un nouveau bouton dans le panel p
    private void ajouteBouton(String label, JPanel p) {
        // Ajoute un bouton, avec le texte label, au panneau p
        JButton b = new JButton(label);
        p.add(b);
        b.addActionListener(this);
    }

// GESTION DES ACTIONS SUITE A UN APPUIS SUR BOUTON : cette methode est declench�e si Un bouton quelconque est appuy�
    public void actionPerformed(ActionEvent e) // on associe l'evenement souris sur bouton avec l'execution d'un sous prg
    {
        String c = e.getActionCommand();     // on capte l'evenement : nom du bouton !

        if (c.equals("Effacer")) {
            effacer();
        }
        if (c.equals("Quitter")) {
            quitter();
        }

        if (c.equals("Dessine")) {
            repaint();
        }
        repaint();
    }

// GESTION SOURIS : evenements de la souris
    public void mousePressed(MouseEvent e) {

        this.X = e.getX();
        this.Y = e.getY();
        repaint();
    }

    public void mouseClicked(MouseEvent e) {
    }  // ! on peut laisser vide mais pas supprimer car interface!

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}
