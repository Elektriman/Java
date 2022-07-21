
package tp0ex5;

import java.util.ArrayList;

public class TP0Ex5 {

   
    public static void main(String[] args) {
        /*
        // créez une classe Joueur afin que les ligne suivantes puissent fonctionner
        
        Joueur j1 = new Joueur("Griezman", 7, "Attaquant", 90); // on fera de la lecture de fichier plus tard pour eviter tout cela...
        Joueur j2 = new Joueur("Giroud", 9, "Attaquant", 80);
        Joueur j3 = new Joueur("Mbappe", 10, "Attaquant", 85);
        Joueur j4 = new Joueur("Fekir", 18, "Attaquant", 75);
        Joueur j5 = new Joueur("Matuidi", 14, "Centre", 82);
        Joueur j6 = new Joueur("Kante", 13, "Centre", 90);
        Joueur j7 = new Joueur("Pogba", 6, "Centre", 87);
        Joueur j8 = new Joueur("Pavard", 2, "Defense", 85);
        Joueur j9 = new Joueur("Herandez", 21, "Defense", 89);
        Joueur j10 = new Joueur("Umtiti", 2, "Defense", 81);
        Joueur j11 = new Joueur("Varane", 4, "Defense", 91);
        Joueur j12 = new Joueur("Sidibé", 2, "Defense", 71);
        Joueur j13 = new Joueur("Tolisso", 16, "Centre", 80);
        Joueur j14 = new Joueur("Lloris", 1, "Gardien", 89);
        Joueur j15 = new Joueur("Mandanda", 6, "Gardien", 75);
        Joueur j16 = new Joueur("Thauvin", 7, "Attaquant", 88);
        
        //création de du arrayList
        ArrayList <Joueur> List;
        List = new ArrayList();
        
        //ajout des joueurs à la main
        List.add(j1);
        List.add(j2);
        List.add(j3);
        List.add(j4);
        List.add(j5);
        List.add(j6);
        List.add(j7);
        List.add(j8);
        List.add(j9);
        List.add(j10);
        List.add(j11);
        List.add(j12);
        List.add(j13);
        List.add(j14);
        List.add(j15);
        List.add(j16);
        
        //affichage des joueurs
        for (int i=0; i<List.size(); i++){
            System.out.println(List.get(i).toString());
        }
        
        System.out.println();
        
        //affichage des défenseurs
        for (int i=0; i<List.size(); i++){
            if(List.get(i).getPlace()=="Defense"){
                System.out.println(List.get(i).toString());
            }
        }
        */
        
        Equipe france = new Equipe("Equipe de France");
        france.afficher(); //affichage de l'équipe totale
        france.afficherCat("Centre"); //affichage des Centres
        france.afficherPetiteForme(85); //test de afficherPetiteForme
        
        //test de tabCat (affichage du 2e centre de l'équipe)
        System.out.println(france.tabCat("Centre").get(2).toString());
        System.out.println();
        
        //test de la méthode meilleur()
        System.out.println(france.meilleur());
        System.out.println();
        
        //récupération de la sélection puis affichage de cette dernière
        ArrayList<Joueur> selection = france.selection("Attaquant");
        
        for(int i=0; i<selection.size(); i++){
            System.out.println(selection.get(i).toString());
        }
    }
}
