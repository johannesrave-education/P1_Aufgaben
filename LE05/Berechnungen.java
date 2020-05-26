/**
 * P1_LE05
 * @author Johannes Rave, Medieninformatik
 * @version 1.0 2.5.2020
 */

public class Berechnungen {

    final private static double PI = Math.PI;
    private static int tauschVariableA = 5;
    private static int tauschVariableB = 7;

    public static void main(String[] args) {

        int radius = 10;

        if (args.length > 0) {
            radius = Integer.parseInt(args[0]);
            System.out.println("Es wurde ein Radius eingegeben.");
        } else {
            System.out.println("Es wurde kein Radius-Argument eingegeben.");
        }

        System.out.println("Berechnungen erfolgen mit einem Radius von " + radius + " Metern.");

        berechneUmfang(radius);
        berechneFlaeche(radius);

        System.out.println(min((short) 4, (short) 3));

        System.out.println(min(4,3));

        System.out.println(min(3131443543L , 3131443543843L));

        System.out.println(min(.4f, .3f));

        System.out.println(min(.43d, .56d));


        int a = 6;
        int b = 8;

        System.out.println(tauschVariableA + " und " + tauschVariableB + " vor dem Tauschen.");
        System.out.println(a + " und " + b + " vor dem Tauschen.");
        System.out.println();

        tauscheWerte(a,b);

        System.out.println();
        System.out.println(tauschVariableA + " und " + tauschVariableB + " nach dem Tauschen.");
        System.out.println(a + " und " + b + " nach dem Tauschen.");

    }

    public static double berechneUmfang(int radius){
        System.out.println("Der Umfang wurde berechnet und beträgt etwa "+(2*radius* PI)+" Einheiten.");
        return (2*radius* PI);
    }

    public static double berechneFlaeche(int radius){
        System.out.println("Die Fläche wurde berechnet und beträgt etwa "+(Math.pow(radius,2)* PI)+" Quadrateinheiten.");
        return (Math.pow(radius,2)* PI);
    }

    public static short min (short a, short b) {
        System.out.println("Die kleinere short wird zurückgegeben.");

        return a <= b ? a : b;

    }
    
    public static int min (int a, int b) {
        System.out.println("Die kleinere int wird zurückgegeben.");
        if (a <= b) {
            return a;
        } else return b;
    }

    public static long min (long a, long b) {
        System.out.println("Die kleinere long wird zurückgegeben.");
        if (a <= b) {
            return a;
        } else return b;
    }

    public static float min (float a, float b) {
        System.out.println("Die kleinere float wird zurückgegeben.");
        if (a <= b) {
            return a;
        } else return b;
    }

    public static double min (double a, double b) {
        System.out.println("Die kleinere double wird zurückgegeben.");
        if (a <= b) {
            return a;
        } else return b;
    }

    public static void tauscheWerte (int a, int b) {
        System.out.println("Es ist nicht möglich, die beiden Werte in der ursprünglichen Variable zu tauschen.");
        System.out.println("Dies liegt am 'Scope' der Parameter, die nur in dieser Methode existieren.");
        System.out.println("Die Methode hat keinen Zugriff auf die Variablen, die beim Aufruf mitgegeben wurden, nur auf 'Kopien' davon.");
        int tmp = b;
        b = a;
        a = tmp;

        System.out.println("Es ist aber möglich, zwei vorher für mindestens die ganze Klasse sichtbar deklarierte Variablen zu tauschen:");
        tmp = tauschVariableB;
        tauschVariableB = tauschVariableA;
        tauschVariableA = tmp;
        System.out.println("Mit Argumenten/Parametern geht das aber nicht.");

        return;
    }
}
