import org.junit.Assert;
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
    @Test
    public void epingleNonPayee(){
        // ÉTANT DONNE un serveur ayant pris une commande
        Commande commande = new Commande();
        //QUAND il la déclare comme non-payée
        commande.commandeNonPayee();
        //ALORS cette commande est marquée comme épinglée
        commande.commandeEpinglee();
        assertEquals(commande.nonPayee,commande.eplinglee);
    }
    @Test
    public void epingleNonPayeeDelaiDepassee(){
        //ÉTANT DONNE un serveur ayant épinglé une commande
        Commande commande =new Commande();
        commande.commandeEpinglee();
        //QUAND elle date d'il y a au moins 15 jours
        commande.dateAttente();
        //ALORS cette commande est marquée comme à transmettre gendarmerie
        assertTrue(commande.eplinglee);
        assertEquals(commande.date,15);
        commande.commandeTansmiseGendarmerie();
        assertTrue(commande.transmise);
    }

}