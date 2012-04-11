/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

import Kortti.PinoFaceUp;
import Kortti.Kortti;
import Kortti.Maa;
import java.util.LinkedList;
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
public class PinoFaceUpTest {
    
    PinoFaceUp paikka;
    
    public PinoFaceUpTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        Maa pata = Maa.PATA;
        paikka = new PinoFaceUp();
        paikka.setKortti(new Kortti(pata, 1));
        paikka.setKortti(new Kortti(pata, 2));
        paikka.setKortti(new Kortti(pata, 3));
        paikka.setKortti(new Kortti(pata, 4));
        paikka.setKortti(new Kortti(pata, 5));
        paikka.setKortti(new Kortti(pata, 6));
        paikka.setKortti(new Kortti(pata, 7));
        paikka.setKortti(new Kortti(pata, 8));
        paikka.setKortti(new Kortti(pata, 9));
        paikka.setKortti(new Kortti(pata, 10));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getKortti method, of class PinoFaceUp.
     */
    /*@Test(expected = IndexOutOfBoundsException.class)
    public void liianSuuriIndeksiAiheuttaaVirheen(){
        paikka.getKortti(11);
    }*/
    
    @Test
    public void kolmanneksiPäällimmäinenKorttiOnOikein(){
        assertEquals(8,paikka.getKortti(3).getArvo());
    }
    @Test 
    public void lisataanKymmenenJaPoistetaanNeljaKorttiaPoistetutOikein(){
        
        PinoFaceUp dummy = paikka.removeKortti(4);
        assertEquals(4,dummy.getKoko());
    }
    
    @Test
    public void lisataanKymmenenJaPoistetaanNeljaKorttiaJaljelleJaaOikeaMaara(){
        paikka.removeKortti(4);
        assertEquals(6, paikka.getKoko());
    }
        @Test(expected = IndexOutOfBoundsException.class)
    public void lisataanKymmenenJaPoistetaanYksitoistaPaatyyVirheilmoitukseen(){
        paikka.removeKortti(11);
        
    }
    @Test
    public void poisetaanPaikastaKorttejaKortitOikeassaJarjestyksessa(){
        PinoFaceUp dummy = paikka.removeKortti(4);
        assertEquals(10, dummy.removeKortti().getArvo());
    }    
    
    
}
