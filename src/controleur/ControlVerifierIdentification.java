package controleur;

import modele.*;

public class ControlVerifierIdentification {
    private BDClient bdClient=BDClient.getInstance();
    private BDPersonnel bdPersonnel=BDPersonnel.getInstance();
    public boolean verifierIdentification(ProfilUtilisateur user, int numUser) {
        Boolean connexionOK = false;
        switch (user){
            case CLIENT :
                Client client =bdClient.trouverClient(numUser);
                if(client != null)
                    connexionOK=client.isConnecte();
                break;
            case PERSONNEL:
                Personnel personnel = bdPersonnel.trouverPersonnel(numUser);
                if(personnel != null)
                    connexionOK=personnel.isConnecte();
                break;
            default:
                Personnel personnel1 = bdPersonnel.trouverPersonnel(numUser);
                if(personnel1 != null){
                    boolean identificationOK=personnel1.isGerant();
                    if(identificationOK)
                        connexionOK=personnel1.isConnecte();
                }
        }
        return connexionOK;
    }
}
