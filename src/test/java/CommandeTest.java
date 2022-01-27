import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeTest {
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
        assertTrue(cuisine.commandes.contains(commande));
    }
    @Test
    public void commandeBoisson(){
        //ÉTANT DONNE un serveur dans un restaurant
        var serveur = new Serveur();
        var cuisine= new  Cuisine();
        var commande= new Commande();
        //QUAND il prend une commande de boissons
        commande.nourriture=false;
        cuisine.ajoutCommande(commande);
        //ALORS cette commande n'apparaît pas dans la liste de tâches de la cuisine de ce restaurant
        assertFalse(cuisine.commandes.contains(commande));
    }
}