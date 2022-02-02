import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class  TableTest {
    //scope
    @Test
    public void tableOrigine(){
        //  ÉTANT DONNE une table dans un restaurant ayant débuté son service
        Table table=new TableBuilder().Build();
        Client client=new ClientBuilder().Build();
        Restaurant restaurant=new RestaurantBuilder().AyantDebuteLeService().Build();

        //  ALORS cette table est sur la liste des tables libres du restaurant
        assertThat(restaurant.getTablesOccupes()).doesNotContain(table);
    }
    @Test
    public void tableOccupe(){
        //  ÉTANT DONNE une table dans un restaurant ayant débuté son service
        Table table=new TableBuilder().Build();
        Client client=new ClientBuilder().Build();
        Restaurant restaurant=new RestaurantBuilder().AyantDebuteLeService().Build();
        //  QUAND un client est affecté à une table

        //  ALORS cette table n'est plus sur la liste des tables libres du restaurant
        restaurant.tableRemplie(table, client);
        assertThat(restaurant.getTablesOccupes()).contains(table);
    }
    @Test
    public void tableLibre(){
        //ÉTANT DONNE une table occupée par un client
        Table table=new TableBuilder().Build();
        Client client=new ClientBuilder().Build();
        Restaurant restaurant=new RestaurantBuilder().AyantDebuteLeService().Build();
        restaurant.tableRemplie(table, client);
        //QUAND la table est libérée
        //ALORS cette table apparaît sur la liste des tables libres du restaurant
        restaurant.tableVider(table);
        assertThat(restaurant.getTablesOccupes()).doesNotContain(table);
    }
}