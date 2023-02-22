import java.util.LinkedList;
public class Spieler {
    public int aktuellerIndex;
    public int kontostand = 2000;
    public void ueberweisung(int summe){
        this.kontostand = kontostand + summe;
    }
    LinkedList<Feld> besitzListe = new LinkedList<>(); // liste für alle straßen in besitz
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
