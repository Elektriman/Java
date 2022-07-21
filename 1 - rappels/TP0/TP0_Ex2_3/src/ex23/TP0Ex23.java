/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex23;

import java.util.Scanner;

/**
 *
 * @author csempe
 */
public class TP0Ex23 {

    
    public static void main(String[] args) {
        
        //correction de la ligne suivante en rajoutant "new"
        int [] tab = new int [5];                   //declaration du tableau
        Scanner sc = new Scanner( System.in);
        
        //remplaçage de "j" par "i"
        for( int i=0; i< tab.length; i++){      //lecture des données
            System.out.print("Entrez la "+i+" valeur : ");
            tab[i] = sc.nextInt();
        }
        //correction du symbole "<=" par "<"
        for( int i=0; i< tab.length; i++){     //affichage du tableau
            System.out.println("Val "+i+" : "+ tab[i]);  //ajout des crochets pour accéder aux éléments du tableau          
        }
        
        
        
    }
    
}
