package modele;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteBancaireTest {
    CarteBancaire carteBancaire;

    @BeforeEach
    void setUp() {
        carteBancaire=new CarteBancaire(666,1001);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TestCartebancaire(){
        Assertions.assertTrue(carteBancaire!=null," constructeur carteBancaire ok");
    }
    @Test
    void testToString() {
        assertTrue(carteBancaire.toString().equals("CarteBancaire[numeroCarte=666, dateCarte=1001]"),"toString ok");}
}