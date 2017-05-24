package shakkimatti;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelilautaTest {

    private Pelilauta lauta;

    public PelilautaTest() {
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
    public void testaaToStringTyhjallaLaudalla() {
        String tostring = lauta.toString();
        assertEquals("........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n", tostring);
    }
    
    @Test
    public void testaaPelinappuloidenPaikatAlustuksenJalkeen() {
        lauta.alustus();
        String tostring = lauta.toString();
        assertEquals("TRLQKLRT\n"
                + "SSSSSSSS\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "SSSSSSSS\n"
                + "TRLQKLRT\n", tostring);
    }

    @Test
    public void testaaToStringAlustuksenJaYhdenSiirronJalkeen() {
        lauta.alustus();

        Nappula namiska = lauta.lauta[1][1];
        lauta.siirto(namiska, 1, 2);

        String tostring = lauta.toString();
        assertEquals("TRLQKLRT\n"
                + "SSSSSSSS\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + ".S......\n"
                + "S.SSSSSS\n"
                + "TRLQKLRT\n", tostring);
    }

}
