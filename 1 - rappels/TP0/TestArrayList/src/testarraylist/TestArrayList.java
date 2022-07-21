
package testarraylist;

import java.util.ArrayList;     // importation obligatoire

/**
 *
 * Objectif : testez les ArrayList en ajoutant, supprimant les elements.
 */
public class TestArrayList {

    
    public static void main(String[] args) {
        ArrayList <String> t;  // on declare une variable qui contiendra plus tard un ArrayList : le ArrayList n'existe pas vraiment ici
        t = new ArrayList();    // on crée le ArrayList avec le constructeur
        
        t.add("il"); t.add("fait");t.add("beau");t.add("aujourd'hui");t.add("lundi");t.add("au");t.add("travail");
        
        // parcourir le ArrayList
        
        for (int i = 0; i < t.size(); i++) {    // on affiche les elements
            System.out.print( t.get(i)+" " );            
        }
        System.out.println(); 
        
        String recup = t.remove(2);             // on retire un mot du ArrayList
        
        for (int i = 0; i < t.size(); i++) {
            System.out.print( t.get(i)+" " );            
        }
        System.out.println();
        
    }
    
}
