/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kortti;

/**
 *
 * @author atte
 */

public class Maa{
    
    private final String maa;
    private final char vari;
    
    public Maa (String mikaMaa) throws IllegalArgumentException{
        
        
        if(mikaMaa.compareTo("hertta") == 0){
            maa = mikaMaa;
            vari = 'p';
            return;
        }
        if(mikaMaa.compareTo("ruutu") == 0){
            maa = mikaMaa;
            vari = 'p';
            return;
        }
        if(mikaMaa.compareTo("risti") == 0){
            maa = mikaMaa;
            vari = 'm';
            return;
        }
        if(mikaMaa.compareTo("pata") == 0){
            maa = mikaMaa;
            vari = 'm';
            return;
        }
        
        IllegalArgumentException e = new IllegalArgumentException(mikaMaa + " ei ole hyväksyttävä maan arvo");
        throw e;
    }
    
    public String getMaa(){
        return maa;
    }
    
    public char getVari(){
        return vari;
    }
    
    @Override
        public boolean equals(Object olio) {
        if (olio == null) {
            return false;
        }

        if (getClass() != olio.getClass()) {
            return false;
        }
        
        Maa verrattava = (Maa) olio;
        
        return (this.maa.equals(verrattava.getMaa()));
    }
    @Override
    public String toString(){
        return maa;
    }
}
