/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex22;

/**
 *
 * @author csempe
 */
public class TP0Ex22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] tab = { 12, 15, 2, 6, 8, 7, 16, 19, 7, 3 };  // tableau d'entiers initialisé avec des valeurs
        
        int uneValeur = tab[0];        
        System.out.println( uneValeur);
        
        tab[2] = 88;
        
        //correction du symbole comparatif "<=" par "<" sinon l'indice i dépasse la valeur authorisée
        for (int i = 0; i < tab.length; i++) {    //afficher un tableau
            System.out.print( tab[i] + " "); //rajout des crochets afin d'afficher le ième élément à chque itération
        }
        
        // tab[ 20 ] = 99;
        /*
        il n'y a que 10 éléments dans tab donc tab[20] n'a pas de sens ici.
        on peut soit corriger le 20 en un nombre entre 0 et 9,
        sinon on peut copier tab dans un tableau de 21 cases et mettre le dernier élément à 99
        */
        
        //méthode 1
        tab[9] = 99;
        
        //méthode 2
        int [] copie = new int[21];
        
        for(int i=0; i<tab.length; i++){
            copie[i]=tab[i];
        }
        
        System.out.println();
        
        copie[20] = 99;
        
    }
    
}
