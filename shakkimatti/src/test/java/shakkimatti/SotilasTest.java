package shakkimatti;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

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
        lauta = new Pelilauta();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tarkastaLiikutettu() {
        // testaa, että liikutettu on liikkumisen jälkeen true
        Sotilas sotilas = (Sotilas)lauta.lauta[0][1];
        sotilas.liiku(0, 2);
        assertTrue(sotilas.liikutettu);
    }
    
    @Test
    public void aluksiVoiLiikkuaKaksi() {
        // testaa, että sotilasta on mahdollista siirtää aluksi 2 ruutua 
        Sotilas sotilas = (Sotilas)lauta.lauta[0][1];
        assertTrue(sotilas.mahdollisetSiirrot().contains("0,3"));
    }
    
    @Test
    public void aluksiVoiLiikkuaYhden() {
        Sotilas sotilas = (Sotilas)lauta.lauta[0][1];
        assertTrue(sotilas.mahdollisetSiirrot().contains("0,2"));
    }
    
    @Test
    public void siirtoLiikuttaa() {
        Sotilas sotilas = (Sotilas)lauta.lauta[0][1];
        sotilas.liiku(0, 2);
        assertEquals(sotilas.y, 2);
    }
}
