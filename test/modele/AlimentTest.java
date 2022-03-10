package modele;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlimentTest {
    private Hamburger hamburger = new Hamburger("RoyaleDeluxe");
    private  Accompagnement accompagnement = new Accompagnement("pommeNoissette");
    private  Boisson boisson= new Boisson("SanPellegrino");

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Assumptions.assumeTrue(hamburger != null, "hamburger non null");
        Assumptions.assumeTrue(accompagnement!=null,"accompagnement non null");
        Assumptions.assumeTrue(boisson!=null,"boisson non null");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        assertTrue(hamburger.toString().equals("Aliment[nom=RoyaleDeluxe]"),"toString ok");
        assertTrue(accompagnement.toString().equals("Aliment[nom=pommeNoissette]"),"toString ok");
        assertTrue(boisson.toString().equals("Aliment[nom=SanPellegrino]"),"toString ok");
    }

    @Test
    void getNom() {
        assertTrue(hamburger.getNom().equals("RoyaleDeluxe"),"getNom");
        assertTrue(accompagnement.getNom().equals("pommeNoissette"),"getNom");
        assertTrue(boisson.getNom().equals("SanPellegrino"),"getNom");
    }
}