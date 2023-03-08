import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUIMompoly extends JDialog {
    static ArrayList<Spieler> spielerliste = new ArrayList<>();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton bWuerfel;
    private JButton bKaufen;
    public static int i = 0;


    public GUIMompoly() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        bKaufen.setVisible(false);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        bWuerfel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onWuerfel();
            }
        });

        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onKaufen();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public static int getAktuellerSpieler(){
        return i;
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onKaufen() {
        spielerliste.get(i).kaufeFeld();
        bKaufen.setVisible(false);
        Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].setBesitzer(spielerliste.get(i));
        spielerliste.get(i).besitzListe.add(Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex]);
        Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].setPreisstufe(1);


    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    private void onWuerfel(){
        bKaufen.setVisible(true);
        if(i==spielerliste.size()-1){
            i=0;
        } else {
            i=i+1;
        }
        spielerliste.get(i).zug();
        if(Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getKaufpreis()==0){
            bKaufen.setVisible(false);
        }

        else if (Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getZuKaufen()==false) {
            bKaufen.setVisible(false);
            spielerliste.get(i).bezahleMiete();
            System.out.println(spielerliste.get(i) + " bezahlt Miete ("+ Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].berechnePreis() +") an " + Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getBesitzer());
            System.out.println("");
        }

        else if (spielerliste.get(i).kontostand<Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getKaufpreis()){
            bKaufen.setVisible(false);
        }

        System.out.println("Aktueller Spieler: " + spielerliste.get(i));
        System.out.println("Aktuelles Feld: " + spielerliste.get(i).aktuellerIndex);
        System.out.println("Kontostand: " + spielerliste.get(i).kontostand);
        System.out.println("");
    }


    static Spieler sp1= new Spieler();
    static Spieler sp2= new Spieler();

    public static void main(String[] args) {
            spielerliste.add(sp1);
            spielerliste.add(sp2);
            Spielbrett s1 = new Spielbrett();
            s1.erstelleSpielbrett();
            System.out.println((s1.felderListe[sp1.aktuellerIndex]).getKaufpreis());
            Feld aktuellesFeld = s1.felderListe[sp1.aktuellerIndex];

            aktuellesFeld.ereignisAusführen(sp1.aktuellerIndex);

            //Erstellung aller Felder mit Attributen, Index für das Array "felderList


            GUIMompoly dialog = new GUIMompoly();
            dialog.pack();
            dialog.setVisible(true);
            System.exit(0);
    }
}

