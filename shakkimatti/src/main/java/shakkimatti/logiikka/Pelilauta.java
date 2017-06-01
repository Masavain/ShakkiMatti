package shakkimatti.logiikka;

import shakkimatti.nappulat.Sotilas;
import shakkimatti.nappulat.Nappula;
import shakkimatti.nappulat.Lahetti;
import shakkimatti.nappulat.Kuningas;
import shakkimatti.nappulat.Torni;
import shakkimatti.nappulat.Ratsu;
import shakkimatti.nappulat.Kuningatar;
import java.util.*;

public class Pelilauta {

    public Nappula[][] lauta;

    public Pelilauta() {
        this.lauta = new Nappula[8][8];
    }

    public void alustus() {
        for (int i = 0; i < 8; i++) {
            this.lauta[i][6] = new Sotilas(i, 6, 1, false);
            this.lauta[i][1] = new Sotilas(i, 1, 0, false);
        }

        this.lauta[4][7] = new Kuningas(4, 7, 1);
        this.lauta[3][7] = new Kuningatar(3, 7, 1);
        this.lauta[4][0] = new Kuningas(4, 0, 0);
        this.lauta[3][0] = new Kuningatar(3, 0, 0);

        this.lauta[0][0] = new Torni(0, 0, 0);
        this.lauta[7][0] = new Torni(7, 0, 0);
        this.lauta[0][7] = new Torni(0, 7, 1);
        this.lauta[7][7] = new Torni(7, 7, 1);

        this.lauta[1][7] = new Ratsu(1, 7, 1);
        this.lauta[6][7] = new Ratsu(6, 7, 1);
        this.lauta[1][0] = new Ratsu(1, 0, 0);
        this.lauta[6][0] = new Ratsu(6, 0, 0);

        this.lauta[2][7] = new Lahetti(2, 7, 1);
        this.lauta[5][7] = new Lahetti(5, 7, 1);
        this.lauta[2][0] = new Lahetti(2, 0, 0);
        this.lauta[5][0] = new Lahetti(5, 0, 0);

    }

    public String toString() {
        String palautus = "";
        for (int i = 7; i >= 0; i--) {
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

    public void siirto(int xMista, int yMista, int xMihin, int yMihin) {
        Nappula n = this.lauta[xMista][yMista];
        n.liiku(xMihin, yMihin, getLauta());
        this.lauta[xMista][yMista] = null;
        this.lauta[xMihin][yMihin] = n;

    }

    public Nappula[][] getLauta() {
        return lauta;
    }

    public void asetaNappula(Nappula n, int x, int y) {
        this.lauta[x][y] = n;
    }

}
