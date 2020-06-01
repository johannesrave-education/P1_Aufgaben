/**
 * P1_LE07
 * Entwickelt und getestet mit JDK 13.
 * Diese Klasse enthält Methoden zur Konvertierung von Ganzzahlen bzw. Ziffern in Strings und umgekehrt.
 *
 * @author Johannes Rave, Medieninformatik
 * @version 1.1 27.5.2020
 */

public class Converter {
    public static void main(String[] args) {

        System.out.println("int nach String und retour:");
        intToString(30);
        stringToInt("56");
        System.out.println();


        System.out.println("int nach ASCII, Methode 1:");
        toAscii(7);
        toAscii(-2);
        toAscii(300);
        System.out.println();

        System.out.println("int nach ASCII, Methode 2:");
        toAscii2(7);
        toAscii2(-2);
        toAscii2(300);
        System.out.println();

        System.out.println("int nach ASCII, Methode 3:");
        toAscii3(7);
        toAscii3(-2);
        toAscii3(300);
        System.out.println();

        System.out.println("ASCII nach int, Methode 1:");
        fromAscii(56);
        System.out.println();

        System.out.println("ASCII nach int, Methode 2:");
        fromAscii2(56);
        System.out.println();

    }

    public static String intToString(int i){
        System.out.println("int "+i+" in String gewandelt.");
        return Integer.toString(i);
    }

    public static int stringToInt(String s){
        System.out.println("String \""+s+"\" geparst und in int gewandelt.");
        return Integer.parseInt(s);
    }

    /**
     * Diese Methode konvertiert eine Zahl mit Hilfe eines numerischen
     * Offsets in einen String des entsprechenden ASCII-Codes.
     * @param i Zu konvertierende Zahl
     * @return
     */
    public static int toAscii(int i){
        if (i>=0 && i<=9) {
            int s = i + 48;
            System.out.println("Für die Ziffer "+i+" steht der ASCII-Code "+s+".");
            return s;
        } else {
            System.out.println("Bitte geben Sie eine Ziffer zwischen 0 und 9 ein.");
            return -1;
        }
    }

    /**
     * Diese Methode konvertiert eine Zahl in einen String des entsprechenden ASCII-Codes.
     * Dazu wird die Zahl in einen String umgewandelt, und dann zurück in einen char (Zeichen).
     * So kann ohne Addieren eines Offsets auf den Zeichencode zugegriffen werden.
     * @param i Zu konvertierende Zahl
     * @return
     */
    public static int toAscii2(int i){
        if (i>=0 && i<=9) {
            int a = Integer.toString(i).charAt(0);
            System.out.println("Für die Ziffer "+i+" steht der ASCII-Code "+a+".");
            return a;
        } else {
            System.out.println("Bitte geben Sie eine Ziffer zwischen 0 und 9 ein.");
            return -1;
        }
    }

    /**
     * Diese Methode konvertiert eine Zahl in einen String des entsprechenden ASCII-Codes.
     * Dazu nutzt sie die native Funktion "codePointAt" der String-Klasse, und die Tatsache,
     * dass Unicode und ASCII kompatibel sind.
     * @param i Zu konvertierende Zahl
     * @return
     */
    public static int toAscii3(int i){
        if (i>=0 && i<=9) {
            int a = Integer.toString(i).codePointAt(0);
            System.out.println("Für die Ziffer "+i+" steht der ASCII-Code "+a+".");
            return a;
        } else {
            System.out.println("Bitte geben Sie eine Ziffer zwischen 0 und 9 ein.");
            return -1;
        }
    }

    public static int fromAscii(int i){
        int n = i - 48;
        if (n >=0 && n <=9) {
            System.out.println("Der ASCII-Code "+i+" entspricht der Ziffer "+ n +".");
            return n;
        } else {
            System.out.println("Der ASCII-Code "+i+" entspricht keiner Ziffer. -1 zurückgegeben.");
            return -1;
        }
    }

    public static int fromAscii2(int i){
        char c = (char) i;
        if (0<=Character.getNumericValue(c) && Character.getNumericValue(c)<=9) {
            System.out.println("Der ASCII-Code "+i+" entspricht der Ziffer "+c+".");
            return c;
        } else {
            System.out.println("Der ASCII-Code "+i+" entspricht keiner Ziffer. -1 zurückgegeben.");
            return -1;
        }
    }
}
