import java.util.ArrayList;

public class Table {
    public MaitreHotel maitreHotel = null;
    private boolean occupe=false;
    public boolean epinglee=false;
    private ArrayList<Client> lesclients = new ArrayList<>();

    public void affecter(MaitreHotel maitreHotel) {
        this.maitreHotel = maitreHotel;
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
}
