package vuegraphique;

import controleur.ControlCommander;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

    public class PanCommander  extends JPanel implements IUseEnregistrerCoordonneesBancaires {

        // controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
        ControlCommander controlCommander;
        PanEnregistrerCoordonneesBancaire panEnregistrerCoordonneesBancaire;

        // les attributs metiers (ex : numClient)
        int numeroClient;
        int numeroHamburger = 0;
        int numeroAccompagnement = 0;
        int numeroBoisson = 0;

        // Les elements graphiques :

        // Declaration et creation des polices d'ecritures
        Font policeTitre = new Font("Calibri",Font.BOLD,24);
        Font policeParagraphe = new Font("Calibri",Font.HANGING_BASELINE,16);
        // Declaration et creation des ComboBox
        private JComboBox<String> comboBoxHamburger = new JComboBox<>();
        private  JComboBox<String> comboBoxAccompagnement = new JComboBox<>();
        private  JComboBox<String> comboBoxBoisson = new JComboBox<>();

        // Declaration et creation des Button
        private JButton validerCommande = new JButton();



        // Declaration et creation des TextArea

        // Declaration et creation des Labels

        private JLabel numeroCommande = new JLabel();

        // Mise en page : les Box
        Box boxMiseEnPageCommande = Box.createVerticalBox();
        Box boxChoixHamburger = Box.createHorizontalBox();
        Box boxChoixBoisson = Box.createHorizontalBox();
        Box boxChoixAccompagnement = Box.createHorizontalBox();
        Box boxValiderChoix = Box.createHorizontalBox();
        Box boxMiseEnPageNumeroCommande= Box.createVerticalBox();

        public PanCommander (
                // parametres pour l'initialisation des attributs metiers
                // parametres correspondants au controleur du cas + panels
                // des cas inclus ou etendus en lien avec un acteur
                ControlCommander controlCommande, PanEnregistrerCoordonneesBancaire panEnregistrerCoordonneesBancaire
        ) {
            // initialisation des attributs metiers
            // initilaisation du controleur du cas + panels
                this.controlCommander=controlCommande;
                this.panEnregistrerCoordonneesBancaire=panEnregistrerCoordonneesBancaire;
            // des cas inclus ou etendus en lien avec un acteur
        }

        //Methode d'initialisation du panel
        public void initialisation() {
            // mise en forme du panel (couleur, ...)
            setBackground(Color.YELLOW);

            // creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
                JLabel texteCommander = new JLabel("Votre menu");
                texteCommander.setFont(policeTitre);
                JLabel texteHamburger = new JLabel("Choisissez votre hamburger");
                texteHamburger.setFont(policeParagraphe);
                JLabel texteBoisson = new JLabel("Choisissez votre boisson");
                texteBoisson.setFont(policeParagraphe);
                JLabel texteAccompagnement = new JLabel("Choisissez votre Accompagnement");
                texteAccompagnement.setFont(policeParagraphe);
                validerCommande.setText("Valider");

                validerCommande.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(numeroHamburger !=0 && numeroBoisson!=0 && numeroAccompagnement!=0){
                            validationCartePaiement();
                        }
                    }
                });

                comboBoxHamburger.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                numeroHamburger=comboBoxHamburger.getSelectedIndex();
                        }
                });

                comboBoxAccompagnement.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                numeroAccompagnement=comboBoxAccompagnement.getSelectedIndex();
                        };
                });

                comboBoxBoisson.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                numeroBoisson=comboBoxBoisson.getSelectedIndex();
                        }
                });

                JLabel texteNumeroCommandeTitre = new JLabel("Votre commande");
                texteNumeroCommandeTitre.setFont(policeTitre);

            // mise en page : placements des differents elements graphiques dans des Box

                boxMiseEnPageCommande.add(texteCommander);
                boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30)));

                boxChoixHamburger.add(texteHamburger);
                boxChoixHamburger.add(Box.createRigidArea(new Dimension(10, 0)));
                boxChoixHamburger.add(comboBoxHamburger);


                boxChoixBoisson.add(texteBoisson);
                boxChoixBoisson.add(Box.createRigidArea(new Dimension(10, 0)));
                boxChoixBoisson.add(comboBoxBoisson);


                boxChoixAccompagnement.add(texteAccompagnement);
                boxChoixAccompagnement.add(Box.createRigidArea(new Dimension(10, 0)));
                boxChoixAccompagnement.add(comboBoxAccompagnement);

                boxValiderChoix.add(validerCommande);

                boxMiseEnPageNumeroCommande.add(numeroCommande);
                boxMiseEnPageNumeroCommande.add(texteNumeroCommandeTitre);
                boxMiseEnPageNumeroCommande.add(Box.createRigidArea(new Dimension(0,30)));
                numeroCommande.setFont(policeParagraphe);
                boxMiseEnPageNumeroCommande.add(numeroCommande);
                this.add(boxMiseEnPageNumeroCommande);



            // mise en page : placements des differentes box dans une box principale
                boxMiseEnPageCommande.add(boxChoixHamburger);
                boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30)));
                boxMiseEnPageCommande.add(boxChoixAccompagnement);
                boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30)));
                boxMiseEnPageCommande.add(boxChoixBoisson);
                boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0,50)));
                boxMiseEnPageCommande.add(boxValiderChoix);
            // mise en page : ajout de la box principale dans le panel
                this.add(boxMiseEnPageCommande);
        }

        // Methode correspondante au nom du cas
        public void nomCas( /*parametres metiers*/ ) {
        }
        public void commander( int numClient ) {
            boxMiseEnPageCommande.setVisible(true);
            boxMiseEnPageNumeroCommande.setVisible(false);
                this.numeroClient = numClient;
                controlCommander.verifierIdentification(numeroClient);
                affichageMenu();
        }

        // Methodes privees pour le bon deroulement du cas

        private void affichageMenu(){
                List<String> listeHamburger = controlCommander.donnerListeHamburger();
                List<String> listeAccompagnement = controlCommander.donnerListeAccompagnement();
                List<String> listeBoisson = controlCommander.donnerListeBoisson();

                comboBoxHamburger.removeAllItems();
                comboBoxBoisson.removeAllItems();
                comboBoxAccompagnement.removeAllItems();

                comboBoxHamburger.addItem("");
                comboBoxAccompagnement.addItem("");
                comboBoxBoisson.addItem("");

                for(String nom : listeHamburger){
                        comboBoxHamburger.addItem(nom);
                }
                for(String nom : listeBoisson){
                        comboBoxBoisson.addItem(nom);
                }
                for(String nom : listeAccompagnement){
                        comboBoxAccompagnement.addItem(nom);
                }

        }

        @Override
        public void retourEnregistrerCoordonneesBancaire(boolean carteValide) {
            this.panEnregistrerCoordonneesBancaire.setVisible(false);
            if(carteValide)
                this.enregistrerCommande(carteValide);


        }

        private void validationCartePaiement(){
            boolean carteRenseignee =controlCommander.verifierExistanceCarteBancaire(numeroClient);
            if (!carteRenseignee) {
                boxMiseEnPageCommande.setVisible(false);
                panEnregistrerCoordonneesBancaire.setVisible(true);
                this.repaint();
                panEnregistrerCoordonneesBancaire.enregistrerCoordonneesBancaires(numeroClient, this);
            } else{
                this.enregistrerCommande(carteRenseignee);
            }
        }

        private void enregistrerCommande(boolean carteRenseignee){
            if (carteRenseignee) {
                int numCommande =controlCommander.enregistrerCommande(numeroClient, numeroHamburger, numeroAccompagnement, numeroBoisson);
                numeroCommande.setText("Votre numero  de commande est : " + numCommande);
            }
            this.setVisible(true);
            boxMiseEnPageCommande.setVisible(false);
            boxMiseEnPageNumeroCommande.setVisible(true);
            this.repaint();
        }
    }

