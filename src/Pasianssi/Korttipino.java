
package Pasianssi;

import java.util.LinkedList;
import java.util.Collections;
import Kortti.Kortti;

public class Korttipino {
    
    protected LinkedList<Kortti> pino;
    
    public Korttipino(){
        pino = new LinkedList<Kortti>();
    }
    
    public Kortti getKortti(){
        return pino.removeLast();
    }
    
    public void setKortti(Kortti kortti){
        pino.add(kortti);
    }
    public int getKoko(){
        return pino.size();
    }
}
