import java.util.*;

public class Spieler {
    public int aktuellerIndex;
    public int kontostand = 2000;
    ArrayList<Feld> besitzListe = new ArrayList<>(); // Liste für alle Straßen in Besitz

    public int getKontostand() {
        return kontostand;
    }
    public int getAktuellerIndex(){
        return aktuellerIndex;
    }

    public void setKontostand(int kontostand) {
        this.kontostand = kontostand;
    }

    public void kaufeFeld(){
        if(Spielbrett.felderListe[aktuellerIndex].getKaufpreis()==0){
            System.out.println("Dieses Feld kann nicht gekauft werden");
        }

        else if (Spielbrett.felderListe[aktuellerIndex].getZuKaufen()==false) {
            System.out.println("Das Feld wurde bereits gekauft");
        }

        else if (kontostand<Spielbrett.felderListe[aktuellerIndex].getKaufpreis()){
            System.out.println("Du hast nicht genug Geld");
        }

        else{
            GUIMompoly.spielerliste.get(GUIMompoly.getAktuellerSpieler()).besitzListe.add(Spielbrett.felderListe[aktuellerIndex]);
            GUIMompoly.spielerliste.get(GUIMompoly.getAktuellerSpieler()).setKontostand(GUIMompoly.spielerliste.get(GUIMompoly.getAktuellerSpieler()).getKontostand() - Spielbrett.felderListe[aktuellerIndex].getKaufpreis());
            Spielbrett.felderListe[aktuellerIndex].setZuKaufen(false);
            System.out.println(GUIMompoly.spielerliste.get(GUIMompoly.getAktuellerSpieler()) + "hat soeben die Straße mit dem Index " + GUIMompoly.spielerliste.get(GUIMompoly.getAktuellerSpieler()).getAktuellerIndex() + " gekauft." );
            System.out.println("Kaufpreis: " + Spielbrett.felderListe[aktuellerIndex].getKaufpreis());
            System.out.println("Kontostand: " + GUIMompoly.spielerliste.get(GUIMompoly.getAktuellerSpieler()).getKontostand());
            System.out.println("");
        }


    }
    public void zug(){ //eine runde würfeln
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
        aktuellerIndex = returnwert;
    }
}
