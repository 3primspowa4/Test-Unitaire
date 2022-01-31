
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class  ServeurTest {
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
    public void ajoutCAserveur(){
        //ÉTANT DONNÉ un nouveau serveur
        Serveur serveur = new ServeurBuilder().Build();
        //QUAND il prend une commande
        Commande commande=new CommandeBuilder().Build();
        commande.setMontant(12);
        serveur.prendCommande(commande);
        //ALORS son chiffre d'affaires est le montant de celle-ci
        assertEquals(commande.getMontant(),serveur.GetCA());

    }
    @Test
    public void ajoutPlusieursCAserveur(){
        //ÉTANT DONNÉ un nouveau serveur
        Serveur serveur = new ServeurBuilder().Build();
        //QUAND il prend une nouvelle commande
        Commande commande1=new CommandeBuilder().avecMontant(12).Build();
        Commande commande2=new CommandeBuilder().avecMontant(24).Build();

        serveur.prendCommande(commande1);
        serveur.prendCommande(commande2);
        //ALORS son chiffre d'affaires est la somme des deux commandes

        assertEquals(36,serveur.GetCA());

    }
}