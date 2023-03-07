public class Bahnhof implements Feld{
    int index;
    int preisstufe;
    int kaufpreis = 200;
    boolean zuKaufen=true;


    public void ereignisAusführen(int aktuellerIndex) {
        switch(aktuellerIndex){
            case 5:  //bhf1
                break;
            case 15: //bhf2
                break;
            case 25: //bhf3
                break;
            case 35: //bhf4
            default:
                break;
        }
    }
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


    public int getIndex() {
        return index;
    }


    public Bahnhof(int index){
        this.index = index;
    }
}
