/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1ex1;

import java.util.ArrayList ;

/**
 *
 * @author Julien
 */
public class Parcours {
    //la seule structure est la liste de points du parcours
    private ArrayList<Point> parcours ;
    
    //constructeur
    public Parcours(ArrayList<Point> parcours) {
        this.parcours = parcours;
    }
    
    //méthode add() pour ajouter un point
    public void add(Point p) {
        this.parcours.add(p);
    }
    
    //méthode affiche() pour afficher tous les points dans l'ordre
    public void affiche() {
        for (int i=0; i<this.parcours.size(); i++){
            System.out.println(this.parcours.get(i).toString());
        }
    }
    
    //méthode pour avoir l'altitude maximum du parcours
    public double altitudeMax() {
        //ici on fait un algorithme simple de recherche de maximum
        double max = this.parcours.get(0).getAlt();
        
        for (int i=0; i<this.parcours.size(); i++){
            double alt = this.parcours.get(i).getAlt();
            if (alt>max){
                max = alt ;
            }
        }
        return max ;
    }
    
    //méthode pour obtenir le temps de parcours total
    public double temps(){
        //il suffit de faire la somme des temps d'écart entre les points
        double T = 0.0;
        for (int i=1; i<this.parcours.size(); i++){
            T += this.parcours.get(i).getEcart_t();
        }
        return T ;
    }
}
