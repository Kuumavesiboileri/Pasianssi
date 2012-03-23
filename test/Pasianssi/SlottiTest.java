/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

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
public class SlottiTest {
    Slotti slotti;
    
    public SlottiTest() {
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
        slotti = new Slotti(new PinoFaceUp(), alapino);            
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
    public void YlinKorttiOikeinPaallimmainenOikeinPainFalse(){
        slotti.setPaalle(new Kortti(Maa.HERTTA, 5));
        assertTrue(slotti.paallimmainenOikeinpain());
    }
    @Test
    public void LisaaminenJaPoistoToimii(){
        slotti.setPaalle(new Kortti(Maa.HERTTA, 5));
        
        Kortti kortti = slotti.removeKortti();
        assertEquals(5,kortti.getArvo());
        assertFalse(slotti.paallimmainenOikeinpain());
    }
    @Test
    public void TyhjataanPakka(){
        while (!slotti.isEmpty()){
            
            slotti.kaannaPaalle();
            slotti.removeKortti();
        }
        assertTrue(slotti.isEmpty());
    }
    
}
