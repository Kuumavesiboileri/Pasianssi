/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

/**
 *Luokka sisältää Arvon ja Maan, sekä erinnäisiä vertailumetodeja
 * 
 * 
 * @author Adio
 */

public class Kortti {
    
    private Arvo arvo;
    private Maa maa;
   
    /**
     * 
     * @param maa Luodun kortin maa-arvo
     * @param lukuArvo Luodun kortin numeroarvo
     * @see Arvo
     * @see Kortti
     * @throws IllegalArgumentException Mikäli numeroarvo ei välillä 1-13
     */
    public Kortti(Maa maa, int lukuArvo) throws IllegalArgumentException{
        this.arvo = new Arvo(lukuArvo);
        this.maa = maa;
        }
    /**
     * Palauttaa kortin lukuarvon
     * @return lukuarvo
     */
    public int getArvo(){
        return arvo.getArvo();
    }
    /**
     * Palauttaa kortin maa-arvon
     * @return maa
     */
    public String getMaa(){
        return maa.toString();
    }
    
    /**
     * Vertaa kortin lukuarvoa toisen kortin lukuarvoon.
     * 
     * @param toinenKortti Kortti, johon lukuarvoa verrataan.
     * @return Jos luokan lukuarvo on suurempi kuin parametrina annetun, 
     * palauttaa positiivisen luvun; jos pienempi, palauttaa negatiivisen.
     * Jos verrattavat arvot ovat yhtäsuuria, palauttaa nollan.
     */
    public int vertaaArvo(Kortti toinenKortti){
        return this.arvo.getArvo() - toinenKortti.getArvo();
    }
    /**
     * Vertaa kortin maa-arvoa toisen kortin maa-arvoon.
     * @param toinenKortti Kortti, johon maa-arvoa verrataan.
     * 
     * @return Jos kortit ovaa samaa maata, palauttaa true. Muuten palauttaa false.
     */
    public boolean samaaMaata(Kortti toinenKortti){
        return this.maa == toinenKortti.maa;
    }
    
    /**
     * Vertaa kortin väriä (= punainen tai musta) toisen kortin väriin.
     * @param toinenKortti Kortti, johon väriä verrataan
     * @return Jos kortit ovat samaa väriä (esim pata ja risti), palauttaa true. Muuten palauttaa false.
     */
    public boolean samaaVaria(Kortti toinenKortti){
        if (this.maa == Maa.HERTTA || this.maa == Maa.RUUTU){
            if (toinenKortti.maa == Maa.HERTTA || toinenKortti.maa == Maa.RUUTU)
                return true;
        }
        if (this.maa == Maa.PATA || this.maa == Maa.RISTI){
            if (toinenKortti.maa == Maa.PATA || toinenKortti.maa == Maa.RISTI)
                    return true;
        }
        return false;
        
        
    }
    
    @Override
    public String toString(){
        return "(" + maa.toString() + " , " + arvo.toString() + ")";
    }
     
    
}
