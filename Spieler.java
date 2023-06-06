import javax.swing.*;
import java.util.*;

public class Spieler {
    public int x;
    public int y;
    public int aktuellerIndex;
    public int paschcounter;
    boolean gefaengnis = false;
    public boolean bWuerfelnSichbarkeit = false;
    int gefeangniscounter;
    int zuBesuch = 10;
    public int kontostand = 2000;
    ArrayList<Feld> besitzListe = new ArrayList<>(); // Liste für alle Straßen in Besitz
    public int bahnhofsAnzahl = 0;
    public void setGefaengnis(boolean g){
        gefaengnis = g;
    }
    public int getKontostand() {
        return kontostand;
    }
    public int getAktuellerIndex(){
        return aktuellerIndex;
    }
    public void setAktuellerIndex(int i){
        aktuellerIndex = i;
    }
    public void addKontostand(int preis) {
        this.kontostand = this.kontostand + preis;
    }

    public int getBahnhofsAnzahl(){
        return this.bahnhofsAnzahl;
    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }


    public void kaufeFeld(){
        if(Spielbrett.aktuellesFeld().getKaufpreis()==0){
            System.out.println("Dieses Feld kann nicht gekauft werden");
        }

        else if (Spielbrett.aktuellesFeld().getZuKaufen()==false) {
            System.out.println("Das Feld wurde bereits gekauft");
        }

        else if (kontostand<Spielbrett.aktuellesFeld().getKaufpreis()){
            System.out.println("Du hast nicht genug Geld");
        }

        else{
            GUIMompoly.aktuellerSpieler().besitzListe.add(Spielbrett.aktuellesFeld());
            GUIMompoly.aktuellerSpieler().addKontostand(  - Spielbrett.aktuellesFeld().getKaufpreis());
            Spielbrett.aktuellesFeld().setZuKaufen(false);
            Spielbrett.aktuellesFeld().setBesitzer(GUIMompoly.spielerliste.get(GUIMompoly.i));
            Spielbrett.aktuellesFeld().setPreisstufe(1);
            if(Spielbrett.aktuellesFeld().getIndex() == 5 || Spielbrett.aktuellesFeld().getIndex() == 15 || Spielbrett.aktuellesFeld().getIndex() == 25 || Spielbrett.aktuellesFeld().getIndex() ==35) {
                GUIMompoly.aktuellerSpieler().bahnhofsAnzahl = GUIMompoly.aktuellerSpieler().bahnhofsAnzahl + 1;
            }
            System.out.println(GUIMompoly.aktuellerSpieler() + " hat soeben die Straße mit dem Index " + Spielbrett.aktuellesFeld().getIndex() + " gekauft." );
            System.out.println("Kaufpreis: " + Spielbrett.aktuellesFeld().getKaufpreis());
            System.out.println("Kontostand: " + GUIMompoly.aktuellerSpieler().getKontostand());
            System.out.println("Der Spieler besitzt Straßen: ");
            for(int i = 0; i < GUIMompoly.aktuellerSpieler().besitzListe.size(); i++){
                System.out.println(GUIMompoly.aktuellerSpieler().besitzListe.get(i).getFarbe());
            }
            System.out.println("");
        }
    }


    public void zug(){ //eine runde würfeln
        bWuerfelnSichbarkeit = true;
        int returnwert;
        int wuerfel1 = (int)((Math.random())*6 + 1);
        int wuerfel2 = (int)((Math.random())*6 + 1);
        int wuerfelergebnis = wuerfel1 + wuerfel2;
        if(aktuellerIndex + wuerfelergebnis > 39){
            returnwert = wuerfelergebnis - (40 - aktuellerIndex);
            kontostand = kontostand + 200;
        } else {
            returnwert = aktuellerIndex + wuerfelergebnis;
        }
        if (!gefaengnis) {
            aktuellerIndex = returnwert;
        }else if (gefeangniscounter == 3){
            gefaengnis = false;
            aktuellerIndex = 10 + returnwert;
            gefeangniscounter = 0;
        } else if (gefaengnis){
            if (wuerfel1 == wuerfel2){
                gefaengnis = false;
                aktuellerIndex = 10 + returnwert;
                gefeangniscounter = 0;
            } else {
                gefeangniscounter++;
            }
        }
        Spielbrett.aktuellesFeld().ereignisAusführen(GUIMompoly.aktuellerSpieler().aktuellerIndex);
        if(wuerfel1 == wuerfel2){
            paschcounter++;
            bWuerfelnSichbarkeit = true;
        }
        if(paschcounter == 3){
            gefaengnis = true;
        }
        switch(returnwert){
            case 0 : x = 922-GUIMompoly.; y = 872;
                break;
            case 1 : x = 767; y = 872;
                break;
            case 2 : x = 687; y = 872;
                break;
            case 3 : x = 607; y = 872;
                break;
            case 4 : x = 527; y = 872;
                break;
            case 5 : x = 447; y = 872;
                break;
            case 6 : x = 367; y = 872;
                break;
            case 7 : x = 287; y = 872;
                break;
            case 8 : x = 207; y = 872;
                break;
            case 9 : x = 127; y = 872;
                break;
            case 10 : x = 47; y = 872;
                break;
            case 11 : x = 20; y = 720;
                break;
            case 12 : x = 20; y = 660;
                break;
            case 13 : x = 20; y = 580;
                break;
            case 14 : x = 20; y = 500;
                break;
            case 15 : x = 20; y = 420;
                break;
            case 16 : x = 20; y = 340;
                break;
            case 17 : x = 20; y = 260;
                break;
            case 18 : x = 20; y = 800;
                break;
            case 19 : x = 20; y = 800;
                break;
            case 20 : x = 20; y = 800;
                break;
            case 21 : x = 100; y = 800;
                break;
            case 22 : x = 180; y = 800;
                break;
            case 23 : x = 580; y = 800;
                break;
            case 24 : x = 500; y = 800;
                break;
            case 25 : x = 420; y = 800;
                break;
            case 26 : x = 340; y = 800;
                break;
            case 27 : x = 260; y = 800;
                break;
            case 28 : x = 180; y = 800;
                break;
            case 29 : x = 100; y = 800;
                break;
            case 30 : x = 20; y = 800;
                break;
            case 31 : x = 20; y = 720;
                break;
            case 32 : x = 800; y = 660;
                break;
            case 33 : x = 750; y = 580;
                break;
            case 34 : x = 800; y = 500;
                break;
            case 35 : x = 750; y = 420;
                break;
            case 36 : x = 800; y = 340;
                break;
            case 37 : x = 750; y = 260;
                break;
            case 38 :
                break;
            case 39 :
                break;
            case 40 :
                break;

        }
    }
    public void bezahleMiete() {
        addKontostand(-Spielbrett.aktuellesFeld().berechnePreis());
        Spielbrett.aktuellesFeld().getBesitzer().addKontostand(Spielbrett.aktuellesFeld().berechnePreis());
    }
}
