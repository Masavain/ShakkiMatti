package shakkimatti.gui;

import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.*;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import shakkimatti.nappulat.*;
import javafx.scene.shape.StrokeType;

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
        List<ImageView> imaget = new ArrayList();
        for (int i = 0; i < 8; i++) {

            ImageView iv = new ImageView(new Image("valkoSotilas.png"));
            ImageView iv2 = new ImageView(new Image("mustaSotilas.png"));
            for (Node n : root.getChildren()) {
                if (GridPane.getRowIndex(n) == 6 && GridPane.getColumnIndex(n) == i) {
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                } else if (GridPane.getRowIndex(n) == 1 && GridPane.getColumnIndex(n) == i) {
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv2);
                }
            }
        }
        for (Node n : root.getChildren()) {
            if (GridPane.getRowIndex(n) == 0) {
                if (GridPane.getColumnIndex(n) == 0 || GridPane.getColumnIndex(n) == 7) {
                    ImageView iv = new ImageView(new Image("mustaTorni.png"));
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                }
                if (GridPane.getColumnIndex(n) == 1 || GridPane.getColumnIndex(n) == 6) {
                    ImageView iv = new ImageView(new Image("mustaRatsu.png"));
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                }
                if (GridPane.getColumnIndex(n) == 2 || GridPane.getColumnIndex(n) == 5) {
                    ImageView iv = new ImageView(new Image("mustaLahetti.png"));
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                }
                if (GridPane.getColumnIndex(n) == 3) {
                    ImageView iv = new ImageView(new Image("mustaKuningatar.png"));
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                }
                if (GridPane.getColumnIndex(n) == 4) {
                    ImageView iv = new ImageView(new Image("mustaKunkku.png"));
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                }
            } else if (GridPane.getRowIndex(n) == 7) {
                if (GridPane.getColumnIndex(n) == 0 || GridPane.getColumnIndex(n) == 7) {
                    ImageView iv = new ImageView(new Image("valkoTorni.png"));
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                }
                if (GridPane.getColumnIndex(n) == 1 || GridPane.getColumnIndex(n) == 6) {
                    ImageView iv = new ImageView(new Image("valkoRatsu.png"));
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                }
                if (GridPane.getColumnIndex(n) == 2 || GridPane.getColumnIndex(n) == 5) {
                    ImageView iv = new ImageView(new Image("valkoLahetti.png"));
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                }
                if (GridPane.getColumnIndex(n) == 3) {
                    ImageView iv = new ImageView(new Image("valkoKuningatar.png"));
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                }
                if (GridPane.getColumnIndex(n) == 4) {
                    ImageView iv = new ImageView(new Image("valkoKunkku.png"));
                    StackPane stack = (StackPane) n;
                    stack.getChildren().add(iv);
                }
            }
        }

    }

    public void varitaRuudukko() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                StackPane stack = new StackPane();
                Rectangle ruutu = new Rectangle();
                ruutu.setWidth(50);
                ruutu.setHeight(50);
                ruutu.setStrokeWidth(2.0);
                ruutu.setStrokeType(StrokeType.INSIDE);
                ruutu.setStroke(Color.TRANSPARENT);
                Color color;
                if ((row + col) % 2 == 0) {
                    color = Color.BEIGE;
                } else {
                    color = Color.PINK;
                }

                ruutu.setFill(color);
                stack.getChildren().add(ruutu);
                stack.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> System.out.println("Node: " + stack + " at " + GridPane.getRowIndex(stack) + "/" + GridPane.getColumnIndex(stack)));
                stack.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (stack.getChildren().size()==2) {
                            Rectangle ruutu = (Rectangle) stack.getChildren().get(0);
                            ruutu.setStroke(Color.RED);
                        }
                    }
                });
                stack.setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Rectangle ruutu = (Rectangle) stack.getChildren().get(0);
                        ruutu.setStroke(Color.TRANSPARENT);
                    }
                });

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
