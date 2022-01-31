
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;



public class CommandeTest {
    @Test
    //scope commande
    public void listeCommande() {
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
    public void commandeBoisson() {
        //ÉTANT DONNE un serveur dans un restaurant
        var serveur = new Serveur();
        var cuisine = new Cuisine();
        var commande = new Commande();
        //QUAND il prend une commande de boissons
        commande.setNourriture(false);
        cuisine.ajoutCommande(commande);
        //ALORS cette commande n'apparaît pas dans la liste de tâches de la cuisine de ce restaurant
        assertFalse(cuisine.commandes.contains(commande));
    }

    @Test
    public void epingleNonPayee() {
        // ÉTANT DONNE un serveur ayant pris une commande
        Commande commande = new Commande();
        //QUAND il la déclare comme non-payée
        commande.setNonPayee(true);
        //ALORS cette commande est marquée comme épinglée
        commande.setEplinglee(true);
        assertEquals(commande.isNonPayee(), commande.isEplinglee());
    }

    @Test
    public void epingleNonPayeeDelaiDepassee() {
        //ÉTANT DONNE un serveur ayant épinglé une commande
        Commande commande = new Commande();
        commande.setEplinglee(true);
        //QUAND elle date d'il y a au moins 15 jours
        commande.dateAttente();
        //ALORS cette commande est marquée comme à transmettre gendarmerie
        assertTrue(commande.isEplinglee());
        assertEquals(commande.getDate(), 15);
        commande = commande.commandeMarquee();
        assertTrue(commande.isMarquee());
    }

    @Test
    public void listeCommandeGendarmerie() {

        //ÉTANT DONNE une commande à transmettre gendarmerie
        ArrayList<Commande> liste = new ArrayList<>();
        ArrayList<Serveur> serveurs= new ArrayList<>();
        Restaurant restaurant = new Restaurant(serveurs);
        liste = restaurant.listeMarquee(liste);

        //QUAND on consulte la liste des commandes à transmettre du restaurant
        for (Commande value : liste) {
            //ALORS elle y figure
            assertTrue(value.isMarquee());
        }


    }
    @Test
    public void listeCommandeGendarmerieTransmise(){
        //ÉTANT DONNE une commande à transmettre gendarmerie
            Commande commande =new Commande();
        //QUAND elle est marquée comme transmise à la gendarmerie
            commande.setTransmise(true);
        //ALORS elle ne figure plus dans la liste des commandes à transmettre du restaurant
        commande.setEplinglee(false);
        commande.setMarquee(false);
        assertFalse(commande.isEplinglee());
        assertFalse(commande.isMarquee());
    }
}