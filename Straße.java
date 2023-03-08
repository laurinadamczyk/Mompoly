public class Straße implements Feld {
    String farbe;
    int index;
    int kaufpreis;
    boolean zuKaufen=true;
    public Spieler besitzer;

    public int getIndex() {
        return index;
    }

    public void setBesitzer(Spieler besitzer) {
        this.besitzer = besitzer;
    }
    public Spieler getBesitzer(){return besitzer;}


    int startpreis;
    boolean besitzstatus;
    @Override
    public void ereignisAusführen(int aktuellerIndex){

    }

    int preisstufe; //stufe 1 = grundmiete, stufe 2 = grundmiete verdoppelt, stufe 3 = 1, stufe 4 = 2 häuser, stufe 5 = 3 häuser, stufe 6 = 4 häsuer, stufe 7 = 5 häuser
    public void setPreisstufe(int preisstufe){
        this.preisstufe = preisstufe;
    }
    public int getKaufpreis() {
        return kaufpreis;

    }
    public Straße(String farbe, int index, int kaufpreis, int startpreis){
        this.index = index;
        this.kaufpreis = kaufpreis;
        this.farbe = farbe;
        this.startpreis = startpreis;
    }
    public int berechnePreis(){ //preisberechnung für felder
        int preisberechnung = 0;
        if(preisstufe == 1){
            preisberechnung = 1;
        } else if (preisstufe == 2){
            preisberechnung = 2;
        } else if (preisstufe == 3){
            preisberechnung = 5;
        } else if (preisstufe == 4){
            preisberechnung = 14;
        } else if (preisstufe == 5){
            preisberechnung = 37;
        } else if (preisstufe == 6){
            preisberechnung = 50;
        } else if (preisstufe == 7) {
            preisberechnung = 62;
        }
        int endpreis = startpreis * preisberechnung;
        return endpreis;
    }

    public void setZuKaufen(boolean i){
        zuKaufen = i;
    }
    public boolean getZuKaufen(){
        return zuKaufen;
    }


}