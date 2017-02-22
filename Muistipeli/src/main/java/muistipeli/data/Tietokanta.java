package muistipeli.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import muistipeli.ohjelmalogiikka.Lauta;

public class Tietokanta {

    private ArrayList<Kortti> kortit;
    private ArrayList<String> nimet;
    private ArrayList<Kortti> sekoitetutKortit;

    public Tietokanta() {
        this.kortit = new ArrayList<>();
        this.nimet = new ArrayList<>();
        korttienNimienLuonti();
        korttienLuominen();
        korttienIndeksointi(kortit);
    }

    /**
     * Metodi luo listan nimistä ja laittaa sinne nimiä.
     */
    public void korttienNimienLuonti() {
        nimet.add("♥");
        nimet.add("웃");
        nimet.add("☠");
        nimet.add("✿");
        nimet.add("☃");
        nimet.add("☼");
        nimet.add("☢");
        nimet.add("☯");
        nimet.add("✈");
        nimet.add("✯");
    }

    /**
     * Metodi luo kortit-listan, lisää sinne pareittain kortteja, jollai on sama
     * nimi.
     */
    public void korttienLuominen() {

        for (int i = 0; i < this.nimet.size(); i++) {
            Kortti kortti1 = new Kortti(nimet.get(i));
            Kortti kortti2 = new Kortti(nimet.get(i));
            lisaaKuvaKortille(kortti1, i);
            lisaaKuvaKortille(kortti2, i);
            kortit.add(kortti1);
            kortit.add(kortti2);

        }
    }

    /**
     * Metodi asettaa kortit-listan korteille indeksit perustuen niiden
     * indeksiin listalla.
     */
    public void korttienIndeksointi(ArrayList<Kortti> indeksoitavatKortit) {
        for (int i = 0; i < indeksoitavatKortit.size(); i++) {
            indeksoitavatKortit.get(i).setIndeksi(i);
        }
    }
    
    public void lisaaKuvaKortille(Kortti kortti,int indeksi){
        String tiedostonimi="koira"+indeksi+".jpg";
        InputStream is = getClass().getClassLoader().getResourceAsStream(tiedostonimi);
        try {
            kortti.setKuva(ImageIO.read(is));
        } catch (IOException ex) {
            Logger.getLogger(Kortti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void luoSekoitetutKortit(int vaikeusaste){
        this.sekoitetutKortit=new ArrayList<>();
        for (int i = 0; i < vaikeusaste*4; i++) {
            sekoitetutKortit.add(kortit.get(i));
        }
        Collections.shuffle(sekoitetutKortit);
        korttienIndeksointi(sekoitetutKortit);
        
    }

    public ArrayList getNimet() {
        return this.nimet;
    }

    public ArrayList<Kortti> getSekoitetutKortit() {
        return this.sekoitetutKortit;
    }
    
    public void setSekoitetutkortit(ArrayList<Kortti> kortit){
        this.sekoitetutKortit=kortit;
    }
    
    public ArrayList<Kortti> getKortit(){
        return this.kortit;
    }

}
