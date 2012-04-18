/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Komennot;

import Pasianssi.Korttipakat;
import java.util.HashMap;

/**
 *
 * @author atte
 */
public class Lopeta extends Komento {
    
    public Lopeta(Korttipakat korttipakat) {
        super(korttipakat);
    }
    @Override
    public boolean suorita(HashMap<String, String> syote){
        System.exit(0);
        return true;
    }
}
