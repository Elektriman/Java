/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communes;

/**
 *
 * @author Julien
 */
public class Ville extends Commune {
    private String nom ;

    public Ville(String nom, int nbH, int s) {
        super(nbH, s);
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    
    @Override
    public double ratio(){
        return super.ratio()*0.8 ;
    }
}
