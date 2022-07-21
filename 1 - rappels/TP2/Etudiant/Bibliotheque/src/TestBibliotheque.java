/**
 * Test de Bibliotheque sous forme de texte
 */

import java.io.*;
 

public class TestBibliotheque{
   
     
   public static void main(String[] args){
       
		UnLivre monLivre;
		Bibliotheque mesLivres = new Bibliotheque();
                //-------------------------------------------------------
                System.out.println("----chargement des Livres----");
		try{
		mesLivres.chargement("ListeLivres.txt");
		mesLivres.afficher();
		}
		catch (IOException e)
		{
	  		System.out.println("probleme de fichier par exception");
	 	}
                //-------------------------------------------------------
                System.out.println("----on recupere un Livre----");
		System.out.println(mesLivres.getLivre().toString());
                
                //-------------------------------------------------------
                System.out.println("----on passe au Livre suivant----");
                mesLivres.suivant();
		System.out.println(mesLivres.getLivre().toString());
                
                //-------------------------------------------------------
                System.out.println("----on passe au precedent----");
		mesLivres.precedent();
		System.out.println(mesLivres.getLivre().toString());
                
                //-------------------------------------------------------
                System.out.println("----on emprunte un Livre----");
                mesLivres.emprunter();
                System.out.println(mesLivres.getLivre().toString());
                
                //-------------------------------------------------------
                System.out.println("----on rend un Livre----");
		mesLivres.rendre();
                System.out.println(mesLivres.getLivre().toString());

  
	}
    
      	
      
}
