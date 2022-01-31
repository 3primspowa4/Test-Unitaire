
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.security.cert.TrustAnchor;

public class RestaurantTest {
    @Test
    public void CA_resto(){

//    ÉTANT DONNÉ un restaurant ayant X
    Restaurant restaurant = new RestaurantBuilder()
                                .avecListeServeur(100)
                                .Build();
    Commande C1=new CommandeBuilder().Build();
    Franchise F1=new FranchiseBuilder().Build();
    C1.setMontant(2);
//	QUAND tous les serveurs prennent une commande d'un montant Y
        for (Serveur s1:restaurant.getServeurs()) {
            s1.prendCommande(C1);
        }
//	ALORS le chiffre d'affaires de la franchise est X * Y

       //assertEquals(200,F1.getCA(restaurant));
    }
}
