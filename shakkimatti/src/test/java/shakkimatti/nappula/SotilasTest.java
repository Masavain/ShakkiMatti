package shakkimatti.nappula;

import shakkimatti.gui.Pelilauta;
import shakkimatti.nappulat.Sotilas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import javafx.scene.layout.*;

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
        this.lauta = new Pelilauta(new GridPane());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tarkastaLiikutettuMusta() {
        // testaa, että liikutettu on liikkumisen jälkeen true
        Sotilas sotilas = new Sotilas(0, 1, 0, false);
        sotilas.liiku(0, 0, lauta.getLauta());
        assertTrue(sotilas.liikutettu);
    }

    @Test
    public void liikkuuOikeaanKoordinaattiinMusta() {
        // testaa, että liikutettu on liikkumisen jälkeen true
        Sotilas sotilas = new Sotilas(0, 1, 0, false);
        sotilas.liiku(0, 0, lauta.getLauta());
        assertEquals(sotilas.x + "," + sotilas.y, "0,0");
    }

    @Test
    public void aluksiVoiLiikkuaKaksiMusta() {
        // testaa, että sotilasta on mahdollista siirtää aluksi 2 ruutua 
        Sotilas sotilas = new Sotilas(0, 2, 0, false);
        assertTrue(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,0"));
    }

    @Test
    public void aluksiVoiLiikkuaYhdenMusta() {
        Sotilas sotilas = new Sotilas(0, 1, 0, false);
        assertTrue(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,0"));
    }

    @Test
    public void eiVoiLiikkuaTaakseMusta() {
        Sotilas sotilas = new Sotilas(0, 1, 0, false);
        assertTrue(!sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,2"));
    }

    @Test
    public void eiPaaseLaudaltaPoisMusta() {
        Sotilas sotilas = new Sotilas(0, 8, 0, false);
        assertTrue(!sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,9"));
    }

    @Test
    public void eiVoiLiikkuaSivulleMusta() {
        Sotilas sotilas = new Sotilas(0, 1, 0, false);
        sotilas.liiku(1, 1, lauta.getLauta());
        assertEquals(0, sotilas.x);
    }

    @Test
    public void eiVoiLiikkuaSivullePoisLaudaltaMusta() {
        Sotilas sotilas = new Sotilas(0, 1, 0, false);
        sotilas.liiku(-1, 1, lauta.getLauta());
        assertEquals(0, sotilas.x);
    }

    @Test
    public void liikkuuOikeaanKoordinaattiinValk() {
        Sotilas sotilas = new Sotilas(0, 1, 1, false);
        sotilas.liiku(0, 2, lauta.getLauta());
        assertEquals(sotilas.x + "," + sotilas.y, "0,2");
    }

    @Test
    public void aluksiVoiLiikkuaKaksiValk() {
        // testaa, että sotilasta on mahdollista siirtää aluksi 2 ruutua 
        Sotilas sotilas = new Sotilas(0, 0, 1, false);
        assertTrue(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,2"));
    }

    @Test
    public void aluksiVoiLiikkuaYhdenValk() {
        Sotilas sotilas = new Sotilas(0, 0, 1, false);
        assertTrue(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,1"));
    }

    @Test
    public void eiVoiLiikkuaTaakseValk() {
        Sotilas sotilas = new Sotilas(0, 7, 1, false);
        assertTrue(!sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,8"));
    }

    @Test
    public void eiPaaseLaudaltaPoisValk() {
        Sotilas sotilas = new Sotilas(0, 0, 1, false);
        assertFalse(sotilas.mahdollisetSiirrot(lauta.getLauta()).contains("0,-1"));
    }

    @Test
    public void eiVoiLiikkuaSivulleValk() {
        Sotilas sotilas = new Sotilas(0, 7, 1, false);
        sotilas.liiku(1, 1, lauta.getLauta());
        assertEquals(0, sotilas.x);
    }

    @Test
    public void eiVoiLiikkuaSivullePoisLaudaltaValk() {
        Sotilas sotilas = new Sotilas(0, 7, 1, false);
        sotilas.liiku(-1, 7, lauta.getLauta());
        assertEquals(0, sotilas.x);
    }

    @Test
    public void syotavaListallaMusta() {
        Sotilas musta = new Sotilas(0, 0, 0, false);
        Sotilas valkoinen = new Sotilas(1, 1, 1, false);
        lauta.asetaNappula(musta, 0, 0);
        lauta.asetaNappula(valkoinen, 1, 1);

        assertTrue(musta.mahdollisetSyonnit(lauta.getLauta()).contains("1,1"));
    }

    @Test
    public void syotavaListallaMusta2() {
        Sotilas musta = new Sotilas(6, 6, 0, false);
        Sotilas valkoinen = new Sotilas(5, 7, 1, false);
        lauta.asetaNappula(musta, 6, 6);
        lauta.asetaNappula(valkoinen, 5, 7);
        assertTrue(musta.mahdollisetSyonnit(lauta.getLauta()).contains("5,7"));
    }

    @Test
    public void syotavaListallaValk() {
        Sotilas musta = new Sotilas(0, 0, 0, false);
        Sotilas valkoinen = new Sotilas(1, 1, 1, false);
        lauta.asetaNappula(musta, 0, 0);
        lauta.asetaNappula(valkoinen, 1, 1);

        assertTrue(valkoinen.mahdollisetSyonnit(lauta.getLauta()).contains("0,0"));
    }

    @Test
    public void syotavaListallaValk2() {
        Sotilas mustas = new Sotilas(2, 0, 0, false);
        Sotilas valkoinen = new Sotilas(1, 1, 1, false);
        lauta.asetaNappula(mustas, 2, 0);
        lauta.asetaNappula(valkoinen, 1, 1);

        assertTrue(valkoinen.mahdollisetSyonnit(lauta.getLauta()).contains("2,0"));
    }
    @Test
    public void eiVoiSyodaOmanVaristaMusta() {
        Sotilas eka = new Sotilas(0, 0, 0, false);
        Sotilas toka = new Sotilas(1, 1, 0, false);
        lauta.asetaNappula(eka, 0, 0);
        lauta.asetaNappula(toka, 1, 1);

        assertFalse(eka.mahdollisetSyonnit(lauta.getLauta()).contains("1,1"));
    }

    @Test
    public void eiVoiSyodaOmanVaristaValk() {
        Sotilas eka = new Sotilas(0, 0, 1, false);
        Sotilas toka = new Sotilas(1, 1, 1, false);
        lauta.asetaNappula(eka, 0, 0);
        lauta.asetaNappula(toka, 1, 1);

        assertFalse(toka.mahdollisetSyonnit(lauta.getLauta()).contains("0,0"));
    }

}
