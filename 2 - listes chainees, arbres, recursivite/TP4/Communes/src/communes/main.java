/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communes;

/**
 *
 * @author Julien
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //test de la classe Ville
        Commune C = new Commune( 75404, 284300);
        Ville LR = new Ville("La Rochelle", 75404 , 284300);
        
        //test des attributs de Ville
        System.out.println(LR.getNom());
        System.out.println(LR.getNbH());
        System.out.println(LR.getSuperficie());
        
        //test de la méthode ratio()
        System.out.println(C.ratio());
        System.out.println(LR.ratio());
        
        //test de la classe ArrayListEtud
        ArrayListEtud f = new ArrayListEtud();
        f.add(new Personne("DURAND"));
        f.add(new Personne("TYPON"));
        f.add(new Personne("SANNIO"));
        f.add(new Personne("HENRI"));
        f.add(new Personne("DUFAUR"));
        
        System.out.printf(f.toString());
    }
    
}
