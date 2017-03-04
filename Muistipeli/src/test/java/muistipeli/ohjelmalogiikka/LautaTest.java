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
    public void olikoSamatKortitAsettaaEnsimmaisenAvatunKortinLoydetyksiKunKortitSamat() {
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(1));
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.olikoSamatkortit(lauta.getEnsimmainenAvattuKortti(), lauta.getToinenAvattuKortti());
        assertEquals(true, lauta.getEnsimmainenAvattuKortti().getLoydetty());
    }

    @Test
    public void olikoSamatKortitAsettaaEnsimmaisenAvatunKortinEiAvatuksiKunKortitSamat() {
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(1));
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.getEnsimmainenAvattuKortti().setAvattu(true);
        lauta.olikoSamatkortit(lauta.getEnsimmainenAvattuKortti(), lauta.getToinenAvattuKortti());
        assertEquals(false, lauta.getEnsimmainenAvattuKortti().getAvattu());
    }

    @Test
    public void olikoSamatKortitAsettaaToisenAvatunKortinLoydetyksiKunKortitSamat() {
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(1));
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.olikoSamatkortit(lauta.getEnsimmainenAvattuKortti(), lauta.getToinenAvattuKortti());
        assertEquals(true, lauta.getToinenAvattuKortti().getLoydetty());
    }

    @Test
    public void olikoSamatKortitAsettaaToisenAvatunKortinEiAvatuksiKunKortitSamat() {
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(1));
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.getToinenAvattuKortti().setAvattu(true);
        lauta.olikoSamatkortit(lauta.getEnsimmainenAvattuKortti(), lauta.getToinenAvattuKortti());
        assertEquals(false, lauta.getToinenAvattuKortti().getAvattu());
    }

    @Test
    public void olikoSamatKortitAsettaaEnsimmaisenPainetunNapinPoisKaytostaKunKortitSamat() {
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(1));
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.olikoSamatkortit(lauta.getEnsimmainenAvattuKortti(), lauta.getToinenAvattuKortti());
        assertEquals(false, lauta.getEnsimmainenPainettuNappi().isEnabled());
    }

    @Test
    public void olikoSamatKortitAsettaaToisenPainetunNapinPoisKaytostaKunKortitSamat() {
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getSekoitetutKortit().get(1));
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.olikoSamatkortit(lauta.getEnsimmainenAvattuKortti(), lauta.getToinenAvattuKortti());
        assertEquals(false, lauta.getToinenPainettuNappi().isEnabled());
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
    public void suljeVanhatKortitAsettaaToinenPainettuNappiTekstinToisenKortinIndeksinMukaanLisattynaYksiKunEiPari() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(2));
        lauta.getEnsimmainenAvattuKortti().setAvattu(true);
        lauta.getToinenAvattuKortti().setAvattu(true);
        Kortti kortti = lauta.getToinenAvattuKortti();
        lauta.suljeVanhatAvatutKortit();
        String indeksi = "";
        indeksi += kortti.getIndeksi() + 1;
        assertEquals(indeksi, lauta.getToinenPainettuNappi().getText());
    }

    @Test
    public void suljeVanhatKortitAsettaaEnsimmainenPainettuNappiTekstinEnsimmainenKortinIndeksinMukaanLisattynaYksiKunEiPari() {
        lauta.setEnsimmainenPainettuNappi(new JButton());
        lauta.setToinenPainettuNappi(new JButton());
        lauta.setEnsimmainenAvattuKortti(lauta.getTietokanta().getKortit().get(0));
        lauta.setToinenAvattuKortti(lauta.getTietokanta().getKortit().get(2));
        lauta.getEnsimmainenAvattuKortti().setAvattu(true);
        lauta.getToinenAvattuKortti().setAvattu(true);
        Kortti kortti = lauta.getEnsimmainenAvattuKortti();
        lauta.suljeVanhatAvatutKortit();
        String indeksi = "";
        indeksi += kortti.getIndeksi() + 1;
        assertEquals(indeksi, lauta.getEnsimmainenPainettuNappi().getText());
    }

    @Test
    public void pariaEiLoydettyLisaaVuoronNumeroaYhdellaYksinpelissa() {
        lauta.pariaEiLoydetty();
        assertEquals(2, lauta.getVuoronNumero());
    }

    @Test
    public void pariaEiLoydettyLisaaVuoronNumeroaYhdellaKaksinpelissaToisenPelaajanJalkeen() {
        lauta.getTietokanta().setAktiivinenPelaaja(lauta.getTietokanta().getPelaajat().get(1));
        lauta.pariaEiLoydetty();
        assertEquals(2, lauta.getVuoronNumero());
    }

    @Test
    public void pariaEiLoydettyEiLisaaVuoronNumeroaYhdellaKaksinpelissaEnsimmaisenPelaajanJalkeen() {
        lauta.setPelaajamaara(2);
        lauta.pariaEiLoydetty();
        assertEquals(1, lauta.getVuoronNumero());
    }

    @Test
    public void pariaEiLoydettyVaihtaaAktiivistaPelaajaaKaksinpelissa() {
        lauta.setPelaajamaara(2);
        lauta.pariaEiLoydetty();
        assertEquals(lauta.getTietokanta().getPelaajat().get(1), lauta.getTietokanta().getAktiivinenPelaaja());
    }

    @Test
    public void pariLoydettyLisaaPisteenKunViimeinenPariLoydetty() {
        lauta.setParejaLoydetty(8);
        lauta.pariLoydetty();
        assertEquals(1, lauta.getTietokanta().getAktiivinenPelaaja().getPistetilanne());
    }

    @Test
    public void pariLoydettyLisaaPisteenKunEiViimeinenPariLoydetty() {
        lauta.pariLoydetty();
        assertEquals(1, lauta.getTietokanta().getAktiivinenPelaaja().getPistetilanne());
    }

    @Test
    public void uusiPeliAsettaaPelaaja1AktiiviseksiPelaajaksi() {
        lauta.getTietokanta().setAktiivinenPelaaja(lauta.getTietokanta().getPelaajat().get(1));
        lauta.uusiPeli(4);
        assertEquals(lauta.getTietokanta().getPelaajat().get(0), lauta.getTietokanta().getAktiivinenPelaaja());
    }

    @Test
    public void uusiPeliNollaaPelaajienPisteet() {
        lauta.getTietokanta().getAktiivinenPelaaja().setPistetilanne(3);
        lauta.uusiPeli(4);
        assertEquals(0, lauta.getTietokanta().getAktiivinenPelaaja().getPistetilanne());
    }

    @Test
    public void uusiPeliAsettaaKortitEiLoydetyiksi() {
        lauta.getTietokanta().getSekoitetutKortit().get(0).setLoydetty(true);
        lauta.uusiPeli(4);
        assertEquals(false, lauta.getTietokanta().getSekoitetutKortit().get(0).getLoydetty());
    }

    @Test
    public void uusiPeliAsettaaKortitEiAvatuiksi() {

        lauta.getTietokanta().getSekoitetutKortit().get(0).setAvattu(true);
        lauta.uusiPeli(4);
        assertEquals(false, lauta.getTietokanta().getSekoitetutKortit().get(0).getAvattu());
    }

    @Test
    public void uusiPeliLuoSekoitetutKortitVaikeusasteenMukaan() {
        lauta.uusiPeli(3);
        assertEquals(12, lauta.getTietokanta().getSekoitetutKortit().size());
    }

}
