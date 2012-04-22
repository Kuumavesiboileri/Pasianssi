/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Pasianssi.Sovellus;
import Pasianssi.UserInterface;

/**
 *
 * @author atte
 */
public class koeAjo {
    
    public static void main(String[] args){
        UserInterface gui = new GUISovellus();
        Sovellus sovellus = new Sovellus(gui);
        gui.setSovellus(sovellus);
        sovellus.kaynnista();
        
    }
    
}
