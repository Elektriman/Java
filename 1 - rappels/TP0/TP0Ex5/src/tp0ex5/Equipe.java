/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp0ex5;

import java.util.ArrayList;

/**
 *
 * @author Julien
 */
public class Equipe {
    private String nom;
    private ArrayList <Joueur> composition;

    /*
    constructeur personnalisé
    */
    public Equipe(String nom) {
        this.nom = nom;
        
        //définition des joueurs
        Joueur j1 = new Joueur("Griezman", 7, "Attaquant", 90);
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
        
        this.composition = List;
    }
    
    /*
    GETTER
    */
    public String getNom() {
        return nom;
    }

    /*
    cette fonction affiche tous les joueurs
    */
    public void afficher() {
        //affichage des joueurs
        for (int i=0; i<this.composition.size(); i++){
            System.out.println(this.composition.get(i).toString());
        }
        System.out.println();
    }
    
    /*
    cette fonction affiche tous les joueurs d'une même catégorie
    */
    public void afficherCat(String cat){
        for (int i=0; i<this.composition.size(); i++){
            if (this.composition.get(i).getPlace() == cat){ //on compare les postes avant d'afficher
                System.out.println(this.composition.get(i).toString());
            }
        }
        System.out.println();
    }
    
    /*
    cette fontion affiche les joueurs en petite forme sous le seuil seuilCoef
    */
    public void afficherPetiteForme(int seuilCoef){
        for (int i=0; i<this.composition.size(); i++){
            if (this.composition.get(i).getForme() <= seuilCoef){ //on évalue la forme du joueur avant d'afficher
                System.out.println(this.composition.get(i).toString());
            }
        }
        System.out.println();
    }
    
    /*
    cette fonction renvoie l'arrayList des joueurs d'une même catégorie
    */
    public ArrayList tabCat(String cat){
        
        //on crée la liste pour mettre les joueurs d'une certaine catégorie
        ArrayList <Joueur> res;
        res = new ArrayList();
        
        for (int i=0; i<this.composition.size(); i++){
            if (this.composition.get(i).getPlace() == cat){ //on vérifie la catégorie avant de les ajouter à la liste
                res.add(this.composition.get(i));
            }
        }
        
        return res;
    }
    
    /*
    cette méthode renvoie le meilleur joueur en terme de forme
    */
    public Joueur meilleur(){
        Joueur meilleur = this.composition.get(0);
        for (int i=0; i<this.composition.size(); i++){
            if(this.composition.get(i).getForme()>meilleur.getForme()){
                meilleur = this.composition.get(i);
            }
        }
        return meilleur;
    }
    
    public ArrayList<Joueur> selection(String cat){
        //on crée la liste pour mettre les joueurs d'une certaine catégorie
        ArrayList <Joueur> selection;
        selection = new ArrayList();
        
        //on récupère les joueurs d'un même catégorie
        ArrayList<Joueur> subcomposition = tabCat(cat);
        
        /*
        on définit m comme le plus petit entre 3 et le nombre de joueurs éligibles pour la sélection
        par exemple il n'y a que deux gardiens donc ils seront frocément dans la sélection
        */
        int m = 3;
        if (m > subcomposition.size()){
            m = subcomposition.size();
        }
        
        //on va donc chercher le meilleur joueur de la liste des memres éligibles
        for (int i=0; i<m; i++){
            int jmax = 0;
            for(int j=0; j<subcomposition.size(); j++){
                if(subcomposition.get(j).getForme()>subcomposition.get(jmax).getForme()){
                    jmax = j; //on va garder l'indice du meilleur et pas l'objet du meilleur joueur
                }
            }
            //on garde l'indice pour pouvoir supprimer le meilleur joueur des éligibles vers la sélection
            selection.add(subcomposition.remove(jmax));
        } //on recommence donc jusqu'à trois ou jusqu'à plus de joueurs
        
        //enfin, on renvoie la sélection
        return selection;
    }
}