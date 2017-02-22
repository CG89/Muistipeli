package muistipeli.main;

import javax.swing.SwingUtilities;
import muistipeli.kayttoliittyma.GraafinenKayttoliittyma;
import muistipeli.ohjelmalogiikka.Lauta;

/**
 * Luokka käynnistää ohjelman.
 */
public class Main {

    public static void main(String[] args) {
        Lauta lauta=new Lauta(4);
        lauta.sekoitaKortit();
        lauta.korttienIndeksointi();
        GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma(lauta);
        SwingUtilities.invokeLater(kayttoliittyma);

    }

}