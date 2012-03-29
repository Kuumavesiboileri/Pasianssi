/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

import Kortti.Kortti;

/**
 * Pakka, johon kortit pasianssi -pelissä pyritään saamaan. 
 * Pino kortteja, jonka päälle voi laittaa lisää vain tiettyjen sääntöjen mukaan.
 * @author Adio
 */
public class Maalipakka {
    PinoFifo pakka;
    
    Maalipakka(){
        pakka = new PinoFifo();
    }
    /**
     *Jos siirto on laillinen, laittaa kortin maalipakan päälimmäiseksi ja palauttaa true.
     * Jos siirto on laiton, ei tee mitään ja palauttaa false.
     * @param laitettava Päällelaitettava kortti.
     * @return Onnistuiko siirto.
     */
    
    public boolean setPaalle(Kortti laitettava){
        if(pakka.isEmpty()){
            if(laitettava.getArvo() == 1){
                pakka.setKortti(laitettava);
                return true;
            }
            else return false;
        }
                
        Kortti verrattava = pakka.getKortti();
        if(voikoLaittaa(verrattava, laitettava)){
            pakka.setKortti(laitettava);
            return true;
        }
        return false;
        
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
    private boolean voikoLaittaa(Kortti alle, Kortti paalle){
        if(alle.getMaa().equals(paalle.getMaa()))
            if(alle.vertaaArvo(paalle) == -1)
                return true;
        
        return false;
    }
    
}
