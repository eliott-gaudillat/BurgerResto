package vueconsole;

import controleur.ControlSIdentifier;
import modele.ProfilUtilisateur;

public class BoundarySIdentifierClient {

    private ControlSIdentifier controlSIdentifier;
    public BoundarySIdentifierClient(ControlSIdentifier controlSIdentifier) {
        this.controlSIdentifier=controlSIdentifier;
    }

    public int sIdentifierClient() {
        System.out.println("Veuillez entrer votre login");
        String login = Clavier.entrerClavierString();
        System.out.println("Veuiiez entrer votre mot de passe");
        String mdp=Clavier.entrerClavierString();
        return controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT,login,mdp);
    }
}
