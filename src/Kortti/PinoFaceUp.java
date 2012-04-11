/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

import java.util.LinkedList;
import Kortti.Kortti;

/**
 * Olio pasianssin seitsemän korttipaikan kuvapuoli ylöspäin olevien korttien toteutusta varten.
 * Toimii kuten pinoFifo, mutta pinosta voidaan ottaa myös alipinoja i:stä kortista ylöspäin.
 *@see PinoFifo
 * @author atte
 */
public class PinoFaceUp extends PinoFifo {
    
    public PinoFaceUp(){
        super();
    }
    public PinoFaceUp(LinkedList<Kortti> lista){
        super.lista =lista;
    }
    /**
     * Palauttaa pinon i:nneksi päällimmäisen kortin, poistamatta tuota pinosta.
     * @param i Kuinka monenneksi päällimmäinen kortti.
     * @return  I:nneksi päällimäinen kortti.
     * @throws IndexOutOfBoundsException Jos i on suurempi kuin pinon koko.
     */
    public Kortti getKortti(int i) throws IndexOutOfBoundsException {
        if(i > this.getKoko()){
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("size:" + this.getKoko() + ", but index was:" + i);
            throw e;            
        }
        
        int palautaIndeksi = lista.size() - i;
        return lista.get(palautaIndeksi);
        
    }
    /**
     * Palauttaa pinon päällimmäisen kortin, poistamatta tuota pinosta.
     * @return Pinon päällimmäinen kortti
     */
    public Kortti getPaallimmainen(){
        return super.lista.getLast();
    }
    /**
     * Palauttaa pinon pohjimmaisen kortin, poistamatta tuota pinosta.
     * @return Pinon pohjimmaisen kortti
     */
    public Kortti getPohjimmainen(){
        return super.lista.getFirst();
    }
    
    /**
     * Lisää pinon päälle toisen PinoFaceUp -pinon.
     * @param kasaKortteja Toinen samaa luokkaa kuvaava pino-olio.
     */
    public void setKortti(PinoFaceUp kasaKortteja){
        while(!kasaKortteja.isEmpty())
           this.lista.addLast(kasaKortteja.lista.removeFirst());
    }
    
    /**
     * Poistaa pinosta ja palauttaa pinon kaikki kortit pinon i:nneksi 
     * päällimmäisestä kortista ylöspäin.
     * @param i Lukuarvo, kuinka monta päällimmäistä korttia halutaan palauttaa.
     * @return Pino i:nneksi päällimmäisistä korteista
     * @throws IndexOutOfBoundsException Jos parametri i on suurempi, kuin pinon koko.
     */
    public PinoFaceUp removeKortti(int i) throws IndexOutOfBoundsException{
        if(i > this.getKoko()){
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("size:" + this.getKoko() + ", but index was:" + i);
            throw e;            
        }
        LinkedList<Kortti> palautus = new LinkedList<Kortti>();
        for(int j = 0; j < i; j++){
            palautus.addFirst(super.lista.removeLast());
        }
        return new PinoFaceUp(palautus);
       }
}
