package vueconsole;

import controleur.ControlAjouterAlimentMenu;
import modele.AlimentMenu;
import modele.ProfilUtilisateur;

public class BoundaryAjouterAlimentMenu {
    private  ControlAjouterAlimentMenu controlAjoutAlimentMenu;
    public BoundaryAjouterAlimentMenu(ControlAjouterAlimentMenu controlAjouterAlimentMenu) {
        this.controlAjoutAlimentMenu = controlAjouterAlimentMenu;
    }

    public void ajouterAlimentMenu(int numProfil) {
       boolean identificationOK = controlAjoutAlimentMenu.verifierIdentification(ProfilUtilisateur.GERANT,numProfil);
       if(identificationOK){
           System.out.println("Entrer le numero du type d'aliment que vous souhaitez ajouter\n");
           int choix=0;
           while(!(choix==1 || choix ==2 || choix==3)){
               System.out.println("1 ajouter un hamburger\n" +
                       "2 ajouter un accompagnement \n" +
                       "3 ajouter une boisson\n");
               choix=Clavier.entrerClavierInt();
           }
           System.out.println("Veuillez entrer le nom de l'aliment\n");
           String nomAliment = Clavier.entrerClavierString();

           switch (choix) {
               case 1:
                   controlAjoutAlimentMenu.ajouterAliment(AlimentMenu.HAMBURGER,nomAliment);
                   break;
               case 2:
                   controlAjoutAlimentMenu.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT,nomAliment);
                   break;
               case 3:
                   controlAjoutAlimentMenu.ajouterAliment(AlimentMenu.BOISSON,nomAliment);
                   break;
               default:
                   System.out.println("Type d'aliment non reconnu\n");
           }
       }
    }
}
