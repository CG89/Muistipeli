/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.muistipeli.ohjelmalogiikka;

import java.util.*;

public class Lauta {
    private int leveys;
    private int korkeus;
    private ArrayList kortit;
    private Scanner lukija;
    private int parejaLoydetty;
    
    public Lauta(int leveys, int korkeus, Scanner lukija){
        this.lukija=lukija;
        this.leveys=leveys;
        this.korkeus=korkeus;
        int ruutuja=leveys*korkeus;
        this.kortit=new ArrayList();
        this.parejaLoydetty=0;
        for (int i = 0; i < ruutuja/2; i++) {
            kortit.add(i);
            kortit.add(i);
            
        }
    }
    
    public void peliAlkaa(){
        System.out.println("Laudalla on "+kortit.size()+" korttia numeroituna 0-"+(kortit.size()-1));
        System.out.println("Valitse ensin yksi korteista syöttämällä kortin numero, minkä jälkeen näet, mikä kortti on kyseessä");
        while (true)
            if(kaannaKortteja()){
                break;
            }
        System.out.println("Voitit pelin, onneksi olkoon!");
        
        
        
    }

    private boolean kaannaKortteja() {
        System.out.print("Syötä käännettävän kortin numero: ");
        int ensimmaisenIndeksi=lukija.nextInt();
        System.out.println(kortit.get(ensimmaisenIndeksi));
        System.out.print("Syötä toisen käännettävän kortin numero ja yritä löytää kääntämällesi kortille pari: ");
        int toisenIndeksi=lukija.nextInt();
        
        System.out.println(kortit.get(toisenIndeksi));
        if(!olikoSamat(ensimmaisenIndeksi, toisenIndeksi)){
            System.out.println("Et löytänyt paria, yritä uudestaan");
        }else{
            System.out.println("Löysit parin, hienoa!");
            parejaLoydetty++;
            if(parejaLoydetty==kortit.size()/2){
                return true;
            }
        }return false;
    }
    
    public void kerroKortit(){
        String tulostaKortit="";
        for (int i = 0; i < kortit.size(); i++) {
            tulostaKortit+=(kortit.get(i)+", ");
        }
        System.out.println(tulostaKortit);
    }
    
    private boolean olikoSamat(int ensimmaisenIndeksi, int toisenIndeksi){
        if(kortit.get(ensimmaisenIndeksi)==kortit.get(toisenIndeksi)&&kortit.get(ensimmaisenIndeksi)!="Löydetty"&&kortit.get(toisenIndeksi)!="Löydetty"){
            kortit.set(ensimmaisenIndeksi, "Löydetty");
            kortit.set(toisenIndeksi, "Löydetty");
            
            return true;
        }else{
            return false;
        }
    }
    
}
