package muistipeli.main;

import javax.swing.SwingUtilities;
import muistipeli.data.Tietokanta;
import muistipeli.kayttoliittyma.GraafinenKayttoliittyma;
import muistipeli.ohjelmalogiikka.Lauta;

/**
 * Luokka käynnistää ohjelman.
 */
public class Main {

    public static void main(String[] args) {
        Lauta lauta=new Lauta(new Tietokanta());
        lauta.uusiPeli(4);
        GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma(lauta);
        SwingUtilities.invokeLater(kayttoliittyma);

    }

}