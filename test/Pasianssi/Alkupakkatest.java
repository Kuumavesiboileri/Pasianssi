/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

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
public class Alkupakkatest {
    
    private Alkupakka pakka;
    
    public Alkupakkatest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
         pakka = new Alkupakka();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriLuoKokoPinon() {
        assertEquals(52,pakka.getPakka().size());
    }
}
