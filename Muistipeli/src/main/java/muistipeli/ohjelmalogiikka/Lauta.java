package muistipeli.ohjelmalogiikka;

import java.util.*;
import javax.swing.JButton;
import muistipeli.data.Kortti;

/**
 * Luokka toimii ohjelman logiikkana.
 */
public class Lauta {

    private ArrayList<Kortti> kortit;
    private ArrayList<String> nimet;
    private int parejaLoydetty;
    private Kortti ensimmainenAvattuKortti;
    private Kortti toinenAvattuKortti;
    private JButton ensimmainenPainettuNappi;
    private JButton toinenPainettuNappi;
    private int vaikeusaste;

    /**
     * Konstruktori luo listan kortteja, antaa niille nimet, indeksoi ne ja asettaa vaikeusasteeksi saamansa luvun.
     * @param vaikeusaste Asetettava vaikeusaste laudalle
     */
    public Lauta(int vaikeusaste) {
        this.vaikeusaste=vaikeusaste;
        korttienNimienLuonti();
        korttienLuominen();
        korttienIndeksointi();
        ensimmainenAvattuKortti = null;
        toinenAvattuKortti = null;
        

    }

    /**
     * Metodi luo listan nimistä ja laittaa sinne nimiä.
     */
    public void korttienNimienLuonti() {
        this.nimet = new ArrayList();
        nimet.add("♥");
        nimet.add("웃");
        nimet.add("☠");
        nimet.add("✿");
        nimet.add("☃");
        nimet.add("☼");
        nimet.add("☢");
        nimet.add("☯");
        nimet.add("✈");
        nimet.add("✯");
    }

    /**
     * Metodi luo kortit-listan, lisää sinne pareittain kortteja, jollai on sama
     * nimi.
     */
    public void korttienLuominen() {
        kortit = new ArrayList();
        
        for (int i = 0; i < this.vaikeusaste*2; i++) {
            Kortti kortti1 = new Kortti(nimet.get(i));
            Kortti kortti2 = new Kortti(nimet.get(i));
            
            
            kortit.add(kortti1);
            kortit.add(kortti2);

        }
    }

    /**
     * Metodi asettaa kortit-listan korteille indeksit perustuen niiden
     * indeksiin listalla.
     */
    public void korttienIndeksointi() {
        for (int i = 0; i < kortit.size(); i++) {
            kortit.get(i).setIndeksi(i);
        }

    }

    /**
     * Metodi käy läpi parametrina annetun kortin indeksin ja painetun napin
     * indeksin perusteella, käänsikö pelaaja esiin kelvollisen kortin ja
     * tallentaa sen. Jos käännetty kortti oli toinen kelvollinen, tarkistaa
     * metodi olikoSamatKortit-metodin avulla, olivatko kortit pari ja ilmoittaa
     * siitä pelaajalle.
     *
     * @param kaannetynKortinIndeksi painetun napin indeksi, jota käytetään
     * kortit-listan indeksinä
     * @param nappi painettu JButton, johon piirretään kelvollisen kortin
     * tapauksessa kortin nimi
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
                    if (parejaLoydetty == kortit.size() / 2) {
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
     * kortit-listalla
     * @return Kortin tilanteen mukainen viesti
     */
    public String olikoKorttiJoKaannettyTaiLoydetty(int kaannetynKortinIndeksi) {
        if (kortit.get(kaannetynKortinIndeksi).getAvattu()) {
            return "Valitsit saman kortin uudestaan, valitse toinen kortti!";
        }
        if (kortit.get(kaannetynKortinIndeksi).getLoydetty()) {
            return "Valitsit jo löydetyn kortin, valitse toinen kortti!";
        } else {
            return "kelvollinen kortti";
        }
    }

    /**
     * Jos ensimmaista korttia ei ole vielä käännetty, kutsutaan tätä metodia,
     * mikä asettaa parametrin mukaisessa indeksissa olevan kortin
     * kortit-listalta ensimmäiseksi avatuksi kortiksi, asettaa sen kortin tilan
     * avatuksi ja siihen liittyvän napin ensimmäiseksi painetuksi napiksi.
     *
     * @param kaannetynKortinIndeksi Kortit-listalta etsittävän kortin indeksi
     * @param nappi Korttiin liittyvä nappi
     * @return palauttaa pelaajalle viestin, joka kehottaa valitsemaan vielä
     * toisen kortin
     */
    public String ensimmainenKorttiValittu(int kaannetynKortinIndeksi, JButton nappi) {
        ensimmainenAvattuKortti = kortit.get(kaannetynKortinIndeksi);
        ensimmainenPainettuNappi = nappi;
        ensimmainenAvattuKortti.setAvattu(true);
        return "Yritä löytää kääntämällesi kortille pari";
    }

    /**
     * Metodi saa kelvollisen kortin indeksin parametrina ja siihen liittyvän
     * napin ja asettaa ne toiseksi avatuksi/painetuksi ja kortin tilan
     * avatuksi.
     *
     * @param kaannetynKortinIndeksi Kortit-listalla olevan kortin indeksi
     * @param nappi Korttiin liittyvä nappi
     */
    public void toinenKorttiValittu(int kaannetynKortinIndeksi, JButton nappi) {
        toinenAvattuKortti = kortit.get(kaannetynKortinIndeksi);
        toinenPainettuNappi = nappi;
        toinenAvattuKortti.setAvattu(true);
    }

    /**
     * Metodi sekoittaa listan kortit.
     */
    public void sekoitaKortit() {
        Collections.shuffle(kortit);
    }

    /**
     * Metodi vertaa saamiensa korttien nimiä ja indeksejä ja sen perusteella
     * toteaa ne joko pariksi tai ei. Jos pari löytyy, muuttaa metodi korttien
     * tilan avatusta löydetyksi, kasvattaa parejaLoydetty-oliomuuttujaa yhdellä
     * ja palauttaa true. Jos kortit eivät ole pari, palauttaa metodi false.
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
     * Metodi kertoo NappiKuuntelijalle, että sen pitää kääntää edelliset kaksi
     * nappia, jotka liittyvät kahteen viimeksi avattuihin kortteihin, kiinni,
     * jos ne eivät olleet pari.
     *
     *
     * @return boolean true, jos kaksi korttia on jo avattuna, eivätkä ne ole
     * samoja.
     *
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
            ensimmainenPainettuNappi.setText("" + ensimmainenAvattuKortti.getIndeksi());
            toinenPainettuNappi.setText("" + toinenAvattuKortti.getIndeksi());
            ensimmainenAvattuKortti = null;
            toinenAvattuKortti = null;
            return true;

        }
        return false;
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

    public ArrayList getNimet() {
        return this.nimet;
    }

    public ArrayList<Kortti> getKortit() {
        return this.kortit;
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
    
    public int getVaikeusaste(){
        return this.vaikeusaste;
    }

}
