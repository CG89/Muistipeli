package muistipeli.kayttoliittyma;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class Menukuuntelija implements ActionListener {

    private JMenuItem menuItem;
    private GraafinenKayttoliittyma gui;
    private int napinNumero;

    public Menukuuntelija(JMenuItem menuItem, GraafinenKayttoliittyma gui) {
        this.menuItem = menuItem;
        this.gui = gui;

    }

    @Override
    public void actionPerformed(ActionEvent a) {
        Container container = gui.getFrame().getContentPane();
        container.removeAll();
        this.napinNumero = mikaNappi(menuItem);
        if (napinNumero > 2 && napinNumero < 6) {
            gui.getLauta().uusiPeli(napinNumero);
        }
        if (napinNumero == 2) {
            if (gui.getLauta().getPelaajamaara() == 1) {
                gui.getLauta().setPelaajamaara(2);
            } else {
                gui.getLauta().setPelaajamaara(1);
            }
            gui.getLauta().uusiPeli(gui.getLauta().getVaikeusaste());
        } else {
            gui.getLauta().uusiPeli(gui.getLauta().getVaikeusaste());
        }
        gui.luoKomponentit(container);

        gui.getFrame().pack();
        gui.getFrame().setTitle("Uusi peli, pelaajia: " + gui.getLauta().getPelaajamaara());
    }

    public int mikaNappi(JMenuItem menuItem) {
        String teksti = menuItem.getText();
        if (teksti.equals("Uusi peli")) {
            return gui.getLauta().getVaikeusaste();
        }
        if (teksti.equals("Helppo")) {
            return 3;
        }
        if (teksti.equals("Keskitaso")) {
            return 4;
        }
        if (teksti.equals("Vaikea")) {
            return 5;
        }
        if (teksti.equals("Kaksinpeli")) {
            return 2;
        } else {
            return 4;
        }
    }

}
