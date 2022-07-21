import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*; // Pour pouvoir utiliser les fichiers
import java.util.ArrayList;
   

public class Fenetre extends JFrame implements ActionListener , MouseListener
{
    // 3 panneaux constituant la fenêtre    
    private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
    private JPanel p1;                    // zone boutons hauts
    private JPanel p2;                    // zone boutons bas  
    
    private ArrayList <Segment> mem;
   
    
// CONSTRUCTEUR 
    
    public Fenetre(String titre, int largeur, int hauteur) 
    {
        super(titre);
        // placer ici l'initialisation de vos structures de données ------------------------------        
        this.mem = new ArrayList <Segment> ();
        
           
        //----------------------------------------------------------------------------------------
        // Construction de la fenêtre
        getContentPane().setLayout(new BorderLayout());   // gestionnaire de mise en page automatique
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                                 
        mise_en_page( largeur, hauteur );   // on place les boutons et la zone de dessin ...
    
        repaint();                           // on dessine l'ensemble     
    }
    

// ASSEMBLAGE PARTIES FENETRE : la fenetre est constituée de trois parties Panel Nord : boutons ; Sud : boutons; Centre: zone de zoneDessin
    private void mise_en_page(int maxX, int maxY) 
    {
        //--------------------------------------------------------------------
        // insertion boutons du haut
        this.p1 = new JPanel(new GridLayout());
           	  
  		  
        
        //--------------------------------------------------------------------
        // insertion boutons du bas
        this.p2 = new JPanel(new GridLayout());
        ajouteBouton("Effacer", p2);
  		  ajouteBouton("Quitter", p2);
		  
		          
        //--------------------------------------------------------------------
        // zone de dessin
        this.zoneDessin = new JPanel();
        this.zoneDessin.setSize(maxX,maxY);
        this.zoneDessin.setPreferredSize(new Dimension(maxX,maxY));
        
        //--------------------------------------------------------------------
        // on assemble le tout dans le fentre principale
        this.getContentPane().add(this.p1,"North");  // on ajoute le panel en haut de la fenetre frame
        this.getContentPane().add(this.zoneDessin,"Center");  // panel pour zoneDessiner au milieu
        this.getContentPane().add(this.p2,"South");  // on ajoute le panel en bas

        
        addMouseListener(this);           // on veut gerer les evenements des souris

        pack();
        setVisible(true);
    }

// AFFICHAGE A L ECRAN : tout ce qui est dans le paint() sera à l'ecran   
    public void paint(Graphics g)  // dessin de la fenêtre générale
    {
         this.p1.repaint();  // on redessine les boutons hauts
         this.p2.repaint();  // on redessine les boutons bas
            
         g= this.zoneDessin.getGraphics(); // on recupere le contexte graphique du panel de dessin
        
         // c'est ici qu'il faut mettre les elements à afficher  
         for(int i=0; i< this.mem.size() ; i++ )
         {  
            Segment s = this.mem.get(i);    
            g.setColor( s.getC() );
            g.drawLine(s.getX1(),s.getY1(),s.getX2(),s.getY2());
         }
    }
    
    public void tracerLigne(int x1, int y1, int x2, int y2 , Color c )
    {
      this.mem.add(new Segment(x1, y1, x2, y2, c ) );      
      repaint();
    }
    
// QUELQUES OUTILS
   
    // Procédure d'arrêt
    private void quitter() {
        System.exit(0);
    }
    
    // Effacer le plan de dessin
    private void effacer() {
        Graphics g = this.zoneDessin.getGraphics(); 
        g.setColor( Color.WHITE );
        g.fillRect(0,0,this.getWidth(),this.getHeight() );
    }
    
    // Permet d'ajouter un nouveau bouton dans le panel p
    private void ajouteBouton(String label, JPanel p) {
        // Ajoute un bouton, avec le texte label, au panneau p
        JButton b = new JButton(label);
        p.add(b);
        b.addActionListener(this);
    } 
    
       
       
// GESTION DES ACTIONS SUITE A UN APPUIS SUR BOUTON : cette methode est declenchée si Un bouton quelconque est appuyé
    public void actionPerformed(ActionEvent e)  // on associe l'evenement souris sur bouton avec l'execution d'un sous prg
	 {
      String c = e.getActionCommand();     // on capte l'evenement : nom du bouton !
        
      					
		if (c.equals("Effacer")) effacer();
      if (c.equals("Quitter")) quitter();		
		  										
	   repaint();    
    } 


// GESTION SOURIS : evenements de la souris

    public void mousePressed(MouseEvent e) {
	
	   System.out.println(e.getX()+"  "+e.getY() );
	 }
    
    public void mouseClicked(MouseEvent e){}  // ! on peut laisser vide mais pas supprimer car interface!
    
    public void mouseReleased(MouseEvent e){}
    
    public void mouseEntered(MouseEvent e){}
    
    public void mouseExited(MouseEvent e){}
     
     
}

class Segment
{
   private int x1, y1, x2, y2;
   private Color c;
   
   public Segment( int x1, int y1,int x2, int y2, Color c)
   {
      this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2; this.c = c;
   }
   
   public int getX1() { return this.x1; }
   public int getY1() { return this.y1; }
   public int getX2() { return this.x2; }
   public int getY2() { return this.y2; }
   public Color getC() { return this.c; }

}