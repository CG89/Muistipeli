package muistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import muistipeli.ohjelmalogiikka.Lauta;

public class Nappikuuntelija implements ActionListener {

    private JButton nappi;
    private int indeksi;
    private Lauta lauta;
    private JFrame frame;

    public Nappikuuntelija(JButton nappi, JFrame frame, Lauta lauta) {
        this.indeksi = Integer.parseInt(nappi.getText()) - 1;
        this.lauta = lauta;
        this.nappi = nappi;
        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        lauta.suljeVanhatAvatutKortit();
        int vuoronNumero = lauta.getVuoronNumero();
        String palautus = lauta.korttiKaannetty(indeksi, nappi);
        frame.setTitle("Vuoro #" + vuoronNumero + ": " + lauta.getTietokanta().getAktiivinenPelaaja() + ", " + lauta.getTietokanta().getAktiivinenPelaaja().getPistetilanne() + " löydetty ");
        nappi.setText("");
        nappi.setIcon(new ImageIcon(lauta.getTietokanta().getSekoitetutKortit().get(indeksi).getKuva()));
        if (palautus.equals("Voitit pelin, onneksi olkoon!")) {
            if (lauta.getPelaajamaara() == 2) {
                frame.setTitle("Lopulliset pisteet: " + lauta.getTietokanta().getPelaajat().get(0) + ": " + lauta.getTietokanta().getPelaajat().get(0).getPistetilanne() + " | "
                        + lauta.getTietokanta().getPelaajat().get(1) + ": " + lauta.getTietokanta().getPelaajat().get(1).getPistetilanne());
            } else {
                frame.setTitle("Löysit kaikki parit " + lauta.getVuoronNumero() + " vuorossa!");

            }
        }
    }

}
