package controleur;

import modele.BDClient;
import modele.BDPersonnel;
import modele.ProfilUtilisateur;

public class ControlSIdentifier {
    private BDClient bdClient=BDClient.getInstance();
    private BDPersonnel bdPersonnel=BDPersonnel.getInstance();
    public String visualiserBDUtilisateur() {
        return bdPersonnel.toString()+"\n"+bdClient.toString();
    }

    public int sIdentifier(ProfilUtilisateur profilUser, String login, String mdp) {
        int numClient;
        if(profilUser==ProfilUtilisateur.CLIENT){
            numClient=bdClient.connexionClient(login, mdp);

        }
        else{
            numClient=bdPersonnel.connexionPersonnel(login, mdp);

        }
        return numClient;
    }
}
