package shakkimatti.logiikka;

import shakkimatti.nappulat.*;

/**
 * luokka kuvastaa shakkilautaa (8x8 ruudukko).
 *
 */
public class Pelilauta {

    private Nappula[][] lauta;
    private final int size = 8;

    /**
     * Konstruktori, luo uuden taulukon nappuloille.
     */
    public Pelilauta() {
        this.lauta = new Nappula[8][8];
    }

    /**
     * alustaa normaalin shakkipelin alun. Asettaa pelinappulat oikeille
     * aloituspaikoilleen.
     */
    public void alustus() {
        for (int i = 0; i < size; i++) {
            this.lauta[i][6] = new Sotilas(i, 6, Pelaaja.VALKOINEN, false);
            this.lauta[i][1] = new Sotilas(i, 1, Pelaaja.MUSTA, false);
        }
        this.lauta[4][7] = new Kuningas(4, 7, Pelaaja.VALKOINEN);
        this.lauta[3][7] = new Kuningatar(3, 7, Pelaaja.VALKOINEN);
        this.lauta[4][0] = new Kuningas(4, 0, Pelaaja.MUSTA);
        this.lauta[3][0] = new Kuningatar(3, 0, Pelaaja.MUSTA);
        this.lauta[0][0] = new Torni(0, 0, Pelaaja.MUSTA);
        this.lauta[7][0] = new Torni(7, 0, Pelaaja.MUSTA);
        this.lauta[0][7] = new Torni(0, 7, Pelaaja.VALKOINEN);
        this.lauta[7][7] = new Torni(7, 7, Pelaaja.VALKOINEN);
        this.lauta[1][7] = new Ratsu(1, 7, Pelaaja.VALKOINEN);
        this.lauta[6][7] = new Ratsu(6, 7, Pelaaja.VALKOINEN);
        this.lauta[1][0] = new Ratsu(1, 0, Pelaaja.MUSTA);
        this.lauta[6][0] = new Ratsu(6, 0, Pelaaja.MUSTA);
        this.lauta[2][7] = new Lahetti(2, 7, Pelaaja.VALKOINEN);
        this.lauta[5][7] = new Lahetti(5, 7, Pelaaja.VALKOINEN);
        this.lauta[2][0] = new Lahetti(2, 0, Pelaaja.MUSTA);
        this.lauta[5][0] = new Lahetti(5, 0, Pelaaja.MUSTA);
    }

    /**
     * Metodi toString palauttaa laudan merkkijonoesityksenä.
     * @return merkkijonoesitys laudasta
     */
    public String toString() {
        String palautus = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.lauta[j][i] != null) {
                    palautus += this.lauta[j][i];
                } else {
                    palautus += ".";
                }
            }
            palautus += "\n";
        }
        return palautus;
    }

    /**
     * siirtää pelinappulaa koordinaatista (xMista,yMista) koordinaattiin
     * (xMihin,yMihin), jos siirto on mahdollinen.
     *
     * @param xMista lähtökoordinaatin x-arvo
     * @param yMista lähtökoordinaatin y-arvo
     * @param xMihin päätekoordinaatin x-arvo
     * @param yMihin päätekoordinaatin y-arvo
     * @return palauttaa true jos siirto oli mahdollinen, false jos ei
     */
    public boolean siirto(int xMista, int yMista, int xMihin, int yMihin) {
        Nappula n = this.lauta[xMista][yMista];
        if (n.mahdollisetSiirrot(lauta).contains(xMihin + "," + yMihin)) {
            if (this.lauta[xMihin][yMihin] != null && this.lauta[xMihin][yMihin].getMerkki().equals("K")) {
                return false;
            }
            n.liiku(xMihin, yMihin, getLauta());
            this.lauta[xMista][yMista] = null;
            this.lauta[xMihin][yMihin] = n;

            return true;
        }
        return false;
    }

    /**
     * tarkistaa onko käyttäjän valitseman koordinaatin nappula siirrettävä, eli
     * onko koordinaatissa nappulaa ollenkaan ja onko nappula tämänhetkisen
     * pelaajan oma.
     *
     * @param pelaaja pelaajan väri
     * @param xMista valitun nappulan x-koordinaatti
     * @param yMista valitun nappulan y-koordinaatti
     * @return palauttaa true jos valittu nappula ei ole null ja on pelaajan
     * oma, false jos ei
     */
    public boolean validiSiirrettava(Pelaaja pelaaja, int xMista, int yMista) {
        if (this.lauta[xMista][yMista] != null
                && this.lauta[xMista][yMista].getPelaaja() == pelaaja) {
            return true;
        } else {
            return false;
        }
    }

    public Nappula[][] getLauta() {
        return lauta;
    }

    /**
     * Asettaa laudalle nappulan n koordinaattiin (x,y).
     *
     * @param n nappula
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public void asetaNappula(Nappula n, int x, int y) {
        this.lauta[x][y] = n;
    }

}
