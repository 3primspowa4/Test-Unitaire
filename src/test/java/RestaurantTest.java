import org.junit.Assert.*;
import org.junit.Test;

import java.security.cert.TrustAnchor;

import static org.junit.Assert.*;
public class RestaurantTest {
    @Test
    public void CA_resto(){

//    ÉTANT DONNÉ un restaurant ayant X
    Restaurant restaurant = new RestaurantBuilder()
                                .avecListeServeur(1)
                                .Build();
    Commande C1=new CommandeBuilder().Build();
    Franchise F1=new FranchiseBuilder().Build();
    C1.setMontant(1);
//	QUAND tous les serveurs prennent une commande d'un montant Y
        for (Serveur s1:restaurant.getServeurs()) {
            s1.prendCommande(C1);
        }
//	ALORS le chiffre d'affaires de la franchise est X * Y

        assertEquals(1,F1.getCA());
    }
}
