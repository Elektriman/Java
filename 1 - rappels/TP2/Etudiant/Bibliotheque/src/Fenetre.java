import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*; // Pour pouvoir utiliser les fichiers
import java.util.* ;


public class Fenetre extends JFrame implements ActionListener 
{
        
    private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
    private JPanel p1;                    // zone boutons hauts
    private JPanel p2;                    // zone boutons bas  
    
    private Image im;
    private Bibliotheque mesLivres = new Bibliotheque();
    
// CONSTRUCTEUR 
    
    public Fenetre(String titre, int largeur, int hauteur) 
    {
        super(titre);
        
        //--On cree une bibliotheque et on ajoute les livres----------------
        try {
            mesLivres.chargement("ListeLivres.txt");
        } catch(IOException e){
            System.out.println("Unable to load the file");
            e.printStackTrace();
        }
        
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                           
        mise_en_page( largeur, hauteur );    // on place les boutons et la zone de dessin ...
        
        //--On charge une image par defaut------------------------------
        try{
            this.im = ImageIO.read(new File( mesLivres.getLivre().getNomPhoto())); 
        }
        catch( IOException e ) {
            System.out.println("erreur d'image");
            e.printStackTrace();
        } 
        
        repaint(); // on redessine la fenetre	       
    }
    
    //dessin du texte et revoi du nombre de lignes dessinées
    public int drawText(Graphics g, String text, int x, int y, int maxL) {
        int p = 0; //pointeur
        int d = 0; //début de ligne
        int l = 0; //nombre de lignes
        
        while(d+p<text.length()){ //fin du texte ?
            if(p>maxL){ //fin de ligne ?
                //retour à la fin du dernier mot passé
                while(!" ".equals(text.substring(d+p,d+p+1))){ 
                    p--;
                }
                g.drawString(text.substring(d,d+p), x, y+l*13); //dessin de la ligne
                l++; //incrémentation de la ligne
                d+=p+1; //mise à jour du début de ligne
                p=0; //ràz du pointeur
            } else {
                p++;
            }
        }
        g.drawString(text.substring(d), x, y+l*13); //ajout de la fin du texte
        return l+1 ; //renvoie du nombre de lignes dessinées
    }
    

    public void mise_en_page(int maxX, int maxY) 
    {
        //--------------------------------------------------------------------
        // insertion boutons du haut
        this.p1 = new JPanel(new GridLayout());
        
        ajouteBouton("Supprimer", p1);
        ajouteBouton("Emprunter", p1);
        ajouteBouton("Rendre", p1);
   	  
  	getContentPane().add(p1,"North");  // on ajoute le panel en haut de la fenetre frame
        
        //--------------------------------------------------------------------
        // insertion boutons du bas
        this.p2 = new JPanel(new GridLayout());
        ajouteBouton("<<<", p2); 
        ajouteBouton(">>>", p2);                       
  	ajouteBouton("Quitter", p2);
		  
	getContentPane().add(p2,"South");  // on ajoute le panel en bas
        
        //--------------------------------------------------------------------
        // zone de dessin
        this.zoneDessin = new JPanel();
        this.zoneDessin.setSize(maxX,maxY);
        this.zoneDessin.setPreferredSize(new Dimension(maxX,maxY));
        getContentPane().add(this.zoneDessin,"Center");  // panel pour zoneDessiner au milieu
        //--------------------------------------------------------------------

        pack();
        setVisible(true);
    }
   
    // Accesseur au zoneDessin de la fenetre
    public Graphics getzoneDessin() {
        return this.zoneDessin.getGraphics();
    }
    
    
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
    
       
    public void paint(Graphics g)  // dessin de la fenetre generale
    {
        this.p1.repaint();  // on redessine les boutons hauts
        this.p2.repaint();  // on redessine les boutons bas
           
        g = this.zoneDessin.getGraphics(); // on redessine dans le panel de dessin
        
        effacer();
        
        g.drawImage(this.im, 30, 50, 400, 300, zoneDessin);
                
        Font StyleLesTitres = new Font("TimesRoman",Font.BOLD,20); // trois styles d'ecriture
 	Font StyleMoyen = new Font("TimesRoman", Font.ITALIC,14);
	Font StyleNormal = new Font("TimesRoman", Font.PLAIN,12);
        
        //écriture du titre
        g.setFont(StyleLesTitres);
        g.drawString(mesLivres.getLivre().getTitre(), 400, 80);
        
        //écriture du résumé
        g.setFont(StyleNormal);
        int l = drawText(g, mesLivres.getLivre().getTexte(), 400, 110, 30);
        
        //affichage des emprunts
        g.setFont(StyleMoyen);
        String tmp = String.format("Ce livre a été emprunté %d fois", mesLivres.getLivre().getNbEmprunts());
        g.drawString(tmp, 400, 130+(l+1)*12);
        
        //affichage des exemplaires restants
        g.setFont(StyleMoyen);
        int rest = mesLivres.getLivre().getNbExemplaires();
        String tmp2 = "Il ne reste plus d'exemplaires de ce livre !";
        if(rest>0){
           tmp2 = String.format("Il reste %d exemplaires", rest);
        }
        g.drawString(tmp2, 400, 150+(l+1)*12);
        
    }
    
    // GESTION DES ACTIONS SUITE A UN APPUIS SUR BOUTON : cette methode est declenchee si Un bouton quelconque est appuye
    @Override
    public void actionPerformed(ActionEvent e)  
    {
        String c = e.getActionCommand();     // on capte l'evenement : nom du bouton !

        if (c.equals("Quitter")) quitter();		
		  										
        if (c.equals(">>>")) 
        {
            mesLivres.suivant();
            try
            {
                this.im = ImageIO.read(new File( mesLivres.getLivre().getNomPhoto()) );      // on charge une image
            }
            catch( IOException ex ) {
                System.out.println("erreur d'image");
                ex.printStackTrace();
            }
        };
      
        if (c.equals("<<<")) 
        { 
            mesLivres.precedent();
            try
            {
                this.im = ImageIO.read(new File( mesLivres.getLivre().getNomPhoto()) );      // on charge une image
            }
            catch( IOException ex ) {
                System.out.println("erreur d'image");
                ex.printStackTrace();
            }
        }
      
        if (c.equals("Emprunter")) 
        {  
            mesLivres.emprunter();
        };
      
        if (c.equals("Rendre")) 
        {  
            mesLivres.rendre();
        };
      
        if (c.equals("Supprimer")) 
        {  
            mesLivres.supprimer();
            try
            {
                this.im = ImageIO.read(new File("VIDE.jpg"));      // on charge une image
            }
            catch( IOException ex ) {ex.printStackTrace();}
        };
        
        repaint();	       
    } 
    
   
}

