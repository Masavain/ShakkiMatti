
package shakkimatti.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkimatti.logiikka.Peliapu;
import shakkimatti.gui.Pelilauta;
import shakkimatti.nappulat.Kuningas;

public class PeliapuTest {
    
    public PeliapuTest() {
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
        Peliapu apu = new Peliapu();
        
        apu.pelilauta.asetaNappula(new Kuningas(0,0,0), 0, 0);
        assertTrue(apu.validiSiirrettava(0, 0, 0));
    }
    
    @Test
    public void testaaValidiSiir2(){
        Peliapu apu = new Peliapu();
        
        apu.pelilauta.asetaNappula(new Kuningas(0,0,0), 0, 0);
        assertFalse(apu.validiSiirrettava(1, 0, 0));
    }
    
}
