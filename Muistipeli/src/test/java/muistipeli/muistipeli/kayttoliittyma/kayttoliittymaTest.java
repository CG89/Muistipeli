package muistipeli.muistipeli.kayttoliittyma;

import java.util.Scanner;
import muistipeli.muistipeli.ohjelmalogiikka.Lauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class kayttoliittymaTest {

    Kayttoliittyma ui;

    @Test
    public void pelaajamaaraKysyyPelaajamaaraaKunnesNumeroAnnettu() {
        Scanner lukija = new Scanner("a1 a a 1");
        ui = new Kayttoliittyma(lukija);
        assertEquals(1, ui.pelaajamaara());
    }

    @Test
    public void pelaajamaaraKysyyPelaajamaaraaKunnesSopivaNumeroAnnettu() {
        Scanner lukija = new Scanner("0 4 -1 1");
        ui = new Kayttoliittyma(lukija);
        assertEquals(1, ui.pelaajamaara());
    }

    @Test
    public void vaikeusasteKysyyPelaajamaaraaKunnesNumeroAnnettu() {
        Scanner lukija = new Scanner("a1 a a 1");
        ui = new Kayttoliittyma(lukija);
        assertEquals(1, ui.vaikeusaste());
    }

    @Test
    public void vaikeusasteKysyyPelaajamaaraaKunnesSopivaNumeroAnnettu() {
        Scanner lukija = new Scanner("0 4 -1 1");
        ui = new Kayttoliittyma(lukija);
        assertEquals(1, ui.vaikeusaste());
    }

}
