package muistipeli.data;

import muistipeli.data.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja pelaaja;

    @Test
    public void lisaaYksiVuoroLisaaPelaajalleYhdenVuoron() {
        pelaaja = new Pelaaja();
        pelaaja.lisaaYksiVuoro();
        assertEquals(1, pelaaja.getPistetilanne());
    }

    @Test
    public void lisaaYksiVuoroPalauttaaPelaajanVuorotOikein() {
        pelaaja = new Pelaaja();
        pelaaja.lisaaYksiVuoro();
        pelaaja.lisaaYksiVuoro();
        pelaaja.lisaaYksiVuoro();
        pelaaja.lisaaYksiVuoro();
        assertEquals(4, pelaaja.getPistetilanne());
    }

    @Test
    public void toStringPalauttaaOikeanlaisenStringin() {
        pelaaja = new Pelaaja();
        pelaaja.setNimi("Nakki");
        pelaaja.setPistetilanne(5);
        assertEquals("Nakki vuoro #5", pelaaja.toString());
    }

    @Test
    public void getNimiPalauttaaNimen() {
        pelaaja = new Pelaaja();
        pelaaja.setNimi("Makkara");
        assertEquals("Makkara", pelaaja.getNimi());
    }

    @Test
    public void getPistetilannePalauttaaPistetilanteen() {
        pelaaja = new Pelaaja();
        pelaaja.setPistetilanne(1);
        assertEquals(1, pelaaja.getPistetilanne());
    }

    @Test
    public void getVoittikoPalauttaaOikeanTotuusArvon() {
        pelaaja = new Pelaaja();
        pelaaja.setVoittiko(true);
        assertEquals(true, pelaaja.getVoittiko());
    }

}
