package muistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import muistipeli.ohjelmalogiikka.Lauta;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private Lauta lauta;
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;

    public GraafinenKayttoliittyma(Lauta lauta) {
        this.lauta = lauta;
    }

    @Override
    public void run() {
        menunLuonti();
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(800, 600));
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
        menuItem.addActionListener(new Menukuuntelija(menuItem,this));
        menu.add(menuItem);
        submenu = new JMenu("Vaikeusaste");
        submenu.setMnemonic(KeyEvent.VK_S);
        menuItem = new JMenuItem("Helppo");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuItem.addActionListener(new Menukuuntelija(menuItem,this));
        submenu.add(menuItem);
        menuItem = new JMenuItem("Keskitaso");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
        menuItem.addActionListener(new Menukuuntelija(menuItem,this));
        menu.add(submenu);
        menuItem = new JMenuItem("Vaikea");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,ActionEvent.ALT_MASK));
        submenu.add(menuItem);
        menuItem.addActionListener(new Menukuuntelija(menuItem,this));
        menu.add(submenu);
    }

    public void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(lauta.getVaikeusaste(), lauta.getVaikeusaste(), 0, 0);
        container.setLayout(layout);
        for (int i = 0; i < lauta.getKortit().size(); i++) {
            String j = String.valueOf(i);
            JButton lisattava = new JButton(j);
            lisattava.setFont(new Font("Arial", Font.PLAIN, 80));
            lisattava.addActionListener(new Nappikuuntelija(lisattava, frame, lauta));
            container.add(lisattava, i);
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
    
    public Lauta getLauta(){
        return this.lauta;
    }

}
//        JButton pelaajia1=new JButton("1");
//        JButton pelaajia2=new JButton("2");
//        Nappikuuntelija pelaajamaaranKuuntelija1=new Nappikuuntelija(pelaajia1,montako);
//        Nappikuuntelija pelaajamaaranKuuntelija2=new Nappikuuntelija(pelaajia2,montako);
//        pelaajia1.addActionListener(pelaajamaaranKuuntelija1);
//        pelaajia2.addActionListener(pelaajamaaranKuuntelija2);

//        GridLayout layout=new GridLayout(1,3);
//        container.setLayout(layout);
//        JTextArea textAreaVasen =new JTextArea("Kopioija");
//        JTextArea textAreaOikea=new JTextArea();
//        JButton nappi=new JButton("Kopioi!");
//        nappi.addActionListener(new KenttienKopioija(textAreaVasen, textAreaOikea));
//        container.add(textAreaVasen);
//        container.add(nappi);
//        container.add(textAreaOikea);
//        JButton nappi= new JButton("Viestitä!");
//        nappi.addActionListener(new ViestiKuuntelija());
//        container.add(nappi);
//        BoxLayout layout=new BoxLayout(container,BoxLayout.Y_AXIS);
//        container.setLayout(layout);
//        JLabel teksti=new JLabel("Hei, montako pelaajaa?");
//        container.add(teksti);
//        JRadioButton nappi1=new JRadioButton("1 Pelaaja");
//        JCheckBox nappi2=new JCheckBox("2 Pelaajaa");
//        ButtonGroup buttonGroup=new ButtonGroup();
//        buttonGroup.add(nappi1);
//        buttonGroup.add(nappi2);
//        
//        container.add(nappi1);
//        container.add(nappi2);
