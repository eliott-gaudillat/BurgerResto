package modele;

public class Client extends Profil{

    private CarteBancaire carteBancaire=null;

    public Client(String nom, String prenom, String mdp){
        super(nom,prenom,mdp);
    }

    public void enregistrerCoordonneesBancaires(int numeroCarte,int dateCarte){
        this.carteBancaire = new CarteBancaire(numeroCarte,dateCarte);
    }

    public boolean verifierExistanceCarteBancaire(){return carteBancaire!=null;}

    @Override
    public String toString() {
        return "Client["+
                super.toString()+
                ",carteBancaire ="+
                carteBancaire.toString()+
                "]";
    }
}
