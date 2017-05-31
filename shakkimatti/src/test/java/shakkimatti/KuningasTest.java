
package shakkimatti;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KuningasTest {
    
    private Pelilauta lauta;
    public KuningasTest() {
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
    public void eiLiikuJosEiMahdollinenSiirto(){
        Kuningas kingi = new Kuningas(4,0,0);
        kingi.liiku(8, 8, lauta.getLauta());
        assertEquals(kingi.x+","+kingi.y, "4,0");
    }
    
    @Test
    public void liikkuuOikeaanKoordinaattiin(){
        Kuningas kingi = new Kuningas(4,0,0);
        kingi.liiku(4, 1, lauta.getLauta());
        assertEquals(kingi.x+","+kingi.y, "4,1");
    }
    
    @Test
    public void eiPaaseLaudaltaPois(){
        Kuningas kingi = new Kuningas(4,0,0);
        kingi.liiku(0, -2, lauta.getLauta());
        assertEquals(kingi.x+","+kingi.y, "4,0");
    }
}
