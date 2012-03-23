/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasianssi;
import java.util.LinkedList;
import java.util.Collections;
import Kortti.Kortti;
import Kortti.Maa;
/**
 *
 * @author atte
 */
public class Korttipakka extends Korttipino{
    public Korttipakka(){
        lista = new LinkedList<Kortti>();
        
        for (int i = 1; i <= 13; i++)
            lista.add(new Kortti(Maa.HERTTA,i));        
        
        for (int i = 1; i <= 13; i++)
            lista.add(new Kortti(Maa.RISTI,i));    
        
        for (int i = 1; i <= 13; i++)
            lista.add(new Kortti(Maa.RUUTU,i));
                
        for (int i = 1; i <= 13; i++)
            lista.add(new Kortti(Maa.PATA,i));
    }
        public void sekoita(){
        Collections.shuffle(lista);
    }
}
