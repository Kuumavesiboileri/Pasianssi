/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Korttipakka;

import Kortti.Kortti;
import java.util.LinkedList;

/**
 *
 * @author atte
 */
public interface PakkaRajapinta {
    public Kortti getKortti();
    public Kortti removeKortti();
    public void setKortti(Kortti kortti);
    public boolean voikoLaittaa(Kortti paalle);
    public LinkedList<Kortti> getKuva();
}
