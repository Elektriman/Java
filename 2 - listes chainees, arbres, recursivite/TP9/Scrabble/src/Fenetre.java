
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*; // Pour pouvoir utiliser les fichiers

public class Fenetre extends JFrame implements ActionListener {

    private static final int DIMLETTRE = 28;

    // 3 panneaux constituant la fenetre    
    private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
    private JPanel p1;                    // zone boutons hauts
    private JPanel p2;                    // zone boutons bas  

    // ATTRIBUTS DE L APPLICATION
    private JTextField saisie;            // variable du champs de saisie
    private ArbreBR dico;                 // dictionnaire de tous les mots possibles
    private int nbMots;
    private HashMap points;		 // correspondance entre lettre et points
    private LinkedList sac;		 // ensemble des lettres du jeux
    private String lettresJoueur = new String();	// lettres du joueur

    //IMPORTANT-------------------------------------
    private ArrayList<Mot> possibilites;	// resultats de la recherche de l'ordinateur
    //----------------------------------------------

    private boolean motPossible;
    private boolean possibleAvecTirage = true;
    private String proposition = "";         // proposition du joueur
    private int score = 0;
    private int result;
    private boolean probleme;

// CONSTRUCTEUR 
    public Fenetre(String titre, int largeur, int hauteur) {
        super(titre);
        // initialisation structures de donn�es ------------------------------        
        this.nbMots = 0;
        this.probleme = false;
        this.points = new HashMap();
        this.sac = new LinkedList();
        this.possibilites = new ArrayList();
        this.motPossible = false;

        // chargement des structures	
        chargementPoints();
        chargementDico();
        chargementSac();

        tirageAleaLettres();

        //Equilibrage ici 
        ArrayList t = new ArrayList();	// methode pour equiibrer par vecteur
        this.dico.arbreBREnTab(t);
        this.dico = new ArbreBRCons(t, 0, t.size() - 1);

        //----------------------------------------------------------------------------------------
        // Construction de la fenetre
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mise_en_page(largeur, hauteur);   // on place les boutons et la zone de dessin ...

        repaint();                           // on dessine l'ensemble     
    }

// ASSEMBLAGE PARTIES FENETRE : la fenetre est constitu�e de trois parties Panel Nord : boutons ; Sud : boutons; Centre: zone de zoneDessin
    public void mise_en_page(int maxX, int maxY) {
        //--------------------------------------------------------------------
        // insertion boutons du haut
        this.p1 = new JPanel(new GridLayout());

        this.saisie = new JTextField(25);
        this.p1.add(new JLabel("Saisir un mot : "));
        this.p1.add(this.saisie);
        ajouteBouton("Proposition", this.p1);
        ajouteBouton("Mot existe Dico", this.p1);
        ajouteBouton("Nouveau Tirage", this.p1);
        ajouteBouton("Solutions Scrabble", this.p1);

        getContentPane().add(this.p1, "North");  // on ajoute le panel en haut de la fenetre frame

        //--------------------------------------------------------------------
        // insertion boutons du bas
        this.p2 = new JPanel(new GridLayout());
        ajouteBouton("Quitter", this.p2);

        getContentPane().add(this.p2, "South");  // on ajoute le panel en bas

        //--------------------------------------------------------------------
        // zone de dessin
        this.zoneDessin = new JPanel();
        this.zoneDessin.setSize(maxX, maxY);
        this.zoneDessin.setPreferredSize(new Dimension(maxX, maxY));
        getContentPane().add(this.zoneDessin, "Center");  // panel pour zoneDessiner au milieu

        //--------------------------------------------------------------------
        pack();
        setVisible(true);
    }

// AFFICHAGE A L ECRAN : tout ce qui est dans le paint() sera à l'ecran   
    public void paint(Graphics g) // dessin de la fen�tre g�n�rale
    {
        this.p1.repaint();  // on redessine les boutons hauts
        this.p2.repaint();  // on redessine les boutons bas

        g = this.zoneDessin.getGraphics(); // on redessine dans le panel de dessin
        effacer();

        if (this.probleme == true) {
            g.drawString("Probleme de chargement...", 20, 40);
        } else {
            Font StyleLesTitres = new Font("TimesRoman", Font.BOLD, 18); // trois styles d'ecriture
            Font StyleMoyen = new Font("TimesRoman", Font.ITALIC, 14);
            Font StyleNormal = new Font("TimesRoman", Font.PLAIN, 12);

            //g.drawImage(im, 0, 0, 150,235, this);  // l'affiche
            g.setFont(StyleLesTitres);
            affichePions("Jeu du scrabble", 300, 70, g);
            g.drawString("Nb mots dans dico :" + this.nbMots, 1000, 70);		// le titre
            g.drawString("Nb lettres dans le sac : " + this.sac.size(), 1000, 90);
            //AffichePoints(1000,130,g);
            g.drawString("Le score du joueur est : " + score, 150, 150);
            g.drawString("Lettres du joueur :", 150, 190);
            affichePions(this.lettresJoueur, 300, 170, g);
            g.setColor(Color.red);
            if (this.dico.scrabblePossible(this.lettresJoueur)) {
                g.drawString("Scrabble possible", 530, 200);
            } else {
                g.drawString("Scrabble impossible", 530, 200);
            }
            g.setColor(Color.black);

            for (int i = 0; i < this.possibilites.size(); i++) // affiche les possibilt�s
            {
                affichePions(this.possibilites.get(i).getMot(), 200, 290 + i * 40, g);
                g.drawString(calculScore((this.possibilites.get(i)).getMot()) + " pts", 150, 310 + i * 40);
            }

            // affiche si le mot propose existe
            if (this.motPossible) {
                g.drawString("Ce mot est dans le dictionnaire", 700, 270);
            }
            if (!possibleAvecTirage) {
                g.drawString("Ce mot ne peut pas �tre construit avec le tirage", 700, 320);
            }

        }
    }

    public void elagueParScore() {

    }

    public void elagueParLongueur() {
        ArrayList Terminal = new ArrayList();

        this.possibilites = Terminal;
    }

    public boolean estDans(char a) {
        for (int i = 0; i < this.proposition.length(); i++) {
            if (this.proposition.charAt(i) == a) {
                return true;
            }
        }
        return false;
    }

    public void tirageAleaLettres() {

        this.lettresJoueur = "";
        int i = 0;
        while (this.sac.size() > 0 && i < 7) {
            int nbLettreSac = this.sac.size();
            char l = (Character) this.sac.remove(aleatoire(0, nbLettreSac - 1));
            this.lettresJoueur = this.lettresJoueur + l;
            i++;
        }
    }

// QUELQUES OUTILS
    // Proc�dure d'arr�t
    void quitter() {
        System.exit(0);
    }

    // Effacer le plan de dessin
    void effacer() {
        Graphics g = this.zoneDessin.getGraphics();
        g.setColor(Color.white);
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
        String arg = e.getActionCommand();     // on capte l'evenement : nom du bouton !

        if (arg.equals("Quitter")) {
            quitter();
        }

        if (arg.equals("Nouveau Tirage")) {
            this.possibilites.clear();
            if (this.sac.size() >= 7) {
                tirageAleaLettres();
            }
            this.motPossible = false;
            possibleAvecTirage = true;

        }
        if (arg.equals("Solutions Scrabble")) {
            this.motPossible = false;
            possibleAvecTirage = true;
            this.possibilites.clear();
            this.dico.rechercherSolutions(this.lettresJoueur, this.possibilites);
            elagueParLongueur();

        }

        if (arg.equals("Proposition")) {
            this.proposition = this.saisie.getText();
            this.proposition = this.proposition.toUpperCase();

        }

        if (arg.equals("Mot existe Dico")) {
            this.possibilites.clear();
            possibleAvecTirage = true;
            String s = this.saisie.getText();
            s = s.toUpperCase();
            this.motPossible = (dico.rechercherABR(new Mot(s)));
        }

        repaint();
    }

    public void affichePions(String s, int x, int y, Graphics g) {
        String NomImg = "";
        Image im;
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                NomImg = s.charAt(i) + ".jpg";
                try {
                    im = ImageIO.read(new File(NomImg));      // on charge une image du disque dur
                    g.drawImage(im, x + i * DIMLETTRE + 1, y, DIMLETTRE, DIMLETTRE, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void affichePoints(int x, int y, Graphics g) {
        char c = 'A';
        for (int i = 0; i < this.points.size(); i++) {
            if (this.points.containsKey(c)) {
                int p = (Integer) this.points.get(c);
                g.drawString(c + " : " + p, x, y + i * 15);
            }
            c++;
        }

    }

    public int calculScore(String s) {
        s = s.toUpperCase();
        int somme = 0;
        for (int i = 0; i < s.length(); i++) {
            somme = somme + (Integer) this.points.get(s.charAt(i));
        }

        if (s.length() == 7) {
            somme = somme + 20;
        }

        return somme;
    }

    private int aleatoire(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public void chargementPoints() {
        char Lettre;
        int p;
        try {
            FileReader fic = new FileReader("points.txt");

            StreamTokenizer entree = new StreamTokenizer(fic); // on ouvre un stream 	
            entree.quoteChar('"');
            int i = 0;
            entree.nextToken();
            while (entree.ttype != entree.TT_EOF) {
                Lettre = entree.sval.charAt(0);
                entree.nextToken();
                p = (int) entree.nval;
                this.points.put((Character) Lettre, p);
                entree.nextToken();
            }
        } catch (Exception e) {
            this.probleme = true;
        }
    }

    public void chargementSac() {
        char Lettre;
        int p;
        this.sac.clear();
        try {
            FileReader fic = new FileReader("sac.txt");

            StreamTokenizer entree = new StreamTokenizer(fic); // on ouvre un stream 	
            entree.quoteChar('"');
            int i = 0;
            entree.nextToken();
            while (entree.ttype != entree.TT_EOF) {
                Lettre = entree.sval.charAt(0);
                this.sac.add(Lettre);
                entree.nextToken();
            }
        } catch (Exception e) {
            this.probleme = true;
        }
    }

    public void chargementDico() {
        String Mot;
        try {
            FileReader fic = new FileReader("scrabble.txt");

            StreamTokenizer entree = new StreamTokenizer(fic);
            entree.quoteChar('"');

            // lecture des donn�es dans le fichier connaissant le format------------
            int i = 0;
            dico = new ArbreBRVide();
            entree.nextToken();

            while (entree.ttype != entree.TT_EOF) {
                dico = dico.insereTo(new Mot(entree.sval));
                this.nbMots++;
                entree.nextToken();
            }  // fin while
        } catch (Exception e) {
            this.probleme = true;
        }

    }

}
