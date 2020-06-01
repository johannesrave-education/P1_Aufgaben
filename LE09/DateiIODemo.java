import java.io.*;

/** Klasse zum Zeigen von byteweisen Dateien-I/O<br>
 * @author Harald Loose (loose@fh-brandenburg.de)
 * @version 1.00, 16.11.2003
 */
public class DateiIODemo {
  /** Gibt beliebige bin�re Daten in die Datei aaaa aus.
   */
  public static void TestOutput () {
    DataOutputStream out = null;
    try {
      // �ffnen des OutputStreams
      out = new DataOutputStream (new FileOutputStream ("aaab"));
      // Typ bezogene Ausgabe
      out.writeBoolean (true);
      out.writeByte    (6);
      out.writeChar    ('s');
      out.writeDouble  (-1.0);
      out.writeFloat   (-1.0f);
      out.writeInt     (1000000);
      out.writeLong    (1000000000000l);
      out.writeShort   (1000);
      out.writeBytes   ("writeBytes");
      out.close();
    }
    catch (IOException e) {
      System.out.println (e);
    }
    finally {
	}
  }

  /** Liest beliebige bin�re Daten aus der Datei aaaa ein.
   */
  public static void TestInput () {
    DataInputStream in = null;
    try {
      // �ffnen des InputStreams
      in = new DataInputStream (new FileInputStream ("aaab"));
      // Typ bezogene Eingabe
      System.out.println (in.readBoolean());
      System.out.println (in.readByte());
      System.out.println (in.readChar());
      System.out.println (in.readDouble());
      System.out.println (in.readFloat());
      System.out.println (in.readInt());
      System.out.println (in.readLong());
      System.out.println (in.readShort());
      byte [] Bytes = new byte [100];
      int ibytes = in.read (Bytes, 0, Bytes.length - 1);
      System.out.println (ibytes+">" + new String (Bytes, 0, ibytes) + "<");
	  in.close();
    }
    catch (IOException e) {
      System.out.println (e);
    }
    finally {
	}
  }

  /** Testet und zeigt die Verwendung der Methoden */
  public static void main (String args []) {
    DateiIODemo iodemo = new DateiIODemo ();
    System.out.println ("Bin�res Schreiben und Lesen");
//    iodemo.TestOutput ();
    iodemo.TestInput ();
  }
}
