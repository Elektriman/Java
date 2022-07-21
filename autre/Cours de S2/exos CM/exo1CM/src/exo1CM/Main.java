package exo1CM;

/**
 *
 * @author Julien
 */

import java.util.Scanner ;

public class Main {

    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        float euro = s.nextFloat();
        var taux = 1.10 ;
        var livres = euro*taux ;
        System.out.println(livres);
    }
    
}
