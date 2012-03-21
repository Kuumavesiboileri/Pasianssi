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
public class KorttipinoTest {
    
    private Korttipino pino;
    
    public KorttipinoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        pino = new Korttipino();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getKokoNayttaaOikein(){
        for(int i = 0; i < 5; i++)
            pino.setKortti(new Kortti("ruutu", 2));
        assertEquals(5, pino.getKoko());
        for(int i = 0; i < 3; i++)
            pino.setKortti(new Kortti("ruutu", 2));
        assertEquals(8, pino.getKoko());
    }
  
    @Test
    public void listaanJaPoistetaanYksiKortti(){
        pino.setKortti(new Kortti("pata", 1));
        assertEquals(1, pino.getKortti().getArvo());
    }
    
    @Test
    public void listaanJaPoistetaanKolmeKorttia(){
        pino.setKortti(new Kortti("pata", 1));
        pino.setKortti(new Kortti("pata", 2));
        pino.setKortti(new Kortti("pata", 3));
        assertEquals(3, pino.getKortti().getArvo());
        assertEquals(2, pino.getKortti().getArvo());
        assertEquals(1, pino.getKortti().getArvo());
    }
}
