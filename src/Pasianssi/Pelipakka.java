package Pasianssi;

import Kortti.Kortti;
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

public class Pelipakka {
    private PinoFaceUp oikeinpain;
    private PinoFifo vaarinpain;
   
    /**
     * Luo pino-olion
     * @param oikeinpain Päällipino.
     * @param vaarinpain Pohjapino.
     */
    public Pelipakka(PinoFaceUp oikeinpain, PinoFifo vaarinpain){
        this.oikeinpain = oikeinpain;
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
    public boolean setPaalle(Kortti laitettava){

        if (this.isEmpty() && laitettava.getArvo() == 13){
            oikeinpain.setKortti(laitettava);
            return true;
        }
        
        if (oikeinpain.getKoko() == 0){
            return false;
        }
        
        Kortti verrattava = oikeinpain.getPaallimmainen();
        if (voikoLaittaa(verrattava, laitettava)){
            oikeinpain.setKortti(laitettava);
            return true;
        }
        return false;
    }
    /**
     * * Laittaa pinon kuvapuoli ylöspäin olevia kortteja kuvapuoli ylöspäin olevien korttien päälle, jos siirto on laillinen.
     * Jos korttipakka kokonaisuudessaan on tyhjä, kelpaa päällelaitetun pinon pohjimmaisen kortin arvoksi vain kuningas.
     * Jos korttipaikan päällimmäinen kortti on väärin päin ei sen päälle voi laittaa mitään. 
     
     * @param kasaKortteja Päälle laitettava pino.
     * @return Onnistuiko sirto
     */
    public boolean setPaalle(PinoFaceUp kasaKortteja){
        
        Kortti laitettava = kasaKortteja.getPohjimmainen();
        
        if (this.isEmpty() || laitettava.getArvo() == 13){
            oikeinpain.setKortti(kasaKortteja);
            return true;
        }
        
        if (oikeinpain.getKoko() == 0){
            return false;
        }
        
        Kortti verrattava = oikeinpain.getPaallimmainen();
        if (voikoLaittaa(verrattava, laitettava)){
            oikeinpain.setKortti(kasaKortteja);
            return true;
        }
        return false;
    }
    
    /**
     * Jos korttipaikan päällimmäinen kortti on väärinpäin,
     * kääntää tuon ympäri, eli siirtää väärinpäin olevan 
     * pinon päällimmäisen kortin oikein päin olevaan pinoon.
     */
    public void kaannaPaalle(){
        if(!paallimmainenOikeinpain())
            if(!vaarinpain.isEmpty())
                setPaalle(vaarinpain.removeKortti());
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
    
    public boolean isEmpty(){
        if (oikeinpain.isEmpty() && vaarinpain.isEmpty())
                return true;
        else
            return false;
    }
    /**
     * Laittaa kortin kuvapuoli ylöspäin korttipaikan päällimmäiseksi tarkistamatta, onko siirto laillinen.
     * Pelin alustamisessa käytetty metodi.
     * @param kortti Päälle laitettava kortti.
     */
    protected void setPaalleLaittomasti(Kortti kortti){
        oikeinpain.setKortti(kortti);
    }
    /**
     * Tutkii onko ehdotettu siirto (laitettava verrattavan päälle) pasianssin sääntöjen mukainen.
     * @param verrattava Kortti, jonka päälle laitettaisiin toinen kortti
     * @param laitettava Kortti, joka laitettaisiin toisen päälle.
     * @return Onko siirto laillinen.
     */
    private boolean voikoLaittaa(Kortti verrattava, Kortti laitettava){
        
        if(!verrattava.samaaMaata(laitettava))
            if(!verrattava.samaaVaria(laitettava))
                if(verrattava.vertaaArvo(laitettava) == 1)
                    return true;
        return false;
    }
  
}
