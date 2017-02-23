package muistipeli.data;

/**
 * Luokka pitää kirjaa pelaajan tiedoista.
 */
public class Pelaaja {

    private String nimi;
    private int pistetilanne;
    private int vuoronNumero;
    private boolean voittiko;

    /**
     * Konstruktori luo pelaajan.
     */
    public Pelaaja() {

    }

    /**
     * Metodi lisää yhdellä vuoronNumero-oliomuuttujan lukua.
     */
    public void lisaaYksiVuoro() {
        vuoronNumero++;
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

    public boolean getVoittiko() {
        return voittiko;
    }

    public void setVoittiko(boolean t) {
        voittiko = t;
    }

    public int getVuoronNumero() {
        return this.vuoronNumero;
    }

    @Override
    public String toString() {
        return nimi + " vuoro #" + pistetilanne;
    }
}
