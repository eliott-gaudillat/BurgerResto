package modele;

public class Personnel extends Profil {
    private boolean gerant =false;

    public Personnel(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
    }

    public void definirGerant(){
        this.gerant=true;
    }

    @Override
    public String toString() {
        return " Personnel [" +
                "gerant=" + gerant +","+
                super.toString()+
                "connecte"+
                ']';
    }
}
