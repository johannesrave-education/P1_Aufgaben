/**
 * P1_LE03
 * @author Johannes Rave, Medieninformatik
 * @version 1.1 20.4.2020
 */

public class TypeConstants {
    public static void main(String[] args) {
        // Array mit den relevanten Konstanten der Datentypen
        Object[][] typeArray = {
                {"byte", Byte.BYTES, Byte.MIN_VALUE, Byte.MAX_VALUE},
                {"char", Character.BYTES, Character.MIN_VALUE, Character.MAX_VALUE},
                {"short", Short.BYTES, Short.MIN_VALUE, Short.MAX_VALUE},
                {"int", Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE},
                {"long", Long.BYTES, Long.MIN_VALUE, Long.MAX_VALUE},
                {"float", Float.BYTES, Float.MIN_VALUE, Float.MAX_VALUE},
                {"double", Double.BYTES, Double.MIN_VALUE, Double.MAX_VALUE}
        };

        // int 00000000 00000000 00000000 00000000 = 0
        // int 00000000 00000000 00000000 00000001 = 1
        // int 10000000 00000000 00000000 00000000 = 0


        // Beginn der Ausgabe
        System.out.println("Printing relevant datatype constants:");

        for (int i = 0; i < typeArray.length; i++) {

            String t = typeArray[i][0].toString();
            String b = typeArray[i][1].toString();
            String min = typeArray[i][2].toString();
            String max = typeArray[i][3].toString();
            System.out.println("***");
            System.out.println("For the datatype " + t +
                    ", the bytelength is " + b +
                    ", the minimum value is " + min +
                    " and the maximum value is " + max + ".");

            System.out.printf("Using printf(): For the datatype %s, " +
                            "the bytelength is %s, " +
                            "the minimum value is %s " +
                            "and the maximum value is %s.%n%n",
                            typeArray[i][0], typeArray[i][1], typeArray[i][2], typeArray[i][3]);
        }

        System.out.println("***");
        // Ausgeben der Hex-bits für positive und negative ints:
        System.out.println("Printing hex-bit representation of 1, -1, 1.0f and -1.0f:");
        System.out.println("Hex-bits for  1: 0x" + Integer.toHexString(1));
        System.out.println("Hex-bits for -1: 0x" + Integer.toHexString(-1).toUpperCase()); // Ausgabe ohne Vorzeichen (two complement)
        System.out.println("Signed string for hexadecimal -1: " + Integer.toString(-1, 16)); // Ausgabe mit Vorzeichen
        System.out.println();
        System.out.printf("Hex-bits for  1 using a formatted string: 0x%08X%n", 1);
        System.out.printf("Hex-bits for -1 using a formatted string: 0x%08X%n", -1);
        System.out.println();
        System.out.println("Parsing hex-string for  1 to int: " + Integer.parseInt("1", 16));
        // mit parseInt() kommt es auf Grund des Vorzeichen-bits bei negativen Ints zum Overflow, daher workaround mit parseUnsignedInt()
        System.out.println("Parsing hex-string for -1 to int via unsigned int: " + Integer.parseUnsignedInt("FFFFFFFF", 16));
        // Alternative als Datentyp mit mehr bits geparst, dann zur int gecastet
        System.out.println("Parsing hex-string for -1 to int via long: " + (int) Long.parseLong("FFFFFFFF", 16));
        System.out.println();

        System.out.println("***");
        // Ausgeben der Hex-bits für positive und negative floats:
        String hexFloat = Integer.toHexString(Float.floatToIntBits(1.0f));
        String hexFloatNeg = Integer.toHexString(Float.floatToIntBits(-1.0f));

        System.out.println("Hex-bits for  1.0f: 0x" + hexFloat);
        System.out.println("Hex-bits for -1.0f: 0x" + hexFloatNeg);

        System.out.println("Parsing hex-string for  1.0f to float: " + Float.intBitsToFloat(Integer.parseInt(hexFloat, 16)));
        System.out.println("Parsing hex-string for -1.0f to float: " + Float.intBitsToFloat(Integer.parseUnsignedInt(hexFloatNeg, 16)));

        System.out.println("***");
        // Umwandeln verschiedener Datentypen ineinander
        System.out.println("Casting datatypes");
        // char to int, int to long, long in short, int in float, long in double, double in long, char in float, float in double

        char c = 'ß';
        int i = Integer.MAX_VALUE;
        long l = Long.MAX_VALUE;
        double d = Double.MAX_VALUE;
        float f = Float.MAX_VALUE;

        int charToInt = c; // Unicode Zeichencode
        System.out.println("char " + c + " to int " + charToInt);

        long intToLong = i; // Kein Problem, da long auch Ganzzahlen sind und mehr Speicher als int beanspruchen
        System.out.println("int " + i + " to long " + intToLong);

        short longToShort = (short) l; // Verkürzende Umwandlung, expliziter cast ist notwendig, buffer overflow
        System.out.println("long " + l + " to short " + longToShort);

        float intToFloat = i; // Klappt so rum, Float.MAX_VALUE nach int wäre ein Problem
        System.out.println("int " + i + " to float " + intToFloat);

        double longToDouble = l; // Darstellung mit Exponent statt ausgeschrieben
        System.out.println("long " + l + " to double " + longToDouble);

        long doubleToLong = (long) d; // Verkürzende Umwandlung, expliziter cast ist notwendig
        System.out.println("double " + d + " to long " + doubleToLong);

        float charToFloat = c; // Unicode Zeichencode mit Kommastelle, evtl sinnlos
        System.out.println("char " + c + " to float " + charToFloat);

        double floatToDouble = f; // Kein Problem, da double auch Kommazahlen sind und mehr Speicher als float haben
        System.out.println("float " + f + " to double " + floatToDouble);


    }
}