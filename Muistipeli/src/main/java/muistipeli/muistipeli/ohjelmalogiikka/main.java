/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.muistipeli.ohjelmalogiikka;

import java.util.Scanner;

/**
 *
 * @author chgr
 */
public class main {
    public static void main(String[] args){
        Scanner lukija = new Scanner( System.in );
        System.out.println("Tervetuloa pelaamaan Muistipeliä!\nAloitetaan pelaamaalla yksinpeli 4:n ruudun laudalla.");
        Lauta lauta=new Lauta(2,2,lukija);
        lauta.peliAlkaa();
        
    }
    
}
