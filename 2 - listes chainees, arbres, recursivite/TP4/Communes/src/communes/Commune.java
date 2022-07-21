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
public class Commune {
    protected int nbHabitants;
    protected double superficie;
    
    Commune(int nbH, int s ){
        this.nbHabitants = nbH;
        this.superficie = s;
    }
    public int getNbH(){
        return this.nbHabitants;
    }
    public double getSuperficie(){
        return this.superficie;
    }
    public double ratio(){
        return this.nbHabitants/this.superficie;
    }
}
