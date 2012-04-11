/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Komennot;

import TextUI.Analysoija;
import Kortti.Maa;
import Kortti.PinoFifo;
import Kortti.Kortti;
import Korttipakka.Pelipakka;
import Korttipakka.PakkaRajapinta;
import Pasianssi.Korttipakat;
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
public class SiirraTest {
    
    private Siirra siirra;
    private HashMap<String,String> syote;
    private Pelipakka pakka1;
    private Pelipakka pakka2;
    private Analysoija analysoija;
    
    
    private Korttipakat korrtipakatStub = new Korttipakat() {  
        
        @Override
        public PakkaRajapinta getPakka(String pakka, int i){
            if(pakka.equals("pelipakka")){
                if(i == 1)
                    return pakka1;
                if(i == 2)
                    return pakka2;
            }
            return null;
            
        }
    };
    
    public SiirraTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {    
        pakka1 = new Pelipakka(new PinoFifo());
        pakka1.setKortti(new Kortti(Maa.PATA, 2));
        pakka2 = new Pelipakka(new PinoFifo());
        pakka2.setKortti(new Kortti(Maa.HERTTA, 3));
                
        analysoija = new Analysoija();
        
        siirra = new Siirra(korrtipakatStub);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void suoritusSiirtaaKortinPakastaToiseenJosSiirtoLaillinen(){
        syote = analysoija.muokkaaHashTaulukoksi("siirrä pelipakka 1 pelipakka 2");
        
        assertTrue(siirra.suorita(syote));
        assertNull(pakka1.getKortti());
        assertEquals(2, pakka2.getKortti().getArvo());
        assertEquals(3, pakka2.getKortti(2).getArvo());
    }
    
    @Test
    public void suoritusEiSiirraKorttiaPakastaToiseenJosSiirtoEiLaillinen(){
        syote = analysoija.muokkaaHashTaulukoksi("siirrä pelipakka 2 pelipakka 1");
        assertFalse(siirra.suorita(syote));
        assertEquals(2, pakka1.getKortti().getArvo());
        assertEquals(3, pakka2.getKortti().getArvo());
    }
 
}
