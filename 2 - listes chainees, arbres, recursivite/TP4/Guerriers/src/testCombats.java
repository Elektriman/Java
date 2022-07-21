/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julien
 */
public class testCombats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Combats C = new Combats();
        File equipe1 = new File();
        excalibur E = new excalibur(100, 100, 100);
        E.immortel = true ;
        equipe1.add(E);
        File equipe2 = C.equipDefault(20);
        C.setEquipe1(equipe1);
        C.setEquipe2(equipe2);
        C.commencer();
        E.getWeakSpots();

        Combats C2 = new Combats();
        File equipe3 = C.equipDefault(10);
        E.immortel = false ;
        C2.setEquipe1(equipe1);
        C2.setEquipe2(equipe3);
        C2.commencer();
        
    }
    
}
