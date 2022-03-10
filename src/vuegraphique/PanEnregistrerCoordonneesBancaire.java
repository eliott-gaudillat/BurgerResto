package vuegraphique;

import controleur.ControlEnregistrerCoordonneesBancaires;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PanEnregistrerCoordonneesBancaire  extends JPanel {
    // controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
    ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;
    private IUseEnregistrerCoordonneesBancaires panAppelant;
    // les attributs metiers (ex : numClient)
    private int numClient ;

    // Les elements graphiques :

    // Declaration et creation des polices d'ecritures
    Font policeTitre = new Font("Calibri",Font.BOLD,24);
    Font policeParagraphe = new Font("Calibri",Font.HANGING_BASELINE,16);
    Font policeARemplacer = new Font("Arial",Font.ITALIC,12);
    Font policeChoixUtilisateur = new Font("Arial",Font.TRUETYPE_FONT,12);

    // Declaration et creation des ComboBox

    // Declaration et creation des Button
    private JButton validationCoordonneesBancaire = new JButton();

    // Declaration et creation des TextArea
    private TextArea textAreaNumeroCarte = new TextArea();
    private TextArea textAreaDateExpiration = new TextArea();

    // Declaration et creation des Labels

    // Mise en page : les Box
    private Box boxMiseEnPageCoordonneesBancaires = Box.createVerticalBox();
    private Box boxNumeroCarte = Box.createHorizontalBox();
    private  Box boxValiditeCarte = Box.createHorizontalBox();
    private Box boxValiderCarte = Box.createHorizontalBox();

    public PanEnregistrerCoordonneesBancaire (
            // parametres pour l'initialisation des attributs metiers
            // parametres correspondants au controleur du cas + panels
            ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires
            // des cas inclus ou etendus en lien avec un acteur
    ) {
        // initialisation des attributs metiers
        // initilaisation du controleur du cas + panels
        this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
        // des cas inclus ou etendus en lien avec un acteur
    }

    //Methode d'initialisation du panel
    public void initialisation() {

        // mise en forme du panel (couleur, ...)
        setBackground(Color.YELLOW);

        // creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)

        JLabel texteCoordoneesBancaire = new JLabel("Entrez vos coordonnées bancaires");
        texteCoordoneesBancaire.setFont(policeTitre);


        JLabel texteNumeroCarte = new JLabel("Entrez le numero de votre carte bancaire");
        texteNumeroCarte.setFont(policeParagraphe);


        JLabel texteValiditeCarte = new JLabel("Entrez la date d'expiration de votre carte bancaire");
        texteValiditeCarte.setFont(policeParagraphe);


        validationCoordonneesBancaire.setText("Valider");
        validationCoordonneesBancaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroCarte = Integer.valueOf(textAreaNumeroCarte.getText());
                int dateCarte = Integer.valueOf(textAreaDateExpiration.getText());
                traitementCoordonneesBancaires(numeroCarte,dateCarte);
            }
        });

        textAreaNumeroCarte.setMaximumSize(new Dimension(120,20));

        textAreaDateExpiration.setForeground(Color.GRAY);
        textAreaDateExpiration.setMaximumSize(new Dimension(60,20));
        textAreaDateExpiration.setFont(policeARemplacer);
        textAreaDateExpiration.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent arg0) {}
            public void mousePressed(MouseEvent arg0) {}
            public void mouseExited(MouseEvent arg0) {}
            public void mouseEntered(MouseEvent arg0) {}
            public void mouseClicked(MouseEvent arg0) {
                textAreaDateExpiration.setText(null);
                textAreaDateExpiration.setFont(policeChoixUtilisateur);
                textAreaDateExpiration.setForeground(Color.black);
            }
        });

        // mise en page : placements des differents elements graphiques dans des Box
        boxMiseEnPageCoordonneesBancaires.add(texteCoordoneesBancaire);

        boxNumeroCarte.add(texteNumeroCarte);
        boxNumeroCarte.add(Box.createRigidArea(new Dimension(10,0)));
        boxNumeroCarte.add(textAreaNumeroCarte);

        boxValiditeCarte.add(texteValiditeCarte);
        boxValiditeCarte.add(Box.createRigidArea(new Dimension(10,0)));
        boxValiditeCarte.add(textAreaDateExpiration);

        boxValiderCarte.add(validationCoordonneesBancaire);

        // mise en page : placements des differentes box dans une box principale
        boxMiseEnPageCoordonneesBancaires.add(Box.createRigidArea(new Dimension(0,30)));
        boxMiseEnPageCoordonneesBancaires.add(boxNumeroCarte);
        boxMiseEnPageCoordonneesBancaires.add(Box.createRigidArea(new Dimension(0,30)));
        boxMiseEnPageCoordonneesBancaires.add(boxValiditeCarte);
        boxMiseEnPageCoordonneesBancaires.add(Box.createRigidArea(new Dimension(0,50)));
        boxMiseEnPageCoordonneesBancaires.add(boxValiderCarte);

        // mise en page : ajout de la box principale dans le panel
        this.add(boxMiseEnPageCoordonneesBancaires);
        boxMiseEnPageCoordonneesBancaires.setVisible(true);
        this.setVisible(false);
    }

    public void enregistrerCoordonneesBancaires(int numClient,IUseEnregistrerCoordonneesBancaires panAppelant){
        this.numClient=numClient;
        this.panAppelant=panAppelant;
        textAreaNumeroCarte.setText("");
        textAreaDateExpiration.setText("MMAA");
        this.setVisible(true);
        this.repaint();
    }

    // Methode correspondante au nom du cas
    public void nomCas( /*parametres metiers*/ ) {
    }

    // Methodes privees pour le bon deroulement du cas
    private void traitementCoordonneesBancaires(int numeroCarte,int dateCarte) {
        boolean carteValide = controlEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient, numeroCarte, dateCarte);
        panAppelant.retourEnregistrerCoordonneesBancaire(carteValide);
    }
}
