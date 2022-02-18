import java.util.ArrayList;

public class CommandeGenerator {
    private CommandeBuilder Commande = new CommandeBuilder();


    public ArrayList<Commande> Generate(int nb){
        ArrayList<Commande> listCommande= new ArrayList<>();
        for (int cpt=0;cpt<nb;cpt++){
            listCommande.add(Commande.Build());
        }
        return listCommande;
    }
    public CommandeGenerator avecMontant(int montant)
    {
        Commande = Commande.avecMontant(montant);
        return this;
    }


}
