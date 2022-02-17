package modele;

public class FabriqueAliment {
    public static  Aliment creerAliment(AlimentMenu typeAliment,String nom){
        Aliment aliment = null ;
        switch (typeAliment){
            case HAMBURGER:
                aliment=new Hamburger(nom);
                break;
            case BOISSON:
                aliment=new Boisson(nom);
                break;
            case ACCOMPAGNEMENT:
                aliment= new Accompagnement(nom);

                break;
            default:
                throw new IllegalArgumentException("Type de produit inconnu");
        }
        return aliment;
    }
}

