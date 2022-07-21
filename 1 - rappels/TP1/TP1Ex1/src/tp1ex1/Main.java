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
public class Main {

    public static void main(String[] args) {
        //création de points
        Point P1 = new Point(46.056425, -1.083614, 0, 12);
        Point P2 = new Point(46.056455, -1.083547, 5, 12);
        
        //création d'un parcours
        ArrayList<Point> Parc = new ArrayList() ;
        Parcours Parc1 = new Parcours(Parc);
        
        //test du parcours
        Parc1.add(P1);
        Parc1.add(P2);
        Parc1.affiche();
    }
}
