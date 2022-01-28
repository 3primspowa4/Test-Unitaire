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
        assertEquals(15, R1.recupererPrixPlat(nuggets));
    }
    @Test
    public void modificationPrixPlatFranchise(){
        //ÉTANT DONNE un restaurant appartenant à une franchise et définissant un menu ayant un plat
        Restaurant restaurant=new RestaurantBuilder().Build();
        var franchise = new Franchise();
        //ET une meme franchise définissant un menu ayant le même plat
        var plat = new Plat("Frite", 15,true);
        restaurant.ajouterPlat(plat);
        franchise.ajouterPlat(plat);

        //QUAND la franchise modifie le prix du plat
        franchise.modifiePrix(plat, 12);
        //ALORS le prix du plat dans le menu du restaurant reste inchangé
        assertNotEquals(12,restaurant.recupererPrixPlat(plat));
    }

    public void platADeuxPrix(){
        //ÉTANT DONNE un restaurant appartenant à une franchise et définissant un menu ayant un plat
        var restaurant = new RestaurantBuilder().Build();
        var franchise = new Franchise();
        var plat1 =new Plat("Steak", 20,true);
        var plat2=new Plat("Spaghetti",12,false);
        //QUAND la franchise ajoute un nouveau plat
        franchise.ajoutMenu(plat1);

        //ALORS la carte du restaurant propose le premier plat au prix du restaurant et le second au prix de la franchise

    }
}