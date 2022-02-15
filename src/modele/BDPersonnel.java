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

    public int connexionPersonnel(String login,String mdp){
        Personnel personnel;
        int idPersonnel=-1;
        for( int i : listePersonnel.keySet()){
            personnel=listePersonnel.get(i);
            if(personnel.verifierCorrespondanceProfil(login,mdp)){
                personnel.connexionProfil();
                idPersonnel=i;
            }
        }
        return idPersonnel;
    }

    public Personnel trouverPersonnel(int numeroPersonnel){
        Personnel personnel= listePersonnel.get(numeroPersonnel);
        return personnel;
    }


}
