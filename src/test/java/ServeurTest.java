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
        commande.montant=12
        //ALORS son chiffre d'affaires est le montant de celle-ci
        assertEquals(commande.montant,serveur.GetCA());

    }
    //scope installation
    @Test
    public void tableOccupe(){
        //  ÉTANT DONNE une table dans un restaurant ayant débuté son service
        var table= new Table();
        var client= new Client();
        //  QUAND un client est affecté à une table
        table.clientArrive(client);
        //  ALORS cette table n'est plus sur la liste des tables libres du restaurant
        assertEquals(true, table.occupe);
    }
    @Test
    public void tableLibre(){
        //ÉTANT DONNE une table occupée par un client
        var table= new Table();
        var client= new Client();
        table.clientArrive(client);
        //QUAND la table est libérée
        table.clientPart();
        //ALORS cette table apparaît sur la liste des tables libres du restaurant
        assertEquals(false, table.occupe);

    }
    @Test
    //scope commande
    public void listeCommande(){
        //ÉTANT DONNE un serveur dans un restaurant
        var serveur = new Serveur();
        var cuisine = new Cuisine();

        //QUAND il prend une commande de nourriture
        var commande = new Commande();
        cuisine.ajoutCommande(commande);
        //ALORS cette commande apparaît dans la liste de tâches de la cuisine de ce restaurant
        assertEquals(true, cuisine.commandes.contains(commande));
    }
    @Test
    public void commandeBoisson(){
        //ÉTANT DONNE un serveur dans un restaurant
        var serveur = new Serveur();
        //QUAND il prend une commande de boissons

        //ALORS cette commande n'apparaît pas dans la liste de tâches de la cuisine de ce restaurant
    }
}