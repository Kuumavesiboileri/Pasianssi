/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Komennot;

import Korttipakka.PakkaRajapinta;
import Pasianssi.Korttipakat;
import java.util.HashMap;

/**
 *
 * @author atte
 */
public class Kaanna extends Komento{
    
    public Kaanna(Korttipakat korttipakat){
        super(korttipakat);
    }
    
    @Override
    public boolean suorita(HashMap<String, String> syote) {
        try{
            String pakka = syote.get("pakka");
        
            int i = Integer.parseInt(syote.get("i"));
            PakkaRajapinta haettuPakka = korttipakat.getPakka(pakka, i);
        
            if(haettuPakka == null)
                return false;
            
            haettuPakka.kaannaPaalle();
            return true;
        
        }
        
        catch(NumberFormatException e){
            return false;
        }
    }
}
