package muistipeli.muistipeli.kayttoliittyma;

import java.util.Scanner;
import muistipeli.muistipeli.ohjelmalogiikka.Lauta;

public class Kayttoliittyma {

    Scanner lukija;
    int pelaajia;
    int vaikeusaste;
    Lauta pelilauta;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        pelaajia = 1;
        vaikeusaste = 1;

    }

    public void tervetuloa() {
        System.out.println("Tervetuloa pelaamaan Muistipeliä!");
        pelaajamaara();
        vaikeusaste();
        pelilauta = new Lauta(vaikeusaste + 1, vaikeusaste + 1, lukija);
        pelilauta.peliAlkaa();

    }

    public int pelaajamaara() {

        System.out.print("Montako pelaajaa? ");
        while (!lukija.hasNextInt()) {
            System.out.print("Anna kelvollinen numero: ");
            lukija.next();
        }
        int pelaajiaIlmoitettu = lukija.nextInt();
        if (pelaajiaIlmoitettu <= 0) {
            System.out.println("Annoit liian pienen numeron!");
            return pelaajamaara();
        }
        if (pelaajiaIlmoitettu >= 3) {
            System.out.println("Annoit liian suuren numeron!");
            return pelaajamaara();
        }
        pelaajia = pelaajiaIlmoitettu;
        System.out.println("Pelaajia: " + pelaajia);
        return pelaajiaIlmoitettu;
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
}
