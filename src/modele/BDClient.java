package modele;

import java.util.HashMap;
import java.util.Map;

public class BDClient {
    /**attribut **/
    private Map<Integer,Client> listeclient=new HashMap<>();

    /**Construteur privé **/
    private BDClient(){}


    /**holder**/

    private static class BDClientHolder{
        private final static BDClient instance = new BDClient();
    }

    /**Point d'acces pour l'instance unique du singleton **/
    public static BDClient getInstance(){
        return BDClientHolder.instance;
    }

    /**methodes **/
    public void ajouterClient(Client client){
        listeclient.put(listeclient.size(), client);
    }

    @Override
    public String toString() {
        return "BDClient[" +
                "listeclient=" + listeclient +
                ']';
    }

    public int connexionClient(String login, String mdp){
        Client client;
        int idClient=-1;
        for( int i : listeclient.keySet()){
            client=listeclient.get(i);
            if(client.verifierCorrespondanceProfil(login,mdp)){
                client.connexionProfil();
                idClient=i;
            }
        }
        return idClient;
    }

    public Client trouverClient(int numeroClient){
        Client client = listeclient.get(numeroClient);
        return client;
    }
}
