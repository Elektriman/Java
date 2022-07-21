/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Julien
 */
public class Pet {
    private String nom ;
    private String espece ;

    public Pet(String nom, String espece) {
        this.nom = nom;
        this.espece = espece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    @Override
    public String toString() {
        return "Pet{" + "nom=" + nom + ", espece=" + espece + '}';
    }
    
    
}
