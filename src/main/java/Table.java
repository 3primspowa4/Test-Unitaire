public class Table {
    public boolean occupe=false;
    public boolean epinglee=false;

    public void clientArrive(Client client){
        occupe=true;
    }
    public void clientPart(){
        occupe=false;
    }

    public void tableNonPayee(Client client, Commande commande){
        epinglee=true;
    }
}
