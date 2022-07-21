/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphisme;

/**
 *
 * @author Julien
 */
public class Pin extends Plante {
    private int age ;
    

    public Pin(int age) {
        super();
        this.age = age;
    }
    
    
    @Override
    public String toString() {
        return "Pin{" + "age=" + age + '}';
    }
    
    
}
