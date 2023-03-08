public class Bahnhof implements Feld{
    int index;
    int kaufpreis = 200;
    boolean zuKaufen=true;
    public Spieler besitzer;
    public int startpreis = 25;

    public String getFarbe(){return null;}

    public int berechnePreis(){ //preisberechnung für felder
        int preisberechnung = 0;
        if(GUIMompoly.spielerliste.get(GUIMompoly.i).getBahnhofsAnzahl() == 1){
            preisberechnung = 1;
        } else if (GUIMompoly.spielerliste.get(GUIMompoly.i).getBahnhofsAnzahl()  == 2){
            preisberechnung = 2;
        } else if (GUIMompoly.spielerliste.get(GUIMompoly.i).getBahnhofsAnzahl()  == 3){
            preisberechnung = 4;
        } else if (GUIMompoly.spielerliste.get(GUIMompoly.i).getBahnhofsAnzahl()  == 4){
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
    public void ereignisAusführen(int aktuellerIndex) {}
    public void setPreisstufe(int preisstufe){}

    public int getIndex() {
        return index;
    }


    public Bahnhof(int index){
        this.index = index;
    }


}



