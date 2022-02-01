import java.util.ArrayList;

public class Restaurant {
    private Cuisine cuisine;
    private String Statut;
    private ArrayList<Serveur> Serveurs;
    private ArrayList<Commande> Commandes;
    private ArrayList<Table> tablesOccupes=new ArrayList<>();
    //private ArrayList<Serveur> lesServeurs= new ArrayList<>(); //TODO: supprimer et utiliser getServeurs()
    private ArrayList<ContenuRestaurant> contenuRestaurant;

    public Restaurant(ArrayList<ContenuRestaurant> contenu) {
        this.contenuRestaurant =  contenu;
    }
    /*public Restaurant(ArrayList<Serveur> serveurs) {
        Serveurs = serveurs;
    }*/
    public ArrayList<ContenuRestaurant> getContenu() {
        return contenuRestaurant;
    }
    /*public ArrayList<Serveur> getServeurs() {
        return Serveurs;
    }*/
    public ArrayList<Serveur> getServeurs() {
        ArrayList<Serveur> serveurs = new ArrayList<>();
        if (contenuRestaurant.get(0) instanceof Serveur){
            for(ContenuRestaurant contenu: getContenu()) {
                serveurs.add((Serveur) contenu);
            }
        }
        return serveurs;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public ArrayList<Table> getTables() {
        ArrayList<Table> tables = new ArrayList<>();
        if (contenuRestaurant.get(0) instanceof Table){
            for(ContenuRestaurant contenu: getContenu()) {
                tables.add((Table)contenu);
            }
        }
        return tables;
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
    public  void tableOccupe(Table table){
        this.tablesOccupes.add(table);
    }
    public void tableLibre(Table table){
        tablesOccupes.remove(table);
    }

    public void debuterService() {
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void AddContenu(ContenuRestaurant c){
        contenuRestaurant.add(c);
    }
    /*public void AddServeur(Serveur s){
        Serveurs.add(s);
    }*/


    public void ajoutServeur(Serveur serveur) {
        serveur.setRestaurant(this);
        this.lesServeurs.add(serveur);
    }
}
