package modele;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProfilTest {
    private Client client;
    private Personnel personnel;

    @BeforeEach
    void setUp() {
        client = new Client("senpai","gojo","sos");
        personnel= new Personnel("Jaeger","eren","Paradis");
        Assumptions.assumeTrue(client != null, "client non null");
        Assumptions.assumeTrue(personnel!=null,"personnel non null");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void verifierCorrespondanceProfil() {
        assertTrue(client.verifierCorrespondanceProfil("gojo.senpai","sos"),"verifierCorrespondanceProfil ok");
        assertFalse(client.verifierCorrespondanceProfil("gojo.sai","sos"),"verifierCorrespondanceProfil ok");
        assertTrue(personnel.verifierCorrespondanceProfil("eren.Jaeger","Paradis"),"verifierCorrespondanceProfil ok");
        assertFalse(personnel.verifierCorrespondanceProfil("gojo.sai","sos"),"verifierCorrespondanceProfil ok");

    }

    @Test
    void connexionProfil() {
        assertTrue(!client.isConnecte(),"Partie 1 connexion profil ok pour client");
        client.connexionProfil();
        assertTrue(client.isConnecte(),"partie 2 connexion profil ok pour client");
        assertTrue(!personnel.isConnecte(),"Partie 1 connexion profil ok pour personnel");
        personnel.connexionProfil();
        assertTrue(personnel.isConnecte(),"partie 2 connexion profil ok pour personnel");
    }

    @Test
    void isConnecte() {
        assertTrue(!client.isConnecte(),"Partie 1 isConnecte ok pour client");
        client.connexionProfil();
        assertTrue(client.isConnecte(),"partie 2 isConnecte ok pour client");
        assertTrue(!personnel.isConnecte(),"Partie 1 isConnecte ok pour personnel");
        personnel.connexionProfil();
        assertTrue(personnel.isConnecte(),"partie 2 isConnecte ok pour personnel");
    }
}