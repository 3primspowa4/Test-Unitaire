
import java.util.ArrayList;

public class Restaurant {
    private Cuisine cuisine;
    private String Statut;
    private MaitreHotel maitreHotel;
    private ArrayList<Serveur> Serveurs;
    private ArrayList<Commande> Commandes;
    private ArrayList<Table> tablesOccupes=new ArrayList<>();
    private ArrayList<Table> listeTables;



    public Restaurant(ArrayList<Serveur> serveurs,ArrayList<Table> tables) {
        Serveurs = serveurs;
        listeTables=tables;
        maitreHotel = new MaitreHotel();
    }

    public MaitreHotel getMaitreHotel() {
        return maitreHotel;
    }

    public ArrayList<Serveur> getServeurs() {
        return Serveurs;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public ArrayList<Table> getTables() {
       return listeTables;

    }
    public void tableRemplie(Table table, Client client){
        tablesOccupes.add(table);
        table.setOccupe(true);
        table.clientArrive(client);
    }
    public void tableVider(Table table){
        tablesOccupes.remove(table);
        table.setOccupe(false);
    }
    public ArrayList<Plat> lesmenus= new ArrayList<>();


    public String getStatut() {
        return Statut;
    }
    public void AjoutServeur(Serveur s){
        Serveurs.add(s);
        s.setRestaurant(this);
    }
    public void AjoutCommande(Commande c){
        Commandes.add(c);
    }
    public void setStatut(String statut) {
        Statut = statut;
    }

    public ArrayList<Commande> listeMarquee(ArrayList<Commande> liste){
        for (int cpt= 0;cpt<10; cpt++){
            Commande commande = new CommandeBuilder().Build();
            liste.add(commande.commandeMarquee());
        }

        return liste;
    }
    public Menu getMenu(Menu menu){
        return menu;
    }
    public int recupererPrixPlat(Plat plat){
        int result=0;
        for (Plat p : lesmenus) {
            if (p.getNomPlat().equals(plat.getNomPlat())) {
                result= p.getPrixrestaurant();
                break;
            }
        }
        return result;
    }

    public ArrayList<Table> getTablesOccupes() {
        return tablesOccupes;
    }

    public void setTablesOccupes(ArrayList<Table> tablesOccupes) {
        this.tablesOccupes = tablesOccupes;
    }
    public  void tableOccupe(Table table, Client client){
        table.clientArrive(client);
        this.listeTables.add(table);
    }
    public void tableLibre(Table table){
        tablesOccupes.remove(table);
    }

    public void debuterService() {
        for ( Table table : this.listeTables ){
            if (table.getResponsable() == null){
                table.affecter(maitreHotel);
            }
        }
    }
    public void terminerService() {
        for ( Table table : this.listeTables ){
            if (table.getResponsable() == null){
                table.affecter(maitreHotel);
            }
        }
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

}
