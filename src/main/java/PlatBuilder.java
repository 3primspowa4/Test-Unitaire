public class PlatBuilder {
    private String nom="nuggets";
    private int prix=10;
    private boolean origine=true;
    public Plat Build(){
        return new Plat(nom, prix, origine);
    }
    public PlatBuilder avecParametres(String nomDonne,int prixDonne,boolean originedonne){
        nom=nomDonne;
        prix=prixDonne;
        origine=originedonne;
        return this;
    }

}
