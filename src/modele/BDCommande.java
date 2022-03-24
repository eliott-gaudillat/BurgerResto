package modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

public class BDCommande {
    /**attribut **/
    private Map<Integer,Commande> mapCommandes=new HashMap<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

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
        int numCommande = commande.getNumeroCommandeAttribuee();
        mapCommandes.put(numCommande,commande);
        String[] labels = new String[4];
        labels[0]=String.valueOf(numCommande);
        labels[1]= hamburger.getNom();
        labels[2]= accompagnement.getNom();
        labels[3]= boisson.getNom();
        support.firePropertyChange(PropertyName.ENREGISTRER_COMMANDE.toString(),null,labels);

        return numCommande;
    }

    public  void addPropertyChangeSupport(String propertyName, PropertyChangeListener listener){
        support.addPropertyChangeListener(propertyName, listener);

    }
}
