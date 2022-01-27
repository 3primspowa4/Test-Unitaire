import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServeurTest {
    @Test
    public void Get_CA_Serveur() {
        //ÉTANT DONNÉ un nouveau serveur
        Serveur S1 = new Serveur();
        //QUAND on récupére son chiffre d'affaires
        int CAs1 = S1.GetCA();
        //ALORS celui-ci est à 0
        assertEquals(0, CAs1);

    }
    //scope installation
    @Test
    public void tableOccupe(){
        //  ÉTANT DONNE une table dans un restaurant ayant débuté son service
        var table= new Table();
        var client= new Client();
        //  QUAND un client est affecté à une table
        table.clientArrive(client);
        //  ALORS cette table n'est plus sur la liste des tables libres du restaurant
        assertEquals(true, table.occupe);
    }
    @Test
    public void tableLibre(){
        //ÉTANT DONNE une table occupée par un client
        var table= new Table();
        var client= new Client();
        table.clientArrive(client);
        //QUAND la table est libérée
        table.clientPart();
        //ALORS cette table apparaît sur la liste des tables libres du restaurant
        assertEquals(false, table.occupe);

    }
}