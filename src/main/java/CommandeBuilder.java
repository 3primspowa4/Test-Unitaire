public class CommandeBuilder {
    private int montant=0;
    public Commande Build(){
        return new Commande(montant);
    }
    public CommandeBuilder avecMontant(int n){
        montant=n;
        return this;
    }
}
