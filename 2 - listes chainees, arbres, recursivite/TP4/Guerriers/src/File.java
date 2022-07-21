import java.util.ArrayList;
import java.util.Iterator;

/** Cette classe gere des listes de String, elle peut �tre adapt�e pour n'importe quel objet **/

public class File  						
{

private ArrayList <Personnage> f;


File()
{
	this.f= new ArrayList();
}

/** Est ce que la file est vide ? **/
public boolean estVide() 
{	return this.f.isEmpty();	
}

public int size()
{
	return this.f.size();
}

public void add(Personnage e)
{
	this.f.add(e);
}

/** demontage destructeur **/
public Personnage get()	 
{
	if (!estVide())
	{
		return this.f.remove(0);						
	}
    return null;
}


/** retourne un iterateur voir TestFile.java **/
public Iterator iterator() 
{
	return this.f.iterator();
}

@Override
public String toString(){
    String res = "";
    for(Personnage p : f){
        res+=p.toString()+"\n";
    }
    return res ;
}
}