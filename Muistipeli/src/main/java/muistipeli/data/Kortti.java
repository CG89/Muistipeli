package muistipeli.data;

/**
 *
 * Luokka pitää kirjaa kortin tiedoista.
 */
public class Kortti {

    private String nimi;
    private int indeksi;
    private boolean loydetty;
    private boolean avattu;

    /**
     * Konstruktori luo kortin antaen sille nimeksi parametrina saadun
     * merkkijonon.
     *
     * @param nimi kortille annettava nimi
     */
    public Kortti(String nimi) {
        this.nimi = nimi;
        this.indeksi = -1;
        this.loydetty = false;
        this.avattu = false;

    }

    /**
     * Metodi palauttaa kortin nimen.
     *
     * @return String nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Metodi asettaa kortin loydetty-oliomuuttujan totuusarvon parametrin
     * mukaiseksi.
     *
     * @param onkoLoydetty talletettava totuusarvo
     */
    public void setLoydetty(boolean onkoLoydetty) {
        this.loydetty = onkoLoydetty;
    }

    /**
     * Metodi palauttaa loydetty-oliomuuttujan totuusarvon.
     *
     * @return Boolean onko löydetty
     */
    public boolean getLoydetty() {
        return loydetty;
    }

    /**
     * Metodi asettaa kortin avattu-oliomuuttujan totuusarvon parametrin
     * mukaiseksi.
     *
     * @param onkoAvattu Talletettava totuusarvo
     */
    public void setAvattu(boolean onkoAvattu) {
        this.avattu = onkoAvattu;
    }

    /**
     * Metodi palauttaa avattu-oliomuuttujaan tallennetun totuusarvon.
     *
     * @return Boolean onko avattu
     */
    public boolean getAvattu() {
        return avattu;
    }

    /**
     * Metodi asettaa kortin indeksi-oliomuuttujaan parametrina saadun luvun.
     *
     * @param indeksi Talletettava luku
     */
    public void setIndeksi(int indeksi) {
        this.indeksi = indeksi;
    }

    /**
     * Metodi palauttaa indeksi-oliomuuttujaan tallennetun luvun.
     *
     * @return int kortin indeksi
     */
    public int getIndeksi() {
        return this.indeksi;
    }

    /**
     * Metodi palauttaa nimi-oliomuuttujaan tallennetun merkkijonon.
     *
     * @return String nimi
     */
    @Override
    public String toString() {
        return nimi;
    }
}
