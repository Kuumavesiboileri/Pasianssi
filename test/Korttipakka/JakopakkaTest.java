/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Korttipakka;


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


public class JakopakkaTest {
    
    Jakopakka pakka;
    
    public JakopakkaTest(){
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        LinkedList<Kortti> lista = new LinkedList<Kortti>();
        for(int i = 1; i < 14; i++)
            lista.add(new Kortti(Maa.HERTTA, i));
        pakka = new Jakopakka(lista);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void eiYhtaanOikeinpainOlevaaKorttiaGetKuvaKortinSelkapuoli() {
        assertEquals(0,pakka.getKuva().getFirst().getArvo());
    }
    @Test
    public void removePaallimmainenPalauttaaPaallimmaisenKortinJosTuoOnViimeksiKaannetyissa(){
        pakka.kaannaPaalle();
        assertEquals(11, pakka.removeKortti().getArvo());
    }
    @Test
    public void removePaallimmainenPalauttaaPaallimmaisenKortinJosTuoEiOleViimeksiKaannetyissa(){
        pakka.kaannaPaalle();
        pakka.kaannaPaalle();
        pakka.removeKortti();
        pakka.removeKortti();
        pakka.removeKortti();
        assertEquals(11, pakka.removeKortti().getArvo());
        
    }
    @Test
    public void getPaallimmaisetPalauttaaViimeksiKaannetytKolmeKorttia(){
        pakka.kaannaPaalle();
        LinkedList<Kortti> paallimmaiset = pakka.getKuva();
        assertEquals(11,paallimmaiset.getLast().getArvo());
    }
    @Test
    public void getPaallimmaisetPalauttaaViimeksiKaannetytKaksiKorttiaJosKaannetyistaYksiKaytetty(){
        pakka.kaannaPaalle();
        pakka.removeKortti();
        LinkedList<Kortti> paallimmaiset = pakka.getKuva();
        assertEquals(12, paallimmaiset.getLast().getArvo());
        assertEquals(2, paallimmaiset.size());
        
    }
    
}
