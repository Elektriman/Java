
/**
 *
 * @author Administrateur C SEMPE 
 */
 
public class TestDiapo{
   
     
//--------- programme principal ---------------------
   public static void main(String[]	args)
	{
            Diapo vacances = new Diapo();
            
            // on charge des noms d'images dans le diaporama    
            vacances.ajouter("paysage1.jpg");
            vacances.ajouter("paysage2.jpg");
            vacances.ajouter("paysage3.jpg");
            vacances.ajouter("paysage4.jpg");
            
            // on demande une image
            String uneImage = vacances.suivante();
            System.out.println( uneImage );
            
            // on demande encore une image
            uneImage = vacances.suivante();
            System.out.println( uneImage );
            
            // on en demande plein, observez la rotation            
            for(int i=0; i<10 ; i++)
            {
                System.out.println("resultat diapo : "+vacances.precedente() );
            }
            
	}
    	
      
}
