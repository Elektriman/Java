// QT :: Noir | Blanc | (QT QT QT QT)
// QT :: Vide

public class LireQT {

    private ArbreQT arb;        // on va construire un arbreQT ici
    private String s;           // chaine de caracteres a analyser
    private int index;          // tres important car index suit la lecture sur la chaine de caractère
    private boolean erreurDetect;
    private ReprUnique Repr ;

    public LireQT(String s, ReprUnique R) {
        this.s = s;
        this.Repr = R ;
        index = 0;
        erreurDetect = false;

        this.arb = QT();                              // on lance l'analyse
        if (erreurDetect) {
            this.arb = new AQTVide();   // si la moindre erreur est detectée alors on retournera AQTVide	
        }
    }

    /**
     * Analyse de l'expression
     *
     * @return ArbreQT
     */
    private ArbreQT QT() {
        char c = s.charAt(index);              // lecture d'un caractere dans la chaine
        index++;                                // on avance l'index de 1 sur la chaine

        switch (c) // que doit t on faire ? Cela depend du caractere lu
        {
            case 'B':
                return Repr.getRef(new Blanc());
            case 'N':
                return Repr.getRef(new Noir());
            case '(':                      // une pararenthse ouvrante doit lancer 4 analyses ET verifier la parenthse fermante
                ArbreQT I1 = QT();
                ArbreQT I2 = QT();
                ArbreQT I3 = QT();
                ArbreQT I4 = QT();
                if(s.charAt(index++)==')'){
                    return Repr.getRef(new AQTCons(I1, I2, I3, I4));
                }
                break;
            default:
                System.out.println("Erreur Syntaxe caract�re " + index + "  : " + c);
                erreurDetect = true;

        }
        return new AQTVide();  // si on arrive ici c'est qu'il y a eu une erreur	
    }

    /**
     * Permet de recuperer de l'exterieur, l'arbre construit
     *
     * @return ArbreQT
     */
    public ArbreQT get() {
        return this.arb;
    }

}
