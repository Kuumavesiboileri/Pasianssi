
package Pasianssi;

import java.util.LinkedList;
import java.util.Collections;
import Kortti.Kortti;

public class PinoFifo {
    
    protected LinkedList<Kortti> lista;
    
    public PinoFifo(){
        lista = new LinkedList<Kortti>();
    }
    
    public Kortti removeKortti(){
        return lista.removeLast();
    }
    public Kortti getKortti(){
        return lista.getLast();
    }
    
    public void setKortti(Kortti kortti){
        lista.add(kortti);
    }
    public int getKoko(){
        return lista.size();
    }

    public boolean isEmpty(){
        return lista.isEmpty();
    }
}
