/**
 * P1_LE04
 * @author Johannes Rave, Medieninformatik
 * @version 1.0 28.4.2020
 */

public class OperatorenTest {
    public static void main(String[] args) {

        double a,b,c,d,x,y,z;

        a = (2d * Math.PI) / 2d;

        x = 3;
        z = Math.pow(x, 2);
        z = Math.pow(x, 5);

        a = 9d;
        b = 3d;
        d = a / b;

        c = 2d;
        d = 5*((a+1)/(b-c)) - d*((3*a+b)/(b-c*a))*((2*a)/(c+3*a));


        powersOf2();
        comparativeOperations();
        bitPatternAnalysis();

    }

    public static void powersOf2(){
        // Multiplikation und Division mit Zweierpotenzen durch bitwise leftshift bzw rightshift Operationen

        // Ganze Zahl (laut Aufgabe), eher hoch um ganzzahlige Division durch 1024 zu ermöglichen.
        int b1 = 100000;
        // Multiplikation mit 2 = 2^1, daher Verschiebung um ein Bit nach links.
        int a1 = b1 << 1;
        // Multiplikation mit 128 = 2^7, daher Verschiebung um sieben Bits nach links.
        int a2 = b1 << 7;
        // Division durch 2 = 2^1, daher Verschiebung um ein Bit nach rechts.
        int a3 = b1 >> 1;
        // Division durch 1024 = 2^10, daher Verschiebung um zehn Bits nach rechts.
        int a4 = b1 >> 10;

        System.out.println("*** Multiplikation und Division mit Zweierpotenzen:");
        System.out.println("Zahl im Dezimalsystem: " + b1);
        System.out.println("Gleiche Zahl als Bitstring: " + Integer.toBinaryString(b1));
        System.out.println("Zahl im Dezimalsystem: " + a1);
        System.out.println("Gleiche Zahl als Bitstring: " + Integer.toBinaryString(a1));
        System.out.println("Zahl im Dezimalsystem: " + a2);
        System.out.println("Gleiche Zahl als Bitstring: " + Integer.toBinaryString(a2));
        System.out.println("Zahl im Dezimalsystem: " + a3);
        System.out.println("Gleiche Zahl als Bitstring: " + Integer.toBinaryString(a3));
        System.out.println("Zahl im Dezimalsystem: " + a4);
        System.out.println("Gleiche Zahl als Bitstring: " + Integer.toBinaryString(a4));
        // Achtung, durch bitwise-Operationenfallen die Nachkommastellen weg! (Äquivalent zu "ganzzahlig geteilt")
        System.out.println();

    }

    public static void comparativeOperations(){
        // Vergleichsoperationen
        int a = 11;
        int b = 17;
        int c = 23;
        int x = 13;
        int y = 7;
        int z = 5;
        int k = 72;

        System.out.println("*** Vergleichsoperationen:");
        System.out.println("(a < b) && (b <= c): " +
                (a < b && b <= c));

        System.out.println("(y != z) && (z < 0): " +
                ((y != z) && (z < 0)));

        System.out.println("(x > y) || ((0 < k) && (k < 100)): " +
                ((x > y) || ((0 < k) && (k < 100))));

        System.out.println();
    }

    public static void bitPatternAnalysis(){

        System.out.println("*** Setzen und Abfragen von Bitmustern:");
        byte status = 0b1;
        System.out.println(String.format("%8s",Integer.toBinaryString(status)).replace(' ', '0'));

        status |= (1 << 3); // Drittes Bit auf 1 setzen
        System.out.println(String.format("%8s",Integer.toBinaryString(status)).replace(' ', '0'));

        status &= ~(1 << 3); // Drittes Bit auf 0 setzen
        System.out.println(String.format("%8s",Integer.toBinaryString(status)).replace(' ', '0'));

        status &= ~(1 << 3); // Drittes Bit auf 0 setzen
        System.out.println(String.format("%8s",Integer.toBinaryString(status)).replace(' ', '0'));

        status &= ~(1 << 7); // Siebtes Bit auf 0 setzen
        System.out.println(String.format("%8s",Integer.toBinaryString(status)).replace(' ', '0'));

/*
        In Java hat ein Numeral, anders als in bspw. Python oder C, keinen Wahrheitswert.
        Ein solcher Test schlägt fehl bzw. wird gar nicht erst kompiliert:

        if(status){
        Do.Something();
        }

        Es ist aber natürlich möglich, ein byte auf mit einem Vergleichsoperator zu prüfen,
        oder auch eine Stelle eines bitpatterns. Die geht für die dritte Stelle zum Beispiel so:
*/
        boolean Wahrheitswert = ((status >> 3) & 1) == 1;
        System.out.println(Wahrheitswert);

        int bit = ((status >> 5) & 1); // Fünftes Bit abfragen/auslesen
        System.out.println(bit);

        System.out.println();
    }
}
