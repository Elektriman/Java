/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communes;

import java.util.ArrayList ;

/**
 *
 * @author Julien
 */
public class ArrayListEtud extends ArrayList<Personne> {

    public ArrayListEtud() {
        super();
    }
    
    /**
     *
     * @param P
     * @return
     */
    @Override
    public boolean add(Personne P) {
        boolean flag = true; // is true while the function work as intended
        try {
            this.add(0, P); // add the element at the start
        }catch(Exception ex){ //catch exeptions
            flag = false ;
            throw ex ;
        }
        return flag ;
    }
}