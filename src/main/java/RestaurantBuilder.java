import java.util.ArrayList;

public class RestaurantBuilder {

    ArrayList<Serveur> Serveurs= new ArrayList<>();
    ArrayList<Table> tables= new ArrayList<>();
    private Cuisine cuisine;
    private boolean avecCuisine=false;
    private boolean ayantCommenceLeService =false;

    public void setAyantCommenceLeService(boolean ayantCommenceLeService) {
        this.ayantCommenceLeService = ayantCommenceLeService;
    }

    public boolean isAyantCommenceLeService() {
        return ayantCommenceLeService;
    }


    public Restaurant Build(){
        Restaurant rest=new Restaurant(Serveurs,tables);
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
         Serveurs.add(new ServeurBuilder().Build());
      }
      return this;
    }
    public RestaurantBuilder avecListeTable(int nb){
        for (int cpt=0; cpt<nb; cpt++){
            tables.add(new TableBuilder().Build());
            tables.get(cpt).setRestaurantBuilder(this);
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
