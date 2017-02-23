package muistipeli.ohjelmalogiikka;

import javax.swing.JButton;
import muistipeli.data.Kortti;
import muistipeli.data.Tietokanta;

/**
 * Luokka toimii ohjelman logiikkana.
 */
public class Lauta {

    private int parejaLoydetty;
    private Kortti ensimmainenAvattuKortti;
    private Kortti toinenAvattuKortti;
    private JButton ensimmainenPainettuNappi;
    private JButton toinenPainettuNappi;
    private int vaikeusaste;
    private Tietokanta tietokanta;

    /**
     * Konstruktori tallettaa parametrina saamansa Tietokantaolion
     * oliomuuttujaan.
     *
     * @param tietokanta Talletettava Tietokantaolio.
     */
    public Lauta(Tietokanta tietokanta) {
        this.tietokanta = tietokanta;
    }

    /**
     * Metodi käy läpi parametrina annetun kortin indeksin ja painetun napin
     * indeksin perusteella, käänsikö pelaaja esiin kelvollisen kortin ja
     * tallentaa sen. Jos käännetty kortti oli toinen kelvollinen, tarkistaa
     * metodi olikoSamatKortit-metodin avulla, olivatko kortit pari ja ilmoittaa
     * siitä pelaajalle.
     *
     * @param kaannetynKortinIndeksi painetun napin indeksi, jota käytetään
     * sekoitetutKortit-listan indeksinä
     * @param nappi painettu JButton, johon piirretään kelvollisen kortin
     * tapauksessa kortin kuva
     * @return Pelaajalle näytettävä viesti, joka kertoo oliko painettu nappi
     * kelvollinen ja löysikö hän parin
     */
    public String korttiKaannetty(int kaannetynKortinIndeksi, JButton nappi) {
        String olikoKelvollinen = olikoKorttiJoKaannettyTaiLoydetty(kaannetynKortinIndeksi);
        if (!olikoKelvollinen.equals("kelvollinen kortti")) {
            return olikoKelvollinen;
        } else {
            if (ensimmainenAvattuKortti == null) {

                return ensimmainenKorttiValittu(kaannetynKortinIndeksi, nappi);
            } else {
                toinenKorttiValittu(kaannetynKortinIndeksi, nappi);
                if (olikoSamatkortit(ensimmainenAvattuKortti, toinenAvattuKortti)) {
                    if (parejaLoydetty == this.tietokanta.getSekoitetutKortit().size() / 2) {
                        return "Voitit pelin, onneksi olkoon!";
                    }
                    return "Löysit parin, hienoa!";
                } else {
                    return "Et löytänyt paria";
                }
            }

        }
    }

    /**
     * Metodi tarkistaa onko parametrina saadun indeksin omaava kortti jo
     * käännetty tai avattu ja palauttaa tilanteenmukaisen viestin.
     *
     * @param kaannetynKortinIndeksi Tarkistettavana olevan kortin indeksi
     * sekoitetutKortit-listalla
     * @return Kortin tilanteen mukainen viesti
     */
    public String olikoKorttiJoKaannettyTaiLoydetty(int kaannetynKortinIndeksi) {
        if (this.tietokanta.getSekoitetutKortit().get(kaannetynKortinIndeksi).getAvattu()) {
            return "Valitsit saman kortin uudestaan, valitse toinen kortti!";
        }
        if (this.tietokanta.getSekoitetutKortit().get(kaannetynKortinIndeksi).getLoydetty()) {
            return "Valitsit jo löydetyn kortin, valitse toinen kortti!";
        } else {
            return "kelvollinen kortti";
        }
    }

    /**
     * Jos ensimmaista korttia ei ole vielä käännetty, kutsutaan tätä metodia,
     * mikä asettaa parametrin mukaisessa indeksissa olevan kortin
     * sekoitetutKortit-listalta ensimmäiseksi avatuksi kortiksi, asettaa sen
     * kortin tilan avatuksi ja siihen liittyvän napin ensimmäiseksi painetuksi
     * napiksi.
     *
     * @param kaannetynKortinIndeksi SekoitetutKortit-listalta etsittävän kortin
     * indeksi
     * @param nappi Korttiin liittyvä nappi
     * @return palauttaa pelaajalle viestin, joka kehottaa valitsemaan vielä
     * toisen kortin
     */
    public String ensimmainenKorttiValittu(int kaannetynKortinIndeksi, JButton nappi) {
        ensimmainenAvattuKortti = this.tietokanta.getSekoitetutKortit().get(kaannetynKortinIndeksi);
        ensimmainenPainettuNappi = nappi;
        ensimmainenAvattuKortti.setAvattu(true);
        return "Yritä löytää kääntämällesi kortille pari";
    }

    /**
     * Metodi saa kelvollisen kortin indeksin parametrina ja siihen liittyvän
     * napin ja asettaa ne toiseksi avatuksi/painetuksi ja kortin tilan
     * avatuksi.
     *
     * @param kaannetynKortinIndeksi SekoitetutKortit-listalla olevan kortin
     * indeksi
     * @param nappi Korttiin liittyvä nappi
     */
    public void toinenKorttiValittu(int kaannetynKortinIndeksi, JButton nappi) {
        toinenAvattuKortti = this.tietokanta.getSekoitetutKortit().get(kaannetynKortinIndeksi);
        toinenPainettuNappi = nappi;
        toinenAvattuKortti.setAvattu(true);
    }

    /**
     * Metodi vertaa saamiensa korttien nimiä ja indeksejä ja sen perusteella
     * toteaa ne joko pariksi tai ei. Jos pari löytyy, muuttaa metodi korttien
     * tilan avatusta löydetyksi, kasvattaa parejaLoydetty-oliomuuttujaa
     * yhdellä, poistaa kortteihin liittyvät napit käytöstä ja palauttaa true.
     * Jos kortit eivät ole pari, palauttaa metodi false.
     *
     * @param ensimmainenAvattuKortti ensimmäisenä avattu kortti
     * @param toinenAvattuKortti toisena avattu kortti
     * @return palauttaa true, jos kortit olivat pari, muuten false
     */
    public boolean olikoSamatkortit(Kortti ensimmainenAvattuKortti, Kortti toinenAvattuKortti) {
        if (ensimmainenAvattuKortti.getNimi() == toinenAvattuKortti.getNimi() && ensimmainenAvattuKortti.getIndeksi() != toinenAvattuKortti.getIndeksi()) {
            ensimmainenAvattuKortti.setLoydetty(true);
            ensimmainenAvattuKortti.setAvattu(false);
            toinenAvattuKortti.setLoydetty(true);
            toinenAvattuKortti.setAvattu(false);
            parejaLoydetty++;
            ensimmainenPainettuNappi.setEnabled(false);
            toinenPainettuNappi.setEnabled(false);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi poistaa Laudan oliomuuttujista ensimmäisen ja toisen käännetyn
     * kortin, jos molemmissa on kortit. Mikäli kortit eivät olleet parit,
     * metodi myös palauttaa niiden avattu-statuksen falseen, poistaa kuvan ja
     * piirtä nappeihin selkäpuolen takaisin.
     *
     * @return boolean true, jos kaksi korttia on jo avattuna, eivätkä ne ole
     * samoja.
     */
    public boolean suljeVanhatAvatutKortit() {
        if (ensimmainenAvattuKortti != null && toinenAvattuKortti != null) {
            if (ensimmainenAvattuKortti.getLoydetty() && toinenAvattuKortti.getLoydetty()) {
                ensimmainenAvattuKortti = null;
                toinenAvattuKortti = null;
                return false;
            }
            ensimmainenAvattuKortti.setAvattu(false);
            toinenAvattuKortti.setAvattu(false);
            ensimmainenPainettuNappi.setIcon(null);
            ensimmainenPainettuNappi.setText("" + ensimmainenAvattuKortti.getIndeksi());
            toinenPainettuNappi.setIcon(null);
            toinenPainettuNappi.setText("" + toinenAvattuKortti.getIndeksi());
            ensimmainenAvattuKortti = null;
            toinenAvattuKortti = null;
            return true;

        }
        return false;
    }

    /**
     * Metodi alustaa uuden pelin asettamalla vaikeusasteeksi saamansa
     * parametrin, asettamalla nulliksi laudan kortti- ja nappioliomuuttujat,
     * asettamalla falseksi Tietokannan kortit-listan korttien avattu- ja
     * löydettytilat, asettamalla parejaLöydetty nollaksi ja kutsumalla
     * Tietokantaluokan metodia luoSekoitetutKortit(int vaikeusaste).
     *
     * @param vaikeusaste Talletettava vaikeusaste
     */
    public void uusiPeli(int vaikeusaste) {
        this.vaikeusaste = vaikeusaste;
        this.ensimmainenAvattuKortti = null;
        this.ensimmainenPainettuNappi = null;
        this.toinenAvattuKortti = null;
        this.toinenPainettuNappi = null;
        for (int i = 0; i < this.tietokanta.getKortit().size(); i++) {
            this.tietokanta.getKortit().get(i).setAvattu(false);
            this.tietokanta.getKortit().get(i).setLoydetty(false);
        }
        this.parejaLoydetty = 0;
        this.tietokanta.luoSekoitetutKortit(vaikeusaste);

    }

    public void setEnsimmainenPainettuNappi(JButton ensimmainenPainettuNappi) {
        this.ensimmainenPainettuNappi = ensimmainenPainettuNappi;
    }

    public JButton getEnsimmainenPainettuNappi() {
        return this.ensimmainenPainettuNappi;
    }

    public void setToinenPainettuNappi(JButton toinenPainettuNappi) {
        this.toinenPainettuNappi = toinenPainettuNappi;
    }

    public JButton getToinenPainettuNappi() {
        return this.toinenPainettuNappi;
    }

    public int getParejaLoydetty() {
        return parejaLoydetty;
    }

    public Kortti getEnsimmainenAvattuKortti() {
        return this.ensimmainenAvattuKortti;
    }

    public void setEnsimmainenAvattuKortti(Kortti kortti) {
        this.ensimmainenAvattuKortti = kortti;
    }

    public Kortti getToinenAvattuKortti() {
        return this.toinenAvattuKortti;
    }

    public void setToinenAvattuKortti(Kortti kortti) {
        this.toinenAvattuKortti = kortti;
    }

    public void setParejaLoydetty(int loydetty) {
        this.parejaLoydetty = loydetty;
    }

    public int getVaikeusaste() {
        return this.vaikeusaste;
    }

    public Tietokanta getTietokanta() {
        return this.tietokanta;
    }

}
