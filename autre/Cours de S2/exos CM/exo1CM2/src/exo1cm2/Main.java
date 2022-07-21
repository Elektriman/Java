/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo1cm2;

/**
 *
 * @author Julien
 */
public class Main {

    public static void affiche(int m, int M){
        int S=0 ;
        for (int i=m; i<M+1; i++){
            System.out.println(i);
            S+=i ;
        }
        System.out.println(S);
    }
    
    static long factorielle(int n){
        int p = 1 ;
        for (int i = 1; i<n+1; i++){
            p*=i ;
        }
        return(p) ;
    }
    
    public static void main(String[] args) {
        affiche(100,200);
        System.out.println(factorielle(6));
    }
}
