
public class Test {
    public static void main( String [] arg){
        Arbre a1 = new ArbreCons("UN");     // Feuille
        Arbre a2 = new ArbreCons("DEUX");   // Feuille
        
        
        Arbre a3 = new ArbreCons( "TROIS", a1, a2);
        Arbre a4 = new ArbreCons( "QUATRE", a3, new ArbreCons("CINQ"));   
        
        //affichage
        System.out.println("test d'affichage GRD");
        a4.afficheGRD(); //1 3 2 4 5
        
        //nbFeuilles
        System.out.println("test de nbFeuilles");
        System.out.println(a4.nbFeuilles()); //3
        
        //trouver
        System.out.println("test de trouver");
        System.out.println(a4.trouver("TROIS")); //true
        System.out.println(a4.trouver("SIX")); //false
        
        //le plus a droite
        System.out.println("test du plus a droite");
        System.out.println(a4.lePlusADroite()); //5
        
        //suppression
        System.out.println("test de suppression");
        a4.supprimer("QUATRE").afficheGRD(); //3 2 1 5
        
        //constructeur vide
        System.out.println("test du constructeur vide");
        Arbre A = new ArbreCons(2);
        A.afficheGRD(); //null (racine) + 2*null(2 branches de niveau 1) + 4*null (2*2 feuilles)
        //doit afficher 7 "null"
    }
}
