package modele;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client client;

    @BeforeEach
    void setUp() {
        client = new Client("senpai","gojo","sos");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        assertTrue(client.toString().equals(
                "Client[nom=senpai, prenom=gojo, login=gojo.senpai, mdp=sos,connecte=false,carteBancaire =" +
                        "null]"),"toString ok");

        client.enregistrerCoordonneesBancaires(123456,1010);
        assertTrue(client.toString().equals(
                "Client[nom=senpai, prenom=gojo, login=gojo.senpai, mdp=sos,connecte=false,carteBancaire =" +
                        "CarteBancaire[numeroCarte=123456, dateCarte=1010]]"),"toString ok");
    }


    @Test
    void verifierExistanceCarteBancaire() {
        assertTrue(!client.verifierExistanceCarteBancaire(),"ok car carte non renseigné");
        client.enregistrerCoordonneesBancaires(123456,1010); // fonction enregisterCoordonneesBancaires testé ici
        assertTrue(client.verifierExistanceCarteBancaire(),"ok carte bien renseigné");
    }

}