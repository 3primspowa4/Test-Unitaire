import java.util.ArrayList;

public class Serveur {
    private int CA;
    private Commande commande;



    public int GetCA() {
        return CA;
    }

    public Commande getCommande() {
        return commande;
    }

    public void prendCommande(Commande commande){
        CA+=commande.getMontant();
        this.commande=commande;
    }


}
