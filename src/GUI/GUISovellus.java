/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Kortti.Kortti;
import Pasianssi.Sovellus;
import Pasianssi.UserInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author atte
 */
public class GUISovellus implements UserInterface{
    private GUI gui;
    private Sovellus sovellus;
    
    private LinkedList<Kortti> jakopakka;
    private ArrayList<LinkedList<Kortti>> pelipakat;
    private ArrayList<LinkedList<Kortti>> maalipakat;
    
    private int[] pakassaKortteja;
    
    public GUISovellus(){
        gui = new GUI();
        
        pelipakat = new ArrayList<LinkedList<Kortti>>(7);
        maalipakat = new ArrayList<LinkedList<Kortti>>(4);
        pakassaKortteja = new int[7];
    }
    @Override
    public void setSovellus(Sovellus sovellus){
        this.sovellus = sovellus;
    }
    @Override
    public void alusta(){
        
        jakopakka = sovellus.getKuva("jakopakka", 0);
        
        for(int i = 0; i < 4; i++){
            maalipakat.add(sovellus.getKuva("maalipakka", i));
        }
        for(int i = 0; i < 7; i++){
            pelipakat.add(sovellus.getKuva("pelipakka", i));
            pakassaKortteja[i] = pelipakat.get(i).size();   
        }
        gui.alusta(this);
        
    }
    public boolean onkoKortti(String kortinNimi){
        PseudoKortti kortinPaikka = new PseudoKortti(kortinNimi);
        LinkedList<Kortti> kasiteltavaPakka;
        
        if (kortinPaikka.getPakka().equals("jakopakka")){
            if(jakopakka.isEmpty())
                return false;
        }
        if(kortinPaikka.getPakka().equals("maalipakka")){
            kasiteltavaPakka = maalipakat.get(kortinPaikka.getpakanJarjestysnumero());
            if(kasiteltavaPakka.isEmpty())
                return false;
        }
        if(kortinPaikka.getPakka().equals("pelipakka")){
            kasiteltavaPakka = pelipakat.get(kortinPaikka.getpakanJarjestysnumero());
            if(kasiteltavaPakka.isEmpty())
                return false;
            if(kortinPaikka.getkortinJarjestysnumero() >= kasiteltavaPakka.size())
                return false;
        }
        return true;
    }
    // LAITA HEITTÄMÄÄN JOKU VIRHE!!!
    public ImageIcon getKortinKuva(String kortinNimi){
        Kortti kortti = null;
          LinkedList<Kortti> kasiteltavaPakka;
        
        PseudoKortti kortinPaikka = new PseudoKortti(kortinNimi);
        if (kortinPaikka.getPakka().equals("jakopakka")){
            kortti = jakopakka.get(kortinPaikka.getkortinJarjestysnumero());
        }
        if(kortinPaikka.getPakka().equals("maalipakka")){
            kasiteltavaPakka = maalipakat.get(kortinPaikka.getpakanJarjestysnumero());
            kortti = kasiteltavaPakka.get(kortinPaikka.getkortinJarjestysnumero());
        }
        if(kortinPaikka.getPakka().equals("pelipakka"))
            kortti = pelipakat.get(kortinPaikka.getpakanJarjestysnumero()).get(kortinPaikka.getkortinJarjestysnumero());
            return kortinKuva(kortti);
    }
    
    public ImageIcon getTyhjaKortti(){
        return new ImageIcon(getClass().getResource("/GUI/Images/EMPTYSLOT.png"));
    }
    
    public boolean onkoJakopakassaVaarinpainKortteja(){
        return sovellus.onkoJakopakassaVaarinpainKortteja();
    }
    private ImageIcon kortinKuva(Kortti kortti){
        String osoite = "/GUI/Images/" + kortti.getMaa() + "_" + kortti.getArvo() + ".png";
        return new ImageIcon(getClass().getResource(osoite));
    }
    
    /*
    private ImageIcon tyhjaa(){
        return new ImageIcon(getClass().getResource("/GUI/Images/BLANK.png"));
    }*/
/*        PseudoKorttiPakka pakka = new PseudoKorttiPakka(kortinPakanNimi);
        sovellus.getKuva(pakka.getPakka(), pakka.getJarjestysnumero());
        
    }*/

    @Override
    public HashMap<String, String> getKomento() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void out(String line) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
