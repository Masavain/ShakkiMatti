package shakkimatti.gui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import shakkimatti.logiikka.Paalogiikka;
import shakkimatti.logiikka.Pelaaja;

/**
 * Käyttöliittymäluokka Shakkikellon ylläpitoa varten.
 *
 * @author Masavain
 */
public class KelloLabel {

    private Integer valkTimeSeconds = -1;
    private Integer mustaTimeSeconds = -1;
    private Integer timeSeconds = valkTimeSeconds;
    private Timeline timeline;
    private Label timerLabel1 = new Label();
    private Label timerLabel2 = new Label();
    public Paalogiikka peli = new Paalogiikka();
    private Stage primaryStage;

    /**
     * Konstruktorimetodi.
     *
     * @param peli Päälogiikkaluokan ilmentymä
     * @param primaryStage Käyttöliittymän primaryStage
     */
    public KelloLabel(Paalogiikka peli, Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.peli = peli;
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(1), ae -> timeSeconds++), new KeyFrame(Duration.seconds(1), ae -> timerLabel1.setText((timeSeconds / 60 + ":" + timeSeconds % 60)))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        timerLabel1.prefWidthProperty().bind(primaryStage.widthProperty());
        timerLabel2.prefWidthProperty().bind(primaryStage.widthProperty());
        timerLabel2.setText("valkoisen aika ");
    }

    public Integer getValkTimeSeconds() {
        return valkTimeSeconds;
    }

    public Integer getMustaTimeSeconds() {
        return mustaTimeSeconds;
    }

    public Integer getTimeSeconds() {
        return timeSeconds;
    }

    public Label getTimerLabel1() {
        return timerLabel1;
    }

    public Label getTimerLabel2() {
        return timerLabel2;
    }

    /**
     * Metodi, joka vaihtaa kelloa pelaajasta riippuen.
     */
    public void vaihdaKelloa() {
        if (peli.getPelaaja() == Pelaaja.MUSTA) {
            timerLabel2.setText("mustan aika ");
            valkTimeSeconds = timeSeconds;
            timeSeconds = mustaTimeSeconds;

        } else {
            timerLabel2.setText("valkoisen aika ");
            mustaTimeSeconds = timeSeconds;
            timeSeconds = valkTimeSeconds;
        }
    }
}
