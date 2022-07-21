package liste;

public class TestListe {

    public static void main(String[] args) {
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

        //L.afficher();
        //System.out.println(L.rechercherelt(4));
        //System.out.println(L.size());
        //System.out.println(L.somme());
        
        //L.afficherInverse();
        /*
        Liste L2 = L.copie();
        L2 = L2.getReste();
        L.afficher();
        L2.afficher();
        */
        /*
        L = L.placerFin(-1);
        L.afficher();
        */
        /*
        Liste L2 = L.copie();
        Liste C = L.concat(L2);
        C.afficher();
        */
        /*
        Liste Linv = L.inverser();
        Linv.afficher();
        */
        /*
        Liste Ladd = L.add(75, -1);
        Ladd.afficher();
        */
        
        
        /*
        Liste intersectVide = Limpair.intersection(Lpair);
        Liste intersect = L.intersection(Lpair);
        intersect.afficher();
        intersectVide.afficher();
        */
        
        /*
        Liste Union1 = Lpair.Union(Limpair);
        Union1.afficher();
        Liste Union2 = L.Union(Limpair);
        Union2.afficher();
        Liste Union3 = Lpair.getReste().Union(Limpair);
        Union3.afficher();
        */
        
        /*
        System.out.println(L.inclus(Lpair));
        System.out.println(Lpair.inclus(Lpair.getReste()));
        System.out.println(Lpair.getReste().inclus(Lpair));
        System.out.println(Lpair.inclus(Limpair));
        */
        
        /*
        ListeCons Ch = new ListeCons("A", new ListeVide());
        for(int i=1; i<10; i++){
            Ch = new ListeCons("B", Ch);
        }
        Ch.afficher();
        System.out.println(Ch.rechercherelt("A"));
        System.out.println(Ch.size());
        System.out.println(Ch.somme());
        */
    }
}
