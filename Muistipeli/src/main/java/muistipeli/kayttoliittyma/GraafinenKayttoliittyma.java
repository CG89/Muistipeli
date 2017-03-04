package muistipeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import muistipeli.ohjelmalogiikka.Lauta;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private Lauta lauta;
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    JCheckBoxMenuItem cbMenuItem;

    public GraafinenKayttoliittyma(Lauta lauta) {
        this.lauta = lauta;
    }

    @Override
    public void run() {
        menunLuonti();
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(1000, 800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
    }

    public void menunLuonti() {
        menuBar = new JMenuBar();
        menu = new JMenu("Valikko");
        menu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menu);
        menuItem = new JMenuItem("Uusi peli",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.addActionListener(new Menukuuntelija(menuItem, this));
        menu.add(menuItem);
        submenu = new JMenu("Vaikeusaste");
        submenu.setMnemonic(KeyEvent.VK_S);
        menuItem = new JMenuItem("Helppo");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuItem.addActionListener(new Menukuuntelija(menuItem, this));
        submenu.add(menuItem);
        menuItem = new JMenuItem("Keskitaso");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
        menuItem.addActionListener(new Menukuuntelija(menuItem, this));
        menu.add(submenu);
        menuItem = new JMenuItem("Vaikea");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
        menuItem.addActionListener(new Menukuuntelija(menuItem, this));
        menu.add(submenu);
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("Kaksinpeli");
        cbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        cbMenuItem.addActionListener(new Menukuuntelija(cbMenuItem, this));
        menu.add(cbMenuItem);
    }

    public void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(lauta.getVaikeusaste(), lauta.getVaikeusaste(), 0, 0);
        container.setLayout(layout);
        for (int i = 1; i <= lauta.getVaikeusaste() * 4; i++) {
            String j = String.valueOf(i);
            JButton lisattava = new JButton(j);
            lisattava.setFont(new Font("Arial", Font.PLAIN, 80));
            lisattava.addActionListener(new Nappikuuntelija(lisattava, frame, lauta));
            container.add(lisattava, i - 1);
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public void juokse() {
        this.run();
    }

    public void setLauta(Lauta lauta) {
        this.lauta = lauta;
    }

    public Lauta getLauta() {
        return this.lauta;
    }

}
