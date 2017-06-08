package shakkimatti.nappulat;

import shakkimatti.logiikka.Pelaaja;

import java.util.*;

/**
 * Abstrakti luokka jota eri nappulatyypit täydentävät
 *
 */
public abstract class Nappula {

    private int x, y;
    private Pelaaja pelaaja;
    private String merkki;

    public Nappula(int x, int y, Pelaaja pelaaja) {
        this.x = x;
        this.y = y;
        this.pelaaja = pelaaja;
    }

    /**
     * Metodi muuttaa nappulan x- ja y-koordinaatteja, jos haluttu koordinaatti
     * on nappulan mahdollinen siirto tai syönti
     *
     * @param xMihin x-koordinaatti johon nappulaa yritetään siirtää
     * @param yMihin y-koordinaatti johon nappulaa yritetään siirtää
     * @param lauta tämänhetkinen pelilaudan pelitilanne
     */
    public void liiku(int xMihin, int yMihin, Nappula[][] lauta) {
        List<String> mahdSiirrot = this.mahdollisetSiirrot(lauta);
        if (mahdSiirrot.contains(xMihin + "," + yMihin)) {
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

    /**
     *
     * @param tilanne tämänhetkinen pelilaudan pelitilanne
     * @return palauttaa listan mahdollisten siirtojen ja syötävien nappuloiden
     * koordinaateista
     */
    public abstract List<String> mahdollisetSiirrot(Nappula[][] tilanne);

    /**
     * 
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param tilanne pelilaudan tämänhetkinen pelitilanne
     * @return palauttaa true jos parametrina saadussa koordinaatissa on 
     * vastapuolen nappula, muuten false
     */
    public boolean checkSyotava(int x, int y, Nappula[][] tilanne) {
        if (tilanne[x][y] != null && tilanne[x][y].getPelaaja() != getPelaaja()) {
            return true;
        }
        return false;
    }
}
