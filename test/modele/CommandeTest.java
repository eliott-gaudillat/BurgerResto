package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandeTest {
    private Hamburger hamburger = new Hamburger("Royal Deluxe");
    private  Accompagnement accompagnement = new Accompagnement("pommeNoissette");
    private  Boisson boisson= new Boisson("San Pellegrino");
    private Commande commande;
    private Commande commande2;



    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Assumptions.assumeTrue(hamburger != null, "hamburger non null");
        Assumptions.assumeTrue(accompagnement!=null,"accompagnement non null");
        Assumptions.assumeTrue(boisson!=null,"boisson non null");
        commande=new Commande(29,hamburger,accompagnement,boisson);
        commande2=new Commande(30,hamburger,accompagnement,boisson);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        Commande.initialiseNumeroCommande();
    }

    @Test
    void TestCommande(){
        Assertions.assertTrue(commande!=null," constructeur commande ok");
    }

    @org.junit.jupiter.api.Test
    void getNumeroCommandeAttribuee() {
        Assertions.assertTrue(commande.getNumeroCommandeAttribuee()==1," numeroAttribué  ok");
        Assertions.assertTrue(commande2.getNumeroCommandeAttribuee()==2,"incrementation numeroCommande ok");
    }
    @Test
    void getNumeroCommande() {
        Assertions.assertTrue(Commande.getNumeroCommande()==2," numeroCommande ok");
    }

    @org.junit.jupiter.api.Test
    void getNumClient() {
        Assertions.assertTrue(commande.getNumClient()==29," numClient ok");
    }

    @org.junit.jupiter.api.Test
    void getHamburger() {
        Assertions.assertTrue(commande.getHamburger().equals(hamburger)," getHamburger OK");
    }

    @org.junit.jupiter.api.Test
    void getAccompagnement() {
        Assertions.assertTrue(commande.getAccompagnement().equals(accompagnement)," getAccompagnement OK");
    }

    @org.junit.jupiter.api.Test
    void getBoisson() {
        Assertions.assertTrue(commande.getBoisson().equals(boisson)," getBoisson OK");
    }

    @org.junit.jupiter.api.Test
    void initialiseNumeroCommande() {
        Commande.initialiseNumeroCommande();
        Assertions.assertTrue(Commande.getNumeroCommande()==0," initialiseNumeroCommande OK");

    }
}