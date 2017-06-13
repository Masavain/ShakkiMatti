package shakkimatti.logiikka;

import shakkimatti.nappulat.*;
import java.util.*;

/**
 * päälogiikkaluokka shakkipelin vuorojen kontrollointiin sekä pelin
 * voittoehtojen tarkastamiseen.
 *
 * @author Masavain
 */
public class Paalogiikka {

    private Pelilauta pelilauta;
    private Pelaaja pelaaja;

    public Paalogiikka() {
        this.pelilauta = new Pelilauta();
        pelilauta.alustus();
        this.pelaaja = Pelaaja.VALKOINEN;
    }

    
    public void peli() {
        while (!checkShakkiMatti(pelaaja)) {

            
        }
    }
    
    /**
     * vaihtaa pelaajaa valkoisesta mustaan tai mustasta valkoiseen
     */
    public void vaihdaVuoroa(){
        if (pelaaja == Pelaaja.VALKOINEN) {
                pelaaja = Pelaaja.MUSTA;
            } else {
                pelaaja = Pelaaja.VALKOINEN;
            }
    }

    /**
     *
     * @param pelaaja
     * @return palauttaa false jos parametrina saadun pelaajan kuninkaalla on
     * mahdollisia siirtoja, true jos ei. Truen palautus tarkoittaa siis
     * ShakkiMattia, eli pelin päätöstä.
     */
    public boolean checkShakkiMatti(Pelaaja pelaaja) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pelilauta.getLauta()[j][i] != null && pelilauta.getLauta()[j][i].getMerkki().equals("K") && pelilauta.getLauta()[j][i].getPelaaja() == pelaaja) {
                    Kuningas kunkku = (Kuningas) pelilauta.getLauta()[j][i];
                    List<String> kuninkaanSiirrot = kunkku.mahdollisetSiirrot(pelilauta.getLauta());
                    pelilauta.getLauta()[j][i] = null;
                    for (String siirto : kuninkaanSiirrot) {
                        String[] koord = siirto.split("");
                        if (!checkUhka(pelaaja, Integer.parseInt(koord[0]), Integer.parseInt(koord[2]))) {
                            return false;
                        }
                    }
                    pelilauta.getLauta()[j][i] = kunkku;
                }
            }
        }
        return true;
    }

    /**
     * Tarkastaa, onko parametrina saatujen arvojen mukainen koordinattii
     * uhattuna vastapuolen pelaajan puolelta. Käytetaään tarkastamaan onko
     * kuningas shakissa tai onko kuninkaalla mahdollisuutta liikkua johonkin
     * ruutuun.
     *
     * @param pelaaja tämänhetkinen pelaaja
     * @param x tarkastettavan koordinaatin x-arvo.
     * @param y tarkastettavan koordinaatin y-arvo.
     * @return palauttaa true jos koordinaattia uhataan, false jos ei.
     */
    public boolean checkUhka(Pelaaja pelaaja, int x, int y) {
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

    public Pelilauta getPelilauta() {
        return pelilauta;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public void setPelilauta(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
    }

}
