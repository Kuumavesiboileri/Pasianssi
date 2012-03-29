/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

import Kortti.Kortti;
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
public class KorttiTest {
    
    Kortti ruutuAssa;
    Kortti herttaViisi;
    Kortti herttaAssa;
    Kortti ristiSeiska;
    
    public KorttiTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {        
        
        ruutuAssa = new Kortti (Maa.RUUTU ,1);
        herttaViisi = new Kortti(Maa.HERTTA ,5);
        herttaAssa = new Kortti (Maa.HERTTA, 1);
        ristiSeiska = new Kortti (Maa.RISTI, 7);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void maidenVertausToimiiJosSamaaMaata(){
        assertTrue(herttaViisi.samaaMaata(herttaAssa));
    }
    @Test
    public void maidenVertausToimiiJosEriMaata(){
        assertFalse(herttaViisi.samaaMaata(ristiSeiska));
    }
    @Test
    public void varienVertausToimiiJosSamaaVaria(){
        assertTrue(ruutuAssa.samaaVaria(herttaViisi));
    }
    @Test
    public void varienVertausToimiiJosEriVaria(){
        assertFalse(ruutuAssa.samaaMaata(ristiSeiska));
    }
    
}
