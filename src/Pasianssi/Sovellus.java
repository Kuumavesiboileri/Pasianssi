/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

import Komennot.*;
import Kortti.Kortti;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * Varsinainen Pasianssi -sovellus.
 * @author Adio
 */
public class Sovellus {
    UserInterface UI;
    Korttipakat korttipakat;
    HashMap<String, Komento> komentoTaulukko;
    
    public Sovellus(UserInterface UI){
        this.UI = UI;
        korttipakat = new Korttipakat();
        komentoTaulukko = setKomennot();        
    }
    /**
     * Main -metodista suoritettava komento, joka käynnistää pelin. Jatkuu, kunnes käsketään lopettamaan.
     */
    public void kaynnista(){
        UI.alusta();
        /*
        HashMap<String,String> komentoTyyppi;
        while(true){
            komentoTyyppi = UI.getKomento();
            if(komentoTyyppi.get("komento").equals("tyhjä"))
                continue;
            
            if(komentoTyyppi.get("komento").equals("virhe")){
                UI.out("virheellinen komento!");
                continue;
            }
            if(komentoTyyppi.get("komento").equals("laiton")){
                UI.out("laiton siirto!");
                continue;
            }
            if(komentoTyyppi.get("komento").equals("uusiPeli")){
                korttipakat = new Korttipakat();
                komentoTaulukko = setKomennot();
                UI.update();
                continue;
            }
            
            
            Komento komento = komentoTaulukko.get(komentoTyyppi.get("komento"));
            komento.suorita(komentoTyyppi);
            UI.update();
            
        }*/
        
    }
    
    /**
     * Hakee halutun pakan "kuvan". Eli halutun pakan oikeinpäin käännetyt kortit LinkedListinä.
     * @param pakkaId Halutun pakan tyyppi Stringinä.
     * @param i Halutun pakan järjestysnumero (jos Jakopakka, ei väliä mikä)
     * @return Linkitetty listä pakan oikeinpäin olevista korteista.
     */
    public LinkedList<Kortti> getKuva(String pakkaId, int i){
        return korttipakat.getPakanKuva(pakkaId, i);
    }
    /**
     * Kertoo, onko sovelluksen sisältämän Korttipakat -luokan olion jakopakassa väärinpäin olevia kortteja.
     * @return Onko jakopakassa väärinpäin olevia kortteja.
     */
    
    public boolean onkoJakopakassaVaarinpainKortteja(){
        return korttipakat.onkoJakopakassaVaarinpainKortteja();
    }

    /**
     * Metodi alustaa kaikki pelin komennot private HashMappiin.
     * @return Pelin käyttämät komennot.
     */
    private HashMap<String, Komento> setKomennot(){
        HashMap<String, Komento> palautettava = new HashMap<String, Komento>();
        palautettava.put("siirrä", new Siirra(korttipakat));
        palautettava.put("siirräMonta", new SiirraMonta(korttipakat));
        palautettava.put("käännä", new Kaanna(korttipakat));
        palautettava.put("lopeta", new Lopeta(korttipakat));
        return palautettava;
    }
}
