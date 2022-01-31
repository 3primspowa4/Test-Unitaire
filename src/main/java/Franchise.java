import java.util.ArrayList;

public class Franchise {
    private int CA;
    //private ArrayList<Restaurant> listResto;
    ArrayList<Plat> lesplats = new ArrayList<>();
    public void ajoutMenu(Plat plat){
        var menu = new Menu();
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

   /* public int getCA(Restaurant r1) {
        ArrayList<Serveur> listServer=r1.getServeurs();
        for (Serveur s:listServer) {
            s.getCommande().getMontant();
        }
       CA=listServer.size()*listServer.
        return CA;
    }*/
}
