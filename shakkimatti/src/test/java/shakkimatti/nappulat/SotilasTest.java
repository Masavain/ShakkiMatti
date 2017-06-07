package shakkimatti.nappulat;

import shakkimatti.logiikka.Pelilauta;
import shakkimatti.nappulat.Sotilas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import javafx.scene.layout.*;
import shakkimatti.logiikka.Pelaaja;

public class SotilasTest {

    private Pelilauta lauta;

    public SotilasTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.lauta = new Pelilauta();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tarkastaLiikutettuMusta() {
        // testaa, että liikutettu on liikkumisen jälkeen true
        Sotilas sotilas = new Sotilas(0, 1, Pelaaja.MUSTA, false);
        sotilas.liiku(0, 2, lauta.getLauta());
        assertTrue(sotilas.liikutettu);
    }

    @Test
    public void liikkuuOikeaanKoordinaattiinMusta() {
        // testaa, että liikutettu on liikkumisen jälkeen true
        Sotilas sotilas = new Sotilas(0, 1, Pelaaja.MUSTA, false);
        sotilas.liiku(0, 2, lauta.getLauta());
        assertEquals(sotilas.getX() + "," + sotilas.getY(), "0,2");
    }

    @Test
    public void aluksiVoiLiikkuaKaksiMusta() {
        // testaa, että sotilasta on mahdollista siirtää aluksi 2 ruutua 
        Sotilas sotilas = new Sotilas(0, 1, Pelaaja.MUSTA, false);
        assertTrue(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,3"));
    }

    @Test
    public void aluksiVoiLiikkuaYhdenMusta() {
        Sotilas sotilas = new Sotilas(0, 1, Pelaaja.MUSTA, false);
        assertTrue(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,2"));
    }

    @Test
    public void eiVoiLiikkuaTaakseMusta() {
        Sotilas sotilas = new Sotilas(0, 1, Pelaaja.MUSTA, false);
        assertFalse(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,0"));
    }

    @Test
    public void eiPaaseLaudaltaPoisMusta() {
        Sotilas sotilas = new Sotilas(0, 8, Pelaaja.MUSTA, false);
        assertTrue(!sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,9"));
    }

    @Test
    public void eiVoiLiikkuaSivulleMusta() {
        Sotilas sotilas = new Sotilas(0, 1, Pelaaja.MUSTA, false);
        sotilas.liiku(1, 1, lauta.getLauta());
        assertEquals(0, sotilas.getX());
    }

    @Test
    public void eiVoiLiikkuaSivullePoisLaudaltaMusta() {
        Sotilas sotilas = new Sotilas(0, 1, Pelaaja.MUSTA, false);
        sotilas.liiku(-1, 1, lauta.getLauta());
        assertEquals(0, sotilas.getX());
    }

    @Test
    public void liikkuuOikeaanKoordinaattiinValk() {
        Sotilas sotilas = new Sotilas(7, 6, Pelaaja.VALKOINEN, false);
        sotilas.liiku(7, 5, lauta.getLauta());
        assertEquals(sotilas.getX() + "," + sotilas.getY(), "7,5");
    }

    @Test
    public void aluksiVoiLiikkuaKaksiValk() {
        // testaa, että sotilasta on mahdollista siirtää aluksi 2 ruutua 
        Sotilas sotilas = new Sotilas(7, 6, Pelaaja.VALKOINEN, false);
        assertTrue(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("7,4"));
    }

    @Test
    public void aluksiVoiLiikkuaYhdenValk() {
        Sotilas sotilas = new Sotilas(7, 6, Pelaaja.VALKOINEN, false);
        assertTrue(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("7,4"));
    }

    @Test
    public void eiVoiLiikkuaTaakseValk() {
        Sotilas sotilas = new Sotilas(0, 7, Pelaaja.VALKOINEN, false);
        assertTrue(!sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,8"));
    }

    @Test
    public void eiPaaseLaudaltaPoisValk() {
        Sotilas sotilas = new Sotilas(0, 0, Pelaaja.VALKOINEN, false);
        assertFalse(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,-1"));
    }

    @Test
    public void eiVoiLiikkuaSivulleValk() {
        Sotilas sotilas = new Sotilas(0, 7, Pelaaja.VALKOINEN, false);
        sotilas.liiku(1, 1, lauta.getLauta());
        assertEquals(0, sotilas.getX());
    }

    @Test
    public void eiVoiLiikkuaSivullePoisLaudaltaValk() {
        Sotilas sotilas = new Sotilas(0, 7, Pelaaja.VALKOINEN, false);
        sotilas.liiku(-1, 7, lauta.getLauta());
        assertEquals(0, sotilas.getX());
    }

    @Test
    public void syotavaListallaMusta() {
        Sotilas musta = new Sotilas(0, 0, Pelaaja.MUSTA, false);
        Sotilas valkoinen = new Sotilas(1, 1, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(musta, 0, 0);
        lauta.asetaNappula(valkoinen, 1, 1);

        assertTrue(musta.mahdollisetSyonnit(lauta.getLauta()).contains("1,1"));
    }

    @Test
    public void syotavaListallaMusta2() {
        Sotilas musta = new Sotilas(6, 6, Pelaaja.MUSTA, false);
        Sotilas valkoinen = new Sotilas(5, 7, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(musta, 6, 6);
        lauta.asetaNappula(valkoinen, 5, 7);
        assertTrue(musta.mahdollisetSyonnit(lauta.getLauta()).contains("5,7"));
    }

    @Test
    public void syotavaListallaValk() {
        Sotilas musta = new Sotilas(0, 0, Pelaaja.MUSTA, false);
        Sotilas valkoinen = new Sotilas(1, 1, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(musta, 0, 0);
        lauta.asetaNappula(valkoinen, 1, 1);

        assertTrue(valkoinen.mahdollisetSyonnit(lauta.getLauta()).contains("0,0"));
    }

    @Test
    public void syotavaListallaValk2() {
        Sotilas mustas = new Sotilas(2, 0, Pelaaja.MUSTA, false);
        Sotilas valkoinen = new Sotilas(1, 1, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(mustas, 2, 0);
        lauta.asetaNappula(valkoinen, 1, 1);

        assertTrue(valkoinen.mahdollisetSyonnit(lauta.getLauta()).contains("2,0"));
    }
    @Test
    public void eiVoiSyodaOmanVaristaMusta() {
        Sotilas eka = new Sotilas(0, 0, Pelaaja.MUSTA, false);
        Sotilas toka = new Sotilas(1, 1, Pelaaja.MUSTA, false);
        lauta.asetaNappula(eka, 0, 0);
        lauta.asetaNappula(toka, 1, 1);

        assertFalse(eka.mahdollisetSyonnit(lauta.getLauta()).contains("1,1"));
    }

    @Test
    public void eiVoiSyodaOmanVaristaValk() {
        Sotilas eka = new Sotilas(0, 0, Pelaaja.VALKOINEN, false);
        Sotilas toka = new Sotilas(1, 1, Pelaaja.VALKOINEN, false);
        lauta.asetaNappula(eka, 0, 0);
        lauta.asetaNappula(toka, 1, 1);

        assertFalse(toka.mahdollisetSyonnit(lauta.getLauta()).contains("0,0"));
    }

}
