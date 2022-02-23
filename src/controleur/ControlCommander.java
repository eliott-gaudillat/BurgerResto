package controleur;

import modele.*;

import java.util.ArrayList;
import java.util.List;

public class ControlCommander {
    private ControlVerifierIdentification controlVerifierIdentification;
    private BDCommande bdCommande=BDCommande.getInstance();
    private BDClient bdClient=BDClient.getInstance();
    private Menu menu=Menu.getInstance();

    public ControlCommander(ControlVerifierIdentification controlVerifierIdentification) {
        this.controlVerifierIdentification=controlVerifierIdentification;
    }

    public boolean verifierIdentification(int numClient){
        return controlVerifierIdentification.verifierIdentification(ProfilUtilisateur.CLIENT,numClient);
    };

    public List<String> donnerListeHamburger() {
        List<String> listeHamburgers = new ArrayList<>() {};
        List<Hamburger> listeHamburger=this.menu.getListeHamburger();
        for (Hamburger hamburger:listeHamburger) {
            listeHamburgers.add(hamburger.getNom());
        }
        return listeHamburgers;
    }
    public List<String> donnerListeAccompagnement(){

        List<String> listeAccompagnements = new ArrayList<>() {};
        List<Accompagnement> listeAccompagnement=this.menu.getListeAccompagnement();
        for (Accompagnement accompagnement:listeAccompagnement) {
            listeAccompagnements.add(accompagnement.getNom());
        }
        return listeAccompagnements;
    }

    public List<String> donnerListeBoisson(){
        List<String> listeBoissons = new ArrayList<>() {};
        List<Boisson> listeBoisson=this.menu.getListeBoisson();
        for (Boisson boisson:listeBoisson) {
            listeBoissons.add(boisson.getNom());
        }
        return listeBoissons;
    }


    public boolean verifierExistanceCarteBancaire(int numClient){
        Client client = bdClient.trouverClient(numClient);
        return client.verifierExistanceCarteBancaire();
        }

    public int enregistrerCommande( int numClient,int numeroHamburger,int numeroAccompagnement,  int numeroBoisson){
        int numeroCommande;
        Hamburger hamburger=menu.choixHamburger(numeroHamburger);
        Accompagnement accompagnement= menu.choixAccompagnement(numeroAccompagnement);
        Boisson boisson = menu.choixBoisson(numeroBoisson);
        numeroCommande=bdCommande.enregistrerCommande(numClient,hamburger,accompagnement,boisson);
        System.out.println("Votre numero de commande est le :"+ numeroCommande);

        return numeroCommande;}


}
