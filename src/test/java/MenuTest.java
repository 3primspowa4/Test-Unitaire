import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class MenuTest {
    @Test
    public void modificationPrixPlat(){
        // ÉTANT DONNE un restaurant ayant le statut de filiale d'une franchise
        //ET une franchise définissant un menu ayant un plat
        Restaurant R1=new RestaurantBuilder().Build();
        Franchise F1=new FranchiseBuilder().Build();
        Plat nuggets=new PlatBuilder().Build();
        Menu menu = new MenuBuilder().Build();
        R1.setStatut("Filiale");
        //F1.definirMenu("enfant",nuggets);
        //QUAND la franchise modifie le prix du plat
        F1.modifiePrix(nuggets,15);
        menu.ajoutPlat(nuggets);
        //ALORS le prix du plat dans le menu du restaurant est celui défini par la franchise
        assertThat(15).isEqualTo(menu.voirPrix(0));
    }
    @Test
    public void modificationPrixPlatFranchise(){
        //ÉTANT DONNE un restaurant appartenant à une franchise et définissant un menu ayant un plat
        Restaurant restaurant=new RestaurantBuilder().Build();
        Franchise franchise = new FranchiseBuilder().Build();
        Menu menu = new MenuBuilder().Build();
        //ET une meme franchise définissant un menu ayant le même plat
        Plat plat = new PlatBuilder().avecParametres("Frite", 15,false).Build();;
        menu.ajoutPlat(plat);
        //QUAND la franchise modifie le prix du plat
        franchise.modifiePrix(plat, 12);
        //ALORS le prix du plat dans le menu du restaurant reste inchangé
        assertThat(12).isNotEqualTo(menu.voirPrix(0));
    }
    @Test
    public void platADeuxPrix(){
        //ÉTANT DONNE un restaurant appartenant à une franchise et définissant un menu ayant un plat
        Restaurant restaurant = new RestaurantBuilder().Build();
        Franchise franchise = new FranchiseBuilder().Build();
        Plat plat1 =new PlatBuilder().avecParametres("Steak", 20,true).Build();
        Plat plat2=new PlatBuilder().avecParametres("Spaghetti",12,false).Build();
        Menu menu = new MenuBuilder().Build();
        //QUAND la franchise ajoute un nouveau plat
        menu.ajoutPlat(plat1);
        menu.ajoutPlat(plat2);
        //ALORS la carte du restaurant propose le premier plat au prix du restaurant et le second au prix de la franchise
        assertThat(20).isEqualTo(menu.voirPrix(0));
        assertThat(12).isEqualTo(menu.voirPrix(1));
    }
}