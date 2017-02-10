package muistipeli.muistipeli.kayttoliittyma;

import java.util.HashSet;
import java.util.Scanner;
import muistipeli.muistipeli.ohjelmalogiikka.Lauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TekstikayttoliittymaTest {

    Tekstikayttoliittyma ui;

    @Test
    public void pelaajienMaaraKysyyPelaajamaaraaKunnesNumeroAnnettu() {
        Scanner lukija = new Scanner("a1 a a 1");
        ui = new Tekstikayttoliittyma(lukija);
        assertEquals(1, ui.pelaajienMaara());
    }

    @Test
    public void pelaajienMaaraKysyyPelaajamaaraaKunnesSopivaNumeroAnnettu() {
        Scanner lukija = new Scanner("0 4 -1 1");
        ui = new Tekstikayttoliittyma(lukija);
        assertEquals(1, ui.pelaajienMaara());
    }

    @Test
    public void pelaajienNimetTallentaaPelaaja1NimenOikein() {
        Scanner lukija = new Scanner("a1 a a 1");
        ui = new Tekstikayttoliittyma(lukija);
        ui.pelaajienNimet();
        assertEquals("a1", ui.pelaaja1.getNimi());
    }

    @Test
    public void pelaajienNimetTallentaaPelaaja2NimenOikeinKunKaksiPelaajaa() {
        Scanner lukija = new Scanner("a1 a a 1");
        ui = new Tekstikayttoliittyma(lukija);
        ui.setPelaajia(2);

        ui.pelaajienNimet();
        assertEquals("a", ui.pelaaja2.getNimi());
    }

    @Test
    public void vaikeusasteKysyyPelaajamaaraaKunnesNumeroAnnettu() {
        Scanner lukija = new Scanner("a1 a a 1");
        ui = new Tekstikayttoliittyma(lukija);
        assertEquals(1, ui.vaikeusaste());
    }

    @Test
    public void vaikeusasteKysyyPelaajamaaraaKunnesSopivaNumeroAnnettu() {
        Scanner lukija = new Scanner("0 4 -1 1");
        ui = new Tekstikayttoliittyma(lukija);
        assertEquals(1, ui.vaikeusaste());
    }

    @Test
    public void kysyKortinIndeksiysyyNumeroaKunnesNumeroAnnettu() {
        Scanner lukija = new Scanner("a1 a a 1");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(1);

        assertEquals(1, ui.kysyKortinIndeksi(-1));
    }

    @Test
    public void kysyKortinIndeksiKysyyNumeroaKunnesOikeanKokoinenNumeroAnnettu() {
        Scanner lukija = new Scanner("-1 4 100 1");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(1);
        assertEquals(1, ui.kysyKortinIndeksi(-1));
    }

    @Test
    public void kysyKortinIndeksiKysyyNumeroaKunnesEiLoydettyNumeroAnnettu() {
        Scanner lukija = new Scanner("0 1 0 1 2 ");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(1);
        ui.pelilauta.olikoSamat(0, 1);

        assertEquals(2, ui.kysyKortinIndeksi(-1));
    }

    @Test
    public void kysyKortinIndeksiEiHyvaksyEnsimmaisenaAnnettuaNumeroaToiseksiKortiksi() {
        Scanner lukija = new Scanner("0 0 1");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(1);
        assertEquals(1, ui.kysyKortinIndeksi(ui.kysyKortinIndeksi(-1)));
    }

    @Test
    public void piirraLautaPiirtaaLaudanOikeinVaikeusasteella3() {
        Scanner lukija = new Scanner("0 1 2 3 4 5");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(3);
        assertEquals("|0| |1| |2| |3| |4| |5| |6| |7| |8| |9| |10| |11| |12| |13| |14| |15| ", ui.piirraLauta());

    }

    @Test
    public void piirraLautaPiirtaaLaudanOikeinVaikeusasteella3Kun2Ja3Loydetty() {
        Scanner lukija = new Scanner("0 1 2 3 4 5");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(3);
        ui.pelilauta.olikoSamat(2, 3);
        assertEquals("|0| |1| |X| |X| |4| |5| |6| |7| |8| |9| |10| |11| |12| |13| |14| |15| ", ui.piirraLauta());

    }

    @Test
    public void pelaaKunnesToinenVoittaaPäättyyKunPelaaja1Voittaa() {
        Scanner lukija = new Scanner("0 1 2 3 4 5");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(3);
        ui.pelaaja1.setVoittiko(true);
        assertEquals(ui.pelaaja1, ui.pelaaKunnesToinenVoittaa());

    }

    @Test
    public void pelaaKunnesToinenVoittaaPalauttaaOikeanPelaajanKunPelaaja2Voittaa() {
        Scanner lukija = new Scanner("0 6 2 3 4 5");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(3);
        ui.pelaaja2.setVoittiko(true);
        assertEquals(ui.pelaaja2, ui.pelaaKunnesToinenVoittaa());

    }

    @Test
    public void voittajanjulistusPalauttaaOikeanOnnentoivotuksen() {
        Scanner lukija = new Scanner("0 1 2 3 4 5");
        ui = new Tekstikayttoliittyma(lukija);
        ui.pelaaja1.setVoittiko(true);
        ui.voittajanJulistus(ui.pelaaja1);
        assertEquals(ui.pelaaja1.getNimi() + " Voitti pelin " + ui.pelaaja1.getPistetilanne() + " vuoron jälkeen, onneksi olkoon!", ui.voittajanJulistus(ui.pelaaja1));

    }

    @Test
    public void pelaaVuoroPalauttaaOikeanTotuusarvonKunKaikkiLoydetty() {
        Scanner lukija = new Scanner("0 1 2 3 0 1");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(1);

        assertEquals(true, ui.pelaaVuoro(ui.pelaaja1));
    }

    @Test
    public void pelaaVuoroPalauttaaOikeanTotuusarvonKunEiLoydetaParia() {
        Scanner lukija = new Scanner("0 2 2 3 0 1");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(1);

        assertEquals(false, ui.pelaaVuoro(ui.pelaaja1));
    }

    @Test
    public void pelaaVuoroAsettaaPelaajanVoittikoTrueKunViimeinenPariLoytyy() {
        Scanner lukija = new Scanner("0 1 2 3 0 1");
        ui = new Tekstikayttoliittyma(lukija);
        ui.luoPelilauta(1);
        ui.pelaaVuoro(ui.pelaaja1);
        ui.pelaaVuoro(ui.pelaaja1);
        assertEquals(true, ui.pelaaja1.getVoittiko());
    }

}
