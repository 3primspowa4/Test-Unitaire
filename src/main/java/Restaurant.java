import java.util.ArrayList;

public class Restaurant {
    private String Statut;

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String statut) {
        Statut = statut;
    }

    public ArrayList<Commande> listeMarquee(ArrayList<Commande> liste){
        for (int cpt= 0;cpt<10; cpt++){
            Commande commande = new Commande();
            liste.add(commande.commandeMarquee());
        }

        return liste;
    }
}
