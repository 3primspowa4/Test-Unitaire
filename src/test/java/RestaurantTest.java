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
            //s1.prendCommande(C1);
            F1.setCA(C1.getMontant());
        }
//	ALORS le chiffre d'affaires de la franchise est X * Y
       assertEquals(result,F1.getCA());
    }
    @ParameterizedTest
    @CsvSource({"0,0,1","1,1,1","2,2,1","1000,1000,1"})
    public void caFranchise(int x,int y,int z){
        //ÉTANT DONNÉ une franchise ayant X restaurants de Y serveurs chacuns
        int result = x*y*z;
        Restaurant restaurant = new RestaurantBuilder().avecListeServeur(y).Build();
        Commande C1=new CommandeBuilder().Build();
        Franchise F1=new FranchiseBuilder().avecListeRestaurant(x).Build();
        C1.setMontant(z);
        //QUAND tous les serveurs prennent une commande d'un montant Z
        for (Restaurant R1:F1.getListResto()){
            for (Serveur s1:restaurant.getServeurs()) {
                F1.setCA(C1.getMontant());
            }
        }

        //ALORS le chiffre d'affaires de la franchise est X * Y * Z
        assertEquals(result,F1.getCA());
    }
}