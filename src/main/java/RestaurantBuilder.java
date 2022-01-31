import java.util.ArrayList;

public class RestaurantBuilder {
    ArrayList<Serveur> Serveurs= new ArrayList<>();
    public Restaurant Build(){
        return new Restaurant(Serveurs);
    }

    public RestaurantBuilder avecListeServeur(int nb){
      for (int cpt=0;cpt<nb;cpt++){
          Serveurs.add(new ServeurBuilder().Build());
      }
      return this;
    }
}
