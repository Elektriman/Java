import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*; // Pour pouvoir utiliser les fichiers
   


public class Fenetre extends JFrame implements ActionListener , MouseListener
{
 //----- Attributs constituant la fenetre graphique-----------------------------------       
    private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
    private JPanel p1;                    // zone boutons hauts
    private JPanel p2;                    // zone boutons bas  
 //----- Attributs pour le Diaporama--------------------------------------------------    
    private Image im;                     // image courante a afficher
    private Diapo vacances ;              // Diaporama
    
    
/**
 * Constructeur de fenetre graphique
 * @param titre
 * @param largeur
 * @param hauteur 
 */   
    public Fenetre(String titre, int largeur, int hauteur) 
    {
        super(titre);
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);          
        mise_en_page( largeur, hauteur );   // on place les boutons et la zone de dessin ...
        
        //--On cree un diaporama et on ajoute les images----------------
        this.vacances = new Diapo();              
        this.vacances.ajouter("paysage1.jpg");
	this.vacances.ajouter("paysage2.jpg");
	this.vacances.ajouter("paysage3.jpg");
	this.vacances.ajouter("paysage4.jpg");
        
        //--On charge une image par defaut------------------------------
        try{
         this.im = ImageIO.read(new File("paysage1.jpg"));   // on charge une image du Disque Dur
        }
        catch( IOException e ) {e.printStackTrace();}       
        repaint();        // on redessine la fenetre
    }
    
/**
 * la fenetre est constituee de trois parties Panel Nord : 
 * boutons ; Sud : boutons; Centre: zone de zoneDessin
 * @param maxX
 * @param maxY 
 */
  
    public void mise_en_page(int maxX, int maxY) 
    {                
        //--------------------------------------------------------------------
        // insertion boutons du bas
        this.p2 = new JPanel(new GridLayout());
        ajouteBouton("<<", p2);
        ajouteBouton(">>", p2);
  	  
	getContentPane().add(p2,"South");  // on ajoute le panel en bas
        
        //--------------------------------------------------------------------
        // zone de dessin
        this.zoneDessin = new JPanel();
        this.zoneDessin.setSize(maxX,maxY);
        this.zoneDessin.setPreferredSize(new Dimension(maxX,maxY));
        getContentPane().add(this.zoneDessin,"Center");  // panel pour zoneDessiner au milieu
        addMouseListener(this);
        //--------------------------------------------------------------------

        pack();
        setVisible(true);
    }
 
 /**
  * Permet de dessiner tout ce qui apparait dans la fenetre.
  * Paint est regulierement appelé pour mettre a jour l'affichage (repaint() )
  * @param g : contexte graphique de la fenetre
  */ 
    public void paint(Graphics g)   // dessin de la fen�tre generale
    {        
        this.p2.repaint();         // on redessine les boutons bas               
        g= this.zoneDessin.getGraphics(); // on redessine dans le panel de dessin
            
        // On dessine l'image courante im
        effacer();
        g.drawImage(this.im, 90, 30, 400, 300, zoneDessin);
   
    }
         
 // Procedure d'arret
    void quitter() {
        System.exit(0);
    }
     
    void effacer() {
        Graphics g = this.zoneDessin.getGraphics(); 
        g.setColor( Color.WHITE );
        g.fillRect(0,0,this.getWidth(),this.getHeight() );
    }
    
    private void ajouteBouton(String label, JPanel p) {
        // Ajoute un bouton, avec le texte label, au panneau p
        JButton b = new JButton(label);
        p.add(b);
        b.addActionListener(this);
    } 
     
    
/**
 * Cette methode est declenchee dès que l'on a un bouton en action
 * On regarde quel bouton est actif puis on declenche le traitement
 * @param e 
 */
    public void actionPerformed(ActionEvent e)           
    {
      String c = e.getActionCommand();          // on capte l'evenement : nom du bouton !
    
      if (c.equals(">>"))                       // Ce bouton ?
      {
         try{
            this.im = ImageIO.read(new File( this.vacances.suivante() ) );      // on charge une image
         }
         catch( IOException ex ) {ex.printStackTrace();}
            
      }  
      
      if (c.equals("<<")) 
      {
         try{
            this.im = ImageIO.read(new File( this.vacances.precedente() ) );      // on charge une image
         }
         catch( IOException ex ) {ex.printStackTrace();}
            
      }  
      repaint();        
    } 



/**
 * GESTION SOURIS : Quels evenements de souris vous voulez traiter ?
 * @param e 
 */
    public void mousePressed(MouseEvent e) { }
    
    public void mouseClicked(MouseEvent e){}
    
    public void mouseReleased(MouseEvent e){}
    
    public void mouseEntered(MouseEvent e)
    {
      try{
            this.im = ImageIO.read(new File( this.vacances.suivante() ) );      // on charge une image
           }
           catch( IOException ex ) {ex.printStackTrace();}  
      
      repaint();            // on demande la mise a jour de l'affichage 
    }
    
    public void mouseExited(MouseEvent e){}
    
     
}

