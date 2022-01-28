import org.junit.Test;
import static org.junit.Assert.*;

public class MenuTest {
    @Test
    public void modificationPrixPlat(){
        // ÉTANT DONNE un restaurant ayant le statut de filiale d'une franchise
        //ET une franchise définissant un menu ayant un plat
        Restaurant R1=new Restaurant();
        Franchise F1=new Franchise();
        Plat nuggets=new Plat("nuggets");
        R1.setStatut("Filiale");
        F1.definirMenu("enfant",nuggets);


        //QUAND la franchise modifie le prix du plat
        F1.modifiePrix(nuggets,15);
        //ALORS le prix du plat dans le menu du restaurant est celui défini par la franchise
        //R1.getMenu().getPlat().getPrix();
    }
}
