package vuegraphique;

import controleur.ControlCommander;
import controleur.ControlEnregistrerCoordonneesBancaires;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameClient extends JFrame {
    // Les attributs metiers (ex : numClient)
    private int numClient;
    // Declaration et creation des elements graphiques (JLabel)
    // Declaration et creation de la barre de menu (MenuBar)
    MenuBar barreMenu = new MenuBar();
    // Declaration et creation des differents panels
    private JPanel panAccueil = new JPanel();
    private JPanel panContents = new JPanel();
    private PanCommander panCommander;
    private  PanModifierProfil panModifierProfil= new PanModifierProfil();
    private PanHistorique panHistorique = new PanHistorique();
    // Declaration et creation du gestionnaire des cartes (CardLayout)
    CardLayout cartes = new CardLayout();

    // Le constructeur
    public FrameClient (
            // parametres pour l'initialisation des attributs metiers
            int numClient,
            // parametres correspondants aux controleurs des cas utiliser par
            // l'acteur en relation avec cette frame
            ControlCommander controlCommande,
            ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires
    ) {
        // initialisation des attributs metiers
        this.numClient=numClient;
        // mise en forme de la frame (titre, dimension, ...)
        setTitle("BurgerResto");
        setSize(900,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // initialisation des differents panels : appel a leur methode d'initialisation
        PanEnregistrerCoordonneesBancaire panEnregistrerCoordonneesBancaire = new PanEnregistrerCoordonneesBancaire(controlEnregistrerCoordonneesBancaires);
        panCommander = new PanCommander(controlCommande,panEnregistrerCoordonneesBancaire);
        this.panCommander.initialisation();
        this.panHistorique.initialisation();
        this.panModifierProfil.initialisation();
        panEnregistrerCoordonneesBancaire.initialisation();
        // ajout des pannels dans le ContentPane de la Frame
        panContents.setLayout(cartes);
        panContents.add(panCommander,"COMMANDER");
        panCommander.add(panEnregistrerCoordonneesBancaire, "ENREGISTRER_COORDONNEES_BANCAIRE");
        panContents.add(panHistorique,"HISTORIQUE");
        panContents.add(panModifierProfil,"MODIFIER_PROFIL");
        getContentPane().add(panContents);
        // mise en page : mises en place des cartes
        initialisationAcceuil();
        // mise en place du menu
        initialisationMenu();
        setMenuBar(barreMenu);
        // appel a la methode d'initialisation du menu
        // appel a la methode d'initialisation de la page d'accueil (optionnel)

        this.setVisible(true);
    }


    private void initialisationMenu() {
        MenuItem commander = new MenuItem("Commander");
        commander.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                panCommander.commander(numClient);
                cartes.show(panContents, "COMMANDER");
            }
        });
        MenuItem historique = new MenuItem("Historique");
        historique.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cartes.show(panContents, "HISTORIQUE");
            }
        });

        MenuItem modifierProfil = new MenuItem("ModifierProfil");
        modifierProfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cartes.show(panContents, "MODIFIER_PROFIL");
            }
        });
        Menu menuMonCompte = new Menu("Mon compte");
        menuMonCompte.add(commander);
        menuMonCompte.add(historique);
        menuMonCompte.add(modifierProfil);
        Menu menuDeconnexion = new Menu("Deconnexion");
        this.barreMenu.add(menuMonCompte);
        this.barreMenu.add(menuDeconnexion);
    }

    private void initialisationAcceuil(){
        panAccueil.setBackground(Color.ORANGE);
        JLabel texteAccueil = new JLabel("Bienvenue à Burger Resto");
        texteAccueil.setFont(new Font("Calibri", Font.BOLD, 24));
        panAccueil.add(texteAccueil);
        panAccueil.setVisible(true);
        panContents.add(panAccueil, "ECRAN_ACCUEIL");
        cartes.show(panContents, "ECRAN_ACCUEIL");
    }
}
