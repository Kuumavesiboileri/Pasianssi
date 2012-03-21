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
    
    public Kortti(String maaNimi, int lukuArvo) throws IllegalArgumentException{
        this.arvo = new Arvo(lukuArvo);
        this.maa= new Maa(maaNimi);
    }
    
    public int getArvo(){
        return arvo.getArvo();
    }
    
    public String getMaa(){
        return maa.getMaa();
    }
    
    
    public int vertaaArvo(Kortti toinenKortti){
        return this.arvo.getArvo() - toinenKortti.getArvo();
    }
    public boolean samaaMaata(Kortti toinenKortti){
        return this.maa.equals(toinenKortti.maa);
    }
    
    public boolean samaaVaria(Kortti toinenKortti){
        return this.maa.getVari() == toinenKortti.maa.getVari();
            
    }
    
    public String toString(){
        return "(" + maa.toString() + " , " + arvo.toString() + ")";
    }
     
    
   
}
