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

        lauta = new Lauta(3, 2);
        assertEquals(6, lauta.getKortitKoko());
    }

    @Test
    public void olikoSamatPalauttaaOikeanTotuusarvonKunKortitSamat() {

        lauta = new Lauta(2, 2);
        assertEquals(true, lauta.olikoSamat(0, 1));

    }

    @Test
    public void olikoSamatPalauttaaOikeanTotuusarvonKunKortitEri() {

        lauta = new Lauta(2, 2);
        assertEquals(false, lauta.olikoSamat(0, 2));
    }

    @Test
    public void olikoSamatPalauttaaOikeanTotuusarvonKunKorttienIndeksiSama() {

        lauta = new Lauta(2, 2);
        assertEquals(false, lauta.olikoSamat(0, 0));
    }

    @Test
    public void olikoSamatPalauttaaOikeanTotuusarvonKunEnsimmainenKorttiLoydetty() {
        lauta = new Lauta(2, 2);
        lauta.olikoSamat(0, 1);
        assertEquals(false, lauta.olikoSamat(0, 2));
    }

    @Test
    public void olikoSamatPalauttaaOikeanTotuusarvonKunToinenKorttiLoydetty() {
        lauta = new Lauta(2, 2);
        lauta.olikoSamat(0, 1);
        assertEquals(false, lauta.olikoSamat(1, 2));
    }

    @Test
    public void olikoSamatPalauttaaOikeanTotuusarvonKunMolemmatKortitLoydetty() {
        lauta = new Lauta(2, 2);
        lauta.olikoSamat(0, 1);
        assertEquals(false, lauta.olikoSamat(0, 1));
    }
    
    @Test
    public void sekoitaKortitSekoittaaKortit(){
        lauta=new Lauta(1,1);
        Lauta lautaSekaisin=new Lauta(1,1);
        lautaSekaisin.sekoitaKortit();
        assertEquals(false,lauta==lautaSekaisin);
    }
}
