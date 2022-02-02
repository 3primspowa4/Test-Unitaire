import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DebutServiceTest {
    @Test
    public void tester1(){
        //ÉTANT DONNE un restaurant ayant 3 tables
        RestaurantBuilder restaurantBuilder = new RestaurantBuilder().avecListeTable(3);
        //QUAND le service commence
        Restaurant restaurant = restaurantBuilder.AyantDebuteLeService().Build();
        //ALORS elles sont toutes affectées au Maître d'Hôtel
        for( Table table:restaurant.getTables()){
            Assertions.assertEquals(restaurant.getMaitreHotel(), table.getResponsable());
        }
    }

    @Test
    public void tester2(){
        //ÉTANT DONNÉ un restaurant ayant 3 tables dont une affectée à un serveur
        RestaurantBuilder restaurantBuilder = new RestaurantBuilder().avecListeTable(3);
        Serveur serveur1 = new ServeurBuilder().Build();
        Table tableAffectee = restaurantBuilder.tables.get(0);
        Table tableNonAffectee1 = restaurantBuilder.tables.get(1);
        Table tableNonAffectee2 = restaurantBuilder.tables.get(2);
        restaurantBuilder.tables.get(0).affecter(serveur1);
        //QUAND le service débute
        Restaurant restaurant = restaurantBuilder.AyantDebuteLeService().Build();
        //ALORS la table precedement affectée est encore affectée au serveur
        // et les deux autres au maître d'hôtel
        Assertions.assertEquals(serveur1, tableAffectee.getResponsable());
        Assertions.assertEquals(restaurant.getMaitreHotel(), tableNonAffectee1.getResponsable());
        Assertions.assertEquals(restaurant.getMaitreHotel(), tableNonAffectee2.getResponsable());

        Assertions.assertEquals(1, restaurant.getTables().stream().filter(table->table.getResponsable() instanceof Serveur).count());
        Assertions.assertEquals(2, restaurant.getTables().stream().filter(table->table.getResponsable() instanceof MaitreHotel).count());

    }

    @Test
    public void tester3() {

        //ÉTANT DONNÉ un restaurant ayant 3 tables dont une affectée à un serveur
        RestaurantBuilder restaurantBuilder = new RestaurantBuilder().avecListeTable(3);
        Serveur serveur = new ServeurBuilder().Build();
        Table table = restaurantBuilder.tables.get(0);
        table.affecter(serveur);
        //QUAND le service débute
        Restaurant restaurant = restaurantBuilder.AyantDebuteLeService().Build();
        //ALORS il n'est pas possible de modifier le serveur affecté à la table
        Serveur serveurTraitre = new ServeurBuilder().Build();
        table.affecter(serveurTraitre);
        Assertions.assertEquals(serveur, table.getResponsable());
    }

    @Test
    public void tester4() {

        //ÉTANT DONNÉ un restaurant ayant 3 tables dont une affectée à un serveur
        RestaurantBuilder restaurantBuilder = new RestaurantBuilder().avecListeTable(3);
        Serveur serveur = new ServeurBuilder().Build();
        Table tableAffectee = restaurantBuilder.tables.get(0);
        Table tableNonAffectee1 = restaurantBuilder.tables.get(1);
        Table tableNonAffectee2 = restaurantBuilder.tables.get(2);
        tableAffectee.affecter(serveur);
        //ET ayant débuté son service
        restaurantBuilder.setAyantCommenceLeService(true);
        Restaurant restaurant = restaurantBuilder.Build();
        //QUAND le service se termine
        restaurant.terminerService();
        //ET qu'une table est affectée à un serveur
        tableAffectee.affecter(serveur);
        //ALORS la table éditée est affectée au serveur et les deux autres au maître d'hôtel
        Assertions.assertEquals(serveur, tableAffectee.getResponsable());
        Assertions.assertEquals(restaurant.getMaitreHotel(), tableNonAffectee1.getResponsable());
        Assertions.assertEquals(restaurant.getMaitreHotel(), tableNonAffectee2.getResponsable());
    }

}
