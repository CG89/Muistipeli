package muistipeli.data;

/**
 * Luokka pitää kirjaa pelaajan tiedoista.
 */
public class Pelaaja {

    private String nimi;
    private int pistetilanne;

    /**
     * Konstruktori luo pelaajan ja antaa sille parametrina saamansa nimen
     * nimeksi ja asettaa vuoron numeroksi 1.
     *
     * @param nimi talletettava nimi
     */
    public Pelaaja(String nimi) {
        this.nimi = nimi;
    }

    /**
     * Metodi lisää yhdellä pistetilanne-oliomuuttujan lukua.
     */
    public void lisaaYksiPiste() {
        pistetilanne++;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setPistetilanne(int pistetilanne) {
        this.pistetilanne = pistetilanne;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPistetilanne() {
        return pistetilanne;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
