/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Korttipakka;

import Korttipakka.Maalipakka;
import Kortti.Maa;
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
public class MaalipakkaTest {
    Maalipakka maalipakka;
    public MaalipakkaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        maalipakka = new Maalipakka();
    }
    
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tyhjaanMaalipakkaanEiVoiLaittaaEiAssaa(){
        assertFalse(maalipakka.voikoLaittaa(new Kortti(Maa.HERTTA, 2)));
    }
    
    @Test
    public void pakanTayttaminenToimiiLaillisillaSiirroilla(){
       for(int i = 1; i < 14; i++){
           Kortti kortti = new Kortti(Maa.HERTTA,i);
           if(maalipakka.voikoLaittaa(kortti))
               maalipakka.setKortti(kortti);
       }
       assertEquals(13,maalipakka.pakka.getKoko());
    }
    
    @Test
    public void laitonSiirtoAiheutuuMaasta(){
        for(int i=1; i < 6; i++)
            maalipakka.setKortti(new Kortti(Maa.HERTTA,i));
        assertFalse(maalipakka.voikoLaittaa(new Kortti(Maa.RUUTU, 6)));
        
    }
    @Test
    public void laitonSiirtoAiheutuuArvosta(){
        for(int i=1; i < 6; i++)
            maalipakka.setKortti(new Kortti(Maa.HERTTA,i));
        assertFalse(maalipakka.voikoLaittaa(new Kortti(Maa.HERTTA,7)));
        
    }
    @Test
    public void pakstaVoiOttaaPaallimmaisenKortin(){
        maalipakka.setKortti(new Kortti(Maa.PATA,1));
        maalipakka.removeKortti();
    }

}
