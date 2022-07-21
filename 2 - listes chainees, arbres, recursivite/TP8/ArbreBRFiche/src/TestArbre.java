
import java.io.IOException;
import java.util.ArrayList;

public class TestArbre {

    public static void main(String[] args) {
        ArrayList<Fiche> tabClass = new ArrayList();

        ChargementDonnees c = new ChargementDonnees();

        try {
            tabClass = c.chargementClassement();
        } catch (IOException e) {
            System.out.println("pb lors du chargement");
        }

        // creation d'un ABR avec le classement comme relation d'ordre
        ArbreBR A = new ArbreBRCons(tabClass, 0, 0);

        // en combien de fois on trouve la fiche index 49 du ArrayList ?
        System.out.println(A.rechercherABR(tabClass.get(49), 0));
        //1 fois

            // Notion de reference sur un objet partage entre tableau et arbre...
            System.out.println("----Notion de reference sur un objet partage entre tableau et arbre...");
            Fiche f = A.rechercherRef( tabClass.get(25) );
            System.out.println("Le code de l'element trouvé est :"+f.hashCode());
            System.out.println("Le code de l'element proposé :"+tabClass.get(25).hashCode());

            // Doit on inserer un element deja present ?
            System.out.println("----Doit on inserer un element deja present ?");
            Fiche nouv = new Fiche(1, "Tetris", 1984, "Multiplateforme", 170); // Cette fiche existe deja !!
            System.out.println("Le code de l'element nouv est :"+nouv.hashCode());
            A.insereTo( nouv );
            Fiche resultat = A.rechercherRef( nouv );
            System.out.println("Le code de l'element resultat recherche est :"+resultat.hashCode());
            System.out.println("On detecte un element identique et refuse l'ajout en gardant l'element deja present");
    }
}
