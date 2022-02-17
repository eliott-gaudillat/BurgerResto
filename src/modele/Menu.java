package modele;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Hamburger> listeHamburger = new ArrayList<>();
    private  List<Accompagnement> listeAccompagnement=new ArrayList<>();
    private List<Boisson> listeBoisson= new ArrayList<>();

    /** Constructeur privé **/
    private Menu(){}

    /** Holder **/
     private static class MenuHolder {
         private final static Menu instance = new Menu();
    }

    public static Menu getInstance(){
         return  MenuHolder.instance;
    }


    /**methodes**/
    public void ajouterAliment(Hamburger hamburger){
        listeHamburger.add(hamburger);
    }

    public void ajouterAliment(Accompagnement accompagnement){
        listeAccompagnement.add(accompagnement);
    }

    public void ajouterAliment(Boisson boisson){
        listeBoisson.add(boisson);
    }

    @Override
    public String toString() {
        return "Menu[" +
                "listeHamburger=" + listeHamburger +
                ", listeBoisson=" + listeBoisson +
                ", listeAccompagnement=" + listeAccompagnement +
                ']';
    }
}
