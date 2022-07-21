
/**
 *
 * @author Administrateur C SEMPE 
 */
 

public class TestLivre{
   
/**
 * Test unitaire UnLivre
 * @param args 
 */     
public static void main(String[] args)
{
	UnLivre unLivre = new UnLivre("OuiOui", "Ouioui.jpg","Il ne faut pas l'embeter ce mec",3);
	unLivre.afficher();
	unLivre.setNbEmprunts( unLivre.getNbEmprunts()+1 );
	unLivre.afficher();  
}
    
      	
      
}
