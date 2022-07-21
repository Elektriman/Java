/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2cm;

/**
 *
 * @author Julien
 */

import java.util.Scanner ;

public class Main {

    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        float mps = s.nextFloat() ;
        var taux = 3.6 ;
        double kmh = mps*taux ;
        System.out.println(kmh);
        double allure = 60/(kmh) ;
        System.out.println(allure);
    }
    
}
