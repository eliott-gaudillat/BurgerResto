package testgraphique;

import controleur.ControlEnregistrerCoordonneesBancaires;
import controleur.ControlVerifierCoordonneesBancaires;
import vuegraphique.PanEnregistrerCoordonneesBancaire;

import javax.swing.*;

public class TestEnregistrerCoordonneeBancaire {

    public static void main(String[] args) {
        ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires = new ControlVerifierCoordonneesBancaires();
        ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires = new ControlEnregistrerCoordonneesBancaires(
                controlVerifierCoordonneesBancaires);
        // JFrame test = new JFrame();
        // test.add(panTest);
        // test.isVisible();
        // panTest.isVisible();
        // panTest.enregistrerCoordonneesBancaires(1);
        JFrame fenetre = new JFrame();
        fenetre.setVisible(true);
        fenetre.setSize(800,400);

        PanEnregistrerCoordonneesBancaire panTest = new
                PanEnregistrerCoordonneesBancaire(controlEnregistrerCoordonneesBancaires);
        fenetre.setContentPane(panTest);
        panTest.initialisation();
        //panTest.enregistrerCoordonneesBancaires(1);
        panTest.setVisible(true);
        fenetre.repaint();
    }

}
