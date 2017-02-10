package muistipeli.muistipeli.kayttoliittyma;

import java.util.Scanner;
import muistipeli.muistipeli.data.Pelaaja;
import muistipeli.muistipeli.ohjelmalogiikka.Lauta;

/**
 * Luokka mahdollistaa ohjelman käyttämisen tekstimuotoisena.
 */
public class Tekstikayttoliittyma {

    Scanner lukija;
    int pelaajia;
    int vaikeusaste;
    Lauta pelilauta;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;

    public Tekstikayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        pelaajia = 1;
        vaikeusaste = 1;
        pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();

    }

    public void tervetuloa() {
        System.out.println("Tervetuloa pelaamaan Muistipeliä!");
        pelaajienMaara();
        pelaajienNimet();
        vaikeusaste();
        luoPelilauta(vaikeusaste);
        peliAlkaa();

    }

    public void luoPelilauta(int vaikeusaste) {
        pelilauta = new Lauta(vaikeusaste + 1, vaikeusaste + 1);
    }

    public int pelaajienMaara() {

        System.out.print("Montako pelaajaa? ");
        while (!lukija.hasNextInt()) {
            System.out.print("Anna kelvollinen numero: ");
            lukija.next();
        }
        int pelaajiaIlmoitettu = lukija.nextInt();
        if (pelaajiaIlmoitettu <= 0) {
            System.out.println("Annoit liian pienen numeron!");
            return pelaajienMaara();
        }
        if (pelaajiaIlmoitettu >= 3) {
            System.out.println("Annoit liian suuren numeron!");
            return pelaajienMaara();
        }
        pelaajia = pelaajiaIlmoitettu;
        System.out.println("Pelaajia: " + pelaajia);

        return pelaajiaIlmoitettu;
    }

    public void pelaajienNimet() {
        System.out.print("Anna 1. pelaajan nimi: ");
        pelaaja1.setNimi(lukija.next());
        if (pelaajia == 2) {
            System.out.print("Anna 2. pelaajan nimi: ");
            pelaaja2.setNimi(lukija.next());
        }
    }

    public int vaikeusaste() {
        System.out.print("Valitse vaikeusaste: 1, 2, 3? ");
        while (!lukija.hasNextInt()) {
            System.out.print("Anna kelvollinen numero: ");
            lukija.next();
        }
        int valittuVaikeusaste = lukija.nextInt();
        if (valittuVaikeusaste <= 0) {
            System.out.println("Annoit liian pienen numeron!");
            return vaikeusaste();
        }
        if (valittuVaikeusaste >= 4) {
            System.out.println("Annoit liian suuren numeron!");
            return vaikeusaste();
        }
        vaikeusaste = valittuVaikeusaste;
        System.out.println("Vaikeusaste valittu: " + vaikeusaste);
        return valittuVaikeusaste;

    }

    public void peliAlkaa() {
        System.out.println("Laudalla on " + pelilauta.getKortitKoko() + " korttia numeroituna 0-" + (pelilauta.getKortitKoko() - 1));
        System.out.println("Valitse ensin yksi korteista syöttämällä kortin numero, minkä jälkeen näet, mikä kortti on kyseessä");
        pelilauta.sekoitaKortit();
        Pelaaja voittaja = pelaaKunnesToinenVoittaa();
        System.out.println(voittajanJulistus(voittaja));
    }

    public Pelaaja pelaaKunnesToinenVoittaa() {
        while (true) {
            while (pelaaVuoro(pelaaja1)) {
                if (pelaaja1.getVoittiko()) {
                    break;
                }

            }
            if (pelaajia == 2 && !pelaaja1.getVoittiko()) {
                while (pelaaVuoro(pelaaja2)) {
                    if (pelaaja2.getVoittiko()) {
                        break;
                    }
                }

            }
            if (pelaaja1.getVoittiko()) {
                return pelaaja1;
            }
            if (pelaaja2.getVoittiko()) {
                return pelaaja2;
            }

        }
    }

    public boolean pelaaVuoro(Pelaaja pelaaja) {
        pelaaja.lisaaYksiVuoro();
        System.out.println(pelaaja);
        System.out.println(piirraLauta());
        int ensimmaisenIndeksi = kysyKortinIndeksi(-1);
        int toisenIndeksi = kysyKortinIndeksi(ensimmaisenIndeksi);
        if (pelilauta.olikoSamat(ensimmaisenIndeksi, toisenIndeksi)) {
            if (pelilauta.getParejaLoydetty() == pelilauta.getKortitKoko() / 2) {
                pelaaja.setVoittiko(true);
                return true;
            }
            System.out.println("Löysit parin, hienoa!");
            System.out.println("Saat jatkaa vuoroasi!");
            pelaaja.setPistetilanne(pelaaja.getPistetilanne() - 1);
            return true;
        } else {
            System.out.println("Et löytänyt paria.");
        }
        return false;
    }

    public String piirraLauta() {

        String piirrettavatKortit = "";
        for (int i = 0; i < pelilauta.getKortitKoko(); i++) {

            if (pelilauta.getKortitIndeksissaOleva(i) == "Löydetty") {
                piirrettavatKortit += "|X| ";
            } else {
                piirrettavatKortit += "|" + i + "| ";
            }
        }
        return piirrettavatKortit;

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
        if (annettuIndeksi >= pelilauta.getKortitKoko()) {
            System.out.println("Annoit liian suuren numeron!");
            return kysyKortinIndeksi(ensimmaisenIndeksi);
        }
        if (pelilauta.getKortitIndeksissaOleva(annettuIndeksi) == "Löydetty") {
            System.out.println("Valitsemasi kortti on jo löydetty, valitse toinen kortti!");
            return kysyKortinIndeksi(ensimmaisenIndeksi);
        }
        if (annettuIndeksi == ensimmaisenIndeksi) {
            System.out.println("Valitsit saman kortin kahdesti, valitse toinen kortti!");
            return kysyKortinIndeksi(ensimmaisenIndeksi);
        }

        System.out.println("Käänsit esiin: " + pelilauta.getKortitIndeksissaOleva(annettuIndeksi));
        return annettuIndeksi;
    }

    public String voittajanJulistus(Pelaaja voittaja) {
        return voittaja.getNimi() + " Voitti pelin " + voittaja.getPistetilanne() + " vuoron jälkeen, onneksi olkoon!";

    }

    public void setPelaajia(int pelaajia) {
        this.pelaajia = pelaajia;
    }
}
