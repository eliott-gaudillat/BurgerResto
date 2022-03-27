package vuegraphique;

import controleur.ControlVisualiserCommandeJour;
import modele.ProfilUtilisateur;
import modele.PropertyName;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class PanVisualiserCommandeJour extends JPanel implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;

    // controleurs du cas
    private ControlVisualiserCommandeJour controlVisualiserCommandeJour;

    // les attributs metiers
    private static Map<String, String> mapCommandeJour = new HashMap<>();

    // Les elements graphiques :
    // polices d'ecritures
    private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
    private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);

    // Mise en page : les Box
    private Box boxMiseEnpage = Box.createVerticalBox();
    private Box boxCommandeJour = Box.createVerticalBox();
    private Box boxCommandes = Box.createVerticalBox();

    private FrameCuisinier frame;

    public PanVisualiserCommandeJour(ControlVisualiserCommandeJour controlVisualiserCommandeJour) {
        this.controlVisualiserCommandeJour = controlVisualiserCommandeJour;
    }

    // Methode d'initialisation du panel
    public void initialisation(FrameCuisinier frame) {
        this.frame = frame;
        // mise en forme du panel (couleur, ...)
        this.setBackground(Color.WHITE);
        // creation des differents elements graphiques (JLabel, Combobox,
        // Button, TextAera ...)

        JLabel titre = new JLabel("Commande du Jour");
        titre.setFont(policeTitre);

        // mise en page : placements des differents elements graphiques dans des
        // Box
        this.boxCommandeJour.add(titre);
        this.boxCommandeJour.add(Box.createRigidArea(new Dimension(0, 15)));
        this.boxCommandeJour.add(boxCommandes);
        // mise en page : placements des differentes box dans une box principale
        this.boxMiseEnpage.add(boxCommandeJour);
        // mise en page : ajout de la box principale dans le panel
        this.add(boxMiseEnpage);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName= evt.getPropertyName();
        PropertyName choix = PropertyName.valueOf(propertyName);
        switch (choix){
            case ENREGISTRER_COMMANDE :
                Object objet= evt.getNewValue();
                String[] labels = (String[]) objet;
                String numeroCommande = labels[0];
                String hamburger = labels[1];
                String accompagnement=labels[2];
                String boisson = labels[3];
               String texteCommandeDuJour = ("commande n° : "+numeroCommande + " ; hamburger : " + hamburger +
                        "; accompagnement : " +accompagnement + "; boisson : " + boisson);
               JLabel label = new JLabel(texteCommandeDuJour);
               label.setFont(policeParagraphe);
               PanVisualiserCommandeJour.mapCommandeJour.put(numeroCommande,texteCommandeDuJour);
                break;
            case VIDER_COMMANDE_JOUR:
                PanVisualiserCommandeJour.mapCommandeJour.clear();
                boxCommandes.removeAll();
                actualiserPanel();
                break;
        }


    }

    private void actualiserPanel() {
        frame.setVisible(true);
        frame.repaint();
    }

    private void initialiserPanel() {
        boxCommandes.removeAll();
        for (int i = 0; i < mapCommandeJour.size(); i++) {
            String numeroCommande = String.valueOf(i + 1);
            String texte = mapCommandeJour.get(numeroCommande);
            JLabel label = new JLabel(texte);
            label.setFont(policeParagraphe);
            boxCommandes.add(label);
        }
        actualiserPanel();
    }

    public void visualiserCommandeJour(int numCuisinier) {
        initialiserPanel();
        if(controlVisualiserCommandeJour.verifierIdentification(numCuisinier, ProfilUtilisateur.PERSONNEL)){
            this.controlVisualiserCommandeJour.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(), this);
            this.controlVisualiserCommandeJour.setListener(PropertyName.VIDER_COMMANDE_JOUR.toString(),this);
        }
    }

}
