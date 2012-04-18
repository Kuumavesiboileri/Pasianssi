/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Komennot;

import Korttipakka.PakkaRajapinta;
import Korttipakka.Pelipakka;
import Pasianssi.Korttipakat;
import java.util.HashMap;

/**
 *
 * @author atte
 */
public class SiirraMonta extends Komento {
    
    public SiirraMonta(Korttipakat korttipakat){
        super(korttipakat);
    }

    @Override
    public boolean suorita(HashMap<String, String> syote) {
        try{
            String mista = syote.get("mistä");
            String mihin = syote.get("mihin");
            if(!mista.equals("pelipakka") || !mihin.equals("pelipakka"))
                return false;
            
            int i = Integer.parseInt(syote.get("i"));
            int j = Integer.parseInt(syote.get("j"));
            int montako = Integer.parseInt(syote.get("montako"));
            
            Pelipakka paalle  = (Pelipakka) super.korttipakat.getPakka(mista, i);
            Pelipakka alle = (Pelipakka) super.korttipakat.getPakka(mihin, j);
            
            if(paalle == null || alle == null)
                return false;
            
            if(paalle.getKortti(montako) == null)
                return false;
            
            if (alle.voikoLaittaa(paalle.getKortti(montako))){
                return super.korttipakat.siirraPelipakastaToiseen(paalle, alle, montako);
            }
            return false;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    
    
}
