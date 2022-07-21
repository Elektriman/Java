
import java.util.ArrayList;

public class ReprUnique {

    private ArrayList<ArbreQT> dico;

    public ReprUnique() {
        this.dico = new ArrayList();
    }

    public ArbreQT getRef(ArbreQT a) {
        boolean present = false ;
        for(int i=0; i<dico.size(); i++){
            present = present || dico.get(i).equals(a);
        }
        if(!present){
            dico.add(a.copy());
        }
        return a ;
    }
}
