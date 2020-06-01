/**
 * P1_LE07
 * Entwickelt und getestet mit JDK 13.
 * Diese Klasse verbessert einen Tippfehler in einem String durch 
 * Konvertierung in ein char-Array und Ersetzen des fehlerhaften Zeichen-Elements. 
 *
 * @author Johannes Rave, Medieninformatik
 * @version 1.1 1.6.2020
 */

public class StringChange {
    public static void main(String[] args) {
        String s = "Hello Welt!";
        System.out.println("\nUrsprünglicher String: '"+s+"'");
        // char[] ca = new char[s.length()]; Redundant, kann auch direkt mit s initialisiert werden.
        
        char[] ca = s.toCharArray();

        System.out.println("Ersetze das zweite Zeichen durch ein 'a':");
        ca[1] = 'a';
        
        for (char c : ca){
            System.out.printf("%c", c);
        }
        System.out.println(" (Print mit for-Schleife)");
        
        String s2 = new String(ca);
        System.out.printf("%s", s2);
        System.out.println(" (Print als String)");
    }
}
