import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeTest {
    @Test
    //scope commande
    public void listeCommande(){
        //ÉTANT DONNE un serveur dans un restaurant
        Serveur serveur = new ServeurBuilder().Build();
        Cuisine cuisine = new CuisineBuilder().Build();

        //QUAND il prend une commande de nourriture
        Commande commande = new CommandeBuilder().Build();
        cuisine.ajoutCommande(commande);
        //ALORS cette commande apparaît dans la liste de tâches de la cuisine de ce restaurant
        assertTrue(cuisine.commandes.contains(commande));
    }
    @Test
    public void commandeBoisson(){
        //ÉTANT DONNE un serveur dans un restaurant
        Serveur serveur = new ServeurBuilder().Build();
        Cuisine cuisine = new CuisineBuilder().Build();
        Commande commande = new CommandeBuilder().Build();
        //QUAND il prend une commande de boissons
        commande.nourriture=false;
        serveur.prendCommande(commande);
        cuisine.ajoutCommande(commande);
        //ALORS cette commande n'apparaît pas dans la liste de tâches de la cuisine de ce restaurant
        assertFalse(cuisine.commandes.contains(commande));
    }
}