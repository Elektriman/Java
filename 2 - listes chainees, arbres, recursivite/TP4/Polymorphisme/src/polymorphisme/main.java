/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphisme;
import java.util.ArrayList;

/**
 *
 * @author Julien
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //tests des classes de plantes pour tester le polymorphisme
        ArrayList<Plante> P = new ArrayList();
        P.add(new Peuplier(18.7));
        P.add(new Pin(11));
        P.add(new Rosier());
        for(Plante plante : P){
            System.out.println(plante.toString());
        }
    }
    
}
