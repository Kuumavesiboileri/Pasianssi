/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextUI;



import Pasianssi.Sovellus;
import Pasianssi.UserInterface;
import java.util.HashMap;

/**
 * Tekstipohjainen käyttöliittymä Pasianssi -peliin.
 * @author Adio
 */
public class TextUI implements UserInterface{
    private Lukija lukija;
    private Analysoija analysoija;
    private Sovellus sovellus;
    
    public TextUI(){
        lukija = new Lukija();
        analysoija = new Analysoija();
    }
    /**
     * Käynnistää sovelluksen, jokna jälkeen 
     * käyttöliittymä alkaa "puskemaan" komentoja itse sovellukselle.
     */
    @Override
    public void kaynnista(){
        alusta();
        while(true){
            sovellus.pushKomento(getKomento());
            update();
        }
    }
    /**
     * Linkittää sovelluksen käyttöliittymään.
     * @param sovellus Varsinainen sovellus.
     */
    @Override
    public void setSovellus(Sovellus sovellus){
        this.sovellus = sovellus;
    }
    
    /**
     * Tulostaa syötteen näytölle.
     * @param line Tulostettava syöte.
     */
    @Override
    public void out(String line){
        System.out.println(line);
    }
    
    /**
     * Palauttaa käyttäjän antaman komennon HashMap<String,String> -muodossa.
     * @return Käyttäjän antama komento.
     */
    private HashMap<String,String> getKomento(){
        String syote = lukija.getSyote();
        return analysoija.muokkaaHashTaulukoksi(syote);
    }
    
    /**
     * Metodi ohjeiden yms tulostamiseen. Tarkoitettu suoritettavaksi ennen pelin alkua.
     */

    private void alusta(){
        System.out.println("Tervetuloa pelaamaan pasianssia");
        tulostaTilanne();
    }
    /**
     * Päivittää pelitilanteen. Tässä tapauksessa tulostaa nykyisen tilanteen tekstimuodossa.
     */
    
    private void update(){
        tulostaTilanne();    
    }
    
    /**
     * Private -metodi pelitilanteen tekstimuotoiseen tulostamiseen.
     */
    private void tulostaTilanne(){
        System.out.println("-----------------------------------\n");
        System.out.println("Jakopakka:");
        
        if(sovellus.onkoJakopakassaVaarinpainKortteja())
            System.out.println("[###]");
        else
            System.out.println("[null]");
        
        System.out.println(sovellus.getKuva("jakopakka", 0));
        System.out.println("Maalipakat:");
        for(int i = 0; i < 4; i++)
            System.out.println(i + ": " + sovellus.getKuva("maalipakka", i));
        System.out.println("Pelipakat:");
        for(int i = 0; i < 7; i++)
            System.out.println(i + ":" + sovellus.getKuva("pelipakka", i));
        System.out.println();
    }
}
