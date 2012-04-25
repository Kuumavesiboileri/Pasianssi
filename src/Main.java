import Kortti.Kortti;
import Kortti.Maa;
import Pasianssi.Sovellus;
import Pasianssi.UserInterface;
import TextUI.TextUI;
import GUI.GUISovellus;
/**
 *
 * @author Adio
 */
public class Main {
    
    public static void main(String[] args){
        UserInterface UI = new GUISovellus();
        Sovellus sovellus = new Sovellus(UI);
        UI.setSovellus(sovellus);
        UI.kaynnista();
    }
}
