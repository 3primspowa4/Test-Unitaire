public class PlatBuilder {
    private String nom="nuggets";
    private int prix=10;
    public Plat Build(){
        return new Plat(nom, prix, true);
    }
    public PlatBuilder avecNomEtPrix(String nomDonne,int prixDonne){
        nom=nomDonne;
        prix=prixDonne;
        return this;
    }

}
