public class Plat {
    private int prix;
    private String nomPlat;
    public Plat(String plat) {
        nomPlat=plat;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    public int getPrix() {
        return this.prix;
    }

}
