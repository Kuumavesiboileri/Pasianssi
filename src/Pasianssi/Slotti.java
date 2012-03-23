package Pasianssi;

import Kortti.Kortti;

public class Slotti {
    private Korttipaikka oikeinpain;
    private Korttipino vaarinpain;
   
    public Slotti(Korttipaikka oikeinpain, Korttipino vaarinpain){
        this.oikeinpain = oikeinpain;
        this.vaarinpain = vaarinpain;
    }
    
    public Kortti getKortti(){
        if(!oikeinpain.isEmpty())
            return oikeinpain.getKortti();
        else 
            return null;
    }
    
    public Korttipino removeKortti(int i){
        if(!oikeinpain.isEmpty())
            return oikeinpain.removeKortti(i);
        else 
            return null;
    }
    public Korttipaikka getKortti(int i){
        if(!oikeinpain.isEmpty())
            return oikeinpain.removeKortti(i);
        else 
            return null;
    }
    
    public void kaanna(){
        if(oikeinpain.isEmpty())
            oikeinpain.setKortti(vaarinpain.getKortti());
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
  
}
