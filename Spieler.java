import javax.swing.*;
import java.util.*;

public class Spieler {
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
    }
    public void bezahleMiete() {
        addKontostand(-Spielbrett.aktuellesFeld().berechnePreis());
        Spielbrett.aktuellesFeld().getBesitzer().addKontostand(Spielbrett.aktuellesFeld().berechnePreis());
    }
}
