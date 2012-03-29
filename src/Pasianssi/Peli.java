
package Pasianssi;
import Kortti.Kortti;


public class Peli {
    Pelipakka[] slotti;
    
    public Peli(){
        Alkupakka pakka = new Alkupakka();
        pakka.sekoita();
        
        slotti = new Pelipakka[7];
        
    }
}
