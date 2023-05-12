import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;
import javax.imageio.ImageIO;





public class GUIMompoly extends JDialog{
    BufferedImage img = ImageIO.read(new File("C:\\Users\\la002310\\Documents\\Mompoly.git\\branches\\dateien\\monopoly-printable-game-board-paper-craft.jpg"));
    JLabel pic = new JLabel(new ImageIcon(img));
    static ArrayList<Spieler> spielerliste = new ArrayList<>();
    public JPanel contentPane;
    private JButton bWuerfel;
    private JButton bKaufen;
    private JButton bBauen;
    private JButton bBraun;
    private JButton bHellblau;
    private JButton bPink;
    private JButton bOrange;
    private JButton bRot;
    private JButton bGelb;
    private JButton bGrün;
    private JButton bDunkelblau;
    private JButton bZugBeenden;
    private JLabel lAktuellerSpieler;
    public static int i = 0;



    public GUIMompoly() throws IOException {
        contentPane.add(pic);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(bWuerfel);
        bKaufen.setVisible(false);
        bBauen.setVisible(false);
        bZugBeenden.setVisible(false);
        farbButton(false);


        bWuerfel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onWuerfel();
            }
        });
        this.bBauen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBauen();
            }
        });

        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onKaufen();
            }
        });
        this.bBraun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBraun();
            }
        });
        this.bHellblau.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onHellblau();
            }
        });
        this.bPink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPink();
            }
        });
        this.bOrange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOrange();
            }
        });
        this.bRot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRot();
            }
        });
        this.bGelb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onGelb();
            }
        });
        this.bGrün.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onGrün();
            }
        });
        this.bDunkelblau.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDunkelblau();
            }
        });
        this.bZugBeenden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onZugBeenden();
            }
        });



    }

    public static Spieler aktuellerSpieler(){
        return spielerliste.get(i);
    }

    private void onKaufen() {
        aktuellerSpieler().kaufeFeld();
        bKaufen.setVisible(false);
        farbabfrage(false);
    }

    public void onZugBeenden(){
        bZugBeenden.setVisible(false);
        bWuerfel.setVisible(true);
        bBauen.setVisible(false);
        bKaufen.setVisible(false);
        farbButton(false);
        if(i==spielerliste.size()-1){
            i=0;
        } else {
            i=i+1;
        }
        lAktuellerSpieler.setText(i+"");
    }

    private void onWuerfel(){
        bWuerfel.setVisible(false);
        farbButton(false);
        if(aktuellerSpieler().bWuerfelnSichbarkeit = false) {
            bWuerfel.setVisible(false);
        }
        aktuellerSpieler().zug();
        //ALLLLELEES HIER FDDRUTNERT
        farbabfrage(false);
        setbKaufen();
        bKaufen.setVisible(true);
        if(Spielbrett.aktuellesFeld().getKaufpreis()==0){
            bKaufen.setVisible(false);
        }
        else if (Spielbrett.aktuellesFeld().getZuKaufen()==false) {
            bKaufen.setVisible(false);
            if(Spielbrett.aktuellesFeld().getBesitzer() != aktuellerSpieler()){
                aktuellerSpieler().bezahleMiete();
                System.out.println(aktuellerSpieler() + " bezahlt Miete ("+ Spielbrett.aktuellesFeld().berechnePreis() +") an " + Spielbrett.aktuellesFeld().getBesitzer());
                System.out.println("");
            }
            else{System.out.println("Die Straße" + Spielbrett.aktuellesFeld().getName() +  "gehört dir.");}

        }

        else if (aktuellerSpieler().kontostand<Spielbrett.aktuellesFeld().getKaufpreis()){
            bKaufen.setVisible(false);
        }

        System.out.println("Aktueller Spieler: " + aktuellerSpieler());
        System.out.println("Aktuelles Feld: " + Spielbrett.aktuellesFeld().getName() + Spielbrett.aktuellesFeld().getIndex());
        System.out.println("Kontostand: " + aktuellerSpieler().kontostand);

        System.out.println("");
        farbButton(false);
        bZugBeenden.setVisible(true);
    }

    public void setbKaufen(){
        bKaufen.setVisible(false);
        bKaufen.setText("Möchten sie Feld " + Spielbrett.aktuellesFeld().getName() + " (" + Spielbrett.aktuellesFeld().getFarbe() + ")" + " kaufen?");
    }
    public void farbabfrage(boolean sichtbar){
        int braun = 0;
        int hellblau = 0;
        int pink = 0;
        int orange = 0;
        int rot = 0;
        int gelb = 0;
        int grün = 0;
        int dunkelblau = 0;
        for(int j = 0; j < aktuellerSpieler().besitzListe.size() ; j++ ){
            if(aktuellerSpieler().besitzListe.get(j).getFarbe() == "Braun"){braun++;}
            else if(aktuellerSpieler().besitzListe.get(j).getFarbe() == "Hellblau"){hellblau++;}
            else if(aktuellerSpieler().besitzListe.get(j).getFarbe() == "Pink"){pink++;}
            else if(aktuellerSpieler().besitzListe.get(j).getFarbe() == "Orange"){orange++;}
            else if(aktuellerSpieler().besitzListe.get(j).getFarbe() == "Rot"){rot++;}
            else if(aktuellerSpieler().besitzListe.get(j).getFarbe() == "Gelb"){gelb++;}
            else if(aktuellerSpieler().besitzListe.get(j).getFarbe() == "Grün"){grün++;}
            else if(aktuellerSpieler().besitzListe.get(j).getFarbe() == "Dunkelblau"){dunkelblau++;}
        }
        if(braun==2){
            bBraun.setVisible(sichtbar);
            Spielbrett.felderListe[1].setPreisstufe(2);
            Spielbrett.felderListe[3].setPreisstufe(2);
            bBauen.setVisible(true);
        }
        if(hellblau==3){
            bHellblau.setVisible(sichtbar);
            Spielbrett.felderListe[6].setPreisstufe(2);
            Spielbrett.felderListe[8].setPreisstufe(2);
            Spielbrett.felderListe[9].setPreisstufe(2);
            bBauen.setVisible(true);
        }
        if(pink==3){
            bPink.setVisible(sichtbar);
            Spielbrett.felderListe[11].setPreisstufe(2);
            Spielbrett.felderListe[13].setPreisstufe(2);
            Spielbrett.felderListe[14].setPreisstufe(2);
            bBauen.setVisible(true);
        }
        if(orange==3){
            bOrange.setVisible(sichtbar);
            Spielbrett.felderListe[16].setPreisstufe(2);
            Spielbrett.felderListe[18].setPreisstufe(2);
            Spielbrett.felderListe[19].setPreisstufe(2);
            bBauen.setVisible(true);
        }
        if(rot==3){
            bRot.setVisible(sichtbar);
            Spielbrett.felderListe[21].setPreisstufe(2);
            Spielbrett.felderListe[23].setPreisstufe(2);
            Spielbrett.felderListe[24].setPreisstufe(2);
            bBauen.setVisible(true);
        }
        if(gelb==3){
            bGelb.setVisible(sichtbar);
            Spielbrett.felderListe[26].setPreisstufe(2);
            Spielbrett.felderListe[27].setPreisstufe(2);
            Spielbrett.felderListe[29].setPreisstufe(2);
            bBauen.setVisible(true);
        }
        if(grün==3){
            bGrün.setVisible(sichtbar);
            Spielbrett.felderListe[31].setPreisstufe(2);
            Spielbrett.felderListe[32].setPreisstufe(2);
            Spielbrett.felderListe[34].setPreisstufe(2);
            bBauen.setVisible(true);
        }
        if (dunkelblau==2){
            bDunkelblau.setVisible(sichtbar);
            Spielbrett.felderListe[37].setPreisstufe(2);
            Spielbrett.felderListe[39].setPreisstufe(2);
            bBauen.setVisible(true);
        }
    }

    private void onBauen() {
        farbabfrage(true);
    }

    public void farbButton(boolean b) {
        bBraun.setVisible(b);
        bHellblau.setVisible(b);
        bPink.setVisible(b);
        bOrange.setVisible(b);
        bRot.setVisible(b);
        bGelb.setVisible(b);
        bGrün.setVisible(b);
        bDunkelblau.setVisible(b);
    }

    public void kaufoption(){

    }
    private void onBraun() {

    }
    private void onHellblau() {

    }
    private void onPink() {

    }
    private void onOrange() {

    }
    private void onRot() {

    }
    private void onGelb() {

    }
    private void onGrün() {

    }
    private void onDunkelblau() {}
    static Spieler Yuri= new Spieler();
    static Spieler Laurin = new Spieler();
    static Spielbrett s1 = new Spielbrett();

     public void ImagePanel() {
        try
        {
            JFrame f = new JFrame("Add an Image to a JPanel");
            contentPane.setBounds(0, 0, 1000, 1000);
            BufferedImage img = ImageIO.read(new File("C:\\Users\\la002310\\Documents\\Mompoly.git\\branches\\dateien\\monopoly-printable-game-board-paper-craft.jpg"));
            JLabel pic = new JLabel(new ImageIcon(img));
            contentPane.add(pic);
            f.add(contentPane);
            f.setSize(1000, 1000);
            f.setLayout(null);
            f.setVisible(true);
        }
        catch (IOException e) {}
    }

    public static void main(String[] args) throws IOException {
            spielerliste.add(Yuri);
            spielerliste.add(Laurin);
            s1.erstelleSpielbrett();
            //Erstellung aller Felder mit Attributen, Index für das Array "felderListe"
            GUIMompoly dialog = new GUIMompoly();
            dialog.pack();
            dialog.setVisible(true);
            System.exit(0);
    }
}

