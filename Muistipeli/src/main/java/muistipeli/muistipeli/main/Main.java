package muistipeli.muistipeli.main;

import java.util.Scanner;
import muistipeli.muistipeli.kayttoliittyma.Kayttoliittyma;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Kayttoliittyma ui = new Kayttoliittyma(lukija);
        ui.tervetuloa();

    }

}
