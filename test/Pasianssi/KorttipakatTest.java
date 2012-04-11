/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

import Kortti.Kortti;
import Korttipakka.Jakopakka;
import Korttipakka.PakkaRajapinta;
import Korttipakka.Pelipakka;
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
public class KorttipakatTest {
    private Korttipakat pakat;
    
    public KorttipakatTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        pakat = new Korttipakat();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPakka method, of class Korttipakat.
     */
    @Test
    public void konsturktoriLuoKaikkiMaalipakat(){
        for(int i = 0; i < 4; i++){
            assertNotNull(pakat.getPakka("maalipakka" , i));
        }
    }
    @Test
    public void konstruktoriLuoKaikkiPelipakatOikein(){
        for(int i = 0; i < 7; i++){
            Pelipakka pakka = (Pelipakka) pakat.getPakka("pelipakka" , i);
            int lkm = 0;
            while(!pakka.isEmpty()){
                pakka.removeKortti();
                pakka.kaannaPaalle();
                lkm ++;
            }
            assertEquals(i, lkm -1);
        }
    }
    @Test
    public void konstruktoriLuoJakopakanOikein(){
        Jakopakka pakka = (Jakopakka) pakat.getPakka("jakopakka", 0);
        assertEquals(24,pakka.size());
    }
    
}
