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
public class Korttipaikka extends Korttipino {
    
    public Korttipaikka(){
        super();
    }
    
    public Korttipaikka(LinkedList<Kortti> lista){
        super.lista = lista;
    }
    
    public LinkedList<Kortti> getKaikki(){
        return super.lista;
    }
    
    public Korttipaikka removeKortti(int i) throws IndexOutOfBoundsException{
        if(i > this.getKoko()){
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("size:" + this.getKoko() + ", but index was:" + i);
            throw e;            
        }
        LinkedList<Kortti> palautus = new LinkedList<Kortti>();
        for(int j = 0; j < i; j++){
            palautus.addFirst(super.lista.removeLast());
        }
     
        return new Korttipaikka(palautus);
            
    }
}
