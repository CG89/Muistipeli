package muistipeli.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Luokka pitää kirjaa korteista.
 */
public class Tietokanta {

    private ArrayList<Kortti> kortit;
    private ArrayList<String> nimet;
    private ArrayList<Kortti> sekoitetutKortit;

    /**
     * Konstruktori luo kortit ja nimet -listat ja kutsuu korttienNimienLuonti-,
     * korttienLuominen- ,korttienIndeksointi-metodeja.
     */
    public Tietokanta() {
        this.kortit = new ArrayList<>();
        this.nimet = new ArrayList<>();
        korttienNimienLuonti();
        korttienLuominen();
        korttienIndeksointi(kortit);
    }

    /**
     * Metodi lisää nimiä nimet-listaan.
     */
    public void korttienNimienLuonti() {
        nimet.add("A");
        nimet.add("B");
        nimet.add("C");
        nimet.add("D");
        nimet.add("E");
        nimet.add("F");
        nimet.add("G");
        nimet.add("H");
        nimet.add("I");
        nimet.add("J");
    }

    /**
     * Metodi lisää kortit-listaan pareittain kortteja, jollai on sama nimi ja
     * kuva.
     */
    public void korttienLuominen() {

        for (int i = 0; i < this.nimet.size(); i++) {
            Kortti kortti1 = new Kortti(nimet.get(i));
            Kortti kortti2 = new Kortti(nimet.get(i));
            lisaaKuvaKortille(kortti1, i);
            lisaaKuvaKortille(kortti2, i);
            kortit.add(kortti1);
            kortit.add(kortti2);

        }
    }

    /**
     * Metodi asettaa saamansa listan korteille indeksit perustuen niiden
     * indeksiin listalla.
     * @param indeksoitavatKortit indeksoitavat kortit
     */
    public void korttienIndeksointi(ArrayList<Kortti> indeksoitavatKortit) {
        for (int i = 0; i < indeksoitavatKortit.size(); i++) {
            indeksoitavatKortit.get(i).setIndeksi(i);
        }
    }

    /**
     * Metodi lisää saamallensa kortille saamaansa indeksiä apua käyttäen kuvan.
     *
     * @param kortti Kortti, jolle kuva annetaan
     * @param indeksi Integer, jonka avulla valitaan annettava kuva.
     */
    public void lisaaKuvaKortille(Kortti kortti, int indeksi) {
        String tiedostonimi = "koira" + indeksi + ".jpg";
        InputStream is = getClass().getClassLoader().getResourceAsStream(tiedostonimi);
        try {
            kortti.setKuva(ImageIO.read(is));
        } catch (IOException ex) {
            Logger.getLogger(Kortti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodi luo peliä varten kortit-listan korteista uuden
     * sekoitetutKortit-listan, johon tulee vaikeusastetta vastaava määrä
     * kortteja. Lopuksi metodi sekoittaa listan kortit ja kutsuu
     * korttienIndeksointi-metodia.
     *
     * @param vaikeusaste Integer, kortteja valitaan nelinkertainen määrä
     * kortit-listalta sekoitetutKortit-listalle
     */
    public void luoSekoitetutKortit(int vaikeusaste) {
        this.sekoitetutKortit = new ArrayList<>();
        for (int i = 0; i < vaikeusaste * 4; i++) {
            sekoitetutKortit.add(kortit.get(i));
        }
        Collections.shuffle(sekoitetutKortit);
        korttienIndeksointi(sekoitetutKortit);

    }

    public ArrayList getNimet() {
        return this.nimet;
    }

    public ArrayList<Kortti> getSekoitetutKortit() {
        return this.sekoitetutKortit;
    }

    public void setSekoitetutkortit(ArrayList<Kortti> kortit) {
        this.sekoitetutKortit = kortit;
    }

    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }

}
