package modele;

public class FabriqueProfil {
    public static  Profil creerProfil(ProfilUtilisateur profilUtilisateur,String nom ,String prenom,String mdp){
        Profil profil = null ;
        switch (profilUtilisateur){
            case CLIENT :
                profil=new Client(nom,prenom,mdp);
                break;
            case PERSONNEL:
                profil=new Personnel(nom,prenom,mdp);
                break;
            case GERANT:
                Personnel personnel=new Personnel(nom,prenom,mdp);
                personnel.definirGerant();
                profil=personnel;
                break;
            default:
                throw new IllegalArgumentException("Type de produit inconnu");
        }
        return profil;
    }
}
