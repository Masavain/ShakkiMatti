package shakkimatti;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class SotilasTest {
    
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tarkastaLiikutettu() {
        // testaa, että liikutettu on liikkumisen jälkeen true
        Sotilas sotilas = new Sotilas(0,1,0);
        sotilas.liiku(0, 2);
        assertTrue(sotilas.liikutettu);
    }
    
    @Test
    public void liikkuuOikeaanKoordinaattiin() {
        // testaa, että liikutettu on liikkumisen jälkeen true
        Sotilas sotilas = new Sotilas(0,1,0);
        sotilas.liiku(0, 2);
        assertEquals(sotilas.x+","+sotilas.y, "0,2");
    }
    
    @Test
    public void aluksiVoiLiikkuaKaksi() {
        // testaa, että sotilasta on mahdollista siirtää aluksi 2 ruutua 
        Sotilas sotilas = new Sotilas(0,1,0);
        assertTrue(sotilas.mahdollisetSiirrot().contains("0,3"));
    }
    
    @Test
    public void aluksiVoiLiikkuaYhden() {
        Sotilas sotilas = new Sotilas(0,1,0);
        assertTrue(sotilas.mahdollisetSiirrot().contains("0,2"));
    }
        
    @Test
    public void eiVoiLiikkuaTaakse() {
        Sotilas sotilas = new Sotilas(0,1,0);
        assertTrue(!sotilas.mahdollisetSiirrot().contains("0,0"));
    }
    
    @Test
    public void eiPaaseLaudaltaPois() {
        Sotilas sotilas = new Sotilas(0,8,0);
        assertTrue(!sotilas.mahdollisetSiirrot().contains("0,9"));
    }
    
    @Test
    public void eiVoiLiikkuaSivulle() {
        Sotilas sotilas = new Sotilas(0,1,0);
        sotilas.liiku(1, 1);
        assertEquals(0, sotilas.x);
    }
    
    @Test
    public void eiVoiLiikkuaSivullePoisLaudalta() {
        Sotilas sotilas = new Sotilas(0,1,0);
        sotilas.liiku(-1, 1);
        assertEquals(0, sotilas.x);
    }
}
