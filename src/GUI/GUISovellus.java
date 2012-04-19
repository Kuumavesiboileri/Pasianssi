/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Kortti.Kortti;
import Pasianssi.Sovellus;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author atte
 */
public class GUISovellus {
    private Sovellus sovellus;
    
    private LinkedList<Kortti> jakopakka;
    private ArrayList<LinkedList<Kortti>> pelipakat;
    private ArrayList<LinkedList<Kortti>> maalipakat;
    
    public GUISovellus(){
        jakopakka = new LinkedList<Kortti>();
        pelipakat = new ArrayList<LinkedList<Kortti>>(7);
        maalipakat = new ArrayList<LinkedList<Kortti>>(4);
    }
    public void setSovellus(Sovellus sovellus){
        this.sovellus = sovellus;
    }
    public void alusta(){
        jakopakka = sovellus.getKuva("jakopakka", 0);
        for(int i = 0; i < 7; i++){
            pelipakat.set(i, sovellus.getKuva("pelipakka", i));
        }
        for(int i = 0; i < 4; i++){
            maalipakat.set(i, sovellus.getKuva("maalipakka", i));
        }
    }
    
    //public ImageIcon getKortinKuva(String korttipaikanNimi){
        
    //}
}
