import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServeurTest {
    @Test
    public void Get_CA_Serveur() {
        //ÉTANT DONNÉ un nouveau serveur
        Serveur S1 = new Serveur();
        //QUAND on récupére son chiffre d'affaires
        int CAs1 = S1.GetCA();
        //ALORS celui-ci est à 0
        assertEquals(0, CAs1);

    }
    @Test
    public void ajoutCAserveur(){
        //ÉTANT DONNÉ un nouveau serveur
        var serveur = new Serveur();
        //QUAND il prend une commande
        var commande=new Commande();
        commande.montant=12;
        serveur.CA= commande.montant;
        //ALORS son chiffre d'affaires est le montant de celle-ci
        assertEquals(commande.montant,serveur.GetCA());

    }
}