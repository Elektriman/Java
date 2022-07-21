package communes;


public class Personne
{
	private String nom;
	
	Personne( String nom)
	{
		this.nom = nom;
	}
        
        public String getNom()
	{
		return this.nom;
	}
	
        @Override
	public String toString()
	{
		return this.nom;
	}
}