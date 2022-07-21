/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1donneesgps;

import java.io.IOException;
import java.util.ArrayList;


public class TP1DonneesGPS {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Parcours Parc = new Parcours();
        Parc.chargement();
        
        /*
        Parc.afficher();
        double[] vitesses = Parc.creerVitesses();
        Parc.afficherVitesses(vitesses);
        */
        
        System.out.println("alt max = "+Parc.altitudeMax()+" km");
        System.out.println("distance tot = "+Parc.distance()+" km");
        System.out.println("Temps tot = "+Parc.temps()+" s");
        System.out.println("Vitesse moy = "+Parc.vitesseMoy()+" m/s");
        
        /*
        ArrayList<Double> split1 = Parc.split(1);
        for (int i=0; i<split1.size(); i++){
            System.out.println(split1.get(i));
        }
        */
        
        // Parc.afficherLesMax();
        
        Fenetre affichageAlt = new Fenetre("Altitude course", 1500,500);
        Fenetre affichageVit = new Fenetre("Vitesses course", 1500,500);
        Parc.tracerAltitude(affichageAlt);
        Parc.tracerVitesse(affichageVit);
    }
}
