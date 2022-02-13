package vueconsole;

import controleur.ControlCreerProfil;
import modele.ProfilUtilisateur;

public class BoundaryCreerProfilGerant {

    private ControlCreerProfil controlCreerProfil;

    public BoundaryCreerProfilGerant(ControlCreerProfil controlCreerProfil) {
        this.controlCreerProfil=controlCreerProfil;

    }

    public void creerProfilGerant() {
        System.out.println("Veuillez entre votre nom");
        String nom = Clavier.entrerClavierString();
        System.out.println("Veuillez entrer votre prenom");
        String prenom = Clavier.entrerClavierString();
        System.out.println("Veuillez saisir votre mot de passe");
        String mdp = Clavier.entrerClavierString();
        controlCreerProfil.creerProfil(ProfilUtilisateur.GERANT,nom,prenom,mdp);
    }
}
