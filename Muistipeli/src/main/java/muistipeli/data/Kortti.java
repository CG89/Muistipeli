package muistipeli.data;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * Luokka pitää kirjaa kortin tiedoista.
 */
public class Kortti {

    private String nimi;
    private int indeksi;
    private boolean loydetty;
    private boolean avattu;
//    private BufferedImage kuva;

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
//        InputStream is = getClass().getClassLoader().getResourceAsStream("koira1.jpg");
//        try {
//            kuva = ImageIO.read(is);
//        } catch (IOException ex) {
//            Logger.getLogger(Kortti.class.getName()).log(Level.SEVERE, null, ex);
//        }




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
    
    
    
//    public BufferedImage getKuva(){
//        return this.kuva;
//    }

   
    @Override
    public String toString() {
        return nimi;
    }
}
