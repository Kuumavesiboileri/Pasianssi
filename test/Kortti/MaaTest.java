/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

import Kortti.Maa;
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
public class MaaTest {
    
    public MaaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void virheellinenMaaSyotePaatyyVirheilmoitukseen() throws Exception{
        new Maa("saf");
    }
    
    @Test
    public void maanLuontiToimiiSallituissaPuitteissa(){
        new Maa("hertta");
        new Maa("pata");
        new Maa("risti");
        new Maa("ruutu");
    }
    @Test
    public void samojenMaidenEqualsTrue(){
        Maa eka = new Maa("hertta");
        Maa toka = new Maa("hertta");
        assertTrue(eka.equals(toka));
    }
    @Test
    public void eriMaidenEqualsFalse(){
        Maa eka = new Maa("hertta");
        Maa toka = new Maa("pata");
        assertFalse(eka.equals(toka));
    }
    @Test
    public void samojenVarienEqualsTrue(){
        Maa pata = new Maa("pata");
        Maa risti = new Maa("risti");
        Maa hertta = new Maa("hertta");
        Maa ruutu = new Maa("ruutu");
        
        assertTrue(pata.getVari() == risti.getVari());
        assertTrue(hertta.getVari() == ruutu.getVari());
    }
    
    @Test
    public void eriVarienEqualsFalse(){
        Maa risti = new Maa("risti");
        Maa hertta = new Maa("hertta");
        assertFalse(risti.getVari() == hertta.getVari());
    }
}
