import java.util.ArrayList;

public class Franchise {
    private int CA=0;
    private ArrayList<Restaurant> listResto;

    public Franchise(ArrayList<Restaurant> listResto) {
        this.listResto = listResto;
    }

    public ArrayList<Restaurant> getListResto() {
        return listResto;
    }

    ArrayList<Plat> lesplats = new ArrayList<>();
    public void ajoutMenu(Plat plat){
        Menu menu = new Menu();
    }
    public void modifiePrix(Plat plat, int i) {
        plat.setPrixfranchise(i);
        if(plat.isCreerParLaFranchise()){
            plat.setPrixrestaurant(i);
        }
    }
    public int recupererPrixPlat(Plat plat){
        int result=0;
        for (Plat p : lesplats) {
            if (p.getNomPlat().equals(plat.getNomPlat())) {
                result= p.getPrixfranchise();
                break;
            }
        }
        return result;
    }


    public int getCA() {
        return CA;
    }

    public void setCA(int CA) {
        this.CA += CA;
    }
}
