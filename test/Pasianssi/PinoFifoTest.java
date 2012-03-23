/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

import Kortti.*;
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
public class PinoFifoTest {
    
    private PinoFifo pino;
    
    public PinoFifoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        pino = new PinoFifo();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getKokoNayttaaOikein(){
        Maa ruutu = Maa.RUUTU;
        for(int i = 0; i < 5; i++)
            pino.setKortti(new Kortti(ruutu, 2));
        assertEquals(5, pino.getKoko());
        for(int i = 0; i < 3; i++)
            pino.setKortti(new Kortti(ruutu, 2));
        assertEquals(8, pino.getKoko());
    }
  
    @Test
    public void listaanJaPoistetaanYksiKortti(){
        Maa pata = Maa.PATA;
        pino.setKortti(new Kortti(pata, 1));
        assertEquals(1, pino.removeKortti().getArvo());
    }
    
    @Test
    public void listaanJaPoistetaanKolmeKorttia(){
        Maa pata = Maa.PATA;
        pino.setKortti(new Kortti(pata, 1));
        pino.setKortti(new Kortti(pata, 2));
        pino.setKortti(new Kortti(pata, 3));
        assertEquals(3, pino.removeKortti().getArvo());
        assertEquals(2, pino.removeKortti().getArvo());
        assertEquals(1, pino.removeKortti().getArvo());
    }
}
