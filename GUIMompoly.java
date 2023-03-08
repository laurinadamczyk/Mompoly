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
        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBauen();
            }
        });

        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onKaufen();
            }
        });
        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBraun();
            }
        });
        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onHellblau();
            }
        });
        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPink();
            }
        });
        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOrange();
            }
        });
        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRot();
            }
        });
        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onGelb();
            }
        });
        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onGrün();
            }
        });
        this.bKaufen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDunkelblau();
            }
        });



    }

    public static int getAktuellerSpieler(){
        return i;
    }



    private void onKaufen() {
        farbButton(false);
        spielerliste.get(i).kaufeFeld();
        bKaufen.setVisible(false);
        Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].setBesitzer(spielerliste.get(i));
        spielerliste.get(i).besitzListe.add(Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex]);
        Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].setPreisstufe(1);
        if(Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getIndex() == 5 || Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getIndex() == 15 || Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getIndex() == 25 || Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getIndex() ==35) {
            spielerliste.get(i).bahnhofsAnzahl = spielerliste.get(i).bahnhofsAnzahl +1;
        }
        System.out.println("");
        farbButton(false);



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
        if(Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getKaufpreis()==0){
            bKaufen.setVisible(false);
        }

        else if (Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getZuKaufen()==false) {
            bKaufen.setVisible(false);

            if(Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getBesitzer() != spielerliste.get(i)){
                spielerliste.get(i).bezahleMiete();
                System.out.println(spielerliste.get(i) + " bezahlt Miete ("+ Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].berechnePreis() +") an " + Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getBesitzer());
                System.out.println("");
            }
            else{System.out.println("Die Straße gehört dir.");}

        }

        else if (spielerliste.get(i).kontostand<Spielbrett.felderListe[spielerliste.get(i).aktuellerIndex].getKaufpreis()){
            bKaufen.setVisible(false);
        }

        System.out.println("Aktueller Spieler: " + spielerliste.get(i));
        System.out.println("Aktuelles Feld: " + spielerliste.get(i).aktuellerIndex);
        System.out.println("Kontostand: " + spielerliste.get(i).kontostand);
        System.out.println("");
        farbButton(false);
    }

    private void onBauen() {
        int braun = 0;
        int hellblau = 0;
        int pink = 0;
        int orange = 0;
        int rot = 0;
        int gelb = 0;
        int grün = 0;
        int dunkelblau = 0;
        for(int j = 0; j < spielerliste.get(i).besitzListe.size() ; j++ ){
            if(spielerliste.get(i).besitzListe.get(j).getFarbe() == "Braun"){braun++;}
            else if(spielerliste.get(i).besitzListe.get(j).getFarbe() == "Hellblau"){hellblau++;}
            else if(spielerliste.get(i).besitzListe.get(j).getFarbe() == "Pink"){pink++;}
            else if(spielerliste.get(i).besitzListe.get(j).getFarbe() == "Orange"){orange++;}
            else if(spielerliste.get(i).besitzListe.get(j).getFarbe() == "Rot"){rot++;}
            else if(spielerliste.get(i).besitzListe.get(j).getFarbe() == "Gelb"){gelb++;}
            else if(spielerliste.get(i).besitzListe.get(j).getFarbe() == "Grün"){grün++;}
            else if(spielerliste.get(i).besitzListe.get(j).getFarbe() == "Dunkelblau"){dunkelblau++;}
        }
        if(braun==2){
            bBraun.setVisible(true);
        }
        else if(hellblau==3){
            bHellblau.setVisible(true);
        }
        else if(pink==3){
            bPink.setVisible(true);
        }
        else if(orange==3){
            bOrange.setVisible(true);
        }
        else if(rot==3){
            bRot.setVisible(true);
        }
        else if(gelb==3){
            bGelb.setVisible(true);
        }
       else if(grün==3){
            bGrün.setVisible(true);
        }
        else if (dunkelblau==2){
            bDunkelblau.setVisible(true);
        }



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

