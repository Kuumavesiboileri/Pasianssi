/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.HashMap;

/**
 *
 * @author atte
 */
public class KomentoKirjasto {
    HashMap<String, String> komento;
    
    public KomentoKirjasto(){
    }
    public HashMap<String, String> siirra(String mistaKortinNimi, String mihinKortinNimi){
        komento = new HashMap<String, String>();
        komento.put("komento", "siirrä");
        PseudoKortti mista = new PseudoKortti(mistaKortinNimi);
        PseudoKortti mihin = new PseudoKortti(mihinKortinNimi);
        komento.put("mistä", mista.getPakka());
        komento.put("i", Integer.toString(mista.getPakanJarjestysnumero()));
        komento.put("mihin", mihin.getPakka());
        komento.put("j", Integer.toString(mihin.getPakanJarjestysnumero()));
        return komento;
    }
    public HashMap<String, String> siirraMonta(String mistaKortinNimi, String mihinKortinNimi, int montako){
        komento = new HashMap<String, String>();
        PseudoKortti mista = new PseudoKortti(mistaKortinNimi);
        PseudoKortti mihin = new PseudoKortti(mihinKortinNimi);
        komento.put("komento", "siirräMonta");
        komento.put("mistä", mista.getPakka());
        komento.put("i", Integer.toString(mista.getPakanJarjestysnumero()));
        komento.put("mihin", mihin.getPakka());
        komento.put("j", Integer.toString(mihin.getPakanJarjestysnumero()));
        komento.put("montako", Integer.toString(montako));
        return komento;
    }
    
    public HashMap<String, String> kaanna(String kortinNimi){
        komento = new HashMap<String, String>();
        PseudoKortti pakka = new PseudoKortti(kortinNimi);
        komento.put("komento", "käännä");
        komento.put("pakka", pakka.getPakka());
        komento.put("i", Integer.toString(pakka.getPakanJarjestysnumero()));
        return komento;
    }
    
}
