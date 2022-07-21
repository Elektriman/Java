/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Julien
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pet A1 = new Pet( "tigrette", "chat");
        Pet A2 = new Pet("Hotty", "Howl");
        
        System.out.println(A1.toString());
        System.out.println(A2.toString());
        A1.setEspece(A2.getEspece());
        System.out.println(A1.toString());
    }
}
