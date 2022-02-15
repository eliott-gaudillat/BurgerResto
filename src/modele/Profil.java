package modele;

public abstract class Profil {
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private  boolean connecte=false;

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
                ", mdp=" + mdp +
                ",connecte=" + connecte;
    }

    public boolean verifierCorrespondanceProfil(String login, String mdp){
        return this.login.equals(login) && this.mdp.equals(mdp);}

    public void connexionProfil(){
        connecte=true;
    }

    public boolean isConnecte(){
        return connecte;
    }
}
