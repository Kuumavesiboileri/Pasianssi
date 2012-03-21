/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

import Kortti.Arvo;
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
public class ArvoTest {
    
    public ArvoTest() {
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
    public void liianSuuriArvoPaatyyVirheeseen() throws Exception {
         new Arvo(14);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void liianPieniArvoPaatyyVihreeseen() throws Exception {
        new Arvo(0);
    }
    
    @Test
    public void arvonLuontiToimiiAnnetuissaRajoissa(){
        new Arvo(5);
    }
    
    @Test
    public void compareToTulosPositiivinen(){
        Arvo suurempi = new Arvo(13);
        Arvo pienempi = new Arvo (4);
        assertTrue(suurempi.compareTo(pienempi) > 0);
    }
    
    
}
