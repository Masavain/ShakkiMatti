
package shakkimatti;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KuningatarTest {
    
    private Pelilauta lauta;
    public KuningatarTest() {
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
        Kuningatar kuningatar = new Kuningatar(3,0,0);
        kuningatar.liiku(8, 8, lauta.getLauta());
        assertEquals(kuningatar.x+","+kuningatar.y, "3,0");
    }
    
    @Test
    public void liikkuuOikeaanKoordinaattiin(){
        Kuningatar kuningatar = new Kuningatar(3,0,0);
        kuningatar.liiku(3, 5, lauta.getLauta());
        assertEquals(kuningatar.x+","+kuningatar.y, "3,5");
    }
    
    @Test
    public void eiPaaseLaudaltaPois(){
        Kuningatar kuningatar = new Kuningatar(3,0,0);
        kuningatar.liiku(0, -2, lauta.getLauta());
        assertEquals(kuningatar.x+","+kuningatar.y, "3,0");
    }
}
