/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

/**
 *
 * @author atte
 */
public class Arvo implements Comparable <Arvo> {
    private final int arvo;
    
    public Arvo(int numeroArvo) throws IllegalArgumentException{
        if(numeroArvo >= 1){
            if(numeroArvo <= 13){
                arvo = numeroArvo;
                return;
            }
        } 
        IllegalArgumentException e = new IllegalArgumentException(numeroArvo + " ei ole väliltä [1,13]");
        throw e;
    }
    
    public int getArvo(){
        return arvo;
    }
    
    @Override
    public int compareTo(Arvo toinenArvo){
        return this.getArvo() - toinenArvo.getArvo();
    }
    
    @Override
    public String toString(){
        Integer palauta = new Integer(arvo);
        return palauta.toString();
    }
}
