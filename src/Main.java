
import Pasianssi.Sovellus;
import Pasianssi.UserInterface;
import TextUI.TextUI;

/**
 *
 * @author Adio
 */
public class Main {
    
    public static void main(String[] args){
        UserInterface UI = new TextUI();
        Sovellus sovellus = new Sovellus(UI);
        UI.setSovellus(sovellus);
        sovellus.kaynnista();
    }
}
