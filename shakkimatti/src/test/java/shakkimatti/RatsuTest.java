
package shakkimatti;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RatsuTest {
    
    
    public RatsuTest() {
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
        Ratsu ratsu = new Ratsu(1,0,0);
        ratsu.liiku(1, 1);
        assertEquals(ratsu.x+","+ratsu.y, "1,0");
    }
    
    @Test
    public void liikkuuOikeaanKoordinaattiin(){
        Ratsu ratsu = new Ratsu(1,0,0);
        ratsu.liiku(0, 2);
        assertEquals(ratsu.x+","+ratsu.y, "0,2");
    }
    
    @Test
    public void eiPaaseLaudaltaPois(){
        Ratsu ratsu = new Ratsu(1,0,0);
        ratsu.liiku(0, -2);
        assertEquals(ratsu.x+","+ratsu.y, "1,0");
    }
}
