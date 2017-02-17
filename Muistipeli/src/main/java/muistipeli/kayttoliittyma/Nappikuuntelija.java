/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.kayttoliittyma;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import muistipeli.ohjelmalogiikka.Lauta;

public class Nappikuuntelija implements ActionListener {

    private JButton nappi;
    private int indeksi;
    private Lauta lauta;
    private JFrame frame;

    public Nappikuuntelija(JButton nappi, JFrame frame, Lauta lauta) {
        this.indeksi = Integer.parseInt(nappi.getText());
        this.lauta = lauta;
        this.nappi = nappi;
        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        lauta.suljeVanhatAvatutKortit();
        frame.setTitle(lauta.korttiKaannetty(indeksi, nappi));
        nappi.setText(lauta.getKortit().get(indeksi).toString());

    }

}
