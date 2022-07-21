import java.util.ArrayList;

public class FilePrio
{
	private ArrayList <Personne> f;
	
	FilePrio()
	{
		f=new ArrayList();
	}
	
	public void add( Personne p )
	{
		int i=0;
		while ((i<f.size()) && (f.get(i).getPrio() <= p.getPrio() ))
		{
			i++;
		}
		f.add(i,p);	
	}

	public boolean isEmpty()
	{
		return (f.size() == 0);
	}

	public int size()
	{
		return f.size();
	}
	
	public Personne get()
	{
		return  f.remove(0);
	}
	
	public Personne getEnd()
	{
		return f.remove( f.size()-1);
	}
	
	public int getPrioTete()
	{
		return  f.get(0).getPrio();
	}
	
	public void afficher()
	{
		for(int i=0; i<f.size(); i++ )
		{
			System.out.println( "  "+f.get( i ).toString() );
		}
		System.out.println();
	}
	
}