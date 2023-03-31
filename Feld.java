public interface Feld{
    public void ereignisAusführen(int aktuellerIndex);
    public int getKaufpreis();
    public boolean getZuKaufen();
    public void setZuKaufen(boolean i);
    public int getIndex();
    public int berechnePreis();
    public void setBesitzer(Spieler spieler);
    public Spieler getBesitzer();
    public void setPreisstufe(int preisstufe);
    public String getFarbe();
    public String getName();




    }