
import java.util.HashMap;
import java.io.*;
import java.awt.Color;

public class LSystem {

    private String axiome;
    private HashMap<String, String> regles;
    private String expCourante;

    public LSystem() {
        /* definition regle derivation */
        this.regles = new HashMap();
        regles.put("X","X+Y++Y-X - -XX-Y+");
        regles.put("Y","-X+YY++Y+X--X-Y");
        regles.put("+","+");
        regles.put("-","-");

        this.expCourante = this.axiome;
    }

    public void derivation() {
        String nouvelleExp = "";
        
        for(int i = 0; i<expCourante.length(); i++){
            nouvelleExp += regles.get(expCourante.substring(i, i+1));
        }
        
        this.expCourante = nouvelleExp;
        System.out.println(this.expCourante);
    }

    public void resetExp() {
        this.expCourante = this.axiome;
    }

    public void interpretation() {
        Logo l = new Logo(400, 300, 90, Color.black, Logo.PEN_DOWN, 6);
        // lire l'expression et interpreter les symboles...
        for(int i = 0; i<expCourante.length(); i++){
            String curseur = expCourante.substring(i,i+1);
            if(null != curseur)switch (curseur) {
                case "X":
                    l.av();
                    break;
                case "Y":
                    l.av();
                    break;
                case "+":
                    l.rotG(60);
                    break;
                case "-":
                    l.rotD(60);
                    break;
                default:
                    break;
            }
        }
        

    }

    public int alea(int a, int b) {
        return (int) (Math.random() * (b - a + 1) + a);
    }

}
// Fractal
// axiome :"X"
// 'X'->"X+Y++Y-X--XX-Y+"
// 'Y'->"-X+YY++Y+X--X-Y"

// Plante
//  axiome ="X"
//  'X'->"F-[[X]+X]+F[+FX]-X"
//  'F'->"FF"
// Arbre
// axiome ="0"
// '0'->"1[-0]+0"
// '1'->,"11"
