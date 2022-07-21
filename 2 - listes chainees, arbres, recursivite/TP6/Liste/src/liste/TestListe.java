package liste;
import java.util.ArrayList;

public class TestListe {

    public static void main(String[] args) {
        /* tests TP05
        
        //définition de listes pour les tests
        Liste L = new ListeCons(0, new ListeVide());
        for (int i = 1; i < 10; i++) {
            L = new ListeCons(i, L);
        }
        Liste Lpair = new ListeCons(0, new ListeVide());
        for (int i = 1; i < 10; i++) {
            if(i%2==0){
                Lpair = new ListeCons(i, Lpair);
            }
        }
        Liste Limpair = new ListeCons(1, new ListeVide());
        for (int i = 2; i < 10; i++) {
            if(i%2==1){
                Limpair = new ListeCons(i, Limpair);
            }
        }
        
        System.out.println("premiers tests");
        L.afficher(); //test de afficher
        System.out.println("4 est dans L ? "+L.trouver(4)); //test de trouver
        System.out.println("L est de taille "+L.size()); //test de size
        System.out.println("La somme de L est "+L.somme()); //test de somme
        
        System.out.println();
        L.afficherInverse(); //test de afficherInverse
        
        //test de copie
        System.out.println();
        System.out.println("test de copie");
        Liste L2 = L.copie();
        L2 = L2.getReste();
        L.afficher(); //si L2 = L et n'est pas une copie alors L = [8,7,6,5,4,3,2,1,0]
        L2.afficher();
        
        //test de placerFin
        System.out.println();
        System.out.println("test de placerFin");
        L.placerFin(-1).afficher();
        
        //test de concat
        System.out.println();
        System.out.println("test de concat");
        Liste L3 = L.copie();
        Liste C = L.concat(L3);
        C.afficher();
        
        //test de inverser
        System.out.println();
        System.out.println("test de inverser");
        Liste Linv = L.inverser();
        Linv.afficher();
        
        //test de add
        System.out.println();
        System.out.println("test de add");
        Liste Ladd = L.add(75, 4);
        Ladd.afficher();
        
        //test de l'intersection
        System.out.println();
        System.out.println("test de intersection");
        Liste intersect = L.intersection(Lpair); //intersection non-vide
        Liste intersectVide = Limpair.intersection(Lpair); //intersection qui devrait être vide
        intersect.afficher();
        intersectVide.afficher();
        
        //test de Union
        System.out.println();
        System.out.println("test de Union");
        Liste Union1 = Lpair.Union(Limpair);
        Union1.afficher(); //union de nombres pairs et impairs
        Liste Union2 = L.Union(Limpair);
        Union2.afficher(); //union de tous les nombres avec les nombres pairs
        Liste Union3 = Lpair.getReste().Union(Limpair);
        Union3.afficher(); //union de quelques nombres pairs avec les nombres impairs
        
        //test de inclus
        System.out.println();
        System.out.println("test de inclus");
        System.out.println(L.inclus(Lpair)); //true : les nombres pairs sont inclus dans les nombres
        System.out.println(Lpair.inclus(Lpair.getReste())); //true : le reste de L est inclu dans L
        System.out.println(Lpair.getReste().inclus(Lpair)); //false : L n'est pas incluse dans son reste
        System.out.println(Lpair.inclus(Limpair)); //false : les nombres impairs ne sont pas inclus dans les nombres pairs
        
        //test avec d'autres types de données
        System.out.println();
        System.out.println("test d'autres types de données");
        System.out.println();
        System.out.println("Chaine de caractères");
        ListeCons Ch = new ListeCons("A", new ListeVide());
        for(int i=1; i<10; i++){
            Ch = new ListeCons("B", Ch);
        }
        Ch.afficher();
        System.out.println(Ch.trouver("A"));
        System.out.println(Ch.size());
        System.out.println(Ch.somme());
        
        System.out.println();
        System.out.println("Doubles");
        ListeCons Dbl = new ListeCons(0.0, new ListeVide());
        for(int i=1; i<10; i++){
            Dbl = new ListeCons((double) i/10, Dbl);
        }
        Dbl.afficher();
        System.out.println(Dbl.trouver(7/10));
        System.out.println(Dbl.size());
        System.out.println(Dbl.somme());

        */
        
        //tests TP06
        Liste R = Liste.randomListe(0,15,20);
        
        R.afficher();
        Liste Rs = R.QS();
        Rs.afficher();
    }
}
