
public abstract class ArbreQT {
    public abstract boolean estVide();
    public abstract boolean estFeuille();
    public abstract String toString();
    public abstract boolean equals(ArbreQT A);
    public abstract ArbreQT copy();
}

class AQTVide extends ArbreQT {
    @Override
    public boolean estVide(){return true;}
    @Override
    public boolean estFeuille(){return false;}
    @Override
    public String toString(){return "" ;}
    @Override
    public boolean equals(ArbreQT A){return A.estVide();}
    @Override
    public ArbreQT copy(){return new AQTVide();}
}

class AQTCons extends ArbreQT {
    //definition des arguments de l'arbre
    private ArbreQT I1 ;
    private ArbreQT I2 ;
    private ArbreQT I3;
    private ArbreQT I4 ;
    
    //constructeur
    public AQTCons(ArbreQT I1, ArbreQT I2, ArbreQT I3, ArbreQT I4) {
        this.I1 = I1;
        this.I2 = I2;
        this.I3 = I3;
        this.I4 = I4;
    }

    public ArbreQT getI1() {
        return I1;
    }

    public ArbreQT getI2() {
        return I2;
    }

    public ArbreQT getI3() {
        return I3;
    }

    public ArbreQT getI4() {
        return I4;
    }
    
    @Override
    public boolean estVide(){return false;}
    
    @Override
    public boolean estFeuille(){return false;}
    
    @Override
    public String toString(){
        return "( "   + I1.toString()
                + " " + I2.toString()
                + " " + I3.toString()
                + " " + I4.toString()
                + " )" ;
    }
    
    @Override
    public ArbreQT copy(){
        return new AQTCons(I1.copy(), I2.copy(), I3.copy(), I4.copy());
    }
    
    @Override
    public boolean equals(ArbreQT A){
        if(A instanceof AQTCons){
            AQTCons B = (AQTCons) A ;
            return I1.equals(B.getI1())
                && I2.equals(B.getI2())
                && I3.equals(B.getI3())
                && I4.equals(B.getI4());
        } else {
            return false ;
        }
    }
}

class Blanc extends ArbreQT {
    
    public Blanc(){}
    
    @Override
    public boolean estVide(){return false;}
    @Override
    public boolean estFeuille(){return true;}
    @Override
    public String toString(){return "B" ;}
    @Override
    public boolean equals(ArbreQT A){return A instanceof Blanc ;}
    @Override
    public ArbreQT copy(){return new Blanc();}
}

class Noir extends ArbreQT {
    
    public Noir(){}
    
    @Override
    public boolean estVide(){return false;}
    @Override
    public boolean estFeuille(){return true;}
    @Override
    public String toString(){return "N" ;}
    @Override
    public boolean equals(ArbreQT A){return A instanceof Noir ;}
    @Override
    public ArbreQT copy(){return new Noir();}
}
