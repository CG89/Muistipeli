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
    
    @Before
    public void setUp(){
        pelaaja=new Pelaaja("pelaaja 1");
    }

    @Test
    public void lisaaYksiPisteLisaaYhdenPisteen() {
        pelaaja.lisaaYksiPiste();
        assertEquals(1, pelaaja.getPistetilanne());
    }

    @Test
    public void toStringPalauttaaOikeanlaisenStringin() {
        pelaaja.setNimi("Nakki");
        assertEquals("Nakki", pelaaja.toString());
    }

    @Test
    public void getNimiPalauttaaNimen() {
        pelaaja.setNimi("Makkara");
        assertEquals("Makkara", pelaaja.getNimi());
    }

    @Test
    public void getPistetilannePalauttaaPistetilanteen() {
        pelaaja.setPistetilanne(1);
        assertEquals(1, pelaaja.getPistetilanne());
    }

}
