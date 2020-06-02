import java.io.*;

/** Klasse zum Einlesen von Konsoleneingaben<br>
 * @author Harald Loose (loose@fh-brandenburg.de)
 * @version 1.00, 16.11.2003
 */
public class Console_dup {

  /* Der Aufbau eines gepufferten Eingabestroms ermöglicht das spätere Einlesen
   *  einer Zeile, die dann durch gegeignete Parser ausgewertet werden kann.
   */
  /** Referenz eines gepufferten Eingabestroms
   */
  private static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

  /** Liest einen String ein.
   *  @return Wert vom Typ <tt>String</tt>, eingelesen von der Tastatur
   */
  public static String inpString() {
    while (true) {
      try {
        return br.readLine();
      }
      catch (Exception e) {
        System.err.println("Eingabefehler");
      }
    }
  }

  /** Liest eine ganze Zahl ein.
   *  @return Wert vom Typ <tt>int</tt>, eingelesen von der Tastatur
   */
  public static int inpInt() {
    while (true) {
      try {
        return Integer.parseInt(br.readLine());
      }
      catch (Exception e) {
        System.err.println("Eingabefehler");
      }
    }
  }

  /** Liest eine Fließkommazahl ein.
   *  @return Wert vom Typ <tt>float</tt>, eingelesen von der Tastatur
   */
  public static float inpFloat() {
    while (true) {
      try {
        return Float.parseFloat(br.readLine());
      }
      catch (NumberFormatException nfe) {
         System.err.println();
         System.err.println("Eingabefehler");
         System.err.println("Eine Fliesskommazahl bitte mit Punkt als Dezimaltrenner eingeben.");
         System.err.println();
      }
      catch (Exception e) {
        System.err.println("Eingabefehler");
      }
    }
  }

  /** Liest eine doppeltgenaue Fließkommazahl ein.
   *  @return Wert vom Typ <tt>double</tt>, eingelesen von der Tastatur
   */
  public static double inpDouble() {
    String x;
    while ( true ) {
      try {
        x = br.readLine();
        return Double.parseDouble(x);
      }
      catch (NumberFormatException nfe) {
         System.err.println();
         System.err.println("Eingabefehler");
         System.err.println("Eine Fliesskommazahl bitte mit Punkt als Dezimaltrenner eingeben.");
         System.err.println();
      }
      catch (Exception e) {
        System.err.println("Eingabefehler");
      }
    }
  }

  /** Liest ein Zeichen ein.
   *  @return Wert vom Typ <tt>char</tt>, eingelesen von der Tastatur
   */
  public static char inpChar() {
    String buffer;
    while (true) {
      try {
        buffer = br.readLine();
        return buffer.charAt(0);
      }
      catch (Exception e) {
        System.err.println("Eingabefehler");
      }
    }
  }

  /** Liest einen logischen Wert ein.
   *  @return Wert vom Typ <tt>boolean</tt>, eingelesen von der Tastatur
   */
  public static boolean inpBoolean() {
    String buffer;
    while (true) {
      try {
        buffer = br.readLine();
        return Boolean.valueOf(buffer).booleanValue();
      }
      catch (Exception e) {
        System.err.println("Eingabefehler");
      }
    }
  }

  /** Testet und zeigt die Verwendung der Methoden */
  public static void main (String args []) {
	System.out.println("Geben Sie eine Zeichenkette ein: ");
	System.out.println("Sie haben " + inpString() + " eingegeben.");
	System.out.println("Geben Sie ein Zeichen ein: ");
	System.out.println("Sie haben " + inpChar() + " eingegeben.");
	System.out.println("Geben Sie eine ganze Zahl ein: ");
	System.out.println("Sie haben " + inpInt() + " eingegeben.");
	System.out.println("Geben Sie eine float-Zahl ein: ");
	System.out.println("Sie haben " + inpFloat() + " eingegeben.");
	System.out.println("Geben Sie eine double-Zahl ein: ");
	System.out.println("Sie haben " + inpDouble() + " eingegeben.");
	System.out.println("Geben Sie einen logischen Wert ein: ");
	System.out.println("Sie haben " + inpBoolean() + " eingegeben.");
  }
}