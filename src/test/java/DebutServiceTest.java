import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DebutServiceTest {
    @Test
    public void tester(){
        //ÉTANT DONNE un restaurant ayant 3 tables
        RestaurantBuilder restaurantBuilder = new RestaurantBuilder().avecListeTable(3);
        //QUAND le service commence
        Restaurant restaurant = restaurantBuilder.AyantDebuteLeService().Build();
        //ALORS elles sont toutes affectées au Maître d'Hôtel
        MaitreHotel maitreHotel = new MaitreHotelBuilder().Build();
        for( Table table:restaurant.getTables()){
            table.affecter(maitreHotel);
        }
        for( Table table:restaurant.getTables()){
            Assertions.assertEquals(maitreHotel, table.maitreHotel);
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
        Assertions.assertEquals(serveur1, tableAffectee.serveur);
        Assertions.assertEquals(maitreHotel, tableNonAffectee1.maitreHotel);

    }

    @Test
    public void tester3() {
        //ÉTANT DONNÉ un restaurant ayant 3 tables dont une affectée à un serveur

        //QUAND le service débute

        //ALORS il n'est pas possible de modifier le serveur affecté à la table
    }

}