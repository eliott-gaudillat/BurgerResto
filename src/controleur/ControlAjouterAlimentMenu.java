package controleur;

import modele.*;

public class ControlAjouterAlimentMenu {
    private ControlVerifierIdentification controlVerifierIdentification;
    private Menu menu = Menu.getInstance();

    public ControlAjouterAlimentMenu(ControlVerifierIdentification controlVerifierIdentification) {
        this.controlVerifierIdentification=controlVerifierIdentification;
    }

    public String visualiserMenu() {
        return menu.toString();
    }

    public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numProfil) {
        return controlVerifierIdentification.verifierIdentification(profilUtilisateur,numProfil);
    }

    public void ajouterAliment(AlimentMenu alimentMenu, String nom){
        Aliment aliment = FabriqueAliment.creerAliment(alimentMenu,nom);
        switch (alimentMenu){
            case HAMBURGER:
                menu.ajouterAliment((Hamburger) aliment);
                break;
            case BOISSON:
                menu.ajouterAliment((Boisson) aliment);
                break;
            case ACCOMPAGNEMENT:
                menu.ajouterAliment((Accompagnement) aliment);

                break;
            default:
                System.out.println("Type d'aliment non reconnu");

        }

    }
}
