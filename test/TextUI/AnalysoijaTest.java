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
    private HashMap<String,String> virheellinenSyoteKartta;
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
        virheellinenSyoteKartta = new HashMap<String,String>();
        virheellinenSyoteKartta.put("komento", "virhe");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of muokkaaHashTaulukoksi method, of class Analysoija.
     */
    @Test
    public void siirraMuokkaaHashTaulukoksiToimiiOikeallaSiirraSyotteela() {
        String syote = "siirrä jakopakka 1 maalipakka 3";
        //System.out.println(analysoija.muokkaaHashTaulukoksi(syote));
        HashMap<String,String> komennot = analysoija.muokkaaHashTaulukoksi(syote);
        assertEquals("siirrä", komennot.get("komento"));
        assertEquals("jakopakka", komennot.get("mistä"));
    }
    @Test
    public void siirraMuokkaaHashTaulukoksiToimiiOikeallaSiirraMontaSyotteela() {
        String syote = "siirrä pelipakka 3 pelipakka 2 4";
        HashMap<String,String> komennot = analysoija.muokkaaHashTaulukoksi(syote);
        assertEquals("siirräMonta", komennot.get("komento"));
        assertEquals("pelipakka", komennot.get("mihin"));
        assertEquals("4" ,komennot.get("montako"));
    }
    @Test
    public void siirraMuokkaaHashTaulukoksiEiToimiJosPakkaJostaSiirretaanVaarin() {
        String syote = "siirrä peliakka 3 pelipakka 2";
        assertEquals(virheellinenSyoteKartta, analysoija.muokkaaHashTaulukoksi(syote));
    }
    @Test
    public void siirraMuokkaaHashTaulukoksiEiToimiJosPakkaJohonSiirretaanVaarin() {
        String syote = "siirrä pelipakka 3 peliakka 2";
        assertEquals(virheellinenSyoteKartta, analysoija.muokkaaHashTaulukoksi(syote));
    }
    
    
    @Test
    public void siirraMuokkaaHashTaulukoksiEiToimiJosPakkastaSiirretaanJarjestysnumeroEiNumero() {
        String syote = "siirrä pelipakka kolme pelipakka 2";
        assertEquals(virheellinenSyoteKartta,analysoija.muokkaaHashTaulukoksi(syote));
    }
    
    @Test
    public void siirraMuokkaaHashTaulukoksiEiToimiJosPakkaJohonSiirretaanJarjestysnumeroEiNumero() {
        String syote = "siirrä pelipakka 3 pelipakka kaksi";
        assertEquals(virheellinenSyoteKartta,analysoija.muokkaaHashTaulukoksi(syote));
    }
    @Test
    public void siirraMuokkaaHashTaulukoksiEiToimiJosKomentoVaarin(){
        String syote = "siirra pelipakka 3 pelipakka 2";
        assertEquals(virheellinenSyoteKartta,analysoija.muokkaaHashTaulukoksi(syote));
    }
    @Test
    public void kaannaMuokkaaHashTaulukoksiToimiiOikeallaSyotteella(){
        String syote = "käännä pelipakka 3";
        HashMap<String,String> komennot = analysoija.muokkaaHashTaulukoksi(syote);
        assertEquals("käännä", komennot.get("komento"));
    }
    @Test
    public void kaannaMuokkaaHashTaulukoksiEiToimiLiianLyhyellaSyotteella(){
        String syote = "käännä pelipakka";
        assertEquals(virheellinenSyoteKartta,analysoija.muokkaaHashTaulukoksi(syote));
        
    }
}
