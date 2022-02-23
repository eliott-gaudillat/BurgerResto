package modele;

import java.util.HashMap;
import java.util.Map;

public class BDCommande {
    /**attribut **/
    private Map<Integer,Commande> mapCommandes=new HashMap<>();

    /**Construteur privé **/
    private BDCommande(){}



    /**holder**/

    private static class BDCommandeHolder{
        private final static BDCommande instance = new BDCommande();
    }

    /**Point d'acces pour l'instance unique du singleton **/
    public static BDCommande getInstance(){
        return BDCommande.BDCommandeHolder.instance;
    }

    /** methode **/
    public int enregistrerCommande(int numClient,Hamburger hamburger,Accompagnement accompagnement,Boisson boisson){
        Commande commande = new Commande(numClient,hamburger,accompagnement,boisson);
        return commande.getNumeroCommandeAttribuee();}
}
