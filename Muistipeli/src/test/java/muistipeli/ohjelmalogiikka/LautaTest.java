package muistipeli.ohjelmalogiikka;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import muistipeli.data.Kortti;
import muistipeli.data.Tietokanta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LautaTest {

    Lauta lauta;

    @Before
    public void setUp() {
        lauta = new Lauta(new Tietokanta());
        lauta.uusiPeli(4);
        lauta.getTietokanta().setSekoitetutkortit(lauta.getTietokanta().getKortit());

    }

    @Test
    public void olikoKorttiJoKaannettyTaiLoydettyPalauttaaOikeanViestinKunKorttiKaannetty() {

        lauta.getTietokanta().getSekoitetutKortit().get(0).setAvattu(true);
        assertEquals("Valitsit saman kortin uudestaan, valitse toinen kortti!", lauta.olikoKorttiJoKaannettyTaiLoydetty(0));
    }

    @Test
    public void olikoKorttiJoKaannettyTaiLoydettyPalauttaaOikeanViestinKunKorttiLoydetty() {
        lauta.getTietokanta().getSekoitetutKortit().get(0).setLoydetty(true);
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
        assertEquals(lauta.getTietokanta().getSekoitetutKortit().get(0), lauta.getEnsimmainenAvattuKortti());
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
        assertEquals(true, lauta.getTietokanta().getSekoitetutKortit().get(0).getAvattu());
    }

    @Test
    public void toinenKorttiValittuAsettaaToisenAvatunKortinOikein() {
        JButton nappi = new JButton();
        lauta.toinenKorttiValittu(0, nappi);
        assertEquals(lauta.getTietokanta().getSekoitetutKortit().get(0), lauta.getToinenAvattuKortti());
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
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(1));
        assertEquals(true, lauta.olikoSamatkortit(lauta.getEnsimmainenAvattuKortti(), lauta.getToinenAvattuKortti()));
    }

    @Test
    public void olikoSamatKortitPalauttaaOikeanTotuusarvonKunKortitEri() {
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(2));
        assertEquals(false, lauta.olikoSamatkortit(lauta.getEnsimmainenAvattuKortti(), lauta.getToinenAvattuKortti()));
    }

    @Test
    public void korttiKaannettyPalauttaaOikeanViestinKunAvattuKorttiKaannetty() {
        lauta.getTietokanta().getKortit().get(0).setAvattu(true);
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
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setParejaLoydetty((lauta.getTietokanta().getKortit().size() / 2) - 1);
        JButton nappi = new JButton();
        assertEquals("Voitit pelin, onneksi olkoon!", lauta.korttiKaannetty(1, nappi));
    }

    @Test
    public void korttiKaannettyPalauttaaOikeanViestinKunPariAvattu() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        JButton nappi = new JButton();
        assertEquals("Löysit parin, hienoa!", lauta.korttiKaannetty(1, nappi));
    }

    @Test
    public void korttiKaannettyPalauttaaOikeanViestinKunPariaEiAvattu() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        JButton nappi = new JButton();
        assertEquals("Et löytänyt paria", lauta.korttiKaannetty(2, nappi));
    }

    @Test
    public void suljeVanhatAvatutKortitPalauttaaOikeanTotuusArvonKunPariaEiLoytynyt() {
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(2));
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        assertEquals(true, lauta.suljeVanhatAvatutKortit());
    }

    @Test
    public void suljeVanhatAvatutKorttitPalauttaaFalseKunKahtaKorttiaEiOleVielaAvattu() {
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        assertEquals(false, lauta.suljeVanhatAvatutKortit());
    }

    @Test
    public void suljeVanhatAvatutKortitEiSuljeLoydettyjaKortteja() {
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.getTietokanta().getKortit().get(0).setLoydetty(true);
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(1));
        lauta.getTietokanta().getKortit().get(1).setLoydetty(true);
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        assertEquals(false, lauta.suljeVanhatAvatutKortit());
    }

    @Test
    public void suljeVanhatKortitAsettaaEnsimmainenAvattuKorttiAvattuFalseksiKunEiPari() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(2));
        lauta.getEnsimmainenAvattuKortti().setAvattu(true);
        lauta.getToinenAvattuKortti().setAvattu(true);
        Kortti kortti = lauta.getEnsimmainenAvattuKortti();
        lauta.suljeVanhatAvatutKortit();
        assertEquals(false, kortti.getAvattu());
    }

    @Test
    public void suljeVanhatKortitAsettaaToinenAvattuKorttiAvattuFalseksiKunEiPari() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(2));
        lauta.getEnsimmainenAvattuKortti().setAvattu(true);
        lauta.getToinenAvattuKortti().setAvattu(true);
        Kortti kortti = lauta.getToinenAvattuKortti();
        lauta.suljeVanhatAvatutKortit();
        assertEquals(false, kortti.getAvattu());
    }

    @Test
    public void suljeVanhatKortitAsettaaEnsimmainenPainettuKorttiIconinNulliksiKunEiPari() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(2));
        lauta.getEnsimmainenAvattuKortti().setAvattu(true);
        lauta.getToinenAvattuKortti().setAvattu(true);
        Kortti kortti = lauta.getEnsimmainenAvattuKortti();
        lauta.getEnsimmainenPainettuNappi().setIcon(new ImageIcon(kortti.getKuva()));
        
        lauta.suljeVanhatAvatutKortit();
        assertEquals(null, lauta.getEnsimmainenPainettuNappi().getIcon());
    }

    @Test
    public void suljeVanhatKortitAsettaaToinenPainettuNappiIconinNulliksiKunEiPari() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(2));
        lauta.getEnsimmainenAvattuKortti().setAvattu(true);
        lauta.getToinenAvattuKortti().setAvattu(true);
        Kortti kortti = lauta.getToinenAvattuKortti();
        lauta.getToinenPainettuNappi().setIcon(new ImageIcon(kortti.getKuva()));
        lauta.suljeVanhatAvatutKortit();
        assertEquals(null, lauta.getToinenPainettuNappi().getIcon());
    }

    @Test
    public void suljeVanhatKortitAsettaaToinenPainettuNappiTekstinToisenKortinIndeksinMukaanKunEiPari() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(2));
        lauta.getEnsimmainenAvattuKortti().setAvattu(true);
        lauta.getToinenAvattuKortti().setAvattu(true);
        Kortti kortti = lauta.getToinenAvattuKortti();
        lauta.suljeVanhatAvatutKortit();
        String indeksi = "";
        indeksi += kortti.getIndeksi();
        assertEquals(indeksi, lauta.getToinenPainettuNappi().getText());
    }

    @Test
    public void suljeVanhatKortitAsettaaEnsimmainenPainettuNappiTekstinEnsimmainenKortinIndeksinMukaanKunEiPari() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(2));
        lauta.getEnsimmainenAvattuKortti().setAvattu(true);
        lauta.getToinenAvattuKortti().setAvattu(true);
        Kortti kortti = lauta.getEnsimmainenAvattuKortti();
        lauta.suljeVanhatAvatutKortit();
        String indeksi = "";
        indeksi += kortti.getIndeksi();
        assertEquals(indeksi, lauta.getEnsimmainenPainettuNappi().getText());
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

}
