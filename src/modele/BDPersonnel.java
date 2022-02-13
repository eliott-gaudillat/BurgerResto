package modele;

import java.util.HashMap;
import java.util.Map;

public class BDPersonnel {
    /**attribut **/
    private Map<Integer,Personnel> listePersonnel=new HashMap<>();

    /**Construteur privé **/
    private BDPersonnel(){}



    /**holder**/

    private static class BDPersonnelHolder{
        private final static BDPersonnel instance = new BDPersonnel();
    }

    /**Point d'acces pour l'instance unique du singleton **/
    public static BDPersonnel getInstance(){
        return BDPersonnelHolder.instance;
    }

    /**methode**/
    public void ajouterPersonnel(Personnel personnel){
        listePersonnel.put(listePersonnel.size(),personnel);

    }

    @Override
    public String toString() {
        return "BDPersonnel[" +
                "listePersonnel=" + listePersonnel +
                ']';
    }


}
