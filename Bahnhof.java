public class Bahnhof implements Feld{
    int index;
    int kaufpreis = 200;
    boolean zuKaufen=true;
    public Spieler besitzer;
    public int startpreis = 25;
    public String getFarbe(){return null;}
    public String name;

    public String getName(){
        return this.name;
    }

    public int berechnePreis(){ //preisberechnung für felder
        int preisberechnung = 0;
        if(Spielbrett.aktuellesFeld().getBesitzer().getBahnhofsAnzahl() == 1){
            preisberechnung = 1;
        } else if (Spielbrett.aktuellesFeld().getBesitzer().getBahnhofsAnzahl()  == 2){
            preisberechnung = 2;
        } else if (Spielbrett.aktuellesFeld().getBesitzer().getBahnhofsAnzahl()  == 3){
            preisberechnung = 4;
        } else if (Spielbrett.aktuellesFeld().getBesitzer().getBahnhofsAnzahl()  == 4){
            preisberechnung = 8;
        }
        int endpreis = startpreis * preisberechnung;
        return endpreis;
    }

    public void setBesitzer(Spieler spieler){this.besitzer = spieler;}

    public Spieler getBesitzer(){return besitzer;}

    public int getKaufpreis(){
        return kaufpreis;
    }

    public void setZuKaufen(boolean i){
        zuKaufen = i;
    }

    @Override
    public boolean getZuKaufen() {
        return zuKaufen;
    }

    public void ereignisAusführen(int aktuellerIndex){}

    public void setPreisstufe(int preisstufe){}

    public int getIndex() {
        return index;
    }

    public Bahnhof(String name, int index){
        this.index = index;
        this.name = name;
    }

}