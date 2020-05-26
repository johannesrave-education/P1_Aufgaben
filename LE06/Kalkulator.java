/**
 * P1_LE06
 * Diese Klasse enthält außer main() noch die Methoden kalkuliere(), kalkuliere2() und kalkuliere3().
 * kalkuliere() nutzt Scanner um die Benutzereingabe zu parsen.
 * kalkuliere2() nutzt Scanner mit einer Regex um die Benutzereingabe auch ohne Delimiter zu parsen.
 * kalkuliere3() nutzt einen BufferedReader mit einer Regex um die Benutzereingabe ohne Scanner zu parsen.
 *
 * @author Johannes Rave, Medieninformatik
 * @version 1.0 12.5.2020
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            kalkuliere();

            System.out.println("Möchten Sie eine weitere Kalkulation vornehmen? (j/n)");
            char eingabe = sc.next().toLowerCase().charAt(0);
            if (eingabe == 'n' ){
                System.out.println("Die Berechnung wird beendet.");
                break;
            } else if (eingabe == 'j'){
                System.out.println("Die Berechnung wird fortgesetzt.");
            }
        }
    }

    static int kalkuliere(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Bitte geben Sie den ersten Operanden ein.");
        int o1 = sc.nextInt();

        System.out.println("Bitte geben Sie nun den Operator ein.");
        String op = sc.next();

        System.out.println("Geben Sie schließlich den zweiten Operanden ein.");
        int o2 = sc.nextInt();

        int r = 0;

        switch(op) {
            case("+"): r = o1 + o2; break;
            case("-"): r = o1 - o2; break;
            case("*"): r = o1 * o2; break;
            case("/"): r = o1 / o2; break;
            default: System.out.println(op + " ist kein gültiger Operator.");
        }

        System.out.println("***   " + o1 + " " + op + " " + o2 + " = " + r);
        if (op.equals("/")){
            System.out.println("Der Rest dieser ganzzahligen Teilung beträgt " + (o1%o2));
        }
        System.out.println();
        System.out.println();

        return r;
    }

    static int kalkuliere2(){
        Scanner sc = new Scanner(System.in);

        Pattern p = Pattern.compile("(\\d+)\\s*([+\\-*/])\\s*(\\d+)");

        System.out.println("Bitte geben Sie die Rechnung in der Form 'operand1 operator operand2' ein.");

        String s = sc.nextLine();
        Matcher m = p.matcher(s);
        m.matches();

        int o1 = Integer.parseInt(m.group(1));
        String op = m.group(2);
        int o2 = Integer.parseInt(m.group(3));

        int r = 0;

        switch(op) {
            case("+"): r = o1 + o2; break;
            case("-"): r = o1 - o2; break;
            case("*"): r = o1 * o2; break;
            case("/"): r = o1 / o2; break;
            default: System.out.println(op + " ist kein gültiger Operator.");
        }

        System.out.println("***   " + o1 + " " + op + " " + o2 + " = " + r);
        if (op.equals("/")){
            System.out.println("Der Rest dieser ganzzahligen Teilung beträgt " + (o1%o2));
        }
        System.out.println();
        System.out.println();

        return r;
    }

    static int kalkuliere3(){

        Pattern p = Pattern.compile("(\\d+)\\s*([+\\-*/])\\s*(\\d+)");

        System.out.println("Bitte geben Sie die Rechnung in der Form 'operand1 operator operand2' ein.");

        String s = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            s = br.readLine();
        } catch(IOException ioe) {

        }

        Matcher m = p.matcher(s);
        m.matches();

        int o1 = Integer.parseInt(m.group(1));
        String op = m.group(2);
        int o2 = Integer.parseInt(m.group(3));

        int r = 0;

        switch(op) {
            case("+"): r = o1 + o2; break;
            case("-"): r = o1 - o2; break;
            case("*"): r = o1 * o2; break;
            case("/"): r = o1 / o2; break;
            default: System.out.println(op + " ist kein gültiger Operator.");
        }

        System.out.println("***   " + o1 + " " + op + " " + o2 + " = " + r);
        if (op.equals("/")){
            System.out.println("Der Rest dieser ganzzahligen Teilung beträgt " + (o1%o2));
        }
        System.out.println();
        System.out.println();

        return r;
    }
}
