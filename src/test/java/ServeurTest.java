import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;


public class  ServeurTest {
    @Test
    public void Get_CA_Serveur() {
        //ÉTANT DONNÉ un nouveau serveur
        Serveur S1 = new ServeurBuilder().Build();
        //QUAND on récupére son chiffre d'affaires
        int CAs1 = S1.GetCA();
        //ALORS celui-ci est à 0
        assertThat(0).isEqualTo(CAs1);
    }
    @Test
    public void ajoutCAserveur(){
        //ÉTANT DONNÉ un nouveau serveur
        Serveur serveur = new ServeurBuilder().Build();
        //QUAND il prend une commande
        Commande commande=new CommandeBuilder().Build();
        commande.setMontant(12);
        serveur.prendCommande(commande);
        //ALORS son chiffre d'affaires est le montant de celle-ci
        assertThat(commande.getMontant()).isEqualTo(serveur.GetCA());
    }
    @Test
    public void ajoutPlusieursCAserveur(){
        //ÉTANT DONNÉ un nouveau serveur
        Serveur serveur = new ServeurBuilder().Build();
        //QUAND il prend une nouvelle commande
        Commande commande1=new CommandeBuilder().avecMontant(12).Build();
        Commande commande2=new CommandeBuilder().avecMontant(24).Build();
        serveur.prendCommande(commande1);
        serveur.prendCommande(commande2);
        //ALORS son chiffre d'affaires est la somme des deux commandes
        assertThat(36).isEqualTo(serveur.GetCA());

    }
    //Tests unitaires
    @Test
    public void testServeur() {
        Commande commande1 = new CommandeBuilder().Build();
        Serveur serveur1 = new ServeurBuilder().Build();
        serveur1.prendCommande(commande1);
        ArrayList<Commande> commandes=serveur1.getCommande();
        assertThat(commande1).isEqualTo(commandes.get(0));
        assertThat(commande1.getMontant()).isEqualTo(serveur1.GetCA());
    }

    @Test
    public void testRecetteAjoutCaServeur(){
        //ETANT DONNE 2 serveurs dans un restaurant
        Serveur serveur1= new ServeurBuilder().Build();
        Serveur serveur2 = new ServeurBuilder().Build();
        //Au debut, leur deux Ca sont égaux a 0
        assertThat(0).isEqualTo(serveur1.GetCA());
        assertThat(0).isEqualTo(serveur2.GetCA());
        //Quand le 1er serveur prend une commande, son ca augmente d'autant
        Commande commande1Serveur1 = new CommandeBuilder().avecMontant(10).Build();
        serveur1.prendCommande(commande1Serveur1);
        assertThat(10).isEqualTo(serveur1.GetCA());
        //Le 2nd serveur va aussi prendre une autre commande, alors son ca augmente aussi
        Commande commande1Serveur2 = new CommandeBuilder().avecMontant(20).Build();
        serveur2.prendCommande(commande1Serveur2);
        assertThat(20).isEqualTo(serveur2.GetCA());
        //Quand le 1er serveur prend une seconde commande alors le ca augmente, mais pas celui du second
        Commande commande2Serveur1 = new CommandeBuilder().avecMontant(15).Build();
        serveur1.prendCommande(commande2Serveur1);
        assertThat(25).isEqualTo(serveur1.GetCA());
        assertThat(20).isEqualTo(serveur2.GetCA());
        //Quand le 2eme serveur prend une seconde commande , son ca augmente sans toucher le ca du 1er serveur
        Commande commande2Serveur2 = new CommandeBuilder().avecMontant(5).Build();
        serveur2.prendCommande(commande2Serveur2);
        assertThat(25).isEqualTo(serveur1.GetCA());
        assertThat(25).isEqualTo(serveur2.GetCA());
        //Quand le 1er serveur prend plusieurs commandes, le 2nd n'as aucun changement
        int montantCommande=10;
        ArrayList<Commande> listCommande=new CommandeGenerator().avecMontant(montantCommande).Generate(90);
        for (int i=0;i<50;i++){
            serveur1.prendCommande(listCommande.get(i));
        }
        assertThat(525).isEqualTo(serveur1.GetCA());
        assertThat(25).isEqualTo(serveur2.GetCA());
        //Quand le 2nd prend plusieurs commande, le 2nd n'as aucun changement
        for (int i=50;i<90;i++){
            serveur2.prendCommande(listCommande.get(i));
        }
        assertThat(525).isEqualTo(serveur1.GetCA());
        assertThat(425).isEqualTo(serveur2.GetCA());
    }
}