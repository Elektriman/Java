/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp0ex4exemple;

/**
 *
 * @author Julien
 */
public class Animal {
    /*
    un animal est défini par son nom et son espece
    */
    private String nom ;
    private String espece ;
    
    /*
    Constructeur d'objets par défaut avec le constructeur
    */
    public Animal(String nom, String espece) {
        this.nom = nom;
        this.espece = espece;
    }
    
    /*
    GETTERs et SETTERs pour manipuler les noms et especes
    */
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
    
    /*
    la méthode toString pour afficher rapidement un objet et ses attributs
    */
    @Override
    public String toString() {
        return "Animal{" + "nom=" + nom + ", esp\u00e8ce=" + espece + '}';
    }
    
    
}
