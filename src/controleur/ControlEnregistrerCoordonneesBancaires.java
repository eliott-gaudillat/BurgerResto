package controleur;

import modele.BDClient;
import modele.Client;

public class ControlEnregistrerCoordonneesBancaires {

    private ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires;
    private BDClient bdClient=BDClient.getInstance();

    public ControlEnregistrerCoordonneesBancaires(ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires) {
        this.controlVerifierCoordonneesBancaires=controlVerifierCoordonneesBancaires;
    }

    public boolean enregistrerCoordonneesBancaires(int numClient, int numeroCarte, int dateExpCarte) {
        boolean carteValide= controlVerifierCoordonneesBancaires.verifierCoordonneesBancaires(numeroCarte,dateExpCarte);
        if(carteValide){
            Client client = bdClient.trouverClient(numClient);
            client.enregistrerCoordonneesBancaires(numeroCarte,dateExpCarte);
        }
        return carteValide;
    }
}
