package shakkimatti.gui;

import java.util.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import shakkimatti.logiikka.Paalogiikka;
import shakkimatti.logiikka.Pelaaja;
import shakkimatti.nappulat.Nappula;

public class Kayttoliittyma extends Application {

    private BorderPane root = new BorderPane();
    private GridPane ruudukko = new GridPane();
    private Nappula nappula;
    private Paalogiikka peli = new Paalogiikka();
    private ArrayList<Rectangle> keltaiset = new ArrayList();

    @Override
    public void start(Stage primaryStage) {
        nappula = null;

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        Menu valikko = new Menu("Valikko");
        MenuItem lopetusValikko = new MenuItem("Lopeta");
        MenuItem uusiPeliValikko = new MenuItem("Uusi Peli");
        uusiPeliValikko.setOnAction(actionEvent -> this.peli = new Paalogiikka());
        lopetusValikko.setOnAction(actionEvent -> Platform.exit());

        valikko.getItems().add(uusiPeliValikko);
        valikko.getItems().add(lopetusValikko);

        
        menuBar.getMenus().addAll(valikko);

        ruudukko.prefHeightProperty().bind(primaryStage.heightProperty());
        ruudukko.prefWidthProperty().bind(primaryStage.widthProperty());

        root.setCenter(ruudukko);
        Paalogiikka peli = new Paalogiikka();
        varitaRuudukko();
        kuvatGridiin();
        Scene scene = new Scene(root, 550, 550);
        primaryStage.setTitle("SHAKKIMATTI");
        primaryStage.setScene(scene);
        primaryStage.show();
        peli.peli();

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
                            if (peli.getPelilauta().siirto(nappula.getX(), nappula.getY(), x, y)) {
                                System.out.println(peli.getPelilauta().getLauta()[x][y] + "," + peli.getPelilauta().getLauta()[x][y].getPelaaja() + "liikutettu");
                                System.out.println(peli.getPelilauta().toString());
                                kuvatGridiin();
                                keltaisetTakaisin();
                                peli.vaihdaVuoroa();
                            }
                            nappula = null;
                        } else if (peli.getPelilauta().validiSiirrettava(peli.getPelaaja(), x, y) && nappula == null) {
                            System.out.println(peli.getPelilauta().getLauta()[x][y] + "," + peli.getPelilauta().getLauta()[x][y].getPelaaja() + " valittu ");
                            nappula = peli.getPelilauta().getLauta()[x][y];
                            varitaKeltaiseksi();

                        }

                        if (stack.getChildren().size() == 2) {
                            Rectangle ruutu = (Rectangle) stack.getChildren().get(0);
                            ruutu.setStroke(Color.RED);
                        }
                        kuvatGridiin();

                    }
                });
                stack.setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Rectangle ruutu = (Rectangle) stack.getChildren().get(0);
                        ruutu.setStroke(Color.TRANSPARENT);
                    }
                });

                ruudukko.add(stack, col, row);
                ruutu.widthProperty().bind(ruudukko.widthProperty().divide(8));
                ruutu.heightProperty().bind(ruudukko.heightProperty().divide(8));
            }
        }
    }

    public void varitaKeltaiseksi() {
        List<String> mahdSiirrot = nappula.mahdollisetSiirrot(peli.getPelilauta().getLauta());
        for (String koordi : mahdSiirrot) {
            String[] temp = koordi.split("");
            int mahdX = Integer.parseInt(temp[0]);
            int mahdY = Integer.parseInt(temp[2]);
            StackPane stack = etsiStack(mahdX, mahdY);
            Rectangle ruutu = (Rectangle) stack.getChildren().get(0);
            keltaiset.add(ruutu);
            ruutu.setStroke(Color.YELLOW);
        }
    }

    public void keltaisetTakaisin() {
        for (Rectangle ruutu : keltaiset) {
            ruutu.setStroke(Color.TRANSPARENT);
        }
    }

    public void kuvatGridiin() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                StackPane stack = etsiStack(j, i);

                if (peli.getPelilauta().getLauta()[j][i] != null) {
                    String tiedosto = "";
                    if (peli.getPelilauta().getLauta()[j][i].getPelaaja() == Pelaaja.VALKOINEN) {
                        tiedosto += "valko";
                    } else {
                        tiedosto += "musta";
                    }
                    if (peli.getPelilauta().getLauta()[j][i].getMerkki().equals("S")) {
                        tiedosto += "Sotilas";
                    }
                    if (peli.getPelilauta().getLauta()[j][i].getMerkki().equals("T")) {
                        tiedosto += "Torni";
                    }
                    if (peli.getPelilauta().getLauta()[j][i].getMerkki().equals("R")) {
                        tiedosto += "Ratsu";
                    }
                    if (peli.getPelilauta().getLauta()[j][i].getMerkki().equals("L")) {
                        tiedosto += "Lahetti";
                    }
                    if (peli.getPelilauta().getLauta()[j][i].getMerkki().equals("K")) {
                        tiedosto += "Kunkku";
                    }
                    if (peli.getPelilauta().getLauta()[j][i].getMerkki().equals("Q")) {
                        tiedosto += "Kuningatar";
                    }
                    tiedosto += ".png";

                    ImageView iv = new ImageView(new Image(tiedosto));
                    stack.getChildren().add(iv);

                } else if (peli.getPelilauta().getLauta()[j][i] == null) {
                    if (stack.getChildren().size() > 1) {
                        ImageView iv = (ImageView) stack.getChildren().get(1);
                        stack.getChildren().remove(iv);
                    }
                }

            }
        }
    }

    public StackPane etsiStack(int i, int j) {
        for (Node node : ruudukko.getChildren()) {
            if (GridPane.getColumnIndex(node) == i && GridPane.getRowIndex(node) == j) {
                return (StackPane) node;
            }
        }
        return null;
    }
}
