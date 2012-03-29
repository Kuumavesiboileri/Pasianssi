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
        slotti = new Pelipakka(new PinoFaceUp(), alapino);            
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
        slotti.setPaalleLaittomasti(new Kortti(Maa.HERTTA, 5));
        assertTrue(slotti.paallimmainenOikeinpain());
    }
    @Test
    public void LisaaminenJaPoistoToimii(){
        slotti.setPaalleLaittomasti(new Kortti(Maa.HERTTA, 5));
        
        Kortti kortti = slotti.removeKortti();
        assertEquals(5,kortti.getArvo());
        assertFalse(slotti.paallimmainenOikeinpain());
    }
    @Test
    public void LaillinenLisaaminenEiOnnistuJosNumerotEiTäsmää(){
        slotti.setPaalleLaittomasti(new Kortti(Maa.PATA, 11));
        assertFalse(slotti.setPaalle(new Kortti(Maa.HERTTA, 13)));
        assertEquals(1,slotti.paallimmaistenKoko());
        
    }
    
    @Test
    public void LaillinenLisaaminenEiOnnistuJosMaatEiTäsmää(){
        slotti.setPaalleLaittomasti(new Kortti(Maa.PATA, 12));
        assertFalse(slotti.setPaalle(new Kortti(Maa.RISTI, 11)));
        assertEquals(slotti.paallimmaistenKoko(),1);
    }
    
    @Test
    public void LaillinenLisaaminenOnnistuu(){
        slotti.setPaalleLaittomasti(new Kortti(Maa.PATA, 12));
        assertTrue(slotti.setPaalle(new Kortti(Maa.RUUTU, 11)));
        assertEquals(slotti.paallimmaistenKoko(),2);
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
