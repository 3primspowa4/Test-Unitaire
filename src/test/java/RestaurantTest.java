import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import java.security.cert.TrustAnchor;

public class RestaurantTest {
    @ParameterizedTest
    @CsvSource({"0,1","1,1","2,1","100,1"})
    public void caRestaurant(int x, int y){
//    ÉTANT DONNÉ un restaurant ayant X serveurs
        int result = x*y;
        Restaurant restaurant = new RestaurantBuilder()
                                    .avecListeServeur(x)
                                    .Build();
        Commande C1=new CommandeBuilder().Build();
        Franchise F1=new FranchiseBuilder().Build();
        C1.setMontant(y);
//	QUAND tous les serveurs prennent une commande d'un montant Y
        for (Serveur s1:restaurant.getServeurs()) {
            F1.setCA(C1.getMontant());
        }
//	ALORS le chiffre d'affaires de la franchise est X * Y
       assertEquals(result,F1.getCA());
    }
}