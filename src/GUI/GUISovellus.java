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
 *  Luokka, joka toimii rajapintana varsinaisen sovelluksen ja graaffisen käyttöliittymän välillä.
 * @author Adio
 */
public class GUISovellus implements UserInterface{
    private GUI gui;
    private Sovellus sovellus;
    
    private LinkedList<Kortti> jakopakka;
    private ArrayList<LinkedList<Kortti>> pelipakat;
    private ArrayList<LinkedList<Kortti>> maalipakat;
    
    private int[] pakassaKortteja;
    private int[] pakassaTakaKortteja;
    /**
     * Konstruktori alustaa linkitettyjä listoja vastaamaan jokaista pelin korttipakkaa.
     * Metodin suorittamisen jälkeen listat ovat vielä tyhjiä.
     */
    public GUISovellus(){
        
        gui = new GUI();
        
        pelipakat = new ArrayList<LinkedList<Kortti>>(7);
        maalipakat = new ArrayList<LinkedList<Kortti>>(4);
        pakassaKortteja = new int[7];
        pakassaTakaKortteja = new int[7];
    }
    /**
     * Asettaa luokan viittaamaan parametrina annettuun sovellukseen. 
     * Konstruktorissa luodut luokat asetetaan viittaamaan sovelluksen 
     * asianmukaisiin pakkoihin.
     * @param sovellus Pasianssi -pelin varsinainen sovellus.
     */
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
            pakassaTakaKortteja[i] = sovellus.pelipakanAlapakanKoko(i);
        }
        
    }
    /**
     * Kutsuu sovelluksen pushKomento -metodia parametrina HashMap<String, String> -muotoinen komento.
     * Metodi, jota varsinainen GUI kutsuu.
     * @param komento Pasianssi -pelin komento hashMap -muodossa.
     */
    public void pushKomento (HashMap<String,String> komento){
        sovellus.pushKomento(komento);
        paivitaPakat();
        
    }
    /**
     * Kertoo, onko pelissä String -muotoisena parametrina annetussa 
     * paikassa korttia vai ei.
     * 
     * @param kortinNimi Kortin nimi annettuna muodossa <pakka> <pakan n:nnäs kortti>
     * @return Onko annetussa kohdassa korttia varsinaisessa sovelluksessa.
     */
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
        if(kortinPaikka.getPakka().equals("takakortti")){
            if(pakassaTakaKortteja[kortinPaikka.getPakanJarjestysnumero()] <= kortinPaikka.getKortinJarjestysnumero())
                return false;
        }
        return true;
    }/**
     * Kertoo, onko varsinaisen sovelluksen parametrina annetussa kortin
     * pakassa vielä oikeinpäin olevia kortteja.
     * 
     * @param kortinNimi Kortin nimi annettuna muodossa <pakka> <pakan n:nnäs kortti>.
     * @return Onko annetussa pelipakassa vielä oikeinpäin olevia kortteja.
     */
    public boolean onkoPelipakkaOikeinPain(String kortinNimi){
        PseudoKortti pakka = new PseudoKortti(kortinNimi);
        if(pakassaKortteja[pakka.getPakanJarjestysnumero()] == 0)
            return false;
        return true;
    }
    /**
     * Kertoo, onko paranetrina annettu kortti pelpakan päällimmäinen varsinaisessa sovelluksessa.
     * @param kortinNimi Kortin nimi annettuna muodossa <pakka> <pakan n:nnäs kortti>.
     * @return Onko annettu kortin paikka pelipakkansa päällimmäinen.
     */
    public boolean onkoPelipakanPaallimmainen(String kortinNimi){
        PseudoKortti kortinPaikka = new PseudoKortti(kortinNimi);
        if(kortinPaikka.getKortinJarjestysnumero() == pakassaKortteja[kortinPaikka.getPakanJarjestysnumero()] -1)
            return true;
        return false;
    }
    /**
     * Kertoo, monta korttia on paranetrina annetun kortin päällä pvarsinaisen sovelluksen pelipakassa.
     * @param kortinNimi Kortin nimi annettuna muodossa <pakka> <pakan n:nnäs kortti>.
     * @return Monta korttia on annetun kortin päällä pelipakassa.
     */
    public int montaPelipakassaPaalla(String kortinNimi){
        PseudoKortti kortinPaikka = new PseudoKortti(kortinNimi);
        return pakassaKortteja[kortinPaikka.getPakanJarjestysnumero()] -1 - kortinPaikka.getKortinJarjestysnumero();
    }
    
    /**
     * Palauttaa pelin korttia vastaavan kuvan.
     * @param kortinNimi Kortin nimi annettuna muodossa <pakka> <pakan n:nnäs kortti>.
     * @return Korttia vastaava kuva.
     */
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
    /**
     * Palauttaa kuvan tyhjästä pelipakasta (eli sen tyhjän neliön)
     * @return Kuva tyhjästä pelipakasta.
     */
    public ImageIcon getTyhjaKortti(){
        return new ImageIcon(getClass().getResource("/GUI/Images/EMPTYSLOT.png"));
    }
    /**
     * Kertoo, onko varsinaisessa sovelluksessa jakopakassa vielä kortteja väärinpäin.
     * @return 
     */
    public boolean onkoJakopakassaVaarinpainKortteja(){
        return sovellus.onkoJakopakassaVaarinpainKortteja();
    }
    /**
     * Kertoo, onko parametrina annettu kortti varsinaisessa sovelluskessa jakopakan päällimmäinen.
     * @param kortinNimi Kortin nimi annettuna muodossa <pakka> <pakan n:nnäs kortti>.
     * @return Onko annettu kortti jakopakan oikeinpäin olevien päällimmäinen.
     */
    public boolean onkoJakopakanPaallimmainen(String kortinNimi){
        PseudoKortti pakka = new PseudoKortti(kortinNimi);
        return jakopakka.size()-1 == pakka.getKortinJarjestysnumero();
    }/**
     * Palauttaa parametrina annetun pelipakan alapakan koon.
     * @param i Pelipakan järjestysnumero.
     * @return Pelipakan koko.
     */
    public int pelipakanAlapakanKoko(int i){
        return sovellus.pelipakanAlapakanKoko(i);
    }
    /**
     * Päivittää luokan privatet linkitetyt listat vastaamaan varsinaisen pelin tilaa.
     */
    private void paivitaPakat(){
        paivitaPelipakat();
        paivitaMaalipakat();
        paivitaJakopakka();
        paivitaPakassaKortteja();
    }
    /**
     * Päivittää luokan pelipakkoja vastaavat linkitetyt listat vastaamaan varsinaisen pelin tilaa.
     */
    private void paivitaPelipakat(){
        pelipakat = new ArrayList<LinkedList<Kortti>>(7);
        for(int i = 0; i < 7; i++)    
            pelipakat.add(i, sovellus.getKuva("pelipakka", i));
    }
    /**
     * Päivittää luokan maalipakkoja vastaavat linkitetyt listat vastaamaan varsinaisen pelin tilaa.
     */
    private void paivitaMaalipakat(){
        maalipakat = new ArrayList<LinkedList<Kortti>>(4);
        for(int i = 0; i < 4; i++)
            maalipakat.add(i, sovellus.getKuva("maalipakka", i));
    }
    /**
     * Päivittää luokan jakopakkaa vastaavan linkitetyn listan vastaamaan varsinaisen pelin tilaa.
     */
    private void paivitaJakopakka(){
        jakopakka = sovellus.getKuva("jakopakka", 0);
    }
    /**
     * Päivittää int arrayn pakassa kortteja vastaamaan varsinaisen pelin tilaa.
     */
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
    /**
     * 
     * @param i
     * @return 
     */
    public boolean onkoTakakorttienMaaraMuuttunut(int i){
        if(pakassaTakaKortteja[i] == sovellus.pelipakanAlapakanKoko(i))
            return false;
        pakassaTakaKortteja[i] = sovellus.pelipakanAlapakanKoko(i);
        return true;   
    }
    /**
     * 
     * @param kortti
     * @return 
     */
    private ImageIcon kortinKuva(Kortti kortti){
        String osoite = "/GUI/Images/" + kortti.getMaa() + "_" + kortti.getArvo() + ".png";
        return new ImageIcon(getClass().getResource(osoite));
    }    
    /**
     * 
     * @param line 
     */
    @Override
    public void out(String line) {
    //Tännepä ei tulekaan mitään xD
    }
    /**
     * 
     */
    @Override
    public void kaynnista() {
        gui.alusta(this);
    }
}