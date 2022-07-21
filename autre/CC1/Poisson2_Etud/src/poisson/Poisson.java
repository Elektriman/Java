

package poisson;

import java.util.ArrayList;

public class Poisson {
    
    //attributs
    private String nom;
    private String couleur;
    private static int nourriture ; //nourriture partagée
    private static ArrayList<Poisson> banc = new ArrayList(); //liste du banc de poissons
    
    //constructeur
    public Poisson(String nom, String couleur) {
        this.nom = nom;
        this.couleur = couleur;
        Poisson.banc.add(this);
    }
    
    //getters
    public String getNom() {
        return nom;
    }

    public String getCouleur() {
        return couleur;
    }
    
    //méthode toString
    @Override
    public String toString() {
        return "Poisson{" + "nom=" + nom + ", couleur=" + couleur + '}';
    }
    
    public void manger(){
        if(Poisson.nourriture>=30){ //y a-t-il assez de nourriture ?
            Poisson.nourriture-=30 ; //oui -> on diminue le stock
        } else {
            Poisson.nourriture = 0; //non -> on vide le retse de nourriture
            System.out.println("Il n'y a plus assez de nourriture !"); //et on affiche un messgae d'avertissement
        }
    }
    
    //méthode statique pour accéder au champ statique nourriture
    public static int getNourriture(){
        return Poisson.nourriture ;
    }
    
    //méthode rajoutée pour tester les fonction pour manger
    public static void nourrir(int qteNourriture){
        Poisson.nourriture += qteNourriture ;
    }
    
    //méthode pour afficher le banc de poisson
    public void mesCopainsPoissons(){
        System.out.println("Banc de Poissons :");
        for(Poisson p : Poisson.banc){ //utilisation d'un foreach sur le banc
            System.out.println(p.toString());
        }
    }
    
    //méthode pour faire manger les poissons
    public void jeLesObligeAManger(){
        for(Poisson p : Poisson.banc){ //foreach sur le banc
            p.manger();
        }
    }
}
