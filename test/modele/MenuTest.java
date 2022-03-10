package modele;

import org.junit.jupiter.api.*;

class MenuTest {
    private Menu menu;
    private Boisson boisson = new Boisson("coca");
     private Accompagnement accompagnement = new Accompagnement("frites");
    private Hamburger hamburger = new Hamburger("bigM");



    @BeforeEach
    void setUp() {
        menu = Menu.getInstance();
        Assumptions.assumeTrue(boisson != null);
        Assumptions.assumeTrue(accompagnement!= null);
        Assumptions.assumeTrue(hamburger != null);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInstance() {
        Assertions.assertTrue(menu!=null);
    }

    @Test
    /** test de ajouterAliement(Boisson boisson) et de getListeBoisson() **/
    void ajouterAliment() {
        Assertions.assertTrue(menu.getListeBoisson().toString().equals("[]"));
        menu.ajouterAliment(boisson);
        Assertions.assertTrue(menu.getListeBoisson().toString().equals("[Aliment[nom=coca]]"));
    }

    @Test
    /** test de ajouterAliement(Accompagnement accompagnement) et de getListeAccompagnement() **/
    void testAjouterAliment() {
        Assertions.assertTrue(menu.getListeAccompagnement().toString().equals("[]"));
        menu.ajouterAliment(accompagnement);
        Assertions.assertTrue(menu.getListeAccompagnement().toString().equals("[Aliment[nom=frites]]"));
    }

    @Test
    /** test de ajouterAliement(Hamburger hamburger) et de getListeHamburger()**/
    void testAjouterAliment1() {
        Assertions.assertTrue(menu.getListeHamburger().toString().equals("[]"));
        menu.ajouterAliment(hamburger);
        Assertions.assertTrue(menu.getListeHamburger().toString().equals("[Aliment[nom=bigM]]"));
    }

    @Test
    void testToString() {
        System.out.println(menu.toString());
        Assertions.assertTrue(menu.toString().equals("Menu[listeHamburger=[], listeBoisson=[]," +
                " listeAccompagnement=[]]"));
        menu.ajouterAliment(hamburger);
        menu.ajouterAliment(accompagnement);
        menu.ajouterAliment(boisson);

        System.out.println(menu.toString());
        Assertions.assertTrue(menu.toString().equals("Menu[listeHamburger=[Aliment[nom=bigM]], listeBoisson=[Aliment[nom=coca]]," +
                " listeAccompagnement=[Aliment[nom=frites]]]"));


    }


    @Test
    void choixHamburger() {
        menu.ajouterAliment(hamburger);
        Assertions.assertTrue(menu.choixHamburger(1).toString().equals("[Aliment[nom=bigM]]"));
    }

    @Test
    void choixAccompagnement() {
        menu.ajouterAliment(accompagnement);
        Assertions.assertTrue(menu.choixAccompagnement(1).toString().equals("[Aliment[nom=frites]]"));
    }

    @Test
    void choixBoisson() {
        menu.ajouterAliment(boisson);
        Assertions.assertTrue(menu.choixBoisson(1).equals(boisson));
    }
}