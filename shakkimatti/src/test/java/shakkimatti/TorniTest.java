
package shakkimatti;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TorniTest {
    
    public TorniTest() {
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
    public void eiLiikuJosEiMahdollinenSiirto(){
        Torni torni = new Torni(0,0,0);
        torni.liiku(1, 1);
        assertEquals(torni.x+","+torni.y, "0,0");
    }
    
    @Test
    public void liikkuuOikeaanKoordinaattiin(){
        Torni torni = new Torni(0,0,0);
        torni.liiku(0, 2);
        assertEquals(torni.x+","+torni.y, "0,2");
    }
    
    @Test
    public void eiPaaseLaudaltaPois(){
        Torni torni = new Torni(0,0,0);
        torni.liiku(0, -2);
        assertEquals(torni.x+","+torni.y, "0,0");
    }
}
