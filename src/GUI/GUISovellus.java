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
    
    public void pushKomento (HashMap<String,String> komento){
        sovellus.pushKomento(komento);
        paivitaPakat();
        
    }
    
    public boolean onkoKortti(String kortinNimi){
        PseudoKortti kortinPaikka = new PseudoKortti(kortinNimi);
        LinkedList<Kortti> kasiteltavaPakka;
        
        if (kortinPaikka.getPakka().equals("jakopakka")){
            if(jakopakka.size() <= kortinPaikka.getKortinJarjestysnumero())
                return false;
        }
        if(kortinPaikka.getPakka().equals("maalipakka")){
            kasiteltavaPakka = maalipakat.get(kortinPaikka.getPakanJarjestysnumero());
            if(kasiteltavaPakka.isEmpty())
                return false;
        }
        if(kortinPaikka.getPakka().equals("pelipakka")){
            kasiteltavaPakka = pelipakat.get(kortinPaikka.getPakanJarjestysnumero());
            if(kasiteltavaPakka.isEmpty())
                return false;
            if(kortinPaikka.getKortinJarjestysnumero() >= kasiteltavaPakka.size())
                return false;
        }
        return true;
    }
    public boolean onkoPelipakkaOikeinPain(String kortinNimi){
        PseudoKortti pakka = new PseudoKortti(kortinNimi);
        if(pakassaKortteja[pakka.getPakanJarjestysnumero()] == 0)
            return false;
        return true;
    }
    public boolean onkoPelipakanPaallimmainen(String kortinNimi){
        PseudoKortti kortinPaikka = new PseudoKortti(kortinNimi);
        if(kortinPaikka.getKortinJarjestysnumero() == pakassaKortteja[kortinPaikka.getPakanJarjestysnumero()] -1)
            return true;
        return false;
    }
    public int montaPelipakassaPaalla(String kortinNimi){
        PseudoKortti kortinPaikka = new PseudoKortti(kortinNimi);
        return pakassaKortteja[kortinPaikka.getPakanJarjestysnumero()] -1 - kortinPaikka.getKortinJarjestysnumero();
    }
    
    // LAITA HEITTÄMÄÄN JOKU VIRHE!!!
    public ImageIcon getKortinKuva(String kortinNimi){
        Kortti kortti = null;
          LinkedList<Kortti> kasiteltavaPakka;
        
        PseudoKortti kortinPaikka = new PseudoKortti(kortinNimi);
        if (kortinPaikka.getPakka().equals("jakopakka")){
            kortti = jakopakka.get(kortinPaikka.getKortinJarjestysnumero());
        }
        if(kortinPaikka.getPakka().equals("maalipakka")){
            kasiteltavaPakka = maalipakat.get(kortinPaikka.getPakanJarjestysnumero());
            kortti = kasiteltavaPakka.getLast();
        }
        if(kortinPaikka.getPakka().equals("pelipakka")){
            kasiteltavaPakka = pelipakat.get(kortinPaikka.getPakanJarjestysnumero());
            kortti = kasiteltavaPakka.get(kortinPaikka.getKortinJarjestysnumero());
        }
            return kortinKuva(kortti);
    }
    
    public ImageIcon getTyhjaKortti(){
        return new ImageIcon(getClass().getResource("/GUI/Images/EMPTYSLOT.png"));
    }
    
    public boolean onkoJakopakassaVaarinpainKortteja(){
        return sovellus.onkoJakopakassaVaarinpainKortteja();
    }
    public boolean onkoJakopakanPaallimmainen(String kortinNimi){
        PseudoKortti pakka = new PseudoKortti(kortinNimi);
        return jakopakka.size()-1 == pakka.getKortinJarjestysnumero();
    }
    private void paivitaPakat(){
        paivitaPelipakat();
        paivitaMaalipakat();
        paivitaJakopakka();
        paivitaPakassaKortteja();
    }
    private void paivitaPelipakat(){
        pelipakat = new ArrayList<LinkedList<Kortti>>(7);
        for(int i = 0; i < 7; i++)    
            pelipakat.add(i, sovellus.getKuva("pelipakka", i));
    }
    private void paivitaMaalipakat(){
        maalipakat = new ArrayList<LinkedList<Kortti>>(4);
        for(int i = 0; i < 4; i++)
            maalipakat.add(i, sovellus.getKuva("maalipakka", i));
    }
    private void paivitaJakopakka(){
        jakopakka = sovellus.getKuva("jakopakka", 0);
    }
    private void paivitaPakassaKortteja(){
        for(int i = 0; i < 7; i++){
            int koko = pelipakat.get(i).size();
            if(koko == 1){
                if(pelipakat.get(i).getLast().getArvo() == 0){
                    pakassaKortteja[i] = 0;
                    return;
                }
            }
            pakassaKortteja[i] = koko; 
        }
    }
    private ImageIcon kortinKuva(Kortti kortti){
        String osoite = "/GUI/Images/" + kortti.getMaa() + "_" + kortti.getArvo() + ".png";
        return new ImageIcon(getClass().getResource(osoite));
    }    
    
    @Override
    public void out(String line) {
    //Tännepä ei tulekaan mitään xD
    }

    @Override
    public void kaynnista() {
    }
}
