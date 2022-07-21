/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julien
 */
public class Combats {
    static private int nbInstances = 0;
    private File equipe1 = new File();
    private File equipe2 = new File();
    private static double[] REPARTITION = {0.5, 0.6, 0.8, 1} ;
    
    public void Combats(File equipe1, File equipe2){
        this.equipe1 = equipe1 ;
        this.equipe2 = equipe2 ;
    }

    public File getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(File equipe1) {
        this.equipe1 = equipe1;
    }

    public File getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(File equipe2) {
        this.equipe2 = equipe2;
    }
    
    public void commencer(){
        System.out.println("Que le combat commence !");
        while(!equipe1.estVide() && !equipe2.estVide()){
            Personnage p1 = equipe1.get();
            Personnage p2 = equipe2.get();
            
            System.out.println(p1.toString()+" vs "+p2.toString());
            Personnage[] c = unContreUn(p1,p2);
            if(c[0].vie>0){
                c[0].setVie(100);
                equipe1.add(c[0]);
                System.out.println(c[0].toString()+" de l'équipe 1 a gagné");
                System.out.println(c[0].getMem());
            }else if(c[1].vie>0){
                c[1].setVie(100);
                equipe2.add(c[1]);
                System.out.println(c[1].toString()+" de l'équipe 2 a gagné");
            } else {
                System.out.println("Les deux personnages se sont entre-tués");
            }
            System.out.println();
        }
        
        if(equipe1.estVide()){
            System.out.println("L'équipe 2 a gagné !");
        }else if(equipe2.estVide()){
            System.out.println("L'équipe 1 a gagné !");
        } else {
            System.out.println("Les deux équipes se sont anihilées...");
        }
    }
    
    /**cette fonction sert à effectuer des combats en un contre un
     * elle prend en paramètres deux personnages 
     * et les renvoie à la fin du combat
     * 
     * @param p1
     * @param p2
     * @return Personnage[2]
     */
    public Personnage[] unContreUn(Personnage p1, Personnage p2){
        
        while(p1.vie>0 && p2.vie>0){ //l'un des deux est mort ?
            
            //les deux personnages attaquent
            int A1 = p1.attaque();
            int A2 = p2.attaque();
            
            if(A1>A2){ //le perso 1 a la meilleure attaque
                int cible = p1.choixCible( p2.getType() ); //choix de cible
                int dmg = p2.blesse( cible, A1 ); //attaque
                p1.apprendre( p2.getType(), cible, dmg ); //apprentissage
                
            } else if(A1<A2) { //le perso 2 a la meilleure attaque
                int cible = p2.choixCible( p1.getType() );//choix de cible
                int dmg = p1.blesse( cible, A2 ); //attaque
                p2.apprendre( p1.getType(), cible, dmg );
                
            } else { //égalité
                
                int cible = p1.choixCible( p2.getType() );//choix de cible
                int dmg = p2.blesse( cible, A1 ); //attaque
                p1.apprendre( p2.getType(), cible, dmg );//apprentissage
                
                int cible2 = p2.choixCible( p1.getType() );//choix de cible
                int dmg2 = p1.blesse( cible, A2 ); //attaque
                p2.apprendre( p1.getType(), cible2, dmg2 );//apprentissage
            }
        }
        //on renvoie les deux personnages dans un array
        Personnage[] res = new Personnage[2];
        res[0] = p1 ;
        res[1] = p2 ;
        return res;
    }
    
    public File equipDefault(int n){
        File equipe = new File();
        double p = 0.0 ;
        for(int i=0; i<n; i++){
            p = (double) i/n ;
            int r = 0 ;
            while(REPARTITION[r]<p){
                r++ ;
            }
            switch(r){
                case 0:
                    equipe.add(new chevalier(100,100,100));
                    break;
                case 1:
                    equipe.add(new excalibur(200,100,100));
                    break;
                case 2:
                    equipe.add(new enchanteur(80, 120, 120));
                    break;
                case 3:
                    equipe.add(new truqueur(80, 100, 150));
            }
        }
        return equipe ;
    }
}