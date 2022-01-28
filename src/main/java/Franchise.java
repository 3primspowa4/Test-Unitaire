public class Franchise {

    public void definirMenu(String nomMenu1,Plat plat) {
        Menu nomMenu=new Menu(nomMenu1,plat);


    }

    public void modifiePrix(Plat plat, int i) {
        plat.setPrix(i);
    }
}
