public class Main {
    public static void main(String[] args) {


        Spieler sp1 = new Spieler();
        Spielbrett s1 = new Spielbrett();
        s1.erstelleSpielbrett();
        sp1.aktuellerIndex = 2;
        System.out.println((s1.felderListe[sp1.aktuellerIndex]).getKaufpreis());
        Feld aktuellesFeld = s1.felderListe[sp1.aktuellerIndex];
        if(aktuellesFeld.getKaufpreis() == 0){
            aktuellesFeld.ereignisAusführen(sp1.aktuellerIndex);


        }
        //Erstellung aller Felder mit Attributen, Index für das Array "felderList


        GUIMompoly dialog = new GUIMompoly();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}