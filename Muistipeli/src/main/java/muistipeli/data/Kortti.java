package muistipeli.data;

import java.awt.image.BufferedImage;

/**
 * Luokka pitää kirjaa kortin tiedoista.
 */
public class Kortti {

    private String nimi;
    private int indeksi;
    private boolean loydetty;
    private boolean avattu;
    private BufferedImage kuva;

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

    public String getNimi() {
        return nimi;
    }

    public void setLoydetty(boolean onkoLoydetty) {
        this.loydetty = onkoLoydetty;
    }

    public boolean getLoydetty() {
        return loydetty;
    }

    public void setAvattu(boolean onkoAvattu) {
        this.avattu = onkoAvattu;
    }

    public boolean getAvattu() {
        return avattu;
    }

    public void setIndeksi(int indeksi) {
        this.indeksi = indeksi;
    }

    public int getIndeksi() {
        return this.indeksi;
    }

    public BufferedImage getKuva() {
        return this.kuva;
    }

    public void setKuva(BufferedImage bf) {
        this.kuva = bf;
    }

    @Override
    public String toString() {
        return nimi;
    }

}
