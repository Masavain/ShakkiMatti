package shakkimatti;

import java.util.*;

public class Pelilauta {

    public Nappula[][] lauta;
    public boolean[][] ruudut;

    public Pelilauta() {
        this.lauta = new Nappula[8][8];
        this.ruudut = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ruudut[j][i] = false;
            }
        }
    }

    public void alustus() {
        for (int i = 0; i < 8; i++) {
            this.lauta[i][6] = new Sotilas(i, 6, 1);
            this.ruudut[i][6] = true;
            this.lauta[i][1] = new Sotilas(i, 1, 0);
            this.ruudut[i][1] = true;
        }

        this.lauta[4][7] = new Kuningas(4, 7, 1);
        this.lauta[3][7] = new Kuningatar(3, 7, 1);
        this.lauta[4][0] = new Kuningas(4, 0, 0);
        this.lauta[3][0] = new Kuningatar(3, 0, 0);
        this.ruudut[4][7] = true;
        this.ruudut[3][7] = true;
        this.ruudut[4][0] = true;
        this.ruudut[3][0] = true;

        this.lauta[0][0] = new Torni(0, 0, 0);
        this.lauta[7][0] = new Torni(7, 0, 0);
        this.lauta[0][7] = new Torni(0, 7, 1);
        this.lauta[7][7] = new Torni(7, 7, 1);
        this.ruudut[0][0] = true;
        this.ruudut[7][0] = true;
        this.ruudut[0][7] = true;
        this.ruudut[7][7] = true;

        this.lauta[1][7] = new Ratsu(1, 7, 1);
        this.lauta[6][7] = new Ratsu(6, 7, 1);
        this.lauta[1][0] = new Ratsu(1, 0, 0);
        this.lauta[6][0] = new Ratsu(6, 0, 0);
        this.ruudut[1][7] = true;
        this.ruudut[6][7] = true;
        this.ruudut[1][0] = true;
        this.ruudut[6][0] = true;

        this.lauta[2][7] = new Lahetti(2, 7, 1);
        this.lauta[5][7] = new Lahetti(5, 7, 1);
        this.lauta[2][0] = new Lahetti(2, 0, 0);
        this.lauta[5][0] = new Lahetti(5, 0, 0);
        this.ruudut[2][7] = true;
        this.ruudut[5][7] = true;
        this.ruudut[2][0] = true;
        this.ruudut[5][0] = true;
    }

    public void tulosta() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (this.lauta[j][i] != null) {
                    System.out.print(this.lauta[j][i]);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
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

    public void siirto(Nappula n, int xMihin, int yMihin) {
        lauta[n.x][n.y] = null;
        lauta[xMihin][yMihin] = n;
        n.liiku(xMihin, yMihin);
    }

}
