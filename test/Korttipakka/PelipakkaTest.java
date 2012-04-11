/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Korttipakka;

import Korttipakka.Pelipakka;
import Kortti.PinoFifo;
import Kortti.Kortti;
import Kortti.Maa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author atteaalt
 */
public class PelipakkaTest {
    Pelipakka slotti;
    
    public PelipakkaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        PinoFifo alapino = new PinoFifo();
        alapino.setKortti(new Kortti(Maa.RUUTU, 1));
        alapino.setKortti(new Kortti(Maa.PATA, 7));
        slotti = new Pelipakka(alapino);            
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void isEmpty(){
        assertFalse(slotti.isEmpty());
    }
            
    @Test
    public void YlinKorttiVaarinpainPaallimmainenOikeinPainFalse(){
        assertFalse(slotti.paallimmainenOikeinpain());
    }
    @Test
    public void YlinKorttiOikeinPaallimmainenOikeinPainTrue(){
        slotti.setKortti(new Kortti(Maa.HERTTA, 5));
        assertTrue(slotti.paallimmainenOikeinpain());
    }
    @Test
    public void LisaaminenJaPoistoToimii(){
        slotti.setKortti(new Kortti(Maa.HERTTA, 5));
        
        Kortti kortti = slotti.removeKortti();
        assertEquals(5,kortti.getArvo());
        assertFalse(slotti.paallimmainenOikeinpain());
    }
    @Test
    public void voikoLaittaaMetodiToimiiOdotetustiJosNumerotEiTäsmää(){
        slotti.setKortti(new Kortti(Maa.PATA, 11));
        assertFalse(slotti.voikoLaittaa(new Kortti(Maa.HERTTA, 13)));
        
    }
    
    @Test
    public void voikoLaittaaMetodiToimiiOdotetustiJosMaatEiTäsmää(){
        slotti.setKortti(new Kortti(Maa.PATA, 12));
        assertFalse(slotti.voikoLaittaa(new Kortti(Maa.RISTI, 11)));
    }
    
    @Test
    public void LaillinenLisaaminenOnnistuu(){
        slotti.setKortti(new Kortti(Maa.PATA, 12));
        assertTrue(slotti.voikoLaittaa(new Kortti(Maa.RUUTU, 11)));
    }
    @Test
    public void TyhjataanAlapinoKaantamallaKorttiKerrallaanYlapinoonJaPoistamalla(){
        while (!slotti.isEmpty()){
            
            slotti.kaannaPaalle();
            slotti.removeKortti();
        }
        assertTrue(slotti.isEmpty());
    }
    
}
