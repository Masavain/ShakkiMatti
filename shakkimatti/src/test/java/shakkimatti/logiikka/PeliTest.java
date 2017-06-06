
package shakkimatti.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkimatti.logiikka.Peli;
import shakkimatti.gui.Pelilauta;
import shakkimatti.nappulat.Kuningas;

public class PeliTest {
    
    public PeliTest() {
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
    public void testaaValidiSiir(){
        Peli peli = new Peli();
        
        peli.pelilauta.asetaNappula(new Kuningas(0,0,0), 0, 0);
        assertTrue(peli.validiSiirrettava(0, 0, 0));
    }
    
    @Test
    public void testaaValidiSiir2(){
        Peli apu = new Peli();
        
        apu.pelilauta.asetaNappula(new Kuningas(0,0,0), 0, 0);
        assertFalse(apu.validiSiirrettava(1, 0, 0));
    }
    
}
