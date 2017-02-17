package muistipeli.data;

/**
 * Luokka pitää kirjaa pelaajan tiedoista.
 */
public class Pelaaja {

    private String nimi;
    private int pistetilanne;
    private boolean voittiko;
    /**
     * Konstruktori luo pelaajan.
     */
    public Pelaaja() {
        nimi = "";
        pistetilanne = 0;
        voittiko = false;
    }
/**
 * Metodi lisää yhdellä pistetilanne-oliomuuttujan lukua. 
 */
    public void lisaaYksiVuoro() {
        pistetilanne++;
    }
/**
 * Metodi asettaa nimi-oliomuuttujaan parametrina saamansa merkkijonon.
 * @param nimi Talletettava nimi
 */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
/**
 * Metodi asettaa pistetilanne-oliomuuttujaan parametrina saamansa luvun.
 * @param pistetilanne Talletettava luku
 */
    public void setPistetilanne(int pistetilanne) {
        this.pistetilanne = pistetilanne;
    }
/**
 * Metodi palauttaa nimi-oliomuuttujassa olevan merkkijonon.
 * @return String nimi
 */
    public String getNimi() {
        return nimi;
    }
/**
 * Metodi palauttaa pistetilanne-oliomuuttujassa olevan luvun.
 * @return int luku
 */
    public int getPistetilanne() {
        return pistetilanne;
    }
/**
 * Metodi palauttaa voittiko-oliomuuttujassa olevan totuusarvon.
 * @return Boolean voittiko
 */
    public boolean getVoittiko() {
        return voittiko;
    }
/**
 * Metodi asettaa voittiko-oliomuuttujaan parametrina saamansa totuusarvon.
 * @param t Talletettava totuusarvo
 */
    public void setVoittiko(boolean t) {
        voittiko = t;
    }
/**
 * Metodi palauttaa pelaajan nimen ja pistetilanteen.
 * @return String nimi + pistetilanne
 */
    @Override
    public String toString() {
        return nimi + " vuoro #" + pistetilanne;
    }
}
