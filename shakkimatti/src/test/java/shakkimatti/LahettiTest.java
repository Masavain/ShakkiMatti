package shakkimatti;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LahettiTest {

    private Pelilauta lauta;

    public LahettiTest() {
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
    public void eiLiikuJosEiMahdollinenSiirto() {
        Lahetti lahetti = new Lahetti(2, 0, 0);
        lahetti.liiku(2, 2, lauta.getLauta());
        assertEquals(lahetti.x + "," + lahetti.y, "2,0");
    }

    @Test
    public void liikkuuOikeaanKoordinaattiin() {
        Lahetti lahetti = new Lahetti(2, 0, 0);
        lahetti.liiku(1, 1, lauta.getLauta());
        assertEquals(lahetti.x + "," + lahetti.y, "1,1");
    }

    @Test
    public void eiPaaseLaudaltaPois() {
        Lahetti lahetti = new Lahetti(2, 0, 0);
        lahetti.liiku(0, -2, lauta.getLauta());
        assertEquals(lahetti.x + "," + lahetti.y, "2,0");
    }
}
