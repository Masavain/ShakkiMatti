package shakkimatti.logiikka;

import shakkimatti.nappulat.*;
import shakkimatti.logiikka.Pelaaja;

public class Pelilauta {

    private Nappula[][] lauta;

    public Pelilauta() {
        this.lauta = new Nappula[8][8];
    }

    public void alustus() {
        for (int i = 0; i < 8; i++) {
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

    public String toString() {
        String palautus = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
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

    public boolean siirto(int xMista, int yMista, int xMihin, int yMihin) {
        Nappula n = this.lauta[xMista][yMista];
        if (n.mahdollisetSiirrot(lauta).contains(xMihin + "," + yMihin) || n.mahdollisetSyonnit(lauta).contains(xMihin + "," + yMihin)) {
            n.liiku(xMihin, yMihin, getLauta());
            System.out.println("liikutettu");
            this.lauta[xMista][yMista] = null;
            this.lauta[xMihin][yMihin] = n;
            return true;
        }
        return false;
    }

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

    public void asetaNappula(Nappula n, int x, int y) {
        this.lauta[x][y] = n;
    }

}
