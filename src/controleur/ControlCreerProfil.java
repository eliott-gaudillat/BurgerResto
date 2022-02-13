package controleur;

import modele.*;


public class ControlCreerProfil {
    private BDClient bdClient=BDClient.getInstance();
    private BDPersonnel bdPersonnel=BDPersonnel.getInstance();



    public String visualiserBDUtilisateur() {
        return bdPersonnel.toString()+"\n"+bdClient.toString();
    }

    public void creerProfil(ProfilUtilisateur user, String nom, String prenom, String mdp) {
        Profil profil= FabriqueProfil.creerProfil(user, nom, prenom, mdp);

        if(user==ProfilUtilisateur.CLIENT){

            bdClient.ajouterClient((Client)profil);
        }
        else{
           bdPersonnel.ajouterPersonnel((Personnel) profil);
        }
    }
}
