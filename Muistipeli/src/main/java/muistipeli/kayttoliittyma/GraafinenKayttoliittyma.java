package muistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import muistipeli.ohjelmalogiikka.Lauta;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private Lauta lauta;

    public GraafinenKayttoliittyma(Lauta lauta) {
        this.lauta = lauta;
    }

    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(800, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        GridLayout layout = new GridLayout(4, 4, 10, 10);

        container.setLayout(layout);

//        JButton lisattava=new JButton("1");
//        lisattava.addActionListener(new Nappikuuntelija(lisattava,lauta));
//        container.add(lisattava);
        for (int i = 0; i < 16; i++) {

            String j = String.valueOf(i);
            JButton lisattava = new JButton(j);
            lisattava.addActionListener(new Nappikuuntelija(lisattava, frame, lauta));
            container.add(lisattava, i);

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
    public JFrame getFrame() {
        return frame;
    }

}
