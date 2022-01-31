import java.util.ArrayList;

public class Restaurant {
    private Cuisine cuisine;
    private String Statut;
    private ArrayList<Serveur> Serveurs;
    private ArrayList<Commande> Commandes;
    private ArrayList<Table> tablesOccupes=new ArrayList<>();
    private ArrayList<Serveur> lesServeurs= new ArrayList<>();


    public Restaurant(ArrayList<Serveur> serveurs) {
        Serveurs = serveurs;

    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public ArrayList<Serveur> getServeurs() {
        return Serveurs;
    }
    public ArrayList<Plat> lesmenus= new ArrayList<>();


    public String getStatut() {
        return Statut;
    }
    public void AjoutServeur(Serveur s){
        Serveurs.add(s);
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

    public ArrayList<Serveur> getLesServeurs() {
        return lesServeurs;
    }

    public void ajoutServeur(Serveur serveur) {
        serveur.setRestaurant(this);
        this.lesServeurs.add(serveur);
    }
}
