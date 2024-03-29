
package Pasianssi;
import Korttipakka.*;
import Kortti.PinoFifo;
import Kortti.Kortti;
import java.util.LinkedList;


import Kortti.Maa;
/**
 * Sisältää pelin pakat.
 * @author Adio
 */
public class Korttipakat {
    
    private Jakopakka jakopakka;
    private Pelipakka[] pelipakka;
    private Maalipakka[] maalipakka;
    
            
    public Korttipakat(){
        Alkupakka alkupakka = new Alkupakka();
        alkupakka.sekoita();
        
        pelipakka= new Pelipakka[7];
        maalipakka = new Maalipakka[4];
        
        for(int i = 0; i < 7 ; i++){
            
            PinoFifo alapakka = new PinoFifo();
            for(int j = 0; j < i; j++){
                alapakka.setKortti(alkupakka.removeKortti());
            }
            pelipakka[i] = new Pelipakka(alapakka);
            pelipakka[i].setKortti(alkupakka.removeKortti());
        }
        
        for(int i = 0; i < 4; i++)
            maalipakka[i] = new Maalipakka();
        jakopakka = new Jakopakka(alkupakka.getPakka());
    }
    public Korttipakat(boolean totuusarvo){
        Alkupakka alkupakka = new Alkupakka();
        
        pelipakka= new Pelipakka[7];
        maalipakka = new Maalipakka[4];
        
        for(int i = 0; i < 7 ; i++){
            
            PinoFifo alapakka = new PinoFifo();
            for(int j = 0; j < i; j++){
                alapakka.setKortti(alkupakka.removeKortti());
            }
            pelipakka[i] = new Pelipakka(alapakka);
            if(i== 0)
                pelipakka[i].setKortti(new Kortti(Maa.HERTTA, 12));
                else
                if(i == 1)
                pelipakka[i].setKortti(new Kortti(Maa.RISTI, 13));
                else
                    if(i==2)
                        pelipakka[i].setKortti(new Kortti(Maa.PATA, 11));
                    else 
                        if(i==3)
                            pelipakka[i].setKortti(new Kortti(Maa.HERTTA, 1));
                        else
                            if(i==4)
                                pelipakka[i].setKortti(new Kortti(Maa.PATA, 13));
                            else
                                pelipakka[i].setKortti(alkupakka.removeKortti());
                            
        }
        
        for(int i = 0; i < 4; i++)
            maalipakka[i] = new Maalipakka();
        jakopakka = new Jakopakka(alkupakka.getPakka());
    }
    
    /**
     * Palauttaa vittauksen haluttuun pelin pakkaan.
     * @param pakka Halutun pakan tyyppi Stringinä.
     * @param i Halutun pakan järjestysnumero.
     * @return Viittaus haluttuun pakka -olioon.
     */
    public PakkaRajapinta getPakka(String pakka, int i){
        if (pakka.equalsIgnoreCase("jakopakka"))
            return jakopakka;
        if(pakka.equalsIgnoreCase("pelipakka"))
            return pelipakka[i];
        if(pakka.equalsIgnoreCase("maalipakka"))
            return maalipakka[i];
        else return null;
    }
    /**
     * Siirtää kortin pakasta toiseen, jos siirto on laillinen.
     * @param mista Pakka, josta siirretään.
     * @param mihin Pakka, johon siirretään.
     * @return Onnistuiko siirto.
     */
    public boolean siirra(PakkaRajapinta mista, PakkaRajapinta mihin){       
        if(mihin.voikoLaittaa(mista.getKortti())){
            Kortti laita = mista.removeKortti();
            mihin.setKortti(laita);
            return true;
        }
        return false;
    }
    /**
     * Siirtää useamman, päällekkäisen kortin Pelipakasta toiseen, jos siirto on laillinen.
     * @param mista Pakka, josta siirretään.
     * @param mihin Pakka, johon siirretään.
     * @return Onnistuiko siirto.
     */
    public boolean siirraPelipakastaToiseen(Pelipakka mista, Pelipakka mihin, int maara){
        if(mihin.voikoLaittaa(mista.getKortti(maara))){
            mihin.setKortti(mista.removeKortti(maara));
            return true;
        }
        return false;
    }
    
    /**
     * Kääntää pakan päällimmäisen kortin oikeinpäin, jos tämä on väärinpäin
     * @param pakka pakka, josta halutaan kääntää kortti.
     */
    public void kaanna(PakkaRajapinta pakka){
        pakka.kaannaPaalle();
    }
    
    /**
     * Hakee halutun pakan kaikki oikeinpäin olevat kortit, ja palauttaa näistä LinkedListin.
     * @param pakkaID Halutun pakan tyyppi.
     * @param i Haluun pakan järjestysnumero (jos jakopakka, mikä tahansa).
     * @return halutun pakan kaikki oikeinpäin olevat kortit.
     */
    public LinkedList<Kortti> getPakanKuva(String pakkaID, int i){
        PakkaRajapinta pakka = this.getPakka(pakkaID, i);
        return pakka.getKuva();
    }
    
    public boolean onkoJakopakassaVaarinpainKortteja(){
        return jakopakka.onkoVaarinpain();
    }
    public int pelipakanAlapakanKoko(int i){
        return pelipakka[i].alimmaistenKoko();
    }
}