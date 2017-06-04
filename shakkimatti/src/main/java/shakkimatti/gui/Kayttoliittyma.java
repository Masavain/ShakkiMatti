package shakkimatti.gui;

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
import shakkimatti.logiikka.Pelilauta;

public class Kayttoliittyma extends Application {

    GridPane root = new GridPane();
    final int size = 8;

    @Override
    public void start(Stage primaryStage) {
        Pelilauta lauta = new Pelilauta(root);
        lauta.alustus();
        lauta.varitaRuudukko();
        lauta.kuvatGridiin();
        primaryStage.setScene(new Scene(lauta.getRoot(), 500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(Kayttoliittyma.class);
    }

}
