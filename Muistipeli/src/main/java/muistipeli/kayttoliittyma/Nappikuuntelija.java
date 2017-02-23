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
        this.indeksi = Integer.parseInt(nappi.getText());
        this.lauta = lauta;
        this.nappi = nappi;
        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        lauta.suljeVanhatAvatutKortit();
        frame.setTitle(lauta.korttiKaannetty(indeksi, nappi));
        nappi.setText("");
        nappi.setIcon(new ImageIcon(lauta.getTietokanta().getSekoitetutKortit().get(indeksi).getKuva()));

    }

}
