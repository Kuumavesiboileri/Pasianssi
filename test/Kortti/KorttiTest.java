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
        Maa ruutu = Maa.RUUTU;
        Maa risti = Maa.RISTI;
        Maa hertta = Maa.HERTTA;
        
        
        ruutuAssa = new Kortti (ruutu ,1);
        herttaViisi = new Kortti(hertta ,5);
        herttaAssa = new Kortti (hertta, 1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void maidenVertausToimii(){
        assertTrue(herttaViisi.samaaMaata(herttaAssa));
    }
    
    @Test
    public void varienVertausToimii(){
        assertTrue(ruutuAssa.samaaVaria(herttaViisi));
    }
    
}
