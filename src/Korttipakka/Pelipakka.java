package Korttipakka;

import Kortti.KortinSelkapuoli;
import Kortti.PinoFaceUp;
import Kortti.PinoFifo;
import Kortti.Kortti;
import Kortti.Maa;
import java.util.LinkedList;
/**
 * Luokalla toteutetaan pasianssin 7 korttipinoa. Sisältää kuvapuoli alaspäin olevan
 * FIFO -periaatteella toimivan korttipinon (PinoFifo), ja tuon päällä olevan kuvapuoli
 * ylöspäin olevan pinon (PinoFaceUp).
 * 
 * @author Adio
 * 
 * @see PinoFifo
 * @see PinoFaceUp
 */
public class Pelipakka implements PakkaRajapinta{
    private PinoFaceUp oikeinpain;
    private PinoFifo vaarinpain;
   
    /**
     * Luo pino-olion
     * @param vaarinpain Pohjapino.
     */
    public Pelipakka(PinoFifo vaarinpain){
        this.oikeinpain = new PinoFaceUp();
        this.vaarinpain = vaarinpain;
    }
    /**
     * Palauttaa (ei poista) päällimmäisen kuvapuoli ylöspäin olevan kortin, tai arvon null jos 
     * korttipaikassa ei ole kuvapuoli ylöspäin olevia kortteja.
     * @return Päällimmäinen kuvapuoli ylöspäin oleva kortti.
     */
    public Kortti getKortti(){
        if(!oikeinpain.isEmpty())
            return oikeinpain.getKortti();
        else 
            return null;
    }
    /** Palauttaa (ei poista) i:nnen kuvapuoli ylöspäin olevan kortin, tai arvon null jos 
     * korttipaikassa ei ole kuvapuoli ylöspäin olevia kortteja tai i on suurempi kuin kuvapuoli ylöspäin olevien korttien määrä.
     * @return Päällimmäinen kuvapuoli ylöspäin oleva kortti.
     */
    public Kortti getKortti(int i) {
        if(!oikeinpain.isEmpty() || i > oikeinpain.getKoko())
            return oikeinpain.getKortti(i);
        else 
            return null;
    }
    
    /**
    * Palauttaa (ja poistaa pinosta) päällimmäisen kuvapuoli ylöspäin olevan kortin, tai arvon null jos 
     * korttipaikassa ei ole kuvapuoli ylöspäin olevia kortteja.
     * @return Päällimmäinen kuvapuoli ylöspäin oleva kortti.
     */
    public Kortti removeKortti(){
        if(!oikeinpain.isEmpty())
            return oikeinpain.removeKortti();
        return null;
    }
    /**
     * Palauttaa (ja poistaa pinosta) kuvapuoli ylöspäin olevan pinon kaikki kortit i:nneksi 
     * päällimmäisestä kortista ylöspäin. Tai arvon null, jos oikeinpäin oleva pino on tyhjä tai sen koko on pienempi kuin i.
     * @param i Kuinka monta päällimäistä korttia halutaan.
     * @return Alipino, jossa i päällimmäistä korttia.
     */
    public PinoFaceUp removeKortti(int i) {
        if(!oikeinpain.isEmpty() || i > oikeinpain.getKoko())
            return oikeinpain.removeKortti(i);
        else 
            return null;
    }
    
    /**
     * Laittaa kortin kuvapuoli ylöspäin olevien korttien päälle, jos siirto on laillinen.
     * Jos korttipakka kokonaisuudessaan on tyhjä, kelpaa arvoksi vain kuningas. 
     * Jos korttipaikan päällimmäinen kortti on väärin päin ei sen päälle voi laittaa mitään. 
     * @param laitettava Päällimmäiseksi laitettava kortti.
     * @return Onnistuiko siirto.
     * @see voikoLaittaa
     */
    public void setKortti(Kortti laitettava){
        
        oikeinpain.setKortti(laitettava);
    }
    /**
     * * Laittaa pinon kuvapuoli ylöspäin olevia kortteja kuvapuoli ylöspäin olevien korttien päälle, jos siirto on laillinen.
     * Jos korttipakka kokonaisuudessaan on tyhjä, kelpaa päällelaitetun pinon pohjimmaisen kortin arvoksi vain kuningas.
     * Jos korttipaikan päällimmäinen kortti on väärin päin ei sen päälle voi laittaa mitään. 
     
     * @param kasaKortteja Päälle laitettava pino.
     * @return Onnistuiko sirto
     */
    public void setKortti(PinoFaceUp kasaKortteja){
        
        oikeinpain.setKortti(kasaKortteja);
    }
    
    /**
     * Jos korttipaikan päällimmäinen kortti on väärinpäin,
     * kääntää tuon ympäri, eli siirtää väärinpäin olevan 
     * pinon päällimmäisen kortin oikein päin olevaan pinoon.
     */
    public void kaannaPaalle(){
        if(!paallimmainenOikeinpain())
            if(!vaarinpain.isEmpty())
                setKortti(vaarinpain.removeKortti());
    }
    
    /**
     * Kertoo, onko päällimmäinen kortti kuvapuoli ylöspäin. 
     * Eli onko kuvapuoli ylöspäin oleva pino epätyhjä.
     * @return Onko päällimmäinen kortti oikein päin.
     */
    public boolean paallimmainenOikeinpain(){
        if (oikeinpain.isEmpty())
            return false;
        else return true;
    }
    /**
     * Palauttaa korttipaikan kuvapuoli ylöspäin olevien korttien määrän
     * @return Kuvapuoli ylöspäin olevien korttien määrä
     */
    public int paallimmaistenKoko(){
        return oikeinpain.getKoko();
    }
    public int alimmaistenKoko(){
    return vaarinpain.getKoko();
    }
    public boolean isEmpty(){
        if (oikeinpain.isEmpty() && vaarinpain.isEmpty())
                return true;
        else
            return false;
    }
    /**
     * Tutkii onko ehdotettu siirto (laitettava verrattavan päälle) pasianssin sääntöjen mukainen. Verrattava kortti on Pelipakan päällimmäinen.
     * @param laitettava Kortti, joka laitettaisiin toisen päälle.
     * @return Onko siirto laillinen.
     */
    @Override
    public boolean voikoLaittaa(Kortti laitettava){
        
        Kortti verrattava = this.getKortti();
        
        if (verrattava == null){
            if (this.isEmpty() || laitettava.getArvo() == 13)
                return true;                
            return false;
        }
        
        if(!verrattava.samaaMaata(laitettava))
            if(!verrattava.samaaVaria(laitettava))
                if(verrattava.vertaaArvo(laitettava) == 1)
                    return true;
        return false;
    }
    /**
     * Palauttaa kaikki pelipakassa oikeinpäin olevat kortit LinkedListinä.
     * @return Pakassa oikeinpäin olevat kortit.
     */
    @Override
    public LinkedList getKuva(){
        if(!oikeinpain.isEmpty())
            return oikeinpain.getKaikki();
        if(!vaarinpain.isEmpty()){
            LinkedList<Kortti> palauta = new LinkedList<Kortti>();
            palauta.add(new KortinSelkapuoli(Maa.SELKAPUOLI, 0));
            return palauta;
        }   
        return new LinkedList<Kortti>();
    }
}