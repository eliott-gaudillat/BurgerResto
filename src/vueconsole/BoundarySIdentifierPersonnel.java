package vueconsole;

import controleur.ControlSIdentifier;
import modele.ProfilUtilisateur;

public class BoundarySIdentifierPersonnel {
    private ControlSIdentifier controlSIdentifier;
    public BoundarySIdentifierPersonnel(ControlSIdentifier controlSIdentifier) {
        this.controlSIdentifier=controlSIdentifier;
    }

    public int identifierPersonnel() {
        System.out.println("Veuillez entrer votre login");
        String login = Clavier.entrerClavierString();
        System.out.println("Veuiiez entrer votre mot de passe");
        String mdp=Clavier.entrerClavierString();
        return controlSIdentifier.sIdentifier(ProfilUtilisateur.PERSONNEL,login,mdp);
    }
}
