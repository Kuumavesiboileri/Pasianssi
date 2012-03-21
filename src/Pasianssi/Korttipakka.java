/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;
import java.util.LinkedList;
import java.util.Collections;
import Kortti.Kortti;
/**
 *
 * @author atte
 */
public class Korttipakka extends Korttipino{
    public Korttipakka(){
        pino = new LinkedList<Kortti>();
        
        for (int i = 1; i <= 13; i++)
            pino.add(new Kortti("hertta",i));        
        
        for (int i = 1; i <= 13; i++)
            pino.add(new Kortti("risti",i));    
        
        for (int i = 1; i <= 13; i++)
            pino.add(new Kortti("ruutu",i));
                
        for (int i = 1; i <= 13; i++)
            pino.add(new Kortti("pata",i));
    }
        public void sekoita(){
        Collections.shuffle(pino);
    }
}
