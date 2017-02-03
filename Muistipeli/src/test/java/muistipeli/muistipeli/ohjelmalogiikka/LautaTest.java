package muistipeli.muistipeli.ohjelmalogiikka;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import muistipeli.muistipeli.ohjelmalogiikka.Lauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LautaTest {

    Lauta lauta;

    @Test
    public void lautaKonstruktoriLuoJaTayttaaKortitOikein() {
        Scanner lukija = new Scanner(System.in);
        lauta = new Lauta(3, 2, lukija);
        assertEquals(6, lauta.kortitKoko());
    }

    @Test
    public void kysyKortinIndeksiysyyNumeroaKunnesNumeroAnnettu() {
        Scanner lukija = new Scanner("a1 a a 1");
        lauta = new Lauta(2, 2, lukija);
        assertEquals(1, lauta.kysyKortinIndeksi(-1));
    }

    @Test
    public void kysyKortinIndeksiKysyyNumeroaKunnesOikeanKokoinenNumeroAnnettu() {
        Scanner lukija = new Scanner("-1 4 100 1");
        lauta = new Lauta(2, 2, lukija);
        assertEquals(1, lauta.kysyKortinIndeksi(-1));
    }

    @Test
    public void kysyKortinIndeksiKysyyNumeroaKunnesEiLoydettyNumeroAnnettu() {
        Scanner lukija = new Scanner("0 1 0 1 2 0 3 4");
        lauta = new Lauta(4, 4, lukija);
        lauta.kaannaKortteja();
        lauta.kaannaKortteja();

        assertEquals(4, lauta.kysyKortinIndeksi(-1));
    }

    @Test
    public void kysyKortinIndeksiEiHyvaksyEnsimmaisenaAnnettuaNumeroaToiseksiKortiksi() {
        Scanner lukija = new Scanner("0 0 1");
        Lauta lauta = new Lauta(4, 4, lukija);
        assertEquals(1, lauta.kysyKortinIndeksi(lauta.kysyKortinIndeksi(-1)));
    }

    @Test
    public void olikoSamatPalauttaaOikeanTotuusarvonKunKortitSamat() {
        Scanner lukija = new Scanner("0 1");
        lauta = new Lauta(2, 2, lukija);
        assertEquals(true, lauta.olikoSamat(0, 1));

    }

    @Test
    public void olikoSamatPalauttaaOikeanTotuusArvonKunKortitEri() {
        Scanner lukija = new Scanner("0 2");
        lauta = new Lauta(2, 2, lukija);
        assertEquals(false, lauta.olikoSamat(0, 2));
    }

    @Test
    public void olikoSamatPalauttaaOikeanTotuusArvonKunKorttienIndeksiSama() {
        Scanner lukija = new Scanner("0 0");
        lauta = new Lauta(2, 2, lukija);
        assertEquals(false, lauta.olikoSamat(0, 0));
    }

    @Test
    public void kaannaKorttejaPalauttaaOikeanTotuusarvonKunKaikkiParitLoydetty() {
        Scanner lukija = new Scanner("0 1 2 3 4 5");
        lauta = new Lauta(3, 2, lukija);
        lauta.kaannaKortteja();
        lauta.kaannaKortteja();
        assertEquals(true, lauta.kaannaKortteja());

    }

    @Test
    public void piirraLautaPiirtaaLaudanOikeinVaikeusasteella3() {
        Scanner lukija = new Scanner("0 1 2 3 4 5");
        lauta = new Lauta(4, 4, lukija);
        assertEquals("|0| |1| |2| |3| |4| |5| |6| |7| |8| |9| |10| |11| |12| |13| |14| |15| ", lauta.piirraLauta());

    }
}
