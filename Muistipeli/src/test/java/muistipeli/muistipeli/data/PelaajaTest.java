
package muistipeli.muistipeli.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelaajaTest {
    Pelaaja pelaaja;
    
    @Test
    public void lisaaYksiVuoroLisaaPelaajalleYhdenVuoron(){
        pelaaja=new Pelaaja();
        assertEquals(1,pelaaja.lisaaYksiVuoro());
    }
    
    @Test
    public void lisaaYksiVuoroPalauttaaPelaajanVuorotOikein(){
        pelaaja=new Pelaaja();
        pelaaja.lisaaYksiVuoro();
        pelaaja.lisaaYksiVuoro();
        pelaaja.lisaaYksiVuoro();
        assertEquals(4,pelaaja.lisaaYksiVuoro());
    }
    
    @Test
    public void toStringPalauttaaOikeanlaisenStringin(){
        pelaaja=new Pelaaja();
        pelaaja.setNimi("Nakki");
        pelaaja.setPistetilanne(5);
        assertEquals("Nakki vuoro #5",pelaaja.toString());
    }
    

}
