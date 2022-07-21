import java.util.ArrayList;

public class FilePrio
{
    private ArrayList <Groupe> f;

    FilePrio()
    {
        f=new ArrayList();
    }

    public void add( Groupe p )
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
        return (f.isEmpty());
    }

    public int size()
    {
        return f.size();
    }

    public Groupe get()
    {
        return  f.remove(0);
    }

    public int getPrioEnd()
    {
        return f.get(f.size()-1).getPrio();
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