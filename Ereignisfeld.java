public class Ereignisfeld implements Feld{

    int index;
    final int kaufpreis = 0;
    boolean zuKaufen= false;
    public void setZuKaufen(boolean i){
        zuKaufen = false;
    }
    @Override
    public int getIndex() {
        return index;
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
            case 2, 17, 33: System.out.println("gemeischaftskarte");//gemeinschaftskarte ziehen
                break;
            case 4:
                break;
            case 38: //100 bezahlen
                break;
            case 7, 22, 36: //fragekarte ziehen
                break;
            case 20: //alles geld aus mitte
                break;
            case 30: //ins gefängnis
                break;
            case 40: //gefängnis
                break;
            default:
                break;
        }
    }
    public Ereignisfeld(int index){
        this.index = index;
    }

}
