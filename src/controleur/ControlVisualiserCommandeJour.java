package controleur;

import modele.BDCommande;
import modele.ProfilUtilisateur;

import java.beans.PropertyChangeListener;

public class ControlVisualiserCommandeJour {
    BDCommande bdCommande =BDCommande.getInstance();
    ControlVerifierIdentification controlVerifierIdentification;

    public ControlVisualiserCommandeJour(ControlVerifierIdentification controlVerifierIdentification){
        this.controlVerifierIdentification=controlVerifierIdentification;
    }



    public void setListener(String propertyName, PropertyChangeListener listener){
        this.bdCommande.addPropertyChangeSupport(propertyName, listener);

    }
    public boolean verifierIdentification(int numeroCuisinier, ProfilUtilisateur utilisateur ){
        return this.controlVerifierIdentification.verifierIdentification(utilisateur,numeroCuisinier);

    }
}
