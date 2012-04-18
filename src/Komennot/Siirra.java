/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Komennot;

import Korttipakka.PakkaRajapinta;
import Pasianssi.Korttipakat;
import java.util.HashMap;

/**
 * Pelin siirrä -komento.
 * @author Adio
 */
public class Siirra extends Komento{
    
    public Siirra(Korttipakat korttipakat){
        super(korttipakat);
    }
    /**
     * Siirtää kortin pakasta toiseen, jos siirto on laillinen. Palauttaa true, jos siirto onnistuu, false jos ei onnistu.
     * @param syote Komentoparametrit HashMap -muodossa.
     * @return Onnistuiko siirto.
     */
    @Override
    public boolean suorita(HashMap<String, String> syote){
        
        try{
            String mista = syote.get("mistä");
            String mihin = syote.get("mihin");
            int i = Integer.parseInt(syote.get("i"));
            int j = Integer.parseInt(syote.get("j"));
            
            PakkaRajapinta paalle  = super.korttipakat.getPakka(mista, i);
            PakkaRajapinta alle = super.korttipakat.getPakka(mihin, j);
            if(paalle == null || alle == null)
                return false;
            
            if (alle.voikoLaittaa(paalle.getKortti())){
                super.korttipakat.siirra(paalle, alle);
                return true;
            }
            return false;
        }
        catch(NumberFormatException e){
            return false;
        }
              
    }
}
