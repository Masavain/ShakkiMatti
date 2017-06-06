package shakkimatti.gui;

import shakkimatti.logiikka.Pelilauta;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import shakkimatti.logiikka.Pelaaja;
import shakkimatti.nappulat.Nappula;

public class Kayttoliittyma extends Application {

    private GridPane root = new GridPane();
    private Pelilauta lauta;
    private Nappula nappula;

    @Override
    public void start(Stage primaryStage) {
        nappula = null;
        lauta = new Pelilauta();
        lauta.alustus();
        varitaRuudukko();
        kuvatGridiin();
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("SHAKKIMATTI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(Kayttoliittyma.class);
    }

//    public void valitseNappula(){
//        
//    }
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
                stack.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> System.out.println("Node: " + stack + " at " + GridPane.getColumnIndex(stack) + "/" + GridPane.getRowIndex(stack)));
                stack.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        int y = GridPane.getRowIndex(stack);
                        int x = GridPane.getColumnIndex(stack);

                        if (nappula != null) {
                            if (lauta.siirto(nappula.getX(), nappula.getY(), x, y)) {
                                System.out.println(lauta.getLauta()[x][y] + "," + lauta.getLauta()[x][y].getPelaaja() + "liikutettu");
                                System.out.println(lauta.toString());
                                
                            }
                            nappula = null;
                            kuvatGridiin();
                        } else if (lauta.getLauta()[x][y] != null && nappula == null) {
                            System.out.println(lauta.getLauta()[x][y] + "," + lauta.getLauta()[x][y].getPelaaja() + " valittu ");
                            nappula = lauta.getLauta()[x][y];

                        }

                        if (stack.getChildren().size() == 2) {
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

    public void kuvatGridiin() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                StackPane stack = etsiStack(j, i);

                if (lauta.getLauta()[j][i] != null) {
                    String tiedosto = "";
                    if (lauta.getLauta()[j][i].getPelaaja() == Pelaaja.VALKOINEN) {
                        tiedosto += "valko";
                    } else {
                        tiedosto += "musta";
                    }
                    if (lauta.getLauta()[j][i].merkki.equals("S")) {
                        tiedosto += "Sotilas";
                    }
                    if (lauta.getLauta()[j][i].merkki.equals("T")) {
                        tiedosto += "Torni";
                    }
                    if (lauta.getLauta()[j][i].merkki.equals("R")) {
                        tiedosto += "Ratsu";
                    }
                    if (lauta.getLauta()[j][i].merkki.equals("L")) {
                        tiedosto += "Lahetti";
                    }
                    if (lauta.getLauta()[j][i].merkki.equals("K")) {
                        tiedosto += "Kunkku";
                    }
                    if (lauta.getLauta()[j][i].merkki.equals("Q")) {
                        tiedosto += "Kuningatar";
                    }
                    tiedosto += ".png";

                    ImageView iv = new ImageView(new Image(tiedosto));
                    stack.getChildren().add(iv);

                } else if (lauta.getLauta()[j][i] == null) {
                    if (stack.getChildren().size() > 1) {
                        ImageView iv = (ImageView) stack.getChildren().get(1);
                        stack.getChildren().remove(iv);
                    }
                }

            }
        }
    }

    public StackPane etsiStack(int i, int j) {
        for (Node node : root.getChildren()) {
            if (GridPane.getColumnIndex(node) == i && GridPane.getRowIndex(node) == j) {
                return (StackPane) node;
            }
        }
        return null;
    }
}
