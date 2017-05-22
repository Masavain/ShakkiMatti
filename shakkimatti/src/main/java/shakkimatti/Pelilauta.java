package shakkimatti;

import java.util.*;

public class Pelilauta {

    public Nappula[][] lauta;

    public Pelilauta() {
        this.lauta = new Nappula[8][8];
        alustus();
    }

    public void alustus() {
        for (int i = 0; i < 8; i++) {
            this.lauta[i][6] = new Sotilas(i, 6, 1);
            this.lauta[i][1] = new Sotilas(i, 1, 0);
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

    public void tulosta() {
        for (int i = 0; i < 8; i++) {
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

}
