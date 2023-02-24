import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUIMompoly extends JDialog {
    static ArrayList<Spieler> spieler= new ArrayList<>();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton bWuerfel;

    public GUIMompoly() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    private int i=0;
    private void onWuerfel(){

        if(i==spieler.size()-1){
            i=0;
        } else {
            i=i+1;
        }
        spieler.get(i).zug();


        System.out.println(spieler.get(i));
        System.out.println(spieler.get(i).aktuellerIndex);
        System.out.println(spieler.get(i).kontostand);
        System.out.println("");
    }



    static Spieler sp1= new Spieler();
    static Spieler sp2= new Spieler();

    public static void main(String[] args) {
            spieler.add(sp1);
            spieler.add(sp2);
            Spielbrett s1 = new Spielbrett();
            s1.erstelleSpielbrett();
            System.out.println((s1.felderListe[sp1.aktuellerIndex]).getKaufpreis());
            Feld aktuellesFeld = s1.felderListe[sp1.aktuellerIndex];
            if(aktuellesFeld.getKaufpreis() == 0){
                aktuellesFeld.ereignisAusführen(sp1.aktuellerIndex);


            }
            //Erstellung aller Felder mit Attributen, Index für das Array "felderList


            GUIMompoly dialog = new GUIMompoly();
            dialog.pack();
            dialog.setVisible(true);
            System.exit(0);
        }
}

