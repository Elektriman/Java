public class Cafe
{
    //Declaration des constantes
    public static final int NBPERSGROUP=6;
    public static final int DELAI_ARRIVEES = 15;
    public static final int DELAI_COM_MINI = 2; 
    public static final int DELAI_COM_MAXI = 5;
    public static final int DELAI_SERV_MINI = 5 ;
    public static final int DELAI_SERV_MAXI = 10;
    public static final int DELAI_DEP_MINI = 10;
    public static final int DELAI_DEP_MAXI = 30 ;
    
    // les statuts
    public static final int STAT_ARRIVEE = 0 ;	
    public static final int STAT_COMMANDE = 1 ;
    public static final int STAT_SERVICE = 2 ;
    public static final int STAT_DEPART = 3 ;

    // variable d'instance	

    private int nbPlaces;
    private String nom;
    private FilePrio fp;

    //Constructeurs
    Cafe(String n, int nbPlaces)
    {
        this.nom=n;
        this.nbPlaces=nbPlaces;
    }

    //Methodes
    public int getNombrePlaces(){ return this.nbPlaces;}

    public void ouverture(int nbreGroupe)
    {
        fp = new FilePrio(); //nouvelle file prio
        fp.add(new Groupe(NBPERSGROUP,STAT_ARRIVEE,0)); //ajout du premier groupe
        //ajout des autres groupes
        for(int i=1; i<nbreGroupe; i++){ 
            fp.add(new Groupe(NBPERSGROUP,STAT_ARRIVEE,fp.getPrioEnd()+aleatoire(0,DELAI_ARRIVEES)));
        }
    }

    public void gestion()	// programmation de l'automate
    {
        while(!fp.isEmpty()){ //file vide ?
            afficherEvts();
            Groupe g = fp.get(); //on prend le premier
            if(update(g)){ //on le met à jour
                fp.add(g); //on le remet dans la file si mis à jour
            }
        }		
    }

    public Boolean update(Groupe g){

        Boolean keep = true ; //le groupe est-il parti du café ?

        //traitement des 4 cas avec le switch
        switch (g.getStatut()) {
            /*
            --modele--
            case STATUT :
                mise à jour de la priorité avec aleatoire()
                mise à jour du statut
                break;
            */
            case STAT_ARRIVEE :
                g.setPrio(g.getPrio()+aleatoire(DELAI_COM_MINI,DELAI_COM_MAXI));
                g.setStatut(STAT_COMMANDE);
                break;
            case STAT_COMMANDE :
                g.setPrio(g.getPrio()+aleatoire(DELAI_SERV_MINI,DELAI_SERV_MAXI));
                g.setStatut(STAT_SERVICE);
                break;
            case STAT_SERVICE :
                g.setPrio(g.getPrio()+aleatoire(DELAI_DEP_MINI,DELAI_DEP_MAXI));
                g.setStatut(STAT_DEPART);
                break;
            case STAT_DEPART :
                keep = false ; //les groupes sur le départ ne sont pas remis dans la liste
                break ;
        }
        return keep ;
    }

    public void afficherEvts()
    {
        fp.afficher();
    }

    private int aleatoire(int min, int max)
    {
        return  min +(int)(Math.random()*(max - min + 1));
    }
}