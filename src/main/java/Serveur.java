import java.util.ArrayList;

public class Serveur extends ContenuRestaurant {
    private int CA;
    private ArrayList<Commande> lesCommandes= new ArrayList<>();
    private Restaurant restaurant;

    public int GetCA() {
        return CA;
    }

    public void prendCommande(Commande commande){
        CA+=commande.getMontant();
        if(commande.isNourriture())
            restaurant.getCuisine().ajoutCommande(commande);
        this.lesCommandes.add(commande);

    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
