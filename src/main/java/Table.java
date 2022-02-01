public class Table {
    public MaitreHotel maitreHotel = null;
    public boolean occupe=false;
    public boolean epinglee=false;

    public void affecter(MaitreHotel maitreHotel) {
        this.maitreHotel = maitreHotel;
    }
    public void clientArrive(Restaurant restaurant,Client client){
        occupe=true;
        restaurant.tableOccupe(this);

    }
    public void clientPart(Restaurant restaurant){
        occupe=false;
        restaurant.tableLibre(this);
    }

    public void tableNonPayee(Client client, Commande commande){
        epinglee=true;
    }
}
