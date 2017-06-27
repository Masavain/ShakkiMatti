package shakkimatti.logiikka;

import shakkimatti.nappulat.*;
import java.util.ArrayList;

/**
 * päälogiikkaluokka shakkipelin vuorojen kontrollointiin sekä pelin
 * voittoehtojen tarkastamiseen.
 *
 * @author Masavain
 */
public class Paalogiikka {

    private Pelilauta pelilauta;
    private Pelaaja pelaaja;

    /**
     * Konstruktori, luo uuden pelilaudan ja alustaa sen sekä asettaa valkoisen
     * pelaajan ensimmäiseksi vuoroon.
     */
    public Paalogiikka() {
        this.pelilauta = new Pelilauta();
        pelilauta.alustus();
        this.pelaaja = Pelaaja.VALKOINEN;

    }

    /**
     * kuvaa pelaajan vuoroa shakissa. Vuorossa tehdään siirto ja sen jälkeen
     * vaihdetaan vuoroa toiselle pelaajalle.
     *
     * @param xMista pelaajan valitseman nappulan x-koordinaatti
     * @param yMista pelaajan valitseman nappulan y-koordinaatti
     * @param xMihin pelaajan valitseman siirron x-koordinaatti
     * @param yMihin pelaajan valitseman siirron x-koordinaatti
     * @return true jos vuoro suoritettiin onnistuneesti, muuten false
     */
    public boolean vuoro(int xMista, int yMista, int xMihin, int yMihin) {
        if (pelilauta.validiSiirrettava(pelaaja, xMista, yMista)) {
            if (pelilauta.siirto(xMista, yMista, xMihin, yMihin)) {
                vaihdaVuoroa();
                return true;
            }
        }
        return false;
    }

    /**
     * Vaihtaa pelaajaa valkoisesta mustaan tai mustasta valkoiseen.
     */
    public void vaihdaVuoroa() {
        if (pelaaja == Pelaaja.VALKOINEN) {
            pelaaja = Pelaaja.MUSTA;
        } else {
            pelaaja = Pelaaja.VALKOINEN;
        }
    }

    public Pelilauta getPelilauta() {
        return pelilauta;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public void setPelilauta(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
    }

    /**
     * Etsii laudalta kuninkaan koordinaatit.
     *
     * @return palauttaa löydetyn kuninkaan, tai null.
     */
    public Kuningas getKunkku() {
        Kuningas kunkku = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pelilauta.getLauta()[j][i] != null && pelilauta.getLauta()[j][i].getMerkki().equals("K") && pelilauta.getLauta()[j][i].getPelaaja() == pelaaja) {
                    kunkku = (Kuningas) pelilauta.getLauta()[j][i];
                }
            }
        }
        return kunkku;
    }

    /**
     * /**
     * tarkastaa onko kuningas shakissa, eli onko vastapelaajalla mahdollista
     * syödä kuningas.
     *
     * @param lauta pelilaudan tilanne
     * @return palauttaa true jos kuningas uhattuna, false muuten;
     */
    public boolean checkShakki() {
        Kuningas kunkku = getKunkku();
        int x = kunkku.getX();
        int y = kunkku.getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pelilauta.getLauta()[j][i] != null && pelilauta.getLauta()[j][i].getPelaaja() != pelaaja) {
                    Nappula uhkaaja = pelilauta.getLauta()[j][i];
                    if (uhkaaja.mahdollisetSiirrot(pelilauta.getLauta()).contains(x + "," + y)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }
}
