
package poisson;


public class TestPoisson {

   
    public static void main(String[] args) {
        //création de poissons
        Poisson p1 = new Poisson("Nemo", "Orange");
        Poisson p2 = new Poisson("Marin", "Orange");
        Poisson p3 = new Poisson("Dori", "Bleu");
        
        //test des getters
        System.out.println("Mon nom est " + p1.getNom() + " et je suis de couleur " + p1.getCouleur());
        System.out.println();
        
        //test de toSring
        System.out.println(p2.toString());
        System.out.println();
        
        //test de mesCopainsPoisson
        p1.mesCopainsPoissons();
        System.out.println();
        
        //test de getNourriture
        Poisson.nourrir(140);
        System.out.println("Il y a "+Poisson.getNourriture()+" unités de nourriture");
        System.out.println();
        
        //test de manger
        System.out.println(p2.getNom()+" mange");
        p2.manger(); //Marin mange
        System.out.println("Il reste "+Poisson.getNourriture()+" unités de nourriture");
        System.out.println();
        
        //test de jeLesObligeAManger
        System.out.println("Tout le monde mange");
        p1.jeLesObligeAManger();
        System.out.println("Il reste "+Poisson.getNourriture()+" unités de nourriture");
        System.out.println();
        
        //test de la condition ou il ne reste pas assez de nourriture
        System.out.println(p3.getNom()+" essaie de manger");
        p3.manger();
        System.out.println();
    }
    
}
