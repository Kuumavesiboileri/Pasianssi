/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Komennot;

import Pasianssi.Korttipakat;
import java.util.HashMap;

/**
 * Rajapinta pelin komennoille.
 * @author Adio
 */
public abstract class Komento {
    protected Korttipakat korttipakat;
    
    public Komento(Korttipakat korttipakat){
        this.korttipakat = korttipakat;
    }
    public abstract boolean suorita(HashMap<String, String> syote);
}
