import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String Statut;
    private ArrayList<Serveur> Serveurs;

    public Restaurant(ArrayList<Serveur> serveurs) {
        Serveurs = serveurs;
    }

    public ArrayList<Serveur> getServeurs() {
        return Serveurs;
    }

    public String getStatut() {
        return Statut;
    }
    public void AddServeur(Serveur s){
        Serveurs.add(s);
    }
    public void setStatut(String statut) {
        Statut = statut;
    }
    public Menu getMenu(Menu menu){
        return menu;
    }
}
