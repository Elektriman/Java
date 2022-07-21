/*
 * Objectif : comprendre la constitution d'une classe, attributs, constructeur, methodes
 */
package tp0ex4exemple;


public class TP0Ex4Exemple {

    public static void main(String[] args) {
        Personne personne1 = new Personne("Dusson", 22);
        System.out.println( personne1.toString() );
        System.out.println("On change l'age de la personne avec setAge");
        personne1.setAge(30);
        System.out.print( personne1.toString() );
        
        // changez le nom...
        personne1.setNom("David");
        System.out.println( personne1.toString());
        
        // construisez deux nouvelles personnes....
        Personne moi = new Personne("Julien", 19);
        Personne Secretaire = new Personne("Mathilde", 39);
        
        //------------------test de la classe Animal----------------------------
        
        //définition des 3 instances
        Animal A1 = new Animal("Tigrette", "chat");
        Animal A2 = new Animal("Hooty", "chouette");
        Animal A3 = new Animal("Pluto", "chien");
        
        //test des getters, setters et de la méthode toString()
        A1.setEspece("chatte");
        System.out.println(A1.toString());
        System.out.println(A2.getNom());
        System.out.println(A3.getEspece());
        
    }
    
}
