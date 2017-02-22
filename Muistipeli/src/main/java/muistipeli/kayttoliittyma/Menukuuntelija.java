/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.kayttoliittyma;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import muistipeli.ohjelmalogiikka.Lauta;

/**
 *
 * @author chgr
 */
public class Menukuuntelija implements ActionListener {
    private JMenuItem menuItem;
    private GraafinenKayttoliittyma gui;
    private int napinNumero;
    private int vaikeusaste;
    public Menukuuntelija(JMenuItem menuItem,GraafinenKayttoliittyma gui){
        this.menuItem=menuItem;
        this.gui=gui;
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent a){
        Container container=gui.getFrame().getContentPane();
        container.removeAll();
        this.napinNumero=mikaNappi(menuItem);
        if(napinNumero>2&&napinNumero<6){
            gui.setLauta(new Lauta(napinNumero));
        }else{
            gui.setLauta(new Lauta(gui.getLauta().getVaikeusaste()));
        }
        gui.getLauta().sekoitaKortit();
        gui.getLauta().korttienIndeksointi();
        gui.luoKomponentit(container);
        gui.getFrame().pack();
    }
    
    public int mikaNappi(JMenuItem menuItem){
        String teksti=menuItem.getText();
        if(teksti.equals("Uusi peli")){
            return gui.getLauta().getVaikeusaste();
        }if(teksti.equals("Helppo")){
            return 3;
        }if(teksti.equals("Keskitaso")){
            return 4;
        }if(teksti.equals("Vaikea")){
            return 5;
        }else{
            return 4;
        }
    }
    
}
