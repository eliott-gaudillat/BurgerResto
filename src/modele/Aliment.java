package modele;

public abstract class Aliment {
    String nom;

    public Aliment(String nom){
        this.nom=nom;
    }

    @Override
    public String toString() {
        return "Aliment[" +
                "nom=" + nom +
                ']';
    }
}
