import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class TableTest {
    //scope installation
    @Test
    public void tableOccupe(){
        //  ÉTANT DONNE une table dans un restaurant ayant débuté son service
        Table table=new TableBuilder().Build();
        Client client=new ClientBuilder().Build();
        var restaurant=new RestaurantBuilder().Build();
        //  QUAND un client est affecté à une table
        table.clientArrive(client);
        restaurant.tableOccupe(table);
        //  ALORS cette table n'est plus sur la liste des tables libres du restaurant
        assertThat(restaurant.getTablesOccupes()).contains(table);
    }
    @Test
    public void tableLibre(){
        //ÉTANT DONNE une table occupée par un client
        Table table=new TableBuilder().Build();
        Client client=new ClientBuilder().Build();
        var restaurant=new RestaurantBuilder().Build();
        table.clientArrive(client);
        //QUAND la table est libérée
        table.clientPart();
        restaurant.tableLibre(table);
        //ALORS cette table apparaît sur la liste des tables libres du restaurant
        assertThat(restaurant.getTablesOccupes()).doesNotContain(table);
    }
}