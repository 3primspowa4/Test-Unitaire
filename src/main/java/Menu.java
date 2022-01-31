import java.util.ArrayList;

public class Menu {
    public ArrayList<Plat> lesplats= new ArrayList<>();
    public void ajoutPlat(Plat plat){
        lesplats.add(plat);
    }
    public int voirPrix(int index){
        if(lesplats.get(index).isCreerParLaFranchise()){
            return lesplats.get(index).getPrixfranchise();
        }else{
            return lesplats.get(index).getPrixrestaurant();
        }
    }
}