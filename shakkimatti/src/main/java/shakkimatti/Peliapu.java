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
        pelilauta.alustus();
        pelilauta.tulosta();
        int vuoro = 0;
        while (true) {
            // valkoisen siirto
            
            if (vuoro%2 == 0) System.out.println("valkoinen, anna lähtökoordinaatti:");
            else if (vuoro%2 == 1) System.out.println("musta, anna lähtökoordinaatti:");
            String lahto = lukija.nextLine();
            int xMista = kirjaimet.indexOf(lahto.substring(0, 1));
            int yMista = Integer.parseInt(lahto.substring(1, 2)) - 1;

            if (validiSiirrettava(vuoro%2, xMista, yMista)) {
                vuoro(vuoro%2, xMista, yMista);
            }
            pelilauta.tulosta();

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
        Nappula siirrettava = pelilauta.lauta[xMista][yMista];
        List<String> mahdSiirrot = siirrettava.mahdollisetSiirrot();
//                System.out.println(mahdSiirrot);

        while (true) {
            System.out.println("anna päätekoordinaatti:");
            String paate = lukija.nextLine();
            int xMihin = kirjaimet.indexOf(paate.substring(0, 1));
            int yMihin = Integer.parseInt(paate.substring(1, 2)) - 1;
            if (mahdSiirrot.contains(xMihin + "," + yMihin)) {
                pelilauta.siirto(siirrettava, xMihin, yMihin);
                break;
            }
        }
    }

}
