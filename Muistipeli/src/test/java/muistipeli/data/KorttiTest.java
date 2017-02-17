package muistipeli.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KorttiTest {

    Kortti kortti;

    @Test
    public void toStringPalauttaaKortinNimen() {
        kortti = new Kortti("Nakki");
        assertEquals("Nakki", kortti.toString());
    }

}
