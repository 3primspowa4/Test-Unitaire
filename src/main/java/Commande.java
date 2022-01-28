public class Commande {
    public int montant;
    public boolean nourriture=true;
    public int date;
    public boolean nonPayee=false;
    public boolean eplinglee=false;
    public boolean transmise=false;

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

}
