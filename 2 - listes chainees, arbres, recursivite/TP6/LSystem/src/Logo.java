import java.awt.*;
import java.util.Stack;

/* Logo va nous permettre de tracer des motifs selon les commandes choisie */
 

public class Logo {

   
   private static final double COEFDIMINUTION=0.7;
   private static final int HauteurFenetre=800;
   

     /**
     * Constante indiquant si le stylo est en bas
     */
    public static boolean PEN_DOWN = true;

    /**
     * Constante indiquant si le stylo est en haut donc pas de trace
     */
    public static boolean PEN_UP = false;

    /* variables d'instances ----------------------------------------------------------- */
    
    private int x;
    private int y;
    private int angle;
    private Color couleur;
    private boolean positionStylo;
    private int pas;                   // pas pour avancer
    
    
    /*  variables de classe communes entre tous les objets-------------------------------*/
    protected static Stack <Logo> p = new Stack <Logo> ();        // memo des contextes partagées entre objets
    protected static Fenetre f = new Fenetre("Lindenmayer", 1000, 800); //fenetre commune aux objets Logo

    
        
    /**
     * Constructeur principal
     
     */
    public Logo(int initX, int initY, int initAngle, Color initColor, boolean posStylo, int pas) 
    {
   	this.x=initX;
   	this.y=initY;
   	this.angle=initAngle;
   	this.couleur = initColor;
   	this.positionStylo = posStylo; 
      this.pas = pas;  
         
    }
    
     /**
     * getter setter
     */
     
    public int getX() {
	   return this.x;
    }

    public int getY() {
	   return this.y;
    }    
    
    public void setX(int x) {
	   this.x=x;
    }

    public void setY(int y) {
	   this.y=y;
    }

    public Color getCouleur() {
	   return this.couleur;
    }

    public int getAngle() {
	   return this.angle;
    }

   public int getPas() {
	   return this.pas;
    }
    
   public void setPas(int pas) {
	   this.pas = pas;
    }


   public void setAngle(int a) {
	   this.angle = a;      
   }

    /**
     * Deplace la tortue de n pixels 
     */
    public void av() {
   	double radAngle = Math.toRadians(this.angle);
   	int nouvx = this.x + (int)Math.round(Math.cos(radAngle) * this.pas);
   	int nouvy = this.y + (int)Math.round(Math.sin(radAngle) * this.pas);
      f.tracerLigne(this.x, HauteurFenetre-this.y, nouvx, HauteurFenetre-nouvy, this.couleur );
      this.x = nouvx;
      this.y = nouvy;
    }

    /**
     * Rotation a droite sens horaire
     */
   
   public void rotD(int a) {
	   int newAngle = this.angle - a;
	   this.angle = newAngle % 360;
    }
    
    /**
     * Rotation a gauche
     */
   
   public void rotG(int a) {
	   int newAngle = this.angle + a;
	   angle = newAngle % 360;
    }


    /**
     * stylo en bas
     */
    public void StyloBas() {
	   this.positionStylo = PEN_DOWN;
    }

    /**
     * stylo en haut
     */
    public void StyloHaut() {
	   this.positionStylo = PEN_UP;
    }

    /**
     * 
     */
    public boolean getEtatStylo() {
	   return this.positionStylo;
    }

       
    public void memo()
    {
      // on instancie un nouveau Logo avec les parametres actuels
      Logo l = new Logo( this.getX() , this.getY(), this.angle, this.couleur , this.getEtatStylo(), this.pas );
      Logo.p.push(l);         // on memorise le contexte actuel
      
    } 
    
    public void recupMemo( )
    {
      Logo l = Logo.p.pop();  // on recupere le contexte anterieur
      this.x = l.getX();
      this.y = l.getY();
      this.angle = l.getAngle();
      this.couleur = l.getCouleur();
      this.positionStylo = l.getEtatStylo();
      this.pas = l.getPas();
      
    } 
    
    public void reduction()   //reduction du pas
    {
      // modif du pas pour diminuer la taille des segments
      this.pas = (int) (this.pas*COEFDIMINUTION);    
    }

   public String toString()
   {
      String s= "x= "+this.getX()+" y= "+this.getY()+" angle : "+this.angle;
      if (this.positionStylo == PEN_UP )
         s=s+" EtatStylo : en haut";
      else
         s=s+" EtatStylo : en bas";
         
      return s;
   }

}

