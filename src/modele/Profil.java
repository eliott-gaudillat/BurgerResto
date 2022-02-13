package modele;

public abstract class Profil {
    private String nom;
    private String prenom;
    private String login;
    private String mdp;

    public Profil(String nom, String prenom, String mdp){
        this.nom=nom;
        this.prenom=prenom;
        this.login=prenom+'.'+nom;
        this.mdp=mdp;
    }

    @Override
    public String toString() {
        return "nom=" + nom +
                ", prenom=" + prenom +
                ", login=" + login +
                ", mdp=" + mdp ;
    }
}
