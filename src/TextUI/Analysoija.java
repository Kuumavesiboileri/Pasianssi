/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextUI;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Luokka, joka analysoi käyttäjän syötettä ja luo niistä ohjelman ymmärtämiä käskyjä.
 * @author Adio
 */
public class Analysoija {
    public Analysoija(){
        
    }
    /**
     * Muokkaa käyttäjän antamaan syötteen HashMapiksi. 
     * Antaa avaimelle "komento" varsinaisen komennon, ja 
     * allokoi komentoparametrit omille avaimilleen. Jos komento viheellinen palauttaa arvon null.
     * @param Käyttäjän tekstimuodossa antama syöte.
     * @return Komento muokattuna HashMapiksi. Tai null, jos syöte virheellinen.
     */
    public HashMap<String, String> muokkaaHashTaulukoksi(String syote){
        Scanner skanneri = new Scanner(syote);
        if(!skanneri.hasNext())
            return null;
        String komento = skanneri.next();
        if(komento.equals("siirrä"))
            return muokkaaHashTaulukoksiSiirra(skanneri);
        else return null;
    }
    /**
     *Yksityinen metodi, joka luo komennolle "siirrä" komentoriviparametrit. 
     * @param skanneri Käyttäjän antama syöte istutettuna Scanner -olioon.
     * @return Komento "siirrä" HashMap -muodossa.
     */
    private HashMap<String, String> muokkaaHashTaulukoksiSiirra(Scanner skanneri){
        HashMap<String, String> palautettava = new HashMap<String, String>();
        palautettava.put("komento", "siirrä");
        
        if(!skanneri.hasNext())
            return null;
        String mista = skanneri.next();
        if(!onkoPakka(mista))
            return null;
        palautettava.put("mistä", mista);
        
         if(!skanneri.hasNext())
            return null;
         String i = skanneri.next();
         if(!Character.isDigit(i.charAt(0)))
             return null;
         palautettava.put("i", i);
         
         if(!skanneri.hasNext())
             return null;
         String mihin = skanneri.next();
         if(!onkoPakka(mihin))
             return null;
         palautettava.put("mihin", mihin);
         
         if(!skanneri.hasNext())
             return null;
         String j = skanneri.next();
         if(!Character.isDigit(j.charAt(0)))
             return null;
         palautettava.put("j", j);
         
         if(!skanneri.hasNext())
             return palautettava;
         else{
             String maara = skanneri.next();
             if(!Character.isDigit(maara.charAt(0)))
                 return null;
             palautettava.put("komento", "siirräMonta");
             palautettava.put("montako", maara);
             return palautettava;
         }
         
    }
    /**
     * Yksityinen metodi, joka tarkistaa, onko syötteessä annettu pakka oikean muotoinen.
     * @param pakka Syötteenä annettu pakka.
     * @return Onko syöte oikean muotoinen.
     */
    
    private boolean onkoPakka(String pakka){
        if(pakka.equalsIgnoreCase("jakopakka"))
            return true;
        if(pakka.equalsIgnoreCase("pelipakka"))
            return true;
        if(pakka.equalsIgnoreCase("maalipakka"))
            return true;
        return false;
    }
}
