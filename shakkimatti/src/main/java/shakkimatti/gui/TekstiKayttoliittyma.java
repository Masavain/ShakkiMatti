package shakkimatti.gui;

import shakkimatti.nappulat.Nappula;
import java.util.*;
import javafx.scene.layout.*;
import shakkimatti.logiikka.Pelaaja;
import shakkimatti.logiikka.Pelilauta;

public class TekstiKayttoliittyma {

    public Pelilauta pelilauta;
    public ArrayList<String> kirjaimet = new ArrayList<String>(Arrays.asList(new String[]{"a", "b", "c", "d", "e", "f", "g", "h"}));
    public Scanner lukija;

    public TekstiKayttoliittyma() {
        this.pelilauta = new Pelilauta();
        this.lukija = new Scanner(System.in);
    }

    public void kaynnista() {
        
        System.out.println(pelilauta.toString());

        Pelaaja vuoro = Pelaaja.VALKOINEN;

        while (true) {
            // valkoisen siirto
            if (vuoro == Pelaaja.VALKOINEN) {
                System.out.println("valkoinen, anna lähtökoordinaatti:");
            } else if (vuoro == Pelaaja.MUSTA) {
                System.out.println("musta, anna lähtökoordinaatti:");
            }
            String lahto = lukija.nextLine();
            String[] koord = lahto.split("");

            int xMista = kirjaimet.indexOf(koord[0]);
            int yMista = Integer.parseInt(koord[1]) - 1;

            if (pelilauta.validiSiirrettava(vuoro, xMista, yMista)) {
                vuoro(vuoro, xMista, yMista);
            }
            System.out.println(pelilauta.toString());

            if (vuoro == Pelaaja.MUSTA) {
                vuoro = Pelaaja.VALKOINEN;
            } else {
                vuoro = Pelaaja.MUSTA;
            }
        }
    }

    public void vuoro(Pelaaja pelaaja, int xMista, int yMista) {

        while (true) {
            System.out.println("anna päätekoordinaatti:");
            String paate = lukija.nextLine();
            String[] koord = paate.split("");
            int xMihin = kirjaimet.indexOf(koord[0]);
            int yMihin = Integer.parseInt(koord[1]) - 1;
            if (pelilauta.siirto(xMista, yMista, xMihin, yMihin)) {
                break;
            } else {
                System.out.println("ei onnaa.");
            }
        }
    }
}
