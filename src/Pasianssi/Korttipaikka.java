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
    
    public LinkedList<Kortti> getKortti(int i) throws IndexOutOfBoundsException{
        if(i > this.getKoko()){
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("size:" + this.getKoko() + ", but index was:" + i);
            throw e;            
        }
        LinkedList<Kortti> palautus = new LinkedList<Kortti>();
        for(int j = 0; j < i; j++){
            palautus.addFirst(super.pino.removeLast());
        }
        /*
        LinkedList<Kortti> valilista = new LinkedList<Kortti>();
        
        for(int j = 0; j < i; j++)
            valilista.add(super.pino.removeLast());
        
        LinkedList<Kortti> palautus =new LinkedList<Kortti>();
        
        while(!valilista.isEmpty())
            palautus.add(valilista.removeLast());
        */
        return palautus;
            
    }
}
