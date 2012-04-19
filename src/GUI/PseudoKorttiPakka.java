/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Scanner;

/**
 *
 * @author atte
 */
public class PseudoKorttiPakka {
    private Scanner lukija;
    private String pakka;
    private int jarjestysnumero;
    
    public PseudoKorttiPakka(String kortinNimi){
        lukija = new Scanner(kortinNimi);
        pakka = lukija.next();
        jarjestysnumero = Integer.valueOf(lukija.next());
    }
    
    public String getPakka(){
        return pakka;
    }
    
    public int getJarjestysnumero(){
        return jarjestysnumero;
    }
}

