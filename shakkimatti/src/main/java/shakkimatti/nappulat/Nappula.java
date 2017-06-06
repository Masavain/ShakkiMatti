package shakkimatti.nappulat;
import shakkimatti.logiikka.Pelaaja;


import java.util.*;

public abstract class Nappula {

    public int x, y;
    private Pelaaja pelaaja;
    public String merkki;

    public Nappula(int x, int y, Pelaaja pelaaja) {
        this.x = x;
        this.y = y;
        this.pelaaja = pelaaja;
    }

    public void liiku(int xMihin, int yMihin, Nappula[][] lauta) {
        List<String> mahdSiirrot = this.mahdollisetSiirrot(lauta);
        List<String> mahdSyonnit = this.mahdollisetSyonnit(lauta);
        if (mahdSiirrot.contains(xMihin + "," + yMihin) || mahdSyonnit.contains(xMihin + "," + yMihin)) {
            setX(xMihin);
            setY(yMihin);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    public void setMerkki(String merkki) {
        this.merkki = merkki;
    }

    public String getMerkki() {
        return merkki;
    }

    

    @Override
    public String toString() {
        return merkki;
    }

    public abstract List<String> mahdollisetSiirrot(Nappula[][] tilanne);

    public abstract List<String> mahdollisetSyonnit(Nappula[][] tilanne);

}
