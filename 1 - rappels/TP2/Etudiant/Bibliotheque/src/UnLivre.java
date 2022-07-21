/**
 * Classe modelisant un Livre 
 */

public class UnLivre
{
    private String titre;
    private String nomPhoto;
    private String texte;
    private int nbExemplaires;  // nombre d'exemplaires achetés par le commercant
    private int nbEmprunts;     // nombre d'emprunts

/**
 * Constructeur ( titre du film , nom du fichier image, commentaire, nombre d'exemplaire )
 * @param titre : titre du film
 * @param photo : nom du fichier image de la couverture
 * @param texte : description de l'histoire
 * @param nbEx : nombre d'exemplaire en bibliotheque, plutot invariant pour la suite
 */
public UnLivre(String titre, String photo, String texte, int nbEx)
{
	this.titre = titre;
	this.nomPhoto = photo;
	this.texte=texte;
	this.nbExemplaires=nbEx;
	this.nbEmprunts=0;
}
//-----GET SET--------------------------------------------------------------

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNomPhoto() {
        return this.nomPhoto;
    }

    public void setNomPhoto(String nomPhoto) {
        this.nomPhoto = nomPhoto;
    }

    public String getTexte() {
        return this.texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getNbExemplaires() {
        return nbExemplaires;
    }

    public void setNbExemplaires(int nbExemplaires) {
        this.nbExemplaires = nbExemplaires;
    }

    public int getNbEmprunts() {
        return nbEmprunts;
    }

    public void setNbEmprunts(int nbEmprunts) {
        if (this.nbEmprunts<this.nbExemplaires){
            this.nbEmprunts = nbEmprunts ;
        }
    }

    public void setRetour() 
    {
            if (this.nbEmprunts>0) this.nbEmprunts--; 
    }

//------ Affichage texte d'un Livre ----------------------

    public void afficher()
    {
            System.out.println("Titre : "+ this.titre);
            System.out.println("Photo : "+ this.nomPhoto);
            System.out.println("Texte : "+ this.texte);
            System.out.println("Nombre d'exemplaires : "+ this.nbExemplaires);
            System.out.println("Nombre d'emprunts : "+ this.nbEmprunts);
    }

    @Override
    public String toString() {
        return "UnLivre{" + "titre=" + titre + ", nomPhoto=" + nomPhoto + ", texte=" + texte + ", nbExemplaires=" + nbExemplaires + ", nbEmprunts=" + nbEmprunts + '}';
    }



}