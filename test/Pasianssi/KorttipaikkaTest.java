/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

import Kortti.Kortti;
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
public class KorttipaikkaTest {
    
    Korttipaikka paikka;
    
    public KorttipaikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        paikka = new Korttipaikka();
        paikka.setKortti(new Kortti("pata", 1));
        paikka.setKortti(new Kortti("pata", 2));
        paikka.setKortti(new Kortti("pata", 3));
        paikka.setKortti(new Kortti("pata", 4));
        paikka.setKortti(new Kortti("pata", 5));
        paikka.setKortti(new Kortti("pata", 6));
        paikka.setKortti(new Kortti("pata", 7));
        paikka.setKortti(new Kortti("pata", 8));
        paikka.setKortti(new Kortti("pata", 9));
        paikka.setKortti(new Kortti("pata", 10));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getKortti method, of class Korttipaikka.
     */
    /*@Test(expected = IndexOutOfBoundsException.class)
    public void liianSuuriIndeksiAiheuttaaVirheen(){
        paikka.getKortti(11);
    }*/
    
    @Test 
    public void lisataanKymmenenJaPoistetaanNeljaKorttiaPoistetutOikein(){
        LinkedList<Kortti> dummy = paikka.getKortti(4);
        assertEquals(4,dummy.size());
    }
    
    @Test
    public void lisataanKymmenenJaPoistetaanNeljaKorttiaJaljelleJaaOikeaMaara(){
        paikka.getKortti(4);
        assertEquals(6, paikka.getKoko());
    }
    
    @Test
    public void poisetaanPaikastaKorttejaKortitOikeassaJarjestyksessa(){
        LinkedList<Kortti> dummy = paikka.getKortti(4);
        assertEquals(10, dummy.getLast().getArvo());
    }    
    
    
}
