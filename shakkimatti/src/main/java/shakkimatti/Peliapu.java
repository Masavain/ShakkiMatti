package shakkimatti;

import java.util.*;

public class Peliapu {

    public Pelilauta pelilauta;
    public ArrayList<String> kirjaimet = new ArrayList<String>(Arrays.asList(new String[]{"a", "b", "c", "d", "e", "f", "g", "h"}));
    public Scanner lukija;

    public Peliapu() {
        this.pelilauta = new Pelilauta();
        this.lukija = new Scanner(System.in);
    }

    public void kaynnista() {
        pelilauta.tulosta();

        while (true) {
            // valkoisen siirto
            System.out.println("valkoinen, anna lähtökoordinaatti:");
            String lahto = lukija.nextLine();
            int xMista = kirjaimet.indexOf(lahto.substring(0, 1));
            int yMista = Integer.parseInt(lahto.substring(1, 2)) - 1;

            if (validiSiirrettava(0, xMista, yMista)) {
                Nappula siirrettava = pelilauta.lauta[xMista][yMista];
                List<String> mahdSiirrot = siirrettava.mahdollisetSiirrot();
                System.out.println(mahdSiirrot);

                while (true) {
                    System.out.println("valkoinen, anna päätekoordinaatti:");
                    String paate = lukija.nextLine();

                    int xMihin = kirjaimet.indexOf(paate.substring(0, 1));
                    int yMihin = Integer.parseInt(paate.substring(1, 2)) - 1;

                    if (vuoro(0, siirrettava, xMihin, yMihin)) {
                        break;
                    }
                }
            }
            pelilauta.tulosta();

            // mustan siirto
            System.out.println(" musta, anna lähtökoordinaatti:");
            lahto = lukija.nextLine();
            xMista = kirjaimet.indexOf(lahto.substring(0, 1));
            yMista = Integer.parseInt(lahto.substring(1, 2)) - 1;

            if (validiSiirrettava(1, xMista, yMista)) {
                Nappula siirrettava = pelilauta.lauta[xMista][yMista];
                List<String> mahdSiirrot = siirrettava.mahdollisetSiirrot();
                System.out.println(mahdSiirrot);

                while (true) {
                    System.out.println("musta, anna päätekoordinaatti:");
                    String paate = lukija.nextLine();
                    int xMihin = kirjaimet.indexOf(paate.substring(0, 1));
                    int yMihin = Integer.parseInt(paate.substring(1, 2)) - 1;
                    if (vuoro(1, siirrettava, xMihin, yMihin)) {
                        break;
                    }
                }
            }
            pelilauta.tulosta();
        }
    }

    public boolean validiSiirrettava(int pelaaja, int xMista, int yMista) {
        if (pelilauta.lauta[xMista][yMista] != null
                && pelilauta.lauta[xMista][yMista].getColor() == pelaaja) {
            return true;
        } else {
            return false;
        }
    }

    public boolean vuoro(int pelaaja, Nappula siirrettava, int xMihin, int yMihin) {
        int xMista = siirrettava.x;
        int yMista = siirrettava.y;
        List<String> mahdSiirrot = siirrettava.mahdollisetSiirrot();

        if (mahdSiirrot.contains(xMihin + "," + yMihin)) {
            pelilauta.lauta[xMista][yMista] = null;
            pelilauta.lauta[xMihin][yMihin] = siirrettava;
            siirrettava.liiku(xMihin, yMihin);
            return true;
        }
        return false;
    }

}
