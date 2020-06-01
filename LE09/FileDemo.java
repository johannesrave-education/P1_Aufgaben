import java.io.*;
import java.text.*;

/** Klasse zum Zeigen der Anwendung der Klasse File<br>
 * @author Harald Loose (loose@fh-brandenburg.de)
 * @version 1.00, 16.11.2003
 */
public class FileDemo {
  public static void main (String args[]) {

    // Anlegen eines Files = Verzeichnis
    File f = new File (args[0]);
    // Ermitteln der Dateien in diesem Verzeichnis
    String filenames[] = f.list ();

    if (filenames != null) {
      // Festlegen eines dezimalen Bildformats
      DecimalFormat dformat = new DecimalFormat ("0000");
      for (int i = 0; i < filenames.length; i++)
//        System.out.println (dformat.format(i)+" " + filenames[i]);
        System.out.printf ("\n%04d  %s",i,filenames[i]);
    }
  }
}
