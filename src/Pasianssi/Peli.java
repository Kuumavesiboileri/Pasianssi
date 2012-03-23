
package Pasianssi;
import Kortti.Kortti;


public class Peli {
    Slotti[] slotti;
    
    public Peli(){
        Korttipakka pakka = new Korttipakka();
        pakka.sekoita();
        
        slotti = new Slotti[7];
        
    }
}
