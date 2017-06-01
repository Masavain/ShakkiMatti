package shakkimatti.logiikka;

import shakkimatti.nappulat.Nappula;
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
        pelilauta.alustus();

        System.out.println(pelilauta.toString());

        int vuoro = 0;
        while (true) {
            // valkoisen siirto

            if (vuoro % 2 == 0) {
                System.out.println("valkoinen, anna lähtökoordinaatti:");
            } else if (vuoro % 2 == 1) {
                System.out.println("musta, anna lähtökoordinaatti:");
            }
            String lahto = lukija.nextLine();
            String[] koord = lahto.split("");

            int xMista = kirjaimet.indexOf(koord[0]);
            int yMista = Integer.parseInt(koord[1]) - 1;

            if (validiSiirrettava(vuoro % 2, xMista, yMista)) {
                vuoro(vuoro % 2, xMista, yMista);
            }
            System.out.println(pelilauta.toString());

            vuoro++;
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

    public void vuoro(int pelaaja, int xMista, int yMista) {
        Nappula siirrettava = pelilauta.getLauta()[xMista][yMista];
        System.out.println(siirrettava.getX() + "  " + siirrettava.getY());
        List<String> mahdSiirrot = siirrettava.mahdollisetSiirrot(pelilauta.getLauta());
        System.out.println(mahdSiirrot);
        List<String> mahdSyotavat = siirrettava.mahdollisetSyonnit(pelilauta.getLauta());
        System.out.println(mahdSyotavat);

        while (true) {
            System.out.println("anna päätekoordinaatti:");
            String paate = lukija.nextLine();
            String[] koord = paate.split("");
            int xMihin = kirjaimet.indexOf(koord[0]);
            int yMihin = Integer.parseInt(koord[1]) - 1;
            if (mahdSiirrot.contains(xMihin + "," + yMihin) || mahdSyotavat.contains(xMihin + "," + yMihin)) {
                pelilauta.siirto(xMista, yMista, xMihin, yMihin);
                break;
            }
        }
    }
}
