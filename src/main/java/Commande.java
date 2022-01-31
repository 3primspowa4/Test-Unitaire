public class Commande {
    private int montant;
    private boolean nourriture=true;
    private int date;
    private boolean nonPayee=false;
    private boolean eplinglee=false;
    private boolean marquee=false;
    private boolean transmise=false;

    public boolean isNourriture() {
        return nourriture;
    }

    public int getDate() {
        return date;
    }

    public boolean isNonPayee() {
        return nonPayee;
    }

    public boolean isEplinglee() {
        return eplinglee;
    }

    public boolean isMarquee() {
        return marquee;
    }

    public boolean isTransmise() {
        return transmise;
    }

    public void setNourriture(boolean nourriture) {
        this.nourriture = nourriture;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setNonPayee(boolean nonPayee) {
        this.nonPayee = nonPayee;
    }

    public void setEplinglee(boolean eplinglee) {
        this.eplinglee = eplinglee;
    }

    public void setMarquee(boolean marquee) {
        this.marquee = marquee;
    }

    public void setTransmise(boolean transmise) {
        this.transmise = transmise;
    }

    public Commande commandeMarquee(){
        this.marquee= true;
        return this;
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
