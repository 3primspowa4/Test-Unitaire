import org.junit.Test;
import static org.junit.Assert.*;

public class MenuTest {
    @Test
    public void modificationPrixPlat(){
        // ÉTANT DONNE un restaurant ayant le statut de filiale d'une franchise
        //ET une franchise définissant un menu ayant un plat
        Restaurant R1=new RestaurantBuilder().Build();
        Franchise F1=new Franchise();
        Plat nuggets=new Plat("nuggets");
        R1.setStatut("Filiale");
        //F1.definirMenu("enfant",nuggets);
        //QUAND la franchise modifie le prix du plat
        F1.modifiePrix(nuggets,15);
        //ALORS le prix du plat dans le menu du restaurant est celui défini par la franchise
        assertEquals(15, nuggets.getPrix());
    }
    @Test
    public void modificationPrixPlatFranchise(){
        //ÉTANT DONNE un restaurant appartenant à une franchise et définissant un menu ayant un plat
        Restaurant R1=new RestaurantBuilder().Build();
        var franchise = new Franchise();
        //ET une franchise définissant un menu ayant le même plat
        var plat = new Plat("Frite");

        //QUAND la franchise modifie le prix du plat

        //ALORS le prix du plat dans le menu du restaurant reste inchangé

    }
}