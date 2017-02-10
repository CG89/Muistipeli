package muistipeli.muistipeli.data;

/**
 * Luokka pitää kirjaa pelaajan tiedoista.
 */
public class Pelaaja {

    private String nimi;
    private int pistetilanne;
    private boolean voittiko;

    public Pelaaja() {
        nimi = "";
        pistetilanne = 0;
        voittiko = false;
    }

    public int lisaaYksiVuoro() {
        pistetilanne++;
        return pistetilanne;
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

    @Override
    public String toString() {
        return nimi + " vuoro #" + pistetilanne;
    }
}
