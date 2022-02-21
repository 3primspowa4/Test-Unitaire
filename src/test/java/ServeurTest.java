import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    public void testPerformanceAjoutCAserveur(){
        long startTime = System.currentTimeMillis();
        // oui
        ajoutCAserveur();
        long finishTime = System.currentTimeMillis();
        System.out.println("That took: " + (finishTime - startTime) + " ms");
    }
    //scope installation
    @Test
    public void tableOccupe(){
        //  ÉTANT DONNE une table dans un restaurant ayant débuté son service
        Table table= new TableBuilder().Build();
        Client client= new ClientBuilder().Build();
        //  QUAND un client est affecté à une table
        table.clientArrive(client);
        //  ALORS cette table n'est plus sur la liste des tables libres du restaurant
        assertEquals(true, table.occupe);
    }
    @Test
    public void tableLibre(){
        //ÉTANT DONNE une table occupée par un client
       Table table= new TableBuilder().Build();
        Client client= new ClientBuilder().Build();
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

        Cuisine cuisine = new CuisineBuilder().Build();

        //QUAND il prend une commande de nourriture
        Commande commande = new CommandeBuilder().Build();
        cuisine.ajoutCommande(commande);
        //ALORS cette commande apparaît dans la liste de tâches de la cuisine de ce restaurant
        assertEquals(true, cuisine.commandes.contains(commande));
    }
    @Test
    public void commandeBoisson(){
        //ÉTANT DONNE un serveur dans un restaurant

        //QUAND il prend une commande de boissons

        //ALORS cette commande n'apparaît pas dans la liste de tâches de la cuisine de ce restaurant
    }
}