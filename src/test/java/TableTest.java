import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {
    //scope installation
    @Test
    public void tableOccupe(){
        //  ÉTANT DONNE une table dans un restaurant ayant débuté son service
        Table table=new TableBuilder().Build();
        Client client=new ClientBuilder().Build();
        //  QUAND un client est affecté à une table
        table.clientArrive(client);
        //  ALORS cette table n'est plus sur la liste des tables libres du restaurant
        assertEquals(true, table.occupe);
    }
    @Test
    public void tableLibre(){
        //ÉTANT DONNE une table occupée par un client
        Table table=new TableBuilder().Build();
        Client client=new ClientBuilder().Build();
        table.clientArrive(client);
        //QUAND la table est libérée
        table.clientPart();
        //ALORS cette table apparaît sur la liste des tables libres du restaurant
        assertEquals(false, table.occupe);

    }
}