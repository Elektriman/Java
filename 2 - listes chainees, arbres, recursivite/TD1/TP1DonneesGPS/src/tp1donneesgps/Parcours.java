package tp1donneesgps;

import java.util.ArrayList;
import java.io.*;


public class Parcours
{
   //-STRUCTURE DE DONNEES "points"-------------------------------------------------------------------
   private ArrayList<Point> points;
   
   //-CONSTRUCTEUR------------------------------------------------------------------------------------

    public Parcours() {
        this.points = new ArrayList<>() ;
    }

   //-METHODES---------------------------------------------------------------------------------------

    /**
     *
     * @throws IOException
     * Methode qui permet le chargement des points a partir d'un fichier DonneesGPS.csv
     */

   public void chargement()throws IOException
   {
   
      double lat, lon, alt, temps;
                  
      FileReader fic = new FileReader("DonneesGPS.csv");
	   StreamTokenizer entree=new StreamTokenizer(fic) ;
      
      entree.quoteChar('"');
   	entree.nextToken();
   	int i =0;
   	while (entree.ttype!=StreamTokenizer.TT_EOF)
   	{
   		lat=entree.nval ;                            // lecture 4 par 4 des donn�es lat , lon, alt et temps
         
         entree.nextToken();
         lon=entree.nval ;
   		
         entree.nextToken();
         alt=entree.nval ;
         
         entree.nextToken();
         temps=entree.nval ;
         
         Point p = new Point( lat, lon, alt, temps ); // creation du point avec les donn�es
         points.add( p );                            // ajout du point au tableau nommé "points"
         
         entree.nextToken();                          // et on recommence...
   	}
      
      fic.close();
   }
   
   //affiche les éléments de points
   public void afficher()
   {
       for(int i=0; i<points.size(); i++){
           System.out.print(points.get(i).toString()+"\n");
       }
       System.out.println();
   }
   
   //calcule l'altitude maximale
   public double altitudeMax()
   {
      double max = points.get(0).getAlt();//initialisation du max
      
      for(int i=0; i<points.size(); i++){
           if (points.get(i).getAlt()>max){
               max = points.get(i).getAlt(); //actualisation du max
           }
       }
      return max;
   }
   
   //calcule le distance totale du parcours
   public double distance()
   {
      double S = 0.0 ; //variable de la somme
      for(int i=1; i<points.size(); i++){
           S+=points.get(i-1).distance(points.get(i));
       }
      return S;
    }

   //calcule le temps total du parcours
   public double temps()
   {
    double T = 0.0; //variable de la somme
    for (int i=1; i<points.size(); i++){
        T += points.get(i).getTemps();
    }
    return T ;
   }
   
   //crée un tableau de taille points.size()-1 avec les vitesses moyennes entre chaque points
   public double[] creerVitesses()
   {
      double[] vitesses = new double[points.size()-1]; //création du tableau avec une case de moins que la liste de points
      for(int i=1; i<points.size(); i++){
          vitesses[i-1] = points.get(i-1).distance(points.get(i))/points.get(i).getTemps(); 
          //indice de vitesse i-1 à cause des valeurs prises par i
          //vitesse = distance entre deux points/temps entre deux points = distance du point i-1 à i / temps du point i
          //par définition, le temps du point i est le temps du point i-1 au point i (avec le temps du point 0 égal à 0)
      }
      return vitesses ;
   }
   
   //affiche le tableau des vitesses
   public void afficherVitesses(double[] vitesses){
       for(double v : vitesses){
           System.out.println(v);
       }
   }
   
   //renvoie la vitesse moyenne sur l'ensemble du parcours
   public double vitesseMoy(){
       return 1000*this.distance()/this.temps() ; //Vitesse moyenne = Distance totale/Temps total
   }
   
   //décompose le parcours en portions de [intervalledist]km de long et donne la vitesse moyenne sur chaque portion
   public ArrayList <Double> split( double intervalleDist )
   {
       //création des variables
       ArrayList<Double> split = new ArrayList<>();
       double D = 0.0;
       double T = 0.0;
       
       //itération
       for(int i=1; i<points.size (); i++){
           if (D>intervalleDist){ //détection du changement de portion
               //remise à zéro des comptes de distance et temps au changement de protion et ajout des valeurs à split
               split.add(D/T);
               D = 0.0 ;
               T = 0.0 ;
           } else {
               //incrémentation des comptes de distance et de temps
               D+=points.get(i-1).distance(points.get(i));
               T+=points.get(i).getTemps();
           }
       }
       return split ;
   }
   
   //cette fonction affiche les maximums locaux des altitudes des points
   public void afficherLesMax(){
       for(int i=1; i<points.size()-1; i++){
           //détection d'un maximum local lorsqu'un point se trouve entre une variation d'altitude positive puis négative
           if ( points.get(i-1).getAlt() - points.get(i).getAlt() < 0 && points.get(i).getAlt() - points.get(i+1).getAlt() > 0){
               System.out.println(points.get(i));
           }
       }
   }
   
   //cette fonction trace sur une fenêtre les altitudes en fonction de la distance parcourue
   public void tracerAltitude(Fenetre fenetre)
   {
      for(int i=0; i<points.size(); i++){
         double R1 = 1500.0/points.size(); //rapport de conversion de l'axe horizontal
         double R2 = 500/this.altitudeMax(); //rapport de conversion de l'axe vertical
         fenetre.tracerPoint((int)(i * R1 ),500-(int)(points.get(i).getAlt()*R2)); //forçage de la converstion en int pour pouvoir tracer les points
      }
   }
   
   //cette fonction trace les vitesses en fonction de la distance parcourue
   public void tracerVitesse(Fenetre fenetre)
   {
      ArrayList<Double> vitesses = this.split(0.5);//création des vitesse via le split
      
      for(int i=0; i<vitesses.size(); i++){
         double R1 = 1500.0/(2*vitesses.size()); //rapport de conversion de l'axe horizontal
         double R2 = 100000; //rapport de conversion de l'axe vertical
         fenetre.tracerPoint((int)(i * R1 ),500-(int)(vitesses.get(i)*R2)); //forçage de la convertion en int pour tracer les points
      }
   }



}