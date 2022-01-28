import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServeurTest {
    @Test
    public void Get_CA_Serveur() {
        //ÉTANT DONNÉ un nouveau serveur
        Serveur S1 = new ServeurBuilder().Build();
        //QUAND on récupére son chiffre d'affaires
        int CAs1 = S1.GetCA();
        //ALORS celui-ci est à 0
        assertEquals(0, CAs1);

    }
    @Test
    public void premierCAserveur(){
        //ÉTANT DONNÉ un nouveau serveur
        Serveur serveur = new ServeurBuilder().Build();
        //QUAND il prend une commande
        Commande commande = new CommandeBuilder().Build();
        commande.setMontant(12);
        serveur.prendCommande(commande);
        //ALORS son chiffre d'affaires est le montant de celle-ci
        assertEquals(commande.getMontant(),serveur.GetCA());

    }
    @Test
    public void ajoutCAserveur(){
        //ÉTANT DONNÉ un nouveau serveur
        Serveur serveur = new ServeurBuilder().Build();
        //QUAND il prend une commande
        Commande commande1 = new CommandeBuilder().Build();
        Commande commande2 = new CommandeBuilder().Build();
        commande1.setMontant(12);
        commande2.setMontant(24);
        serveur.prendCommande(commande1);
        serveur.prendCommande(commande2);
        //ALORS son chiffre d'affaires est le montant de celle-ci
        assertEquals(36,serveur.GetCA());

    }
}