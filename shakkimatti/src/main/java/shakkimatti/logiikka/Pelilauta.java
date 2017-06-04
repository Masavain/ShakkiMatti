package shakkimatti.logiikka;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.Control;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
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
    public GridPane root;

    public Pelilauta(GridPane root) {
        this.root = root;
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

    public void kuvatGridiin() {
        for (int i = 0; i < 8; i++) {
            ImageView iv = new ImageView(new Image("valkoSotilas.png"));
            root.add(iv, i, 6);
            ImageView iv2 = new ImageView(new Image("mustaSotilas.png"));
            root.add(iv2, i, 1);
        }
        ImageView kunkku1 = new ImageView(new Image("valkoKunkku.png"));
        root.add(kunkku1, 4, 7);
        ImageView kuningatar1 = new ImageView(new Image("valkoKuningatar.png"));
        root.add(kuningatar1, 3, 7);
        ImageView kunkku0 = new ImageView(new Image("mustaKunkku.png"));
        root.add(kunkku0, 4, 0);
        ImageView kuningatar0 = new ImageView(new Image("mustaKuningatar.png"));
        root.add(kuningatar0, 3, 0);
        ImageView torni01 = new ImageView(new Image("mustaTorni.png"));
        ImageView torni02 = new ImageView(new Image("mustaTorni.png"));
        ImageView torni11 = new ImageView(new Image("valkoTorni.png"));
        ImageView torni12 = new ImageView(new Image("valkoTorni.png"));
        root.add(torni01, 0, 0);
        root.add(torni02, 7, 0);
        root.add(torni11, 0, 7);
        root.add(torni12, 7, 7);

        ImageView ratsu11 = new ImageView(new Image("valkoRatsu.png"));
        ImageView ratsu12 = new ImageView(new Image("valkoRatsu.png"));
        ImageView ratsu01 = new ImageView(new Image("mustaRatsu.png"));
        ImageView ratsu02 = new ImageView(new Image("mustaRatsu.png"));
        root.add(ratsu01, 1, 0);
        root.add(ratsu02, 6, 0);
        root.add(ratsu11, 1, 7);
        root.add(ratsu12, 6, 7);

        ImageView lahetti11 = new ImageView(new Image("valkoLahetti.png"));
        ImageView lahetti12 = new ImageView(new Image("valkoLahetti.png"));
        ImageView lahetti01 = new ImageView(new Image("mustaLahetti.png"));
        ImageView lahetti02 = new ImageView(new Image("mustaLahetti.png"));
        root.add(lahetti11, 2, 7);
        root.add(lahetti12, 5, 7);
        root.add(lahetti01, 2, 0);
        root.add(lahetti02, 5, 0);
    }

    public void varitaRuudukko() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                StackPane stack = new StackPane();
                Rectangle ruutu = new Rectangle();
                Color color;
                if ((row + col) % 2 == 0) {
                    color = Color.BEIGE;
                } else {
                    color = Color.SADDLEBROWN;
                }

                ruutu.setFill(color);
                stack.getChildren().add(ruutu);

                root.add(stack, col, row);
                ruutu.widthProperty().bind(root.widthProperty().divide(8));
                ruutu.heightProperty().bind(root.heightProperty().divide(8));
            }
        }
    }

    public GridPane getRoot() {
        return root;
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
