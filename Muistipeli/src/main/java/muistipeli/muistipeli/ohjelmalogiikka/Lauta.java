package muistipeli.muistipeli.ohjelmalogiikka;

import java.util.*;

public class Lauta {

    private int leveys;
    private int korkeus;
    private ArrayList kortit;
    private Scanner lukija;
    private int parejaLoydetty;

    public Lauta(int leveys, int korkeus, Scanner lukija) {
        this.lukija = lukija;
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

    public void peliAlkaa() {
        System.out.println("Laudalla on " + kortit.size() + " korttia numeroituna 0-" + (kortit.size() - 1));
        System.out.println("Valitse ensin yksi korteista syöttämällä kortin numero, minkä jälkeen näet, mikä kortti on kyseessä");
        while (true) {
            System.out.println(piirraLauta());

            if (kaannaKortteja()) {
                break;
            }
        }
        System.out.println("Voitit pelin, onneksi olkoon!");

    }

    public boolean kaannaKortteja() {

        int ensimmaisenIndeksi = kysyKortinIndeksi(-1);
        int toisenIndeksi = kysyKortinIndeksi(ensimmaisenIndeksi);

        if (!olikoSamat(ensimmaisenIndeksi, toisenIndeksi)) {
            System.out.println("Et löytänyt paria, yritä uudestaan");
        } else {
            System.out.println("Löysit parin, hienoa!");
            parejaLoydetty++;
            if (parejaLoydetty == kortit.size() / 2) {
                return true;
            }
        }

        return false;

    }

    public int kysyKortinIndeksi(int ensimmaisenIndeksi) {
        System.out.print("Syötä käännettävän kortin numero: ");
        while (!lukija.hasNextInt()) {
            System.out.print("Anna kelvollinen numero: ");
            lukija.next();
        }
        int annettuIndeksi = lukija.nextInt();
        if (annettuIndeksi < 0) {
            System.out.println("Annoit liian pienen numeron!");
            return kysyKortinIndeksi(ensimmaisenIndeksi);
        }
        if (annettuIndeksi >= kortitKoko()) {
            System.out.println("Annoit liian suuren numeron!");
            return kysyKortinIndeksi(ensimmaisenIndeksi);
        }
        if (kortit.get(annettuIndeksi) == "Löydetty") {
            System.out.println("Valitsemasi kortti on jo löydetty, valitse toinen kortti!");
            return kysyKortinIndeksi(ensimmaisenIndeksi);
        }
        if (annettuIndeksi == ensimmaisenIndeksi) {
            System.out.println("Valitsit saman kortin kahdesti, valitse toinen kortti!");
            return kysyKortinIndeksi(ensimmaisenIndeksi);
        }

        System.out.println(kortit.get(annettuIndeksi));
        return annettuIndeksi;
    }

    public void kerroKortit() {
        String tulostaKortit = "";
        for (int i = 0; i < kortit.size(); i++) {
            tulostaKortit += (kortit.get(i) + ", ");
        }
        System.out.println(tulostaKortit);
    }

    public boolean olikoSamat(int ensimmaisenIndeksi, int toisenIndeksi) {
        if (kortit.get(ensimmaisenIndeksi) == kortit.get(toisenIndeksi) && kortit.get(ensimmaisenIndeksi) != "Löydetty"
                && kortit.get(toisenIndeksi) != "Löydetty" && ensimmaisenIndeksi != toisenIndeksi) {
            kortit.set(ensimmaisenIndeksi, "Löydetty");
            kortit.set(toisenIndeksi, "Löydetty");

            return true;
        } else {
            return false;
        }
    }

    public int kortitKoko() {
        return kortit.size();
    }

    public String piirraLauta() {

        String piirrettavatKortit = "";
        for (int i = 0; i < kortitKoko(); i++) {

            if (kortit.get(i) == "Löydetty") {
                piirrettavatKortit += "|X| ";
            } else {
                piirrettavatKortit += "|" + i + "| ";
            }
        }
        return piirrettavatKortit;

    }

}
