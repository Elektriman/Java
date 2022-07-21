/**
 * Collection de UnLivre
 */

import java.util.ArrayList ;
import java.io.*;


public class Bibliotheque
{
    // votre structure de collection devra s'appeler  desLivres  pour pouvoir etre chargé par chargement()
    private ArrayList<UnLivre> desLivres = new ArrayList(); //structure de la bibliothèque
    private int vueCourante = 0 ; //pointeur
    
    //constructeur
    public void Bibliotheque(){
        this.desLivres = new ArrayList();
    }
    
    //fonction d'affichage
    public void afficher(){
        for(int i=0; i<this.desLivres.size();i++){
            UnLivre livreI = this.desLivres.get(i);
            System.out.printf("livre %d : %s ,%d\n",i ,livreI.getTitre(), livreI.getNbExemplaires());
        }
    }
    
    //ajout d'un livre
    public void ajouter(UnLivre livre){
        this.desLivres.add(livre);
    }
    
    //emprunt d'un livre
    public void emprunter(){
        //récupération du livre et du nb d'exemplaires
        UnLivre livre = this.getLivre();
        int nbEx = livre.getNbExemplaires();
        
        if (nbEx>0){ //reste-il un exemplaire à emprunter ?
            livre.setNbEmprunts(livre.getNbEmprunts()+1);
            livre.setNbExemplaires(livre.getNbExemplaires()-1);
        } else {
            System.out.println("il n'y a plus d'exemplaires de ce livre disponibles !");
        }
    }
    
    //renvoi du livre pointé
    public UnLivre getLivre(){
        return this.desLivres.get(vueCourante);
    }
    
    //pour récupérer le nombre de livres dans la bibliothèque
    // != du nombre de titres différents dans la bibliothèque !
    public int nbLivres(){
        int S = 0;
        for(int i=0; i<this.desLivres.size(); i++){
            S+=this.desLivres.get(i).getNbExemplaires();
        }
        return S;
    }
    
    //passage du pointeur au livre précédent
    public void precedent(){
        if(0 < this.vueCourante){ //arrivé au début ?
            this.vueCourante -=1 ;
        } else {
            this.vueCourante = this.desLivres.size()-1; //passage au dernier livre
        }
    }
    
    //retour d'un livre
    public void rendre(){
        this.getLivre().setNbEmprunts(this.getLivre().getNbEmprunts());
    }
    
    //reset du pointeur de vue
    public void resetVue(){
        this.vueCourante = 0;
    }
    
    //passage au livre suivant
    public void suivant(){
        if(this.vueCourante < this.desLivres.size()-1){ //arrivé à la fin ?
            this.vueCourante +=1 ;
        } else {
            this.resetVue(); //retour au début
        }
    }
    
    //suppression du livre pointé
    public void supprimer(){
        this.desLivres.remove(vueCourante);
    }

/**
 * Permet le chargement des Livres sous forme d'objets a partir d'un fichier
 * La structure de donnees desLivres est remplie
 * @param nomFichier
 * @throws IOException 
 */
public void chargement( String nomFichier )throws IOException
{
  	String leTitre="",nomPhoto="", texte=""; int nbEx=-1;   // recuperation temporaire de ces infos
  	UnLivre unLivre;
        System.setProperty( "file.encoding", "UTF-8" );
 	        
        InputStreamReader fic = new InputStreamReader(new FileInputStream(nomFichier), "utf8");
	StreamTokenizer entree = new StreamTokenizer(fic);	// lecture par bloc de texte
	entree.quoteChar('"');
		
        // lecture des donnees dans le fichier connaissant le format-----------------------------
	int i =0;
	
        entree.nextToken() ;                    // premier element a traiter
	while ( entree.ttype != entree.TT_EOF ) // c'est la fin du fichier ou pb ?
	{  	  
            leTitre = entree.sval; 
            entree.nextToken() ;
            nomPhoto = entree.sval;
            entree.nextToken() ;
            texte = entree.sval;
            entree.nextToken() ;
            nbEx = (int) entree.nval;
            unLivre = new UnLivre( leTitre, nomPhoto, texte, nbEx ); // nouveau livre
            this.desLivres.add(unLivre);												// on ajoute
					
            i++;
            entree.nextToken() ;	
        }  // fin while
			
		
	fic.close();
}

}