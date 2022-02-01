import java.util.ArrayList;

public class RestaurantBuilder {

    ArrayList<ContenuRestaurant> contenu= new ArrayList<>();
    ArrayList<Serveur> Serveurs= new ArrayList<>();
    private Cuisine cuisine;
    private boolean avecCuisine=false;
    private boolean ayantCommenceLeService =false;

    public Restaurant Build(){
        Restaurant rest=new Restaurant(contenu /*Serveurs*/);
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
      for (int cpt=0; cpt<nb; cpt++){
          contenu.add(new ServeurBuilder().Build());
      }
      return this;
    }
    public RestaurantBuilder avecListeTable(int nb){
        for (int cpt=0; cpt<nb; cpt++){
            contenu.add(new TableBuilder().Build());
        }
        return this;
    }
    /*public RestaurantBuilder avecContenu(int nb) {
        for (int cpt=0; cpt<nb; cpt ++){
            if(contenu.get(cpt) instanceof Table) {
                contenu.add(new TableBuilder().Build() );
            } else {
                contenu.add(new ServeurBuilder().Build() );
            }
        }
        return this;
    }
    */
    public RestaurantBuilder AyantDebuteLeService(){
        ayantCommenceLeService=true;
        return this;
    }
}
