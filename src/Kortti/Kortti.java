/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

/**
 *
 * @author atte
 */

public class Kortti {
    
    private Arvo arvo;
    private Maa maa;
    
    public Kortti(Maa maa, int lukuArvo) throws IllegalArgumentException{
        this.arvo = new Arvo(lukuArvo);
        }
    
    public int getArvo(){
        return arvo.getArvo();
    }
    
    public String getMaa(){
        return maa.toString();
    }
    
    
    public int vertaaArvo(Kortti toinenKortti){
        return this.arvo.getArvo() - toinenKortti.getArvo();
    }
    public boolean samaaMaata(Kortti toinenKortti){
        return this.maa == toinenKortti.maa;
    }
    
    public boolean samaaVaria(Kortti toinenKortti){
        if (this.maa == Maa.HERTTA || this.maa == Maa.RUUTU)
            if (toinenKortti.maa == Maa.HERTTA || toinenKortti.maa == Maa.RUUTU)
                return false;
            if (this.maa == Maa.PATA || this.maa == Maa.RISTI)
                if (toinenKortti.maa == Maa.PATA || toinenKortti.maa == Maa.RISTI)
                    return false;
        return true;
        
        
    }
    
    public String toString(){
        return "(" + maa.toString() + " , " + arvo.toString() + ")";
    }
     
    
}
