/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp0ex5;

/**
 * Joueur j1 = new Joueur("Griezman", 7, "Attaquant", 90);
 * @author Julien
 */
public class Joueur {
    /*
    un joueur est défini par 4 paramètres:
    nom, numéro, place, forme
    */
    private String nom;
    private int numero ;
    private String place;
    private int forme;
    
    /*
    constructeur par défaut
    */
    public Joueur(String nom, int numero, String place, int forme) {
        this.nom = nom;
        this.numero = numero;
        this.place = place;
        this.forme = forme;
    }
    
    /*
    GETTERS et SETTERS
    */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getForme() {
        return forme;
    }

    public void setForme(int forme) {
        this.forme = forme;
    }
    
    /*
    methode toString()
    */
    @Override
    public String toString() {
        return "Joueur{" + "nom=" + nom + ", numero=" + numero + ", place=" + place + ", forme=" + forme + '}';
    }
    
    
}
