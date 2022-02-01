import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;



public class CommandeTest {
    @Test
    //scope commande
    public void listeCommande() {
        //ÉTANT DONNE un serveur dans un restaurant
        Serveur serveur=new ServeurBuilder().Build();
        Restaurant resto=new RestaurantBuilder().AvecCuisine().Build();
        resto.AjoutServeur(serveur);

        //QUAND il prend une commande de nourriture


        Commande commande = new CommandeBuilder().Build();
        serveur.prendCommande(commande);


        //ALORS cette commande apparaît dans la liste de tâches de la cuisine de ce restaurant
        assertThat(resto.getCuisine().commandes.contains(commande)).isTrue();
    }

    @Test
    public void commandeBoisson() {
        //ÉTANT DONNE un serveur dans un restaurant
        Cuisine cuisine = new CuisineBuilder().Build();
        Commande commande = new CommandeBuilder().Build();
        //QUAND il prend une commande de boissons
        commande.setNourriture(false);
        cuisine.ajoutCommande(commande);
        //ALORS cette commande n'apparaît pas dans la liste de tâches de la cuisine de ce restaurant
        assertThat(cuisine.commandes.contains(commande)).isFalse();
    }

    @Test
    public void epingleNonPayee() {
        // ÉTANT DONNE un serveur ayant pris une commande
        Commande commande = new CommandeBuilder().Build();
        //QUAND il la déclare comme non-payée
        commande.setNonPayee(true);
        //ALORS cette commande est marquée comme épinglée
        commande.setEplinglee(true);
        assertThat(commande.isNonPayee()).isEqualTo(commande.isEplinglee());
    }

    @Test
    public void epingleNonPayeeDelaiDepassee() {
        //ÉTANT DONNE un serveur ayant épinglé une commande
        Commande commande = new CommandeBuilder().Build();
        commande.setEplinglee(true);
        //QUAND elle date d'il y a au moins 15 jours
        commande.dateAttente();
        //ALORS cette commande est marquée comme à transmettre gendarmerie
        assertTrue(commande.isEplinglee());
        assertEquals(commande.getDate(), 15);
        commande = commande.commandeMarquee();
        assertThat(commande.isMarquee()).isTrue();
    }

    @Test
    public void listeCommandeGendarmerie() {

        //ÉTANT DONNE une commande à transmettre gendarmerie
        ArrayList<Commande> liste = new ArrayList<>();

        Restaurant restaurant = new RestaurantBuilder().Build();
        liste = restaurant.listeMarquee(liste);

        //QUAND on consulte la liste des commandes à transmettre du restaurant
        for (Commande value : liste) {
            //ALORS elle y figure
            assertThat(value.isMarquee()).isTrue();
        }


    }
    @Test
    public void listeCommandeGendarmerieTransmise(){
        //ÉTANT DONNE une commande à transmettre gendarmerie
            Commande commande =new CommandeBuilder().Build();
        //QUAND elle est marquée comme transmise à la gendarmerie
            commande.setTransmise(true);
        //ALORS elle ne figure plus dans la liste des commandes à transmettre du restaurant
        commande.setEplinglee(false);
        commande.setMarquee(false);
        assertThat(commande.isEplinglee()).isFalse();
        assertThat(commande.isMarquee()).isFalse();
    }
}