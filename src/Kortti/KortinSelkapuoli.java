/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

/**
 *
 * @author atte
 */
public class KortinSelkapuoli extends Kortti{
   
    
    public KortinSelkapuoli(Maa maa, int lukuarvo){
        super(maa, 1);
    }
    
    @Override
    public boolean samaaMaata(Kortti toinenKortti){
        return false;
    }
    
    @Override
    public boolean samaaVaria(Kortti toinenKortti){
        return false;
    }
    @Override
    public String getMaa(){
        return "BACK";
    }
    
    @Override
    public int getArvo(){
        return 0;
    }
    @Override
    public String toString(){
        return "###";
    }
    
}
