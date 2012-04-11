/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

import Komennot.*;
import Kortti.Kortti;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * Varsinainen Pasianssi -sovellus.
 * @author Adio
 */
public class Sovellus {
    UserInterface UI;
    Korttipakat korttipakat;
    Scanner lukija;
    HashMap<String, Komento> komentoTaulukko;
    
    public Sovellus(UserInterface UI){
        this.UI = UI;
        korttipakat = new Korttipakat();
        lukija = new Scanner(System.in);
        komentoTaulukko = setKomennot();
    }
    /**
     * Main -metodista suoritettava komento, joka käynnistää pelin. Jatkuu, kunnes käsketään lopettamaan.
     */
    public void kaynnista(){
        UI.alusta();
        
        HashMap<String,String> komentoTyyppi;
        while(true){
            komentoTyyppi = UI.getKomento();
            if(komentoTaulukko.get(komentoTyyppi.get("komento")) == null){
                UI.out("Komentoa ei löydy");
                continue;
            }
            Komento komento = komentoTaulukko.get("komento");
            komento.suorita(komentoTyyppi);
            
        }
        
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
     * Metodi alustaa kaikki pelin komennot private HashMappiin.
     * @return Pelin käyttämät komennot.
     */
    private HashMap<String, Komento> setKomennot(){
        HashMap<String, Komento> palautettava = new HashMap<String, Komento>();
        palautettava.put("siirra", new Siirra(korttipakat));
        return palautettava;
    }
}
