import java.util.ArrayList;

public class Serveur {
    private int CA;
    private ArrayList<Commande> commande;



    public int GetCA() {
        return CA;
    }

    public ArrayList<Commande> getCommande() {
        return commande;
    }

    public void prendCommande(Commande commande){
        CA+=commande.getMontant();
        this.commande.add(commande);
    }


}
