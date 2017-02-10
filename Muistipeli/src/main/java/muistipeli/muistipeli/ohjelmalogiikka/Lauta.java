package muistipeli.muistipeli.ohjelmalogiikka;

import java.util.*;
import muistipeli.muistipeli.kayttoliittyma.Tekstikayttoliittyma;

/**
 * Luokka toimii ohjelman logiikkana.
 */
public class Lauta {

    private int leveys;
    private int korkeus;
    private ArrayList kortit;
    private int parejaLoydetty;

    public Lauta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        int ruutuja = leveys * korkeus;

        this.kortit = new ArrayList();
        this.parejaLoydetty = 0;
        for (int i = 0; i < ruutuja / 2; i++) {
            kortit.add(i);
            kortit.add(i);

        }
    }

    public void kerroKortit() {
        String tulostaKortit = "";
        for (int i = 0; i < kortit.size(); i++) {
            tulostaKortit += (kortit.get(i) + ", ");
        }
        System.out.println(tulostaKortit);
    }

    /**
     * Metodi tarkistaa ovatko käännetyt kortit samoja.
     *
     * @param ensimmaisenIndeksi käyttäjän antama syöte
     * @param toisenIndeksi käyttäjän antama syöte
     *
     *
     * @return boolean oliko samat kortit
     *
     */
    public boolean olikoSamat(int ensimmaisenIndeksi, int toisenIndeksi) {
        if (kortit.get(ensimmaisenIndeksi) == kortit.get(toisenIndeksi) && kortit.get(ensimmaisenIndeksi) != "Löydetty"
                && kortit.get(toisenIndeksi) != "Löydetty" && ensimmaisenIndeksi != toisenIndeksi) {
            kortit.set(ensimmaisenIndeksi, "Löydetty");
            kortit.set(toisenIndeksi, "Löydetty");
            parejaLoydetty++;

            return true;
        } else {
            return false;
        }
    }

    public void sekoitaKortit() {
        Collections.shuffle(kortit);
    }

    public int getKortitKoko() {
        return kortit.size();
    }

    public int getParejaLoydetty() {
        return parejaLoydetty;
    }

    public Object getKortitIndeksissaOleva(int indeksi) {
        return kortit.get(indeksi);

    }

}
