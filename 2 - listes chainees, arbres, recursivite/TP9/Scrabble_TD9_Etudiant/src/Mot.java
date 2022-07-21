
public class Mot {

    private String leMot;

    public Mot(String UnMot) {
        this.leMot = UnMot;
    }

    public String getMot() {
        return this.leMot;
    }

    public String toString() {
        return " Nom :" + this.getMot();
    }

    private int nbLettre(char c, String s) {
        int count = 0 ;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                count += 1 ;
            }
        }
        return count ;
    }

    private boolean lettrePresente(char c, String s) {
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                return true ;
            }
        }
        return false;
    }

// mot gagnant si les lettreJoueur sont inclues dans le motDico.
// Mais il faut aussi le nombre de lettresJoueur soient en nombre suffisant pour constituer le mot
    private boolean lettresPresentes(String s) {
        boolean ttesPresentes = true ;
        for(int i=0; i<s.length(); i++){
            ttesPresentes = ttesPresentes && lettrePresente(s.charAt(i), getMot());
        }
        return ttesPresentes ;
    }

    public boolean motOK(String proposition) {
        boolean occurencesOK = true ;
        for(int i=0; i<getMot().length(); i++){
            occurencesOK = occurencesOK && nbLettre(getMot().charAt(i), getMot()) <= nbLettre(getMot().charAt(i), proposition);
        }
        return occurencesOK && lettresPresentes(proposition) ;
    }

    public int compareTo(Mot m) {
        int i=0 ;
        
        while(i<getMot().length() && i<m.getMot().length() && getMot().charAt(i)==m.getMot().charAt(i)){
            i++ ;
        }
        if(i==getMot().length() && i==m.getMot().length()){
            return 0 ;
        } else if(i==getMot().length() && i<m.getMot().length()){
            return -1 ;
        } else if(i<getMot().length() && i==m.getMot().length()){
            return 1 ;
        } else {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            if(alphabet.indexOf(getMot().charAt(i),0)>alphabet.indexOf(m.getMot().charAt(i),0)){
                return 1 ;
            } else {
                return -1 ;
            }
        }
    }

    public boolean equals(Mot m) {
        return m.motOK(getMot()) && motOK(m.getMot());
    }
}