
package Kortti;

import java.util.LinkedList;
import Kortti.Kortti;

/**
 * Kortti -olioita pinomuodossa. Lisäys ja poisto FIFO -periaatteella.
 * @author atte
 */
public class PinoFifo {
    
    protected LinkedList<Kortti> lista;
   
    public PinoFifo(){
        lista = new LinkedList<Kortti>();
    }
     /**
     * Konstruktori saa arvonaan linkitetyn listan kortteja.
     * @param lista LinkedList kortteja.
     */
    public PinoFifo(LinkedList<Kortti> lista){
        this.lista =lista;
    }
   /**
     * Poistaa ja palauttaa arvona pinon päällimmäisen kortin.
     * @return Pinon päällimmäinen kortti.
     */ 
    public Kortti removeKortti(){
        return lista.removeLast();
    }
    /**
     * Palauttaa, muttei poista pinosta, pinon päällimäisen kortin.
     * @return 
     */
    public Kortti getKortti(){
        if(lista.size() == 0)
            return null;
        return lista.getLast();
    }
    /**
     * Asettaa parametrinä annetun kortin pinon päällimmäiseksi.
     * @param kortti Pinoon lisättävä kortti.
     */
    public void setKortti(Kortti kortti){
        lista.add(kortti);
    }
    /**
     * Palauttaa pinon koon.
     * @return Pinon koko.
     */
    public int getKoko(){
        return lista.size();
    }
    /**
     * Palauttaa pinon sisällön linkitettynä listana.
     * @return Pinon sisältö linkitettynä listana.
     */
    public LinkedList<Kortti> getKaikki(){
        return lista;
    }
    public boolean isEmpty(){
        return lista.isEmpty();
    }
}
