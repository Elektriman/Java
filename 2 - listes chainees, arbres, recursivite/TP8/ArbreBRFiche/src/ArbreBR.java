

import java.util.ArrayList;

public abstract class ArbreBR {

    public abstract Fiche getRacine();

    public abstract ArbreBR getAg();

    public abstract ArbreBR getAd();

    public abstract void setRacine(Fiche s);

    public abstract void setAg(ArbreBR Ag);

    public abstract void setAd(ArbreBR Ad);

    public abstract ArbreBR insereTo(Fiche val);		// nouveau, equivalent à un constructeur

    public abstract boolean rechercherABR(Fiche val);

    public abstract boolean estVide();

    public abstract void afficher();

    public abstract Fiche lePlusAGauche();

    public abstract ArbreBR supprimer(Fiche val);

    public abstract boolean trouver(Fiche val);

    public abstract boolean estFeuille();

    public abstract int nbFeuilles();

    public abstract int nbNoeuds();

    public abstract int hauteur();

    public abstract void arbreBREnTab(ArrayList t);
    
    public int rechercherABR(Fiche val, int compteur) {
        if(estVide()){
            return 0 ;
        } else {
            if(getRacine()==val){
                return 1 + getAg().rechercherABR(val, 0) + getAd().rechercherABR(val, 0) ;
            } else {
                return getAg().rechercherABR(val, 0) + getAd().rechercherABR(val, 0);
            }
        }
    }
    
    public Fiche rechercherRef(Fiche val) {
        if(estVide()){
            return new Fiche(0, "", 0, "", 0.0) ;
        } else {
            if(getRacine()==val){
                return getRacine() ;
            } else {
                if(!getAg().estVide()){
                    return getAg().rechercherRef(val);
                }
                if(!getAd().estVide()){
                    return getAd().rechercherRef(val);
                }
            }
        }
        return new Fiche(0, "", 0, "", 0.0) ;
    }

}
//----------------------------------------------------------------------

class ArbreBRVide extends ArbreBR {

    public ArbreBRVide() {
    }

    public Fiche getRacine() {
        return null;
    }

    public ArbreBR getAg() {
        return this;
    }

    public ArbreBR getAd() {
        return this;
    }

    public void setRacine(Fiche s) {
    }

    public void setAg(ArbreBR Ag) {
    }

    public void setAd(ArbreBR Ad) {
    }

    public ArbreBR insereTo(Fiche val) {
        return new ArbreBRCons(val);
    }

    public boolean estVide() {
        return true;
    }

    public void afficher() {
        // System.out.print(" vide ");
    }

    public Fiche lePlusAGauche() {
        return null;
    }

    public ArbreBR supprimer(Fiche val) {
        return this;
    }

    public boolean trouver(Fiche val) {
        return false;
    }

    public boolean estFeuille() {
        return false;
    }

    public int nbFeuilles() {
        return 0;
    }

    public int nbNoeuds() {
        return 0;
    }

    public int hauteur() {
        return 0;
    }

    public boolean rechercherABR(Fiche val) {
        return false;
    }

    public void arbreBREnTab(ArrayList t) {
    }

}

//----------------------------------------------------------------------
class ArbreBRCons extends ArbreBR {

    private Fiche racine;
    private ArbreBR Ag;
    private ArbreBR Ad;

    public boolean estVide() {
        return false;
    }

    protected ArbreBRCons(Fiche val, ArbreBR Ag, ArbreBR Ad) {
        this.racine = val;
        this.Ag = Ag;
        this.Ad = Ad;
    }

    protected ArbreBRCons(Fiche val) {
        this.racine = val;
        this.Ag = new ArbreBRVide();
        this.Ad = new ArbreBRVide();
    }

    public ArbreBR insereTo(Fiche val) {
        if (!estVide()) {
            if (getRacine().getClassement() > val.getClassement()) {
                setAg(getAg().insereTo(val));
            } else if (getRacine().getClassement() < val.getClassement()) {
                setAd(getAd().insereTo(val));
            }
            return this;
        } else {
            return new ArbreBRCons(val, new ArbreBRVide(), new ArbreBRVide());
        }
    }

    public Fiche getRacine() {
        return this.racine;
    }

    public ArbreBR getAg() {
        return this.Ag;
    }

    public ArbreBR getAd() {
        return this.Ad;
    }

    public void setRacine(Fiche s) {
        this.racine = s;
    }

    public void setAg(ArbreBR Ag) {
        this.Ag = Ag;
    }

    public void setAd(ArbreBR Ad) {
        this.Ad = Ad;
    }

    public boolean estFeuille() {
        return this.getAg().estVide() && this.getAd().estVide();
    }

    public void afficher() {
        this.getAg().afficher();
        System.out.println(this.getRacine() + " ");
        this.getAd().afficher();
    }

    public Fiche lePlusAGauche() {
        if (this.getAg().estVide()) {
            return this.getRacine();
        } else {
            return this.getAg().lePlusAGauche();
        }
    }

    public boolean trouver(Fiche val) //recherche dans tout l'arbre
    {
        if (getRacine().getClassement() == val.getClassement()) {
            return true;
        } else {
            return this.getAg().trouver(val) || this.getAd().trouver(val);
        }

    }

    public int nbFeuilles() {
        if (this.estFeuille()) {
            return 1;
        } else {
            return this.getAg().nbFeuilles() + this.getAd().nbFeuilles();
        }
    }

    public int nbNoeuds() {
        int nfg = 0, nfd = 0;
        nfg = getAg().nbNoeuds();
        nfd = getAd().nbNoeuds();
        return (1 + nfg + nfd);
    }

    public int hauteur() {
        int nfg = 0, nfd = 0;
        nfg = 1 + getAg().hauteur();
        nfd = 1 + getAd().hauteur();
        return Math.max(nfg, nfd);
    }

    public boolean rechercherABR(Fiche val) {
        if (estVide()) {
            return false;
        } else {
            if (getRacine() == val) {
                return true;
            } else {
                if (getRacine().getClassement() > val.getClassement()) {
                    return getAg().rechercherABR(val);
                } else {
                    return getAd().rechercherABR(val);
                }
            }
        }
    }

    public ArbreBR supprimer(Fiche val) {
        if (estVide()) {
            return new ArbreBRVide();
        } else {
            if (getRacine().equals(val)) {
                if (estFeuille()) {
                    return new ArbreBRVide();
                } else {
                    if (getAg().estVide()) {
                        Fiche replace = getAd().lePlusAGauche();
                        return new ArbreBRCons(replace, getAg(), getAd().supprimer(replace));
                    } else {
                        Fiche replace = getAg().lePlusAGauche();
                        return new ArbreBRCons(replace, getAg().supprimer(replace), getAd());
                    }
                }
            } else {
                return new ArbreBRCons(getRacine(), getAg().supprimer(val), getAd().supprimer(val));
            }
        }
    }

    public void arbreBREnTab(ArrayList t) {
        if (estFeuille()) {
            t.add(getRacine());
        } else {
            getAg().arbreBREnTab(t);
            t.add(getRacine());
            getAd().arbreBREnTab(t);
        }
    }

    public ArbreBRCons(ArrayList<Fiche> t, int debut, int fin) {
        int l = t.size();
        if (l == 1) {
            this.racine = t.get(0);
            this.Ag = new ArbreBRVide();
            this.Ad = new ArbreBRVide();
        } else {
            int m = (int) l / 2;
            ArrayList<Fiche> inf = new ArrayList();
            ArrayList<Fiche> sup = new ArrayList();
            for(int i=0; i<l; i++){
                if(t.get(i).getClassement()<t.get(m).getClassement()){
                    inf.add(t.get(i));
                } else if (t.get(i).getClassement()>t.get(m).getClassement()) {
                    sup.add(t.get(i));
                }
            }
            if (inf.isEmpty()) {
                this.Ag = new ArbreBRVide();
            } else {
                this.Ag = new ArbreBRCons(inf, debut, fin);
            }
            if (sup.isEmpty()) {
                this.Ad = new ArbreBRVide();
            } else {
                this.Ad = new ArbreBRCons(sup, debut, fin);
            }
            
            
            this.racine = t.get(m);
        }
    }
}
