package shakkimatti;

import java.util.List;

public class Peliapu {

    public Pelilauta pelilauta;

    public Peliapu(Pelilauta lauta) {
        this.pelilauta = lauta;
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
