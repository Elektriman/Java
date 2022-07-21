import java.util.ArrayList;

public class Planning
{
private FilePrio f;
private String [] [] annee;

public Planning()
{
	Personne pompier1 = new Personne("DURAND", 0);
	Personne pompier2 = new Personne("TYPON", 0);
	Personne pompier3 = new Personne("SANNIO",0);
	Personne pompier4 = new Personne("HENRI",0);
	Personne pompier5 = new Personne("DUFAUR",0);
        
        for(int i=0; i<5; i++){
            pompier1.setAbs(i);
            pompier2.setAbs(i+1);
            pompier3.setAbs(i+2);
            pompier4.setAbs(i+3);
            pompier5.setAbs(i+4);
        }
        
        f = new FilePrio();
        f.add(pompier1);
        f.add(pompier2);
        f.add(pompier3);
        f.add(pompier4);
        f.add(pompier5);
}

public void repartition()
{	
    annee = new String [52] [2];
    for(int i=0; i<annee.length; i++){
        //récupération des deux pompiers en tête de liste
        ArrayList<Personne> absents = new ArrayList(); //tableau d'absents
        ArrayList<Personne> selection = new ArrayList(); //tableau de selection
        while(selection.size()<2 && !f.isEmpty()){ //tri des personnes absentes
            Personne p = f.get();
            if(p.estAbsent(i)){ //le pompier est-il absent ?
                absents.add(p);
            } else {
                attribuer(p,i,selection.size());
                selection.add(p);
            }
        }

        //vérification de la condition de sortie pour les cas où il manque des pompiers
        if(f.isEmpty() && selection.size()<2){ //cas où il manque des pompiers
            for(int j = 0; j<2-selection.size(); j++){
                Personne inco = new Personne("???",53);
                attribuer(inco,i,1-j);
            }
        }
        //on remet les absents dans la file
        while(!absents.isEmpty()){
            f.add(absents.remove(0));
        }
        while(!selection.isEmpty()){
            f.add(selection.remove(0));
        }
    }
}

public void attribuer(Personne p, int i, int k){
        //ajout au planning
        annee[i][k] = p.getNom();
        //incrémentation de la priorité
        p.setPrio(p.getPrio()+1);
}
	
public void affichePlanning()
{	
	System.out.println("Planning :");
	for(int j=0; j<52; j++)  //on affiche le planning
	{
            System.out.print( (j+1)+"  "+annee[j][0]+"  "+annee[j][1]  );
            System.out.println();
	}	
}
}