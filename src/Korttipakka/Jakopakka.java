/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Korttipakka;

import Kortti.PinoFifo;
import Kortti.Kortti;
import java.util.LinkedList;

/**
 *Luokalla toteutetaan ns jakopakka pasianssi -peliin. PakkaRajapinta koostuu yhdestä väärin- 
 * ja yhdestä oikeinpäin käännetystä pakasta. Väärinpäin olevasta voi halutessaan kääntää 
 * kolme päällimmäistä korttia oikeinpäin käännettyyn pakkaan. Oikeinpäin olevasta pakasta 
 * näkyy maksimissaan kolme päällimmäistä.
 * @author Adio
 */
public class Jakopakka implements PakkaRajapinta{
    private PinoFifo vaarinpain;
    private PinoFifo oikeinpain;
    /**
     * Viimeisessä päällekäännössä käännetyt korit. Koko vaihtelee välillä [0,3]
     */
    private LinkedList<Kortti> paallimmaiset;
    
    public Jakopakka(LinkedList<Kortti> vaarinpain){
        this.vaarinpain = new PinoFifo(vaarinpain);
        this.oikeinpain = new PinoFifo();
        this.paallimmaiset = new LinkedList<Kortti>();
    }
   /**
     * Palauttaa (ja poistaa jakopakasta) viimeisessä käännössä käännetyyjen korttien päällimmäisen kortin
     * Jos tämä viimeisen käännön lista on tyhjä, palauttaa päällimmäisen oikeinpäin olevan kortin.
     * 
     * @return viimeisessä käännössä käännetty päällimmäinen kortti, tai
     * ensimmäinen oikeinpäin oleva kortti.
     * 
     */
    @Override
    public Kortti removeKortti(){
        if(paallimmaiset.isEmpty()){
           
            if(oikeinpain.isEmpty())
               return null;
           
           return oikeinpain.removeKortti();
        }
        
        return paallimmaiset.removeLast();
    }
    
    /**
     * Palauttaa (muttei poista jakopakasta) viimeisessä käännössä käännetyyjen korttien päällimmäisen kortin
     * Jos tämä viimeisen käännön lista on tyhjä, palauttaa päällimmäisen oikeinpäin olevan kortin.
     * 
     * @return viimeisessä käännössä käännetty päällimmäinen kortti, tai
     * ensimmäinen oikeinpäin oleva kortti.
     * 
     */
    @Override 
    public Kortti getKortti(){
        if (paallimmaiset.isEmpty()){
            if(oikeinpain.isEmpty()){
                return null;
            }
            return oikeinpain.getKortti();
        }
        return paallimmaiset.getLast();
    }

    /**
     * Kaantaa väärinpäin olevasta pakasta kolme (tai vähemmän jos pakka loppuu kesken) 
     * päällimmäistä korttia korttia oikeinpäin olevan pakan päällimmäiseksi (eli siis 
     * erilliseen "päällimmäiset" listaan). Tämä tehdään sillä tavalla että kolmanneksi 
     * käännetty kortti on päällimmäisenä!
     */
    public void kaannaPaalle(){
        while(!paallimmaiset.isEmpty())
            oikeinpain.setKortti(paallimmaiset.removeFirst());
        
        while(paallimmaiset.size() < 3 && !vaarinpain.isEmpty())
            paallimmaiset.addLast(vaarinpain.removeKortti());
    }
    /**
     * Palauttaa aina arvon 'false', sillä jakopakkaan ei voida laittaa mitään.
     * @return false
     */
    @Override
    public void setKortti(Kortti kortti){
        return;
    }
    /**
     * Koska jakopakkaan ei voida laittaa kortteja palauttaa aina arvon false. 
     * @return false
     */
    @Override
    public boolean voikoLaittaa(Kortti paalle){
        return false;
    }
     /**
     * Palauttaa viimeisessä käännössä käännetyt kortit (listan "päällimmäiset").
     * Jos tämä lista on tyhjä, palauttaa päällimmäisen oikeinpäin olevan kortin.
     * 
     * @return viimeisessä käännössä käännetyt kortit, tai jos tämä tyhjä niin 
     * ensimmäinen oikeinpäin oleva kortti.
     * 
     */
    @Override
    public LinkedList<Kortti> getKuva(){
        if (paallimmaiset.isEmpty()){
            if(oikeinpain.isEmpty()){
                return null;
            }
            
            LinkedList<Kortti> palauta = new LinkedList<Kortti>();
            palauta.add(oikeinpain.getKortti());
            return palauta;
        }
        
        return paallimmaiset;
    }
    /**
     * Palauttaa pakan koon. Sekä oikein-, että väärinpäinkäännetyt.
     * @return Pakan koko.
     */
    public int size(){
        return vaarinpain.getKoko() + oikeinpain.getKoko() + paallimmaiset.size();
    }
}
