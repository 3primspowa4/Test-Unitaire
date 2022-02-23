import java.util.ArrayList;

public class Table {
    private Employe responsable;
    private RestaurantBuilder restaurantBuilder;
    private boolean occupe=false;
    public boolean epinglee=false;
    private ArrayList<Client> lesclients = new ArrayList<>();

    public Employe getResponsable() {
        return responsable;
    }

    public void affecter(Employe employe) {

        if ( restaurantBuilder.isAyantCommenceLeService() ){
            if (!(this.responsable instanceof Serveur))
                this.responsable = employe;
        }
        else {
            this.responsable = employe;
        }
    }

    public void clientPart(){
        setOccupe(false);
    }

    public void tableNonPayee(Client client, Commande commande){
        epinglee=true;
    }

    public boolean isOccupe() {
        return occupe;
    }
    public void clientArrive(Client client){
        setOccupe(true);
        this.lesclients.add(client);

    }
    public void setOccupe(boolean occupe) {
        this.occupe = occupe;

    }

    public void setRestaurantBuilder(RestaurantBuilder restaurantBuilder) {
        this.restaurantBuilder = restaurantBuilder;
    }
}