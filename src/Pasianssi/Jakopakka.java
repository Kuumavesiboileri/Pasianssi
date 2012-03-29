/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

import Kortti.Kortti;
import java.util.LinkedList;

/**
 *Luokalla toteutetaan ns jakopakka pasianssi -peliin. Pakka koostuu yhdestä väärin- 
 * ja yhdestä oikeinpäin käännetystä pakasta. Väärinpäin olevasta voi halutessaan kääntää 
 * kolme päällimmäistä korttia oikeinpäin käännettyyn pakkaan. Oikeinpäin olevasta pakasta 
 * näkyy maksimissaan kolme päällimmäistä.
 * @author Adio
 */
public class Jakopakka {
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
     * Palauttaa viimeisessä käännössä käännetyt kortit (listan "päällimmäiset").
     * Jos tämä lista on tyhjä, palauttaa päällimmäisen oikeinpäin olevan kortin.
     * 
     * @return viimeisessä käännössä käännetyt kortit, tai jos tämä tyhjä niin 
     * ensimmäinen oikeinpäin oleva kortti.
     * 
     */
    public LinkedList<Kortti> getPaallimmaiset(){
        if (paallimmaiset.isEmpty()){
            if(oikeinpain.isEmpty()){
                return null;
            }
            
            LinkedList<Kortti> palauta = new LinkedList<Kortti>();
            palauta.add(oikeinpain.removeKortti());
            return palauta;
        }
        
        return paallimmaiset;
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
            paallimmaiset.addLast(vaarinpain.getKortti());
    }
}
