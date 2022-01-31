public class Plat {
    private String nomPlat;
    private int prixfranchise;
    private int prixrestaurant;
    private boolean creerParLaFranchise;
    public Plat(String nom, int prix, boolean origine){
        this.nomPlat=nom;
        this.prixfranchise=prix;
        this.prixrestaurant=prix;
        this.creerParLaFranchise=origine;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public Plat(String plat) {
        nomPlat=plat;
    }


    public int getPrixfranchise() {
        return prixfranchise;
    }

    public void setPrixfranchise(int prixfranchise) {
        this.prixfranchise = prixfranchise;
    }

    public int getPrixrestaurant() {
        return prixrestaurant;
    }

    public void setPrixrestaurant(int prixrestaurant) {
        this.prixrestaurant = prixrestaurant;
    }

    public boolean isCreerParLaFranchise() {
        return creerParLaFranchise;
    }

    public void setCreerParLaFranchise(boolean creerParLaFranchise) {
        this.creerParLaFranchise = creerParLaFranchise;
    }
}
