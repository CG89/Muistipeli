package muistipeli.ohjelmalogiikka;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import javax.swing.JButton;
import muistipeli.data.Kortti;
import muistipeli.ohjelmalogiikka.Lauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LautaTest {

    Lauta lauta;

//    @Test
//    public void lautaKonstruktoriLuoJaTayttaaKortitOikein() {
//
//        lauta = new Lauta(3, 2);
//        assertEquals(6, lauta.getKortitKoko());
//    }
    @Before
    public void setUp() {
        lauta=new Lauta(4);
    }

    @Test
    public void korttienNimeaminenLuoNimetlistan() {     
        assertNotSame(null, lauta.getNimet());
    }

    @Test
    public void korttienLuominenluoKortitlistan() {
        assertNotSame(null, lauta.getKortit().size());
    }

    @Test
    public void korttienIndeksointiIndeksoiKortit() {
        assertEquals(0, lauta.getKortit().get(0).getIndeksi());
    }

    @Test
    public void olikoKorttiJoKaannettyTaiLoydettyPalauttaaOikeanViestinKunKorttiKaannetty() {
        lauta.getKortit().get(0).setAvattu(true);
        assertEquals("Valitsit saman kortin uudestaan, valitse toinen kortti!", lauta.olikoKorttiJoKaannettyTaiLoydetty(0));
    }

    @Test
    public void olikoKorttiJoKaannettyTaiLoydettyPalauttaaOikeanViestinKunKorttiLoydetty() {        
        lauta.getKortit().get(0).setLoydetty(true);
        assertEquals("Valitsit jo löydetyn kortin, valitse toinen kortti!", lauta.olikoKorttiJoKaannettyTaiLoydetty(0));
    }

    @Test
    public void olikoKorttiJoKaannettyTaiLoydettyPalauttaaOikeanViestinKunKelvollinenKortti() {       
        assertEquals("kelvollinen kortti", lauta.olikoKorttiJoKaannettyTaiLoydetty(0));
    }

    @Test
    public void ensimmainenKorttiValittuPalauttaaOikeanViestin() {     
        JButton nappi = new JButton();
        assertEquals("Yritä löytää kääntämällesi kortille pari", lauta.ensimmainenKorttiValittu(0, nappi));
    }

    @Test
    public void ensimmainenKorttiValittuAsettaaEnsimmaisenKortinOikein() {
        JButton nappi = new JButton();
        lauta.ensimmainenKorttiValittu(0, nappi);
        assertEquals(lauta.getKortit().get(0), lauta.getEnsimmainenAvattuKortti());
    }

    @Test
    public void ensimmainenKorttiValittuAsettaaEnsimmaisenPainetunNapinOikein() {
        JButton nappi = new JButton();
        lauta.ensimmainenKorttiValittu(0, nappi);
        assertEquals(nappi, lauta.getEnsimmainenPainettuNappi());
    }

    @Test
    public void ensimmainenKorttiValittuAsettaaAvatunKortinAvatuksi() {
        JButton nappi = new JButton();
        lauta.ensimmainenKorttiValittu(0, nappi);
        assertEquals(true, lauta.getKortit().get(0).getAvattu());
    }

    @Test
    public void toinenKorttiValittuAsettaaToisenAvatunKortinOikein() {
        JButton nappi = new JButton();
        lauta.toinenKorttiValittu(0, nappi);
        assertEquals(lauta.getKortit().get(0), lauta.getToinenAvattuKortti());
    }

    @Test
    public void toinenKorttiValittuAsettaaToisenPainetunNapinOikein() {
        JButton nappi = new JButton();
        lauta.toinenKorttiValittu(0, nappi);
        assertEquals(nappi, lauta.getToinenPainettuNappi());
    }

    @Test
    public void toinenKorttiValittuAsettaaAvatunKortinAvatuksi() {
        JButton nappi = new JButton();
        lauta.toinenKorttiValittu(0, nappi);
        assertEquals(true, lauta.getToinenAvattuKortti().getAvattu());
    }

    @Test
    public void olikoSamatKortitPalauttaaOikeanTotuusarvonKunKortitSamat() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getKortit().get(1));
        assertEquals(true, lauta.olikoSamatkortit(lauta.getEnsimmainenAvattuKortti(), lauta.getToinenAvattuKortti()));
    }

    @Test
    public void olikoSamatKortitPalauttaaOikeanTotuusarvonKunKortitEri() {
        lauta.setEnsimmainenAvattuKortti(lauta.getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getKortit().get(2));
        assertEquals(false, lauta.olikoSamatkortit(lauta.getEnsimmainenAvattuKortti(), lauta.getToinenAvattuKortti()));
    }

    @Test
    public void korttiKaannettyPalauttaaOikeanViestinKunAvattuKorttiKaannetty() {
        lauta.getKortit().get(0).setAvattu(true);
        JButton nappi = new JButton();
        assertEquals("Valitsit saman kortin uudestaan, valitse toinen kortti!", lauta.korttiKaannetty(0, nappi));
    }

    @Test
    public void korttiKaannettyPalauttaaOikeanViestinKunEnsimmainenKorttiAvattuOnnistuneesti() {
        JButton nappi = new JButton();
        assertEquals("Yritä löytää kääntämällesi kortille pari", lauta.korttiKaannetty(0, nappi));
    }

    @Test
    public void korttiKaannettyPalauttaaOikeanViestinKunViimeinenPariAvattu() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getKortit().get(0));
        lauta.setParejaLoydetty((lauta.getKortit().size() / 2) - 1);
        JButton nappi = new JButton();
        assertEquals("Voitit pelin, onneksi olkoon!", lauta.korttiKaannetty(1, nappi));
    }

    @Test
    public void korttiKaannettyPalauttaaOikeanViestinKunPariAvattu() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getKortit().get(0));
        JButton nappi = new JButton();
        assertEquals("Löysit parin, hienoa!", lauta.korttiKaannetty(1, nappi));
    }

    @Test
    public void korttiKaannettyPalauttaaOikeanViestinKunPariaEiAvattu() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getKortit().get(0));
        JButton nappi = new JButton();
        assertEquals("Et löytänyt paria", lauta.korttiKaannetty(2, nappi));
    }

    @Test
    public void suljeVanhatAvatutKortitPalauttaaOikeanTotuusArvonKunPariaEiLoytynyt() {
        lauta.setEnsimmainenAvattuKortti(lauta.getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getKortit().get(2));
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        assertEquals(true, lauta.suljeVanhatAvatutKortit());
    }

    @Test
    public void suljeVanhatAvatutKorttitPalauttaaFalseKunKahtaKorttiaEiOleVielaAvattu() {
        lauta.setEnsimmainenAvattuKortti(lauta.getKortit().get(0));
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        assertEquals(false, lauta.suljeVanhatAvatutKortit());
    }

    @Test
    public void suljeVanhatAvatutKortitEiSuljeLoydettyjaKortteja() {
        lauta.setEnsimmainenAvattuKortti(lauta.getKortit().get(0));
        lauta.getKortit().get(0).setLoydetty(true);
        lauta.setToinenAvattuKortti(lauta.getKortit().get(1));
        lauta.getKortit().get(1).setLoydetty(true);
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        assertEquals(false, lauta.suljeVanhatAvatutKortit());
    }
//    @Test
//    public void olikoSamatPalauttaaOikeanTotuusarvonKunKortitSamat() {
//
//        lauta = new Lauta(2, 2);
//        assertEquals(true, lauta.olikoSamat(0, 1));
//
//    }
//
//    @Test
//    public void olikoSamatPalauttaaOikeanTotuusarvonKunKortitEri() {
//
//        lauta = new Lauta(2, 2);
//        assertEquals(false, lauta.olikoSamat(0, 2));
//    }
//
//    @Test
//    public void olikoSamatPalauttaaOikeanTotuusarvonKunKorttienIndeksiSama() {
//
//        lauta = new Lauta(2, 2);
//        assertEquals(false, lauta.olikoSamat(0, 0));
//    }
//
//    @Test
//    public void olikoSamatPalauttaaOikeanTotuusarvonKunEnsimmainenKorttiLoydetty() {
//        lauta = new Lauta(2, 2);
//        lauta.olikoSamat(0, 1);
//        assertEquals(false, lauta.olikoSamat(0, 2));
//    }
//
//    @Test
//    public void olikoSamatPalauttaaOikeanTotuusarvonKunToinenKorttiLoydetty() {
//        lauta = new Lauta(2, 2);
//        lauta.olikoSamat(0, 1);
//        assertEquals(false, lauta.olikoSamat(1, 2));
//    }
//
//    @Test
//    public void olikoSamatPalauttaaOikeanTotuusarvonKunMolemmatKortitLoydetty() {
//        lauta = new Lauta(2, 2);
//        lauta.olikoSamat(0, 1);
//        assertEquals(false, lauta.olikoSamat(0, 1));
//    }
//    

    @Test
    public void sekoitaKortitSekoittaaKortit() {
        Kortti kortti1 = lauta.getKortit().get(0);
        Kortti kortti2 = lauta.getKortit().get(0);
        while (true) {
            lauta.sekoitaKortit();
            lauta.korttienIndeksointi();
            kortti2 = lauta.getKortit().get(0);
            if (kortti1 != kortti2) {
                break;
            }
        }
        assertNotEquals(kortti1, kortti2);
    }
}
