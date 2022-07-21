/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp0ex2;

/**
 *
 * @author csempe
 */
public class TP0Ex2 {

    public static void main(String[] args) {
        int mavaleur = 25;
        
        double resultat1 = calcul1(mavaleur); //complétion de l'appel de la fonction calcul1()
        System.out.println(resultat1);
        
        double resultat2 = calcul2(12, 23.6);
        System.out.println(resultat2);
        
        System.out.println();
        
    }
    
    public static double calcul1(int val){ //correction du type de variable de sortie de calcul1()
        double resultat = val*1.25;
        return resultat;
    }
    
    public static double calcul2(double hauteur, double largueur){
        
        double resultat = hauteur*largueur;//correction de l'orthographe de la variable hauteur
        return resultat;
    }
    
}
