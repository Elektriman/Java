
import java.util.Objects;

public class Fiche 
{
    private int classement;
    private String titre;
    private int annee;
    private String plateforme;
    private double ventes;

    public Fiche(int classement, String titre, int annee, String plateforme, double ventes) {
        this.classement = classement;
        this.titre = titre;
        this.annee = annee;
        this.plateforme = plateforme;
        this.ventes = ventes;
    }

    public int getClassement() {
        return classement;
    }

    public String getTitre() {
        return titre;
    }

    public int getAnnee() {
        return annee;
    }

    public String getPlateforme() {
        return plateforme;
    }

    public double getVentes() {
        return ventes;
    }

    @Override
    public String toString() {
        return "Fiche{" + "classement=" + classement + ", titre=" + titre + ", annee=" + annee + ", plateforme=" + plateforme + ", ventes=" + ventes + '}';
    }
    
    public int compareTo( Fiche fc){
        
        if (fc.getClassement()> this.getClassement() ) return -1;
        else if (fc.getClassement() == this.getClassement() ) return 0;
             else return 1;
    } 
     

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fiche other = (Fiche) obj;
        if (this.classement != other.classement) {
            return false;
        }
        if (this.annee != other.annee) {
            return false;
        }
        if (Double.doubleToLongBits(this.ventes) != Double.doubleToLongBits(other.ventes)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.plateforme, other.plateforme)) {
            return false;
        }
        return true;
    }
    
 }

