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
 * Alkupakan luontiin tarkoitettu luokka. Konstruktori luo korttipakan, jossa 52 erilaista korttia.
 * @see PinoFifo
 * @author Adio
 */
public class Alkupakka{
    /**
     * Luo Alkupakka -olion, jossa 52 erilaista korttia maa- ja numerojärjestyksessä.
     */
    private LinkedList<Kortti> lista;
    
    public Alkupakka(){
        lista = new LinkedList<Kortti>();
        
        for (int i = 1; i <= 13; i++)
            lista.add(new Kortti(Maa.HERTTA,i));        
        
        for (int i = 1; i <= 13; i++)
            lista.add(new Kortti(Maa.RISTI,i));    
        
        for (int i = 1; i <= 13; i++)
            lista.add(new Kortti(Maa.RUUTU,i));
                
        for (int i = 1; i <= 13; i++)
            lista.add(new Kortti(Maa.PATA,i));
        
        sekoita();
    }
    /**
     * Sekoittaa korttipakan.
     */
    public void sekoita(){
        Collections.shuffle(lista);
    }
    
    public Kortti getKortti(){
        return lista.removeLast();
    }
    public LinkedList<Kortti> getPakka(){
        return lista;
    }
        
}
