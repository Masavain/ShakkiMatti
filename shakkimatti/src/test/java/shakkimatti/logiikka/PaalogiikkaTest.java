/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkimatti.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Masavain
 */
public class PaalogiikkaTest {

    private Paalogiikka peli;

    public PaalogiikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new Paalogiikka();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testaaAlustus() {
        Pelilauta lauta = peli.getPelilauta();
        assertEquals(lauta.toString(), "TRLQKLRT\n"
                + "SSSSSSSS\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "........\n"
                + "SSSSSSSS\n"
                + "TRLQKLRT\n");
    }

    @Test
    public void testaaVuoro() {
        int ans = 1;
        assertEquals(ans, peli.getVuoro());
    }
}
