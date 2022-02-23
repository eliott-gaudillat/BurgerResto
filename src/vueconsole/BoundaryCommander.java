package vueconsole;

import controleur.ControlCommander;

import java.util.List;

public class BoundaryCommander {
    private ControlCommander controlCommander;
    private BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires;
    public BoundaryCommander(ControlCommander controlCommander, BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires) {
        this.controlCommander = controlCommander;
        this.boundaryEnregistrerCoordonneesBancaires = boundaryEnregistrerCoordonneesBancaires;
    }

    public void commander(int numClient) {
       boolean clientConnecte= this.controlCommander.verifierIdentification(numClient);
       if(clientConnecte){
           int numeroHamburger=this.selectionnerBurger();
           int numeroAccompagnement=this.selectionnerAccompagnement();
           int numeroBoisson=this.selectionnerBoisson();
           boolean carteRenseignee=controlCommander.verifierExistanceCarteBancaire(numClient);
           if(!carteRenseignee){
               carteRenseignee=boundaryEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient);
           }
           if(carteRenseignee){
               controlCommander.enregistrerCommande(numClient,numeroHamburger,numeroAccompagnement,numeroBoisson);

           }

       }
    }

    private int selectionnerBurger(){
        List<String> listeBurger=this.controlCommander.donnerListeHamburger();
        System.out.println("Veuillez selectionner le numero de votre hamburger");
        int chiffre = 1;
        for (String hamburger: listeBurger) {
            System.out.println(chiffre +":"+ hamburger);
            chiffre++;
            }
        return Clavier.entrerClavierInt();
        }


    private int selectionnerAccompagnement(){
        List<String> listeAccompagnement=this.controlCommander.donnerListeAccompagnement();
        System.out.println("Veuillez selectionner le numero de votre Accompagnement");
        int chiffre = 1;
        for (String accompagnement: listeAccompagnement) {
            System.out.println(chiffre +":"+ accompagnement);
            chiffre++;
        }
        return Clavier.entrerClavierInt();}
    private  int selectionnerBoisson(){
        List<String> listeBoisson=this.controlCommander.donnerListeBoisson();
        System.out.println("Veuillez selectionner le numero de votre boisson");
        int chiffre = 1;
        for (String boisson: listeBoisson) {
            System.out.println(chiffre +":"+ boisson);
            chiffre++;
        }
        return Clavier.entrerClavierInt();}
    }


