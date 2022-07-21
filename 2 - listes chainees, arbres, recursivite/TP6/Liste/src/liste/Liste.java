package liste;
import java.util.ArrayList;

/**
 * 
 * @author Julien
 */
public abstract class Liste {
    
    /**
     * 
     * @return boolean
     */
    public abstract boolean estVide();
    
    /**
     * 
     * @return Object
     */
    public abstract Object getPremier();
    
    /**
     * 
     * @return Liste
     */
    public abstract Liste getReste();
    
    public abstract void setReste(Liste reste);
    
    /**
     * fonction pour afficher le premier élément
     */
    public void afficheelt() {
        System.out.println(getPremier());
    }
    
    /**
     * fonction pour dire si l'élément value est dans la liste ou non
     * @param value
     * @return boolean
     */
    public boolean trouver(Object value) {
        if(estVide()){
            return false;
        } else {
            if(getPremier()==value){
                return true;
            } else {
                return getReste().trouver(value);
            }
        }
    }
    
    /**
     * fonction qui donne la longueur de la liste
     * @return int
     */
    public int size() {
        if (estVide()) {
            return 0;
        } else {
            return getReste().size()+1;
        }
    }
    
    /**
     * fonction qui va sommer les éléments de la liste L, peu importe leur type
     * @return Object
     */
    public Object somme() {
        if (getReste().estVide()) {
            return getPremier();
        } else {
            Class[] O = {int.class, String.class, Double.class};
            int classId = 0;
            for (int i = 0; i < 3; i++) {
                if (O[i] == getPremier().getClass()) {
                    classId = i;
                }
            }

            switch (classId) {
                case 0:
                    return (int) getPremier() + (int) getReste().somme();

                case 1:
                    return (String) getPremier() + (String) getReste().somme();

                case 2:
                    return (double) getPremier() + (double) getReste().somme();

            }
        }
        return null;
    }
    
    /**
     * fonction pour afficher tous les éléments de la liste
     */
    public void afficher(){
        if (!estVide()) {
            System.out.println(getPremier());
            getReste().afficher();
        } else {
            System.out.println();
        }
    }
    
    @Override
    public String toString(){
        if (!estVide()) {
            return getPremier().toString() + ", " + getReste().toString();
        } else {
            return ";";
        }
    }
    
    /**
     * fonction pour afficher tous les éléments de la liste à l'envers
     */
    public void afficherInverse(){
        if(!estVide()){
            getReste().afficherInverse();
            System.out.println(getPremier());
        }
    }
    
    /**
     * fonction qui copie une liste
     * @return Liste
     */
    public Liste copie(){
        if(estVide()){
            return new ListeVide();
        } else {
            return new ListeCons(getPremier(), getReste().copie());
        }
    }
    
    /**
     * Place l'element E a la fin de la liste
     * @param E
     * @return la même liste avec E à la fin
     */
    public Liste placerFin(Object E){
        if(estVide()){
            return new ListeCons(E, new ListeVide());
        } else {
            return new ListeCons(getPremier(), getReste().placerFin(E));
        }
    }
    
    /**
     * renvoie la concaténation des deux listes
     * @param L1
     * @return Liste
     */
    public Liste concat(Liste L1){
        if(estVide()){
            return L1 ;
        } else {
            return new ListeCons(getPremier(), getReste().concat(L1));
        }
    }
    
    /**
     * renvoie la liste inversée
     * @return Liste
     */
    public Liste inverser(){
        if(!estVide()){
            Liste reste = getReste().inverser();
            reste = reste.placerFin(getPremier());
            return reste ;
        } else {
            return new ListeVide();
        }
    }
    
    /**
     * ajoute un élément à l'indice indiqué
     * @param o
     * @param place
     * @return Liste
     */
    public Liste add(Object o, int place){
        if(place<=1){
            return new ListeCons(o, this);
        } else {
            return new ListeCons(getPremier(),getReste().add(o, place-1));
        } 
    }
    
    /**
     * renvoie 'this' inter L
     * @param L
     * @return Liste
     */
    public Liste intersection(Liste L){
        if(estVide()){
            return new ListeVide();
        } else {
            if(L.trouver(getPremier())){
                return new ListeCons(getPremier(), getReste().intersection(L));
            } else {
                return getReste().intersection(L) ;
            }
        }
    }
    
    /**
     * fonction qui renvoie une liste des éléments de la liste sans garder les doublons
     * @return Liste
     */
    public Liste unique(){
        if(estVide()){
            return new ListeVide();
        } else {
            Liste uniq = getReste().unique();
            if(uniq.trouver(getPremier())){
                return uniq;
            } else {
                return new ListeCons(getPremier(), uniq);
            }
        }
    }
    
    /**
     * renvoie 'this' union L
     * @param L
     * @return Liste
     */
    public Liste Union(Liste L){
        return concat(L).unique();
    }
    
    /**
     * fonction qui donne un booléen décrivant si L est incluse dans 'this'
     * @param L
     * @return boolean
     */
    public boolean inclus(Liste L){
        if(L.estVide()){
            return true;
        } else {
            if(trouver(L.getPremier())){
                return inclus(L.getReste());
            } else {
                return false ;
            }
        }
    }
    
    /**
     * fonction pour le QS
     * renvoie une liste des éléments inférieurs au pivot s
     * @param s
     * @return Liste
     */
    public Liste inferieurs(int s){
        if(estVide()){
            return new ListeVide();
        } else {
            Liste reste = getReste().inferieurs(s);
            if((int) getPremier()<s){
                return new ListeCons(getPremier(), reste);
            } else {
                return reste;
            }
        }
    }
    
    /**
     * fonction pour le QS
     * renvoie une liste des éléments supérieurs au pivot s
     * @param s
     * @return Liste
     */
    public Liste superieurs(int s){
        if(estVide()){
            return new ListeVide();
        } else {
            Liste reste = getReste().superieurs(s);
            if((int) getPremier()>s){
                return new ListeCons(getPremier(), reste);
            } else {
                return reste;
            }
        }
    }
    
    /**
     * renvoie le nombre de fois que la valeur s est dans la liste
     * @param s
     * @return int
     */
    public int count(int s){
        if(estVide()){
            return 0;
        } else {
            int reste = getReste().count(s);
            if((int) getPremier()==s){
                return 1 + reste;
            } else {
                return reste;
            }
        }
    }
    
    /**
     * Quicksort
     * @return Liste
     */
    public Liste QS(){
        if(size()<2){
            return this;
        } else {
            int pivot = (int) getPremier();
            int C = count(pivot);
            Liste Lsup = superieurs(pivot);
            Liste Linf = inferieurs(pivot);
            Liste Qsup = Lsup.QS();
            Liste Qinf = Linf.QS();
            Liste Piv = new ListeCons(pivot, Qsup);
            for(int i=1; i<C; i++){
                Piv = new ListeCons(pivot, Piv);
            }
            return Qinf.concat(Piv);
        }
    }
    
    /**
     * fonction qui va renvoyer la liste au format ArrayList
     * @return ArrayList
     */
    public ArrayList ListeToArrayList() {
        if (estVide()) {
            return new ArrayList();
        } else {
            ArrayList reste = getReste().ListeToArrayList();
            reste.add(getPremier());
            return reste;
        }
    }
    
    /**
     * fonction qui va renvoyer la liste au format tableau
     * @return Object[]
     */
    public Object[] ListeToArray(){
        return ListeToArrayList().toArray();
    }
    
    /**
     * constructeur d'une liste d'entiers aléatoires dans l'intervalle [a,b[
     * @param a
     * @param b
     * @param l
     * @return Liste
     */
    public static Liste randomListe(int a, int b, int l){
        if(l==0){
            return new ListeVide();
        } else {
            int val = (int) (Math.random()*(b-a))+a;
            return new ListeCons(val, randomListe(a,b,l-1));
        }
    }
}

//************************************************************************************************************
class ListeVide extends Liste {

    ListeVide() {
    }

    @Override
    public boolean estVide() {
        return true;
    }

    @Override
    public String getPremier() {
        return null;
    }

    @Override
    public Liste getReste() {
        return null;
    }
    
    @Override
    public void setReste(Liste reste){}
}

//************************************************************************************************************

class ListeCons extends Liste {

    private Object valeur;
    private Liste suiv;

    ListeCons(Object val, Liste L) {
        this.valeur = val;
        this.suiv = L;
    }

    @Override
    public boolean estVide() {
        return false;
    }
    
    @Override
    public Object getPremier() {
        return this.valeur;
    }

    @Override
    public Liste getReste() {
        return this.suiv;
    }
    
    @Override
    public void setReste(Liste reste) {
        this.suiv = reste ;
    }
}
