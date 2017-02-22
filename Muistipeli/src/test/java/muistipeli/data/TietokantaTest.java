
package muistipeli.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TietokantaTest {
    private Tietokanta tietokanta;
    
    @Before
    public void setUp(){
        this.tietokanta=new Tietokanta();
    }
            
    @Test
    public void korttienNimeaminenLuoNimetlistan() { 
        
        assertNotSame(null, tietokanta.getNimet());
    }

    @Test
    public void korttienLuominenluoKortitlistan() {
        assertNotSame(null, tietokanta.getKortit().size());
    }

    @Test
    public void korttienIndeksointiIndeksoiKortit() {
        assertEquals(0, tietokanta.getKortit().get(0).getIndeksi());
    }
}
