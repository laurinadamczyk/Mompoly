import java.lang.Math;
public class Spielbrett {
    static Feld[] felderListe = new Feld[41]; //erstellung array für felder
    public static int mitte;
    public static int getMitte(){
        return mitte;
    }
    public static void addMitte(int preis){
        mitte = mitte + preis;
    }

    public static void ausgecasht(){
        mitte = 0;
    }

    public static Feld aktuellesFeld(){
        return Spielbrett.felderListe[GUIMompoly.aktuellerSpieler().aktuellerIndex];
    }

    public void erstelleSpielbrett(){ //erstellung aller// felder
        Ereignisfeld Los = new Ereignisfeld ( 0);
        Straße Badstraße = new Straße("Badstraße", "Braun", 1, 60, 2);
        Ereignisfeld Gemeinschaftsfeld1 = new Ereignisfeld( 2);
        Straße Turmstraße = new Straße("Turmstraße", "Braun", 3, 60, 4);
        Ereignisfeld Einkommenssteuer = new Ereignisfeld( 4);
        Bahnhof Bahnhof1 = new Bahnhof("Südbahnhof", 5);
        Straße Chausseestraße = new Straße("Chausseestraße", "Hellblau", 6, 100, 6);
        Ereignisfeld Ereignisfeld1 = new Ereignisfeld( 7);
        Straße Elisenstraße = new Straße("Elisenstraße", "Hellblau", 8, 100, 6);
        Straße Poststraße = new Straße("Poststraße", "Hellblau", 9, 120, 8);
        Ereignisfeld Zu_Besuch = new Ereignisfeld( 10);
        Straße Seestraße = new Straße ("Seestraße", "Pink", 11, 140, 10);
        Straße Elektrizitaetswerk = new Straße("Elektrizitätswerk", "Werk", 12, 150, 0);
        Straße Hafenstraße = new Straße("Hafenstraße", "Pink", 13, 140, 10);
        Straße Neue_Straße = new Straße("Neue Straße", "Pink", 14, 160, 12);
        Bahnhof Bahnhof2 = new Bahnhof("Westbahnhof", 15);
        Straße Muenchner_Straße = new Straße("Münchner Straße", "Orange", 16, 180, 14);
        Ereignisfeld Gemeinschaftsfeld2 = new Ereignisfeld( 17);
        Straße Wiener_Straße = new Straße("Wiener Straße" ,"Orange", 18, 180, 14);
        Straße Berliner_Straße = new Straße("Berliner Straße", "Orange", 19, 200, 16);
        Ereignisfeld Frei_Parken = new Ereignisfeld( 20);
        Straße Theaterstraße = new Straße("Theaterstraße", "Rot", 21, 220, 18);
        Ereignisfeld Ereignisfeld2 = new Ereignisfeld( 22);
        Straße Museumstraße = new Straße("Museumstraße", "Rot", 23, 220, 18);
        Straße Opernplatz = new Straße("Opernplatz", "Rot", 24, 240, 20);
        Bahnhof Bahnhof3 = new Bahnhof("Nordbahnhof", 25);
        Straße Lessingstraße = new Straße("Lessingstraße", "Gelb", 26, 260, 22);
        Straße Schillerstraße = new Straße("Schillerstraße","Gelb", 27, 260, 22);
        Straße Wasserwerk = new Straße("Wasserwerk", "Werk", 28, 150, 0);
        Straße Goethestraße = new Straße("Goethestraße", "Gelb", 29, 280, 24);
        Ereignisfeld Polizei = new Ereignisfeld( 30);
        Straße Rathausplatz = new Straße("Rathausplatz", "Grün", 31, 300, 26);
        Straße Hauptstraße = new Straße("Hauptstraße", "Grün", 32, 300, 26);
        Ereignisfeld Gemeinschaftfeld3 = new Ereignisfeld(33);
        Straße Bahnhofsstraße = new Straße("Bahnhofstraße", "Grün", 34, 320, 28);
        Bahnhof Bahnhof4 = new Bahnhof("Hauptbahnhof", 35);
        Ereignisfeld Ereignisfeld3 = new Ereignisfeld( 36);
        Straße Parkstraße = new Straße("Parkstraße", "Dunkelblau", 37, 350, 35);
        Ereignisfeld Zusatzsteuer = new Ereignisfeld( 38);
        Straße Schlossallee = new Straße("Schlossallee", "Dunkelblau", 39, 400, 50);
        Ereignisfeld Gefängnis = new Ereignisfeld( 40);
        felderListe[0] = Los;
        felderListe[1] = Badstraße;
        felderListe[2] = Gemeinschaftsfeld1;
        felderListe[3] = Turmstraße;
        felderListe[4] = Einkommenssteuer;
        felderListe[5] = Bahnhof1;
        felderListe[6] = Chausseestraße;
        felderListe[7] = Ereignisfeld1;
        felderListe[8] = Elisenstraße;
        felderListe[9] = Poststraße;
        felderListe[10] = Zu_Besuch;
        felderListe[11] = Seestraße;
        felderListe[12] = Elektrizitaetswerk;
        felderListe[13] = Hafenstraße;
        felderListe[14] = Neue_Straße;
        felderListe[15] = Bahnhof2;
        felderListe[16] = Muenchner_Straße;
        felderListe[17] = Gemeinschaftsfeld2;
        felderListe[18] = Wiener_Straße;
        felderListe[19] = Berliner_Straße;
        felderListe[20] = Frei_Parken;
        felderListe[21] = Theaterstraße;
        felderListe[22] = Ereignisfeld2;
        felderListe[23] = Museumstraße;
        felderListe[24] = Opernplatz;
        felderListe[25] = Bahnhof3;
        felderListe[26] = Lessingstraße;
        felderListe[27] = Schillerstraße;
        felderListe[28] = Wasserwerk;
        felderListe[29] = Goethestraße;
        felderListe[30] = Polizei;
        felderListe[31] = Rathausplatz;
        felderListe[32] = Hauptstraße;
        felderListe[33] = Gemeinschaftfeld3;
        felderListe[34] = Bahnhofsstraße;
        felderListe[35] = Bahnhof4;
        felderListe[36] = Ereignisfeld3;
        felderListe[37] = Parkstraße;
        felderListe[38] = Zusatzsteuer;
        felderListe[39] = Schlossallee;
        felderListe[40] = Gefängnis;
    }
}
