/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo3cm;

/**
 *
 * @author Julien
 */

import java.util.Scanner ;
import java.lang.Math; 

public class Main {

    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        double epsilon = s.nextDouble();
        double accuracy = 1 ;
        double ln2 = 0 ;
        int n = 1 ;
        while (accuracy > epsilon){
            double a = Math.pow((-1),(n+1))/n ;
            if (a>0){
                accuracy = a ;
            } else {
                accuracy = -a ;
            }
            ln2 += a ;
            n += 1 ;
        }
        System.out.println(ln2) ;
    }
}
