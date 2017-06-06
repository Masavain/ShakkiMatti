package shakkimatti.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import shakkimatti.logiikka.Peli;


public class Kayttoliittyma extends Application {

    public GridPane root = new GridPane();

    @Override
    public void start(Stage primaryStage) {
        
        Pelilauta lauta = new Pelilauta(root);
        Peli peli = new Peli();
        lauta.alustus();
        lauta.varitaRuudukko();
        lauta.kuvatGridiin();
        Scene scene = new Scene(lauta.getRoot(), 500, 500);
        primaryStage.setTitle("SHAKKIMATTI");
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(Kayttoliittyma.class);
    }

    public void valitseNappula(){
        
    }
    
}
