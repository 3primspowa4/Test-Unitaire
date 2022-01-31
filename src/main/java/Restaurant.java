import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class Restaurant {
    private String Statut;
    private ArrayList<Serveur> Serveurs;

    public Restaurant(ArrayList<Serveur> serveurs) {
        Serveurs = serveurs;
    }

    public ArrayList<Serveur> getServeurs() {
        return Serveurs;
    }
    public ArrayList<Plat> lesmenus= new ArrayList<>();


    public String getStatut() {
        return Statut;
    }
    public void AddServeur(Serveur s){
        Serveurs.add(s);
    }
    public void setStatut(String statut) {
        Statut = statut;
    }
    public Menu getMenu(Menu menu){
        return menu;
    }
    /*public void definirMenu(String nomMenu1,Plat plat) {
        Menu nomMenu=new Menu(nomMenu1,plat);
    }*/
    public void ajouterPlat(Plat plat){

        lesmenus.add(plat);
    }
    public int recupererPrixPlat(Plat plat){
        int result=0;
        for (Plat p : lesmenus) {
            if (p.getNomPlat().equals(plat.getNomPlat())) {
                result= p.getPrixrestaurant();
                break;
            }
        }
        return result;
    }
}
