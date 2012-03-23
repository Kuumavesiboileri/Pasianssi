/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;

import java.util.LinkedList;
import Kortti.Kortti;

/**
 *
 * @author atte
 */
public class PinoFaceUp extends PinoFifo {
    
    public PinoFaceUp(){
        super();
    }
    
    public PinoFaceUp(LinkedList<Kortti> lista){
        super.lista = lista;
    }
    
    public Kortti getPaallimmainen(){
        return super.lista.getLast();
    }
    
    public Kortti getPohjimmainen(){
        return super.lista.getFirst();
    }
    
    public LinkedList<Kortti> getKaikki(){
        return super.lista;
    }
    
    public void setKortti(PinoFaceUp kasaKortteja){
        while(!kasaKortteja.isEmpty())
           this.lista.addLast(kasaKortteja.lista.removeFirst());
    }
    
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
