
import java.util.ArrayList;


public abstract class Arbre {

    public abstract String getRacine();

    public abstract Arbre getAg();

    public abstract Arbre getAd();

    public abstract void setRacine(String s);

    public abstract void setAg(Arbre Ag);

    public abstract void setAd(Arbre Ad);

    public abstract boolean estVide();

    public void afficheGRD() {
        if (!estVide()) {
            getAg().afficheGRD();
            System.out.println(getRacine());
            getAd().afficheGRD();
        }
    }

    public boolean estFeuille() {
        return this.getAg().estVide() && this.getAd().estVide();
    }

    public int nbFeuilles() {
        if (estFeuille()) {
            return 1;
        } else {
            return getAg().nbFeuilles() + getAd().nbFeuilles();
        }
    }

    public int hauteur() {
        int nfg = 0, nfd = 0;
        nfg = 1 + getAg().hauteur();
        nfd = 1 + getAd().hauteur();
        return Math.max(nfg, nfd);
    }
    
    public int nbNoeuds() {
        int nfg = 0, nfd = 0;
        nfg = getAg().nbNoeuds();
        nfd = getAd().nbNoeuds();
        return (1 + nfg + nfd);
    }

    public boolean trouver(String element) {
        if (estVide()) {
            return false;
        } else {
            if (getRacine()!=null && getRacine().equals(element)) {
                return true ;
            } else {
                return getAg().trouver(element) || getAd().trouver(element);
            }
        }
    }

    public String lePlusADroite() {
        if (estFeuille()) {
            return getRacine();
        } else {
            return getAd().lePlusADroite();
        }
    }

    public String lePlusAGauche() {
        if (estFeuille()) {
            return getRacine();
        } else {
            return getAg().lePlusAGauche();
        }
    }

    public Arbre supprimer(String valeur) {
        if (estVide()) {
            return new ArbreVide();
        } else {
            if (getRacine().equals(valeur)) {
                if (estFeuille()) {
                    return new ArbreVide();
                } else {
                    if (getAg().estVide()) {
                        String replace = getAd().lePlusAGauche();
                        return new ArbreCons(replace, getAg(), getAd().supprimer(replace));
                    } else {
                        String replace = getAg().lePlusAGauche();
                        return new ArbreCons(replace, getAg().supprimer(replace), getAd());
                    }
                }
            } else {
                return new ArbreCons(getRacine(), getAg().supprimer(valeur), getAd().supprimer(valeur));
            }
        }
    }
    
    public boolean insereFeuille(String valeur){
        if(!estFeuille()){
            return getAg().insereFeuille(valeur) || getAd().insereFeuille(valeur);
        } else if(getRacine()==null){
            this.setRacine(valeur);
            return true ;
        } else {
            return false ;
        }
    }
    
    public void placerGagnant (String element){
        if(getAg().getRacine()!=null && getAd().getRacine()!=null){
            if(getAg().getRacine().equals(element) || getAd().getRacine().equals(element)){
                setRacine(element);
            }
        } else {
            getAg().placerGagnant(element);
            getAd().placerGagnant(element);
        }
    }
    
    public void adversaires(ArrayList adv){
        if(!estFeuille()){
            if(getAg().getRacine().equals(getRacine())){
                adv.add(getAd().getRacine());
                getAg().adversaires(adv);
            } else if(getAd().getRacine().equals(getRacine())){
                adv.add(getAg().getRacine());
                getAd().adversaires(adv);
            }
        }
    }
}

class ArbreVide extends Arbre {

    ArbreVide() {
    }

    public String getRacine() {
        return null;
    }

    public Arbre getAg() {
        return this;
    }

    public Arbre getAd() {
        return this;
    }

    public void setRacine(String s) {
    }

    public void setAg(Arbre Ag) {
    }

    public void setAd(Arbre Ad) {
    }

    public boolean estVide() {
        return true;
    }

}

class ArbreCons extends Arbre {

    private String racine;
    private Arbre Ag;
    private Arbre Ad;

    ArbreCons(String val, Arbre Ag, Arbre Ad) {
        this.racine = val;
        this.Ag = Ag;
        this.Ad = Ad;
    }

    ArbreCons(String val) {
        this.racine = val;
        this.Ag = new ArbreVide();
        this.Ad = new ArbreVide();
    }

    public String getRacine() {
        return this.racine;
    }

    public Arbre getAg() {
        return this.Ag;
    }

    public Arbre getAd() {
        return this.Ad;
    }

    public void setRacine(String s) {
        this.racine = s;
    }

    public void setAg(Arbre Ag) {
        this.Ag = Ag;
    }

    public void setAd(Arbre Ad) {
        this.Ad = Ad;
    }

    protected ArbreCons(int niveau) {
        this.setRacine(null);
        if (niveau == 0) {
            this.setAd(new ArbreVide());
            this.setAg(new ArbreVide());
        } else {
            this.setAg(new ArbreCons(niveau - 1));
            this.setAd(new ArbreCons(niveau - 1));
        }
    }

    public boolean estVide() {
        return false;
    }

    public boolean estFeuille() {
        return this.getAg().estVide() && this.getAd().estVide();
    }

}
