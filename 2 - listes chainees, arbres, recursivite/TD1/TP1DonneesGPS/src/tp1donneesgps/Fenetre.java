package tp1donneesgps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.io.*; // Pour pouvoir utiliser les fichiers
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
   


public class Fenetre extends JFrame  
{
        
    private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
    private ArrayList <java.awt.Point> memo ;
    
    
    
// CONSTRUCTEUR 

    /**
     *
     * @param titre de la fenetre
     * @param largeur
     * @param hauteur
     */
    
    public Fenetre(String titre, int largeur, int hauteur) 
    {
        super(titre);
        getContentPane().setLayout(new BorderLayout());
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        memo = new ArrayList();                   
        mise_en_page( largeur, hauteur );
        
    }
    
// la fenetre est constituee de trois parties Panel Nord : boutons ; Sud : boutons; Centre: zone de zoneDessin
    private void mise_en_page(int maxX, int maxY) 
    {
                
        // zone de dessin
        this.zoneDessin = new JPanel();
        this.zoneDessin.setSize(maxX,maxY);
        this.zoneDessin.setPreferredSize(new Dimension(maxX/2,maxY));
        JScrollPane scrollPane = new JScrollPane(this.zoneDessin);

        getContentPane().add(scrollPane,"Center");  // panel pour zoneDessiner au milieu
        //--------------------------------------------------------------------
        pack();
        setVisible(true);
    }
   
    // Accesseur au zoneDessin de la fen�tre
    public Graphics getzoneDessin() {
        return this.zoneDessin.getGraphics();
    }
    
    // Proc�dure d'arr�t
    void quitter() {
        System.exit(0);
    }
    
    
    void effacer() {
        
    }
      
       
    public void paint(Graphics g)  // dessin de la fenetre generale
    {
                     
         g= this.zoneDessin.getGraphics(); // on redessine dans le panel de dessin
         //***************************************************************************************************************
         // c'est ici qu'il faut mettre les elements a afficher VOIR DOC CLASSE Graphics
         g.setColor(Color.RED);
         for( int i =0 ; i< memo.size()-1; i++ )
         {
           //g.fillOval((int)memo.get(i).getX(), (int)memo.get(i).getY(), 3, 3); 
           g.drawLine((int)memo.get(i).getX(), (int)memo.get(i).getY(), (int)memo.get(i+1).getX(), (int)memo.get(i+1).getY());
         }
                
         
         //***************************************************************************************************************
    
    }
    
    /**
     *
     * @param x
     * @param y
     */
    public void tracerPoint( int x, int y )
    {
      memo.add( new Point( x, y ) );
      repaint();
    }
    
    /**
     *
     * @param millis en msecondes
     */
    public static void attendre(long millis) 
    {
            try{Thread.sleep(millis);} 
                catch(InterruptedException e){}
    } 
   
}



// INFO COULEURS

// Color.WHITE, Color.WHITE, Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY , Color.RED, Color.GREEN,
// Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.GRAY, Color.PINK, Color.YELLOW