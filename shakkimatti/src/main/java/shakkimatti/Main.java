package shakkimatti;

import shakkimatti.logiikka.Peliapu;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import shakkimatti.gui.Kayttoliittyma;

public class Main {

    public static void main(String[] args) {
        Peliapu apu = new Peliapu();
        apu.kaynnista();
    }
}
