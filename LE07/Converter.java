/**
 * P1_LE07
 *
 * @author Johannes Rave, Medieninformatik
 * @version 1.0 12.5.2020
 */

public class Converter {
    public static void main(String[] args) {

//        intToString(30);
//        stringToInt("56");
        toAscii(7);
        toAscii2(-2);
        toAscii2(300);
        fromAscii("56");
    }

    public static String intToString(int i){
        System.out.println("int "+i+" in String gewandelt.");
        return Integer.toString(i);
    }

    public static int stringToInt(String s){
        System.out.println("String \""+s+"\" geparst und in int gewandelt.");
        return Integer.parseInt(s);
    }

    public static String toAscii(int i){
        if (i>=0 && i<=9) {
            char c = (char) i;
            String s = Character.toString(c);
            System.out.println("Für die Ziffer "+i+" steht der ASCII-Code "+s+".");
            return s;
        } else {
            System.out.println("Bitte geben Sie eine Ziffer zwischen 0 und 9 ein.");
            return "";
        }
    }

    public static int toAscii2(int i){
        if (i>=0 && i<=9) {
            char temp = Integer.toString(i).toCharArray()[0];
            int a = temp;
            System.out.println("Für die Ziffer "+i+" steht der ASCII-Code "+a+".");
            return a;
        } else {
            System.out.println("Bitte geben Sie eine Ziffer zwischen 0 und 9 ein.");
            return -1;
        }
    }

    //
    public static int fromAscii(String s){
        int i = Integer.parseInt(s) - 48;
        if (i>=0 && i<=9) {
            System.out.println("Der ASCII-Code "+s+" entspricht der Ziffer "+i+".");
            return i;
        } else {
            System.out.println("Der ASCII-Code "+s+" entspricht keiner Ziffer. -1 zurückgegeben.");
            return -1;
        }
    }
}
