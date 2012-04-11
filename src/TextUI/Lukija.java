package TextUI;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * Lukee käyttäjän syötettä. Käytännössä katsoen kapseloitu Scanner -olio.
 * @author Adio
 */
public class Lukija {
    
    private Scanner lukija;

    
    
    public Lukija(){
        lukija = new Scanner(System.in);
    }
    /**
     * Lukee käyttäjän syöttämän seuraavan rivin.
     * @return Syötetty rivi.
     */
    public String getSyote(){
        return lukija.nextLine();
    }
    
    
}
