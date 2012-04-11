/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextUI;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author atte
 */
public class AnalysoijaTest {
    private Analysoija analysoija;
    public AnalysoijaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        analysoija = new Analysoija();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of muokkaaHashTaulukoksi method, of class Analysoija.
     */
    @Test
    public void muokkaaHashTaulukoksiToimiiOikeallaSiirraSyotteela() {
        String syote = "siirrä jakopakka 1 maalipakka 3";
        //System.out.println(analysoija.muokkaaHashTaulukoksi(syote));
        HashMap<String,String> komennot = analysoija.muokkaaHashTaulukoksi(syote);
        assertEquals("siirrä", komennot.get("komento"));
        assertEquals("jakopakka", komennot.get("mistä"));
    }
    @Test
    public void muokkaaHashTaulukoksiToimiiOikeallaSiirraMontaSyotteela() {
        String syote = "siirrä pelipakka 3 pelipakka 2 4";
        HashMap<String,String> komennot = analysoija.muokkaaHashTaulukoksi(syote);
        assertEquals("siirräMonta", komennot.get("komento"));
        assertEquals("pelipakka", komennot.get("mihin"));
        assertTrue(komennot != null);
    }
    @Test
    public void muokkaaHashTaulukoksiEiToimiJosPakkaJostaSiirretaanVaarin() {
        String syote = "siirrä peliakka 3 pelipakka 2";
        assertNull(analysoija.muokkaaHashTaulukoksi(syote));
    }
    @Test
    public void muokkaaHashTaulukoksiEiToimiJosPakkaJohonSiirretaanVaarin() {
        String syote = "siirrä pelipakka 3 peliakka 2";
        assertNull(analysoija.muokkaaHashTaulukoksi(syote));
    }
    
    
    @Test
    public void muokkaaHashTaulukoksiEiToimiJosPakkastaSiirretaanJarjestysnumeroEiNumero() {
        String syote = "siirrä pelipakka kolme pelipakka 2";
        assertNull(analysoija.muokkaaHashTaulukoksi(syote));
    }
    
    @Test
    public void muokkaaHashTaulukoksiEiToimiJosPakkaJohonSiirretaanJarjestysnumeroEiNumero() {
        String syote = "siirrä pelipakka 3 pelipakka kaksi";
        assertNull(analysoija.muokkaaHashTaulukoksi(syote));
    }
    @Test
    public void muokkaaHashTaulukoksiEiToimiJosKomentoVaarin(){
        String syote = "siirra pelipakka 3 pelipakka 2";
        assertNull(analysoija.muokkaaHashTaulukoksi(syote));
    }
}
