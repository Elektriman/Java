/**
 * Classe permettant de stocker des nom de fichiers image et de les retourner dans un certain ordre
 * en utilisant suivante() ou precedente()
 */

import java.util.ArrayList;

public class Diapo{
//--------------------------------------------------------------------------------------   
	private ArrayList <String> photos;  // on stocke le nom des fichiers
	private int vueCourante;            // index qui pointe vers le nom de l'image à afficher
//-------------------------------------------------------------------------------------- 

 /**
 * Construit un diaporama vide
 */
	Diapo()
	{
		this.vueCourante =0;
		this.photos = new ArrayList();
	
	}

 /**
 * Ajoute un nom de fichier image au diaporama
 * @param Nom : nom du fichier image ex: monimage.jpg
 */
	public void ajouter ( String Nom )
	{
		this.photos.add( Nom );
	}
        
/**
 * Donne le nombre d'image dans le diaporama
 * @return 
 */	
	public int nbPhotos()
	{
		return this.photos.size();
	}
        
/**
 * Renvoi le nom de l'image à afficher maintenant en allant à droite.
 * Un mecanisme de rotation permet de boucler
 * @return : nom de l'image à afficher
 */	
	public String suivante()			// renvoit la photo courante et avance
	{
		String laphoto =  this.photos.get( vueCourante);
		this.vueCourante++;
		if (this.vueCourante==photos.size())    // rotation ?
			this.vueCourante=0;
		return laphoto;
	}
        
/**
 * Renvoi le nom de l'image à afficher maintenant en allant à gauche.
 * Un mecanisme de rotation permet de boucler
 * @return : nom de l'image à afficher
 */	
	public String precedente(){              // renvoit la photo courante et recule
                String laphoto =  this.photos.get( vueCourante);
		this.vueCourante--;
		if ( this.vueCourante<0 )       // rotation ?
			this.vueCourante=this.photos.size()-1;
		return laphoto;
        }
}