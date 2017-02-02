/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import muistipeli.muistipeli.ohjelmalogiikka.Lauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chgr
 */
public class MuistipeliTest {

   

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
        assertEquals(1, lauta.kysyKortinIndeksi());
    }

    @Test
    public void kysyKortinIndeksiKysyyNumeroaKunnesOikeanKokoinenNumeroAnnettu() {
        Scanner lukija = new Scanner("-1 4 100 1");
        lauta = new Lauta(2, 2, lukija);
        assertEquals(1, lauta.kysyKortinIndeksi());
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
}
