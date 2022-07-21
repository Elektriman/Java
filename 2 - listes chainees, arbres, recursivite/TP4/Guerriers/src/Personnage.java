
import java.util.ArrayList ;
/** CLASSE PERSONNAGE * */

public abstract class Personnage {
    //CONSTANTES -----------------------------------------
    //Type de personnages
    String[] PersoType = {"chevalier", "excalibur", "enchanteur", "truqueur"};
    public static final int TYPE_CHEVALIER = 0;
    public static final int TYPE_EXCALIBUR = 1;
    public static final int TYPE_ENCHANTEUR = 2;
    public static final int TYPE_TRUQUEUR = 3;
    private final int NB_TYPES = 4;

    //Cibles possibles (partie 2 TP)
    String[] CibleType = {"la tête", "le ventre", "les jambes"};
    public static final int CIBLE_TETE = 0;
    public static final int CIBLE_VENTRE = 1;
    public static final int CIBLE_JAMBES = 2;
    private final int NB_CIBLES = 3;
    
    //Points faibles
    private static final double[][] CIBLE = {{0.4,0.7,1},{0.4,1,0.7},{1,0.7,0.4},{1,0.4,0.7}};
    //-----------------------------------------------------

    protected int vie;						// parametre commun a tous les personnages
    protected int typePers;                                     // type du personnage cr�� selon constantes
    protected int[][] memoire ;
    public boolean immortel ;
    
    public int getVie() {
        return this.vie;
    }

    protected int Alea(int min, int max) // tirage au sort entre min et max
    {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public int getType() // renvoie le type de personnage selon les constantes
    {
        return this.typePers;
    }
    
    public String getMem(){
        String res = "" ;
        for(int[] perso : this.memoire){
            String ligne = "{";
            for(int ratio : perso){
                ligne += ratio + "," ;
            }
            ligne = ligne.substring(0,ligne.length()-1);
            ligne += "}" ;
            res += ligne + "\n" ;
        }
        return res ;
    }
    
    public int blesse(int cible, int atk){
        if(immortel){
            return 0;
        }
        double ddmg = atk*CIBLE[this.typePers][cible];
        int dmg = (int) ddmg ;
        this.vie -= dmg ;
        return dmg ;
    }
    
    public int choixCible(int typePerso){
        int cible = 0 ;
        ArrayList<Integer> R = new ArrayList();
        for(int i = 0; i<3; i++){
            if(memoire[typePerso][i]==-1){
                return i ;
            }
            for(int j = 0; j<Alea(0,memoire[typePerso][i]); j++){
                R.add(i);
            }
        }
        int M = 0;
        for(int i=0; i<R.size(); i++){
            M+=R.get(i);
        }
        if(!R.isEmpty()){
            cible = (int) (0.5+(M/R.size()));
        }
        return cible ;
    }
    
    public void apprendre(int typePerso, int cible, int dmg){
        if(dmg > memoire[typePerso][cible]){
            this.memoire[typePerso][cible] = dmg ;
        }
    }

    public abstract int attaque();		// renvoie un entier proposionnel � la force de l'attaque		

    public abstract String toString();	// methode permettant d'afficher un personnage
    
    public void getWeakSpots(){
        for(int i=0; i<4; i++){
            int wp = 0 ;
            for(int j=0; j<3; j++){
                if(memoire[i][j]>memoire[i][wp]){
                    wp = j ;
                }
            }
            System.out.println("le point faible du "+ PersoType[i] +" est "+ CibleType[wp] +"\n");
        }
    }
    
    public void setVie(int vie){
        this.vie = vie ;
    }
}

abstract class guerrier extends Personnage {
    protected int force = 0; //force propre aux guerriers
    
    //getter
    public int getForce() {
        return force;
    }
}

abstract class magicien extends Personnage{
    protected int magie = 0; //magie propre aux magiciens
    
    //getter
    public int getMagie() {
        return magie;
    }
}

class enchanteur extends magicien{
    private int aura = 0; //aura propre aux enchanteurs
    
    //constructeur
    public enchanteur(int vie, int magie, int aura) {
        this.vie = vie ;
        this.magie = magie ;
        this.aura = aura ;
        this.typePers = TYPE_ENCHANTEUR ;
        int[][] prompt = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        this.memoire = prompt ;
    }
    
    //getteur de l'aura
    public int getAura() {
        return aura;
    }
    
    //fonction d'attaque dépendant des paramètres de l'anchanteur
    @Override
    public int attaque(){
        int A = Alea(0, vie)+Alea(0, magie)+Alea(0, aura);
        return A ;
    }
    
    //methode toString
    @Override
    public String toString() {
        return "enchanteur{" + "vie=" + vie + ", magie=" + magie + ", aura=" + aura + '}';
    }
}

class truqueur extends magicien {
    private int malice = 0 ;//malice propre au truqueur
    
    //constructeur
    public truqueur(int vie, int magie, int malice) {
        this.vie = vie ;
        this. magie = magie ;
        this.malice = malice ;
        this.typePers = TYPE_TRUQUEUR ;
        int[][] prompt = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        this.memoire = prompt ;
    }
    
    //getter
    public int getMalice(){
        return this.malice ;
    }
    
    //fonction d'attaque dépendant des paramètres du truqueur
    @Override
    public int attaque(){
        int A = Alea(0, vie)+Alea(0, magie)+Alea(0, malice);
        return A ;
    }
    
    //methode toString
    @Override
    public String toString() {
        return "truqueur{" + "vie=" + vie + ", magie=" + magie + ", malice=" + malice + '}';
    }
}

class chevalier extends guerrier{
    private int courage = 0 ; //courage propre aux chevaliers

        //constructeur
    public chevalier(int vie, int force, int courage) {
        this.vie = vie ;
        this.force = force ;
        this.courage = courage ;
        this.typePers = TYPE_CHEVALIER ;
        int[][] prompt = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        this.memoire = prompt ;
    }
    
    //getter
    public int getCourage(){
        return this.courage ;
    }
    
    //fonction d'attaque dependant des parametres du chevalier
    @Override
    public int attaque(){
        int A = Alea(0, vie)+Alea(0, force)+Alea(0, courage);
        return A ;
    }
    
    //methode toString
    @Override
    public String toString() {
        return "chevalier{" + "vie=" + vie + ", force=" + force + ", courage=" + courage + '}';
    }
}


class excalibur extends guerrier{
    private int aggressivite = 0; //aggressivite propre aux excaliburs
    
    //constructeur
    public excalibur(int vie, int force, int aggressivite){
        this.vie = vie ;
        this.force = force ;
        this.aggressivite = aggressivite ;
        this.typePers = TYPE_EXCALIBUR ;
        int[][] prompt = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        this.memoire = prompt ;
    }
    
    //getter
    public int getAggressivite(){
        return this.aggressivite ;
    }
    
    //fonction d'attaque dependant des parametres de l'excalibur
    @Override
    public int attaque(){
        int A = Alea(0, vie)+Alea(0, force)+Alea(0, aggressivite);
        return A ;
    }
    
    //methode toString
    @Override
    public String toString() {
        return "excalibur{" + "vie=" + vie + ", force=" + force + ", aggressivite=" + aggressivite + '}';
    }
}