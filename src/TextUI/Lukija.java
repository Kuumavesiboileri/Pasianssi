package TextUI;

import java.util.Scanner;
import java.util.ArrayList;

public class Lukija {
    
    private Scanner lukija;

    
    
    public Lukija(){
        lukija = new Scanner(System.in);
    }
    
    public String getSyote(){
        return lukija.nextLine();
    }
    
    
}
