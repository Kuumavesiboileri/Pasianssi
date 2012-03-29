/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

/**
 * Kortti -olion luonnissa käytetty luokka. Sisältää kokonaislukuja väliltä [1,13].
 * @author Adio
 * @see Kortti
 */
public class Arvo implements Comparable <Arvo> {
    private final int arvo;
    
    /**
     * 
     * @param numeroArvo Kokonaisluku väliltä [1,13]
     * 
     * @throws IllegalArgumentException  Jos anntettu parametri ei ole väliltä [1,13] 
     * päätyy luokan suorittaminen virheilmoitukseen.
     */
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
    
    /**
     * 
     * @return Luokan lukuarvo
     */
    public int getArvo(){
        return arvo;
    }
    /**
     * Vertaa luokan lukuarvo toisen Arvo -luokan lukuarvoon.
     * @param toinenArvo Verrattava arvo-olio.
     * 
     * @return Jos luokan lukuarvo on suurempi kuin parametrina annetun, 
     * palauttaa positiivisen luvun. Jos pienempi, palauttaa negatiivisen. 
     * Jos yhtäsuuri, palauttaa nollan.
     */
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
