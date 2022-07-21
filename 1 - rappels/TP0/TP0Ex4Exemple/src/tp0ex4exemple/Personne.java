
package tp0ex4exemple;

// ATTENTION nom de la Classe = nom du fichier java !!
public class Personne {
    /**
     * Attributs : une personne sera representee par son nom et son age
     */
    private String nom;
    private int age;

    /**
     * Constructeur utilisé pour créer un objet :  Personne p1 = new Personne("Duty", 19 );
     * Toujours avec le même nom que la classe !!
     * @param nom
     * @param age 
     */
    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }
    /**
     * GETTERS et SETTERS pour manipuler les attributs
     *  
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * toString est une methode particulière qui permet de representer l'objet sous forme de String
     * @return la chaine de caractère qui represente le mieux l'objet
     */
    @Override
    public String toString() {
        return "Personne{" + "nom=" + this.nom + ", age=" + this.age + '}';
    }
    
    
}
