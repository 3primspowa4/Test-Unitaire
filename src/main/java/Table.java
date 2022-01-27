public class Table {
    public boolean occupe=false;

    public void clientArrive(Client client){
        occupe=true;
    }
    public void clientPart(){
        occupe=false;
    }
}
