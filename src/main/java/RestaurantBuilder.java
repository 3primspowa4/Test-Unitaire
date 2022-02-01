import java.util.ArrayList;

public class RestaurantBuilder {
    ArrayList<Serveur> Serveurs= new ArrayList<>();
    private Cuisine cuisine;
    private boolean avecCuisine=false;
    private boolean ayantCommenceLeService =false;
    public Restaurant Build(){
        Restaurant rest=new Restaurant(Serveurs);
        if (ayantCommenceLeService){
            rest.debuterService();
        }
        if (avecCuisine){
            rest.setCuisine(cuisine);
        }

        return rest;
    }
    public RestaurantBuilder AvecCuisine(){
        this.cuisine=new CuisineBuilder().Build();
        avecCuisine=true;
        return this;
    }
    public RestaurantBuilder avecListeServeur(int nb){
      for (int cpt=0;cpt<nb;cpt++){
          Serveurs.add(new ServeurBuilder().Build());
      }
      return this;
    }
    public RestaurantBuilder AyantDebuteLeService(){
        ayantCommenceLeService=true;
        return this;
    }
}
