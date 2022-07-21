/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphisme;

/**
 *
 * @author Julien
 */
public class Peuplier extends Plante {
    private double taille ;

    
    public Peuplier(double taille) {
        super();
        this.taille = taille;
    }
    

    @Override
    public String toString() {
        return "Peuplier{" + "taille=" + taille + '}';
    }
    
    
}
