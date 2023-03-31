public class Ereignisfeld implements Feld{

    int index;
    final int kaufpreis = 0;
    boolean zuKaufen= false;
    public void setZuKaufen(boolean i){
        zuKaufen = false;
    }

    public int berechnePreis(){return 0;}

    public void setBesitzer(Spieler spieler){}

    public Spieler getBesitzer(){return null;}

    public void setPreisstufe(int preisstufe){}

    @Override
    public int getIndex() {
        return index;
    }

    public String getFarbe(){return null;}
    public String getName(){
        return null;
    }
    @Override
    public int getKaufpreis() {
        return kaufpreis;
    }

    @Override
    public boolean getZuKaufen() {
        return false;
    }

    public void ereignisAusführen(int aktuellerIndex){
        switch(aktuellerIndex){
            case 2, 17, 33: //gemeinschaftskarte ziehen
                break;
            case 4: GUIMompoly.aktuellerSpieler().addKontostand(-200);
                Spielbrett.addMitte(200);
                break;
            case 38: GUIMompoly.aktuellerSpieler().addKontostand(-100);
                Spielbrett.addMitte(100);
                break;
            case 7, 22, 36: //fragekarte ziehen
                break;
            case 20: GUIMompoly.aktuellerSpieler().addKontostand(Spielbrett.getMitte());
                Spielbrett.ausgecasht();
                break;
            case 30: GUIMompoly.aktuellerSpieler().setAktuellerIndex(40);
                GUIMompoly.aktuellerSpieler().setGefaengnis(true);
                break;
            default:
                break;
        }
    }

    public Ereignisfeld(int index){
        this.index = index;
    }

}
