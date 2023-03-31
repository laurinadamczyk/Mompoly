import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUIMompoly extends JDialog {
    static ArrayList<Spieler> spielerliste = new ArrayList<>();
    private JPanel contentPane;
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

    public static int i = 0;


    public GUIMompoly() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(bWuerfel);
        bKaufen.setVisible(false);
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



    }

    public static Spieler aktuellerSpieler(){
        return spielerliste.get(i);
    }




    private void onKaufen() {
        spielerliste.get(i).kaufeFeld();
        bKaufen.setVisible(false);
        farbabfrage(false);
    }

    public void straßeVollständig() {
        for (int j = 0; j < aktuellerSpieler().besitzListe.size(); j++) {
            if (Spielbrett.aktuellesFeld().getFarbe() == aktuellerSpieler().besitzListe.get(j).getFarbe()){
                aktuellerSpieler().besitzListe.get(j).setPreisstufe(2);
                System.out.println("preisstufe auf 2 erhöht");
            }
        }
    }


    private void onWuerfel(){
        farbButton(false);
        bKaufen.setVisible(true);
        if(i==spielerliste.size()-1){
            i=0;
        } else {
            i=i+1;
        }
        spielerliste.get(i).zug();
        if(Spielbrett.aktuellesFeld().getKaufpreis()==0){
            bKaufen.setVisible(false);
        }

        else if (Spielbrett.aktuellesFeld().getZuKaufen()==false) {
            bKaufen.setVisible(false);

            if(Spielbrett.aktuellesFeld().getBesitzer() != spielerliste.get(i)){
                spielerliste.get(i).bezahleMiete();
                System.out.println(aktuellerSpieler() + " bezahlt Miete ("+ Spielbrett.aktuellesFeld().berechnePreis() +") an " + Spielbrett.aktuellesFeld().getBesitzer());
                System.out.println("");
            }
            else{System.out.println("Die Straße gehört dir.");}

        }

        else if (spielerliste.get(i).kontostand<Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getKaufpreis()){
            bKaufen.setVisible(false);
        }

        System.out.println("Aktueller Spieler: " + aktuellerSpieler());
        System.out.println("Aktuelles Feld: " + aktuellerSpieler().aktuellerIndex);
        System.out.println("Kontostand: " + aktuellerSpieler().kontostand);

        System.out.println("");
        farbButton(false);
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
            straßeVollständig();
        }
        else if(hellblau==3){
            bHellblau.setVisible(sichtbar);
            straßeVollständig();
        }
        else if(pink==3){
            bPink.setVisible(sichtbar);
            straßeVollständig();
        }
        else if(orange==3){
            bOrange.setVisible(sichtbar);
            straßeVollständig();
        }
        else if(rot==3){
            bRot.setVisible(sichtbar);
            straßeVollständig();
        }
        else if(gelb==3){
            bGelb.setVisible(sichtbar);
            straßeVollständig();
        }
        else if(grün==3){
            bGrün.setVisible(sichtbar);
            straßeVollständig();
        }
        else if (dunkelblau==2){
            bDunkelblau.setVisible(sichtbar);
            straßeVollständig();
        }
    }

    private void onBauen() {
        farbabfrage(true);
    }

    public void farbButton(boolean b){
        bBraun.setVisible(b);
        bHellblau.setVisible(b);
        bPink.setVisible(b);
        bOrange.setVisible(b);
        bRot.setVisible(b);
        bGelb.setVisible(b);
        bGrün.setVisible(b);
        bDunkelblau.setVisible(b);
    }

    private void onBraun() {}
    private void onHellblau() {}
    private void onPink() {}
    private void onOrange() {}
    private void onRot() {}
    private void onGelb() {}
    private void onGrün() {}
    private void onDunkelblau() {}



    static Spieler sp1= new Spieler();
    static Spieler sp2= new Spieler();
    static Spielbrett s1 = new Spielbrett();

    public static void main(String[] args) {
            spielerliste.add(sp1);
            spielerliste.add(sp2);
            s1.erstelleSpielbrett();
            //Erstellung aller Felder mit Attributen, Index für das Array "felderList


            GUIMompoly dialog = new GUIMompoly();
            dialog.pack();
            dialog.setVisible(true);
            System.exit(0);
    }
}

