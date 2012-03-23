package Pasianssi;

import Kortti.Kortti;

public class Slotti {
    private PinoFaceUp oikeinpain;
    private PinoFifo vaarinpain;
   
    public Slotti(PinoFaceUp oikeinpain, PinoFifo vaarinpain){
        this.oikeinpain = oikeinpain;
        this.vaarinpain = vaarinpain;
    }
    
    public Kortti getKortti(){
        if(!oikeinpain.isEmpty())
            return oikeinpain.getKortti();
        else 
            return null;
    }
    
    public PinoFaceUp getKortti(int i){
        if(!oikeinpain.isEmpty())
            return oikeinpain.removeKortti(i);
        else 
            return null;
    }
    public Kortti removeKortti(){
        if(!oikeinpain.isEmpty())
            return oikeinpain.removeKortti();
        return null;
    }
    public PinoFifo removeKortti(int i){
        if(!oikeinpain.isEmpty())
            return oikeinpain.removeKortti(i);
        else 
            return null;
    }
    
    public boolean setPaalle(Kortti laitettava){

        if (this.isEmpty() || laitettava.getArvo() == 13){
            oikeinpain.setKortti(laitettava);
            return true;
        }
        
        if (oikeinpain.getKoko() == 0){
            return false;
        }
        
        Kortti verrattava = oikeinpain.getPaallimmainen();
        if (voikoLaittaa(verrattava, laitettava)){
            oikeinpain.setKortti(laitettava);
            return true;
        }
        return false;
    }
    public boolean setPaalle(PinoFaceUp kasaKortteja){
        
        Kortti laitettava = kasaKortteja.getPohjimmainen();
        
        if (this.isEmpty() || laitettava.getArvo() == 13){
            oikeinpain.setKortti(kasaKortteja);
            return true;
        }
        
        if (oikeinpain.getKoko() == 0){
            return false;
        }
        
        Kortti verrattava = oikeinpain.getPaallimmainen();
        if (voikoLaittaa(verrattava, laitettava)){
            oikeinpain.setKortti(kasaKortteja);
            return true;
        }
        return false;
    }
    
    public void kaannaPaalle(){
        if(!paallimmainenOikeinpain())
            setPaalle(vaarinpain.removeKortti());
    }
    
    public boolean paallimmainenOikeinpain(){
        if (oikeinpain.isEmpty())
            return false;
        else return true;
    }
    
    public boolean isEmpty(){
        if (oikeinpain.isEmpty() && vaarinpain.isEmpty())
                return true;
        else
            return false;
    }
    
    private boolean voikoLaittaa(Kortti verrattava, Kortti laitettava){
        
        if(!laitettava.samaaMaata(verrattava))
            if(verrattava.getArvo() - laitettava.getArvo() == 1)
                return true;
        return false;
    }
  
}
