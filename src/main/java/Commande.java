public class Commande {
    private int montant;
    public boolean nourriture=true;
    public int date;
    public boolean nonPayee=false;
    public boolean eplinglee=false;
    public boolean marquee=false;
    public boolean transmise=false;

    public Commande commandeMarquee(){
        this.marquee= true;
        return this;
    }
    public void commandeNonPayee(){
        this.nonPayee = true;
    }
    public void commandeEpinglee(){
        this.eplinglee = true;
    }
    public void commandeTansmiseGendarmerie(){
        this.transmise = true;
    }
    public void dateAttente(){
        this.date = 15;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
