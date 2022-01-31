import java.util.ArrayList;

public class FranchiseBuilder {
    ArrayList<Restaurant> listResto=new ArrayList<>();
    public Franchise Build(){
        return new Franchise(listResto);
    }
    public  FranchiseBuilder avecListeRestaurant(int nbRestaurant){
        for (int cpt=0;cpt<nbRestaurant;cpt++){
            listResto.add(new RestaurantBuilder().Build());
        }
        return this;
    }
}
