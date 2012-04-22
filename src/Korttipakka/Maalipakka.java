/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Korttipakka;

import Kortti.PinoFifo;
import Kortti.Kortti;
import java.util.LinkedList;

/**
 * PakkaRajapinta, johon kortit pasianssi -pelissä pyritään saamaan. 
 * Pino kortteja, jonka päälle voi laittaa lisää vain tiettyjen sääntöjen mukaan.
 * @author Adio
 */
public class Maalipakka implements PakkaRajapinta{
    PinoFifo pakka;
    
    public Maalipakka(){
        pakka = new PinoFifo();
    }
    /**
     *Jos siirto on laillinen, laittaa kortin maalipakan päälimmäiseksi ja palauttaa true.
     * Jos siirto on laiton, ei tee mitään ja palauttaa false.
     * @param laitettava Päällelaitettava kortti.
     * @return Onnistuiko siirto.
     */
    
    public void setKortti(Kortti laitettava){                
        pakka.setKortti(laitettava);        
    }
    
    /**
     * Palauttaa (ei poista) pakan päällimmäisen kortin.
     * @return Päällimmäinen kortti.
     */
    
    public Kortti getKortti(){
        return pakka.getKortti();
    }
    /**
     * Poistaa ja palauttaa pakan päällimmäisen kortin.
     * @return Päällimmäinen kortti.
     */
    public Kortti removeKortti(){
        return pakka.removeKortti();
    }
    /**
     * Metodi joka tutkii, onko siirto laillinen.
     * @param alle Kortti, jonka päälle ollaan laittamassa.
     * @param paalle Kortti, joka laitetaan pakan päälle.
     * @return Onko siirto laillinen.
     */
    public boolean voikoLaittaa(Kortti paalle){
        if(pakka.isEmpty()){
            if(paalle.getArvo() == 1){
                return true;
            }
            else return false;
        }
        Kortti alle = pakka.getKortti();
        
        if(alle.getMaa().equals(paalle.getMaa()))
            if(alle.vertaaArvo(paalle) == -1)
                return true;
        
        return false;
    }
    public boolean isEmpty(){
        return pakka.isEmpty();
    }
    /**
     * Palauttaa päällimmäisen oikeinpäin olevan kortin laitettuna LinkedListiin.
     * @return Päälimmäinen kortti.
     */
    @Override
    public LinkedList<Kortti> getKuva(){
        LinkedList<Kortti> palauta = new LinkedList<Kortti>();
        if(!this.isEmpty())
            palauta.add(this.getKortti());
        return palauta;
    }
    @Override
    public void kaannaPaalle(){
        return;
    }
}
