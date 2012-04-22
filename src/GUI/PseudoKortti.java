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
public class PseudoKortti {
    private Scanner lukija;
    private String pakka;
    private int pakanJarjestysnumero;
    private int kortinJarjestysnumero;
    
    
    public PseudoKortti(String kortinNimi){
        lukija = new Scanner(kortinNimi);
        pakka = lukija.next();
        pakanJarjestysnumero = Integer.valueOf(lukija.next());
        kortinJarjestysnumero = Integer.valueOf(lukija.next());
    }
    
    public String getPakka(){
        return pakka;
    }
    
    public int getpakanJarjestysnumero(){
        return pakanJarjestysnumero;
    }
    public int getkortinJarjestysnumero(){
        return kortinJarjestysnumero;
    }
}

