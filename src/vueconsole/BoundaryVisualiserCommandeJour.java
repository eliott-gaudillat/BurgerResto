package vueconsole;

import controleur.ControlVisualiserCommandeJour;
import modele.ProfilUtilisateur;
import modele.PropertyName;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BoundaryVisualiserCommandeJour implements PropertyChangeListener {

    ControlVisualiserCommandeJour controlVisualiserCommandeJour ;
    public BoundaryVisualiserCommandeJour(ControlVisualiserCommandeJour controlVisualiserCommandeJour) {
        this.controlVisualiserCommandeJour = controlVisualiserCommandeJour;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName= evt.getPropertyName();
        PropertyName choix = PropertyName.valueOf(propertyName);
        switch (choix){
            case ENREGISTRER_COMMANDE :
                Object objet= evt.getNewValue();
                String[] labels = (String[]) objet;
                String numeroCommande = labels[0];
                String hamburger = labels[1];
                String accompagnement=labels[2];
                String boisson = labels[3];
                /*System.out.println("commande n° : "+numeroCommande + " ; hamburger : " + hamburger +
                        "; accompagnement : " +accompagnement + "; boisson : " + boisson);
                 */
                Fichier.ecrire("commande n° : "+numeroCommande + " ; hamburger : " + hamburger +
                        "; accompagnement : " +accompagnement + "; boisson : " + boisson);
                break;
        }

    }

    public void visualiserCommandeJour(int numeroCuisinier){
        if(controlVisualiserCommandeJour.verifierIdentification(numeroCuisinier, ProfilUtilisateur.PERSONNEL)){
            this.controlVisualiserCommandeJour.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(), this);
        }
    }

}
