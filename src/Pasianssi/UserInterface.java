/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

import Komennot.Komento;
import java.util.HashMap;

/**
 *
 * @author Adio
 */
public interface UserInterface {
    public void setSovellus(Sovellus sovellus);
    public HashMap<String, String> getKomento();
    public void out(String line);
    
    public void alusta();
    public void update();
}
