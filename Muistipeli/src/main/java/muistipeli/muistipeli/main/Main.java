package muistipeli.muistipeli.main;

import java.util.Scanner;
import muistipeli.muistipeli.kayttoliittyma.Tekstikayttoliittyma;

/**
 * Luokka käynnistää ohjelman.
 */
public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Tekstikayttoliittyma ui = new Tekstikayttoliittyma(lukija);
        ui.tervetuloa();

    }

}
