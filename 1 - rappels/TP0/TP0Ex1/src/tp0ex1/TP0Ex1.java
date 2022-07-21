/*
 * TP0 Ex1
 * Objectif : savoir ouvrir un projet, executer le projet, comprendre les instructions, modifier le programme
 */

package tp0ex1;


public class TP0Ex1 {

    public static void main(String[] args) {
        int n=8;                        // Declaration de variable
        
        for (int i = 1; i <= n; i++) {  // On repete n fois l'affichage
            String etoiles = repetition("*", i); //on génère la chaine en utilisant la fonction définie ci-dessous
            System.out.println(etoiles);
            
            //on fait de même avec les "X" mais leur longueur est décrémentale contrairement aux "*".
            String ligneX = repetition("X", n-i) ;
            System.out.print(ligneX+"\n"); //on rajoute un retour à la ligne à la fin
        }
        
        System.out.println();           // Saut de ligne
    }
    
    /*création d'une fonction qui va générer une chaine de caractère redondante
    'caractere' est le caractère à répéter et 'iterations' est le nombre de fois qu'on le répète
    exemple : repetition("#", 3) = "###"
    */
    public static String repetition(String caractere, int iterations){
        String res = "";
        for(int i=0; i<iterations; i++){
            res+=caractere ;
        }
        return res ;
    }
    
}
