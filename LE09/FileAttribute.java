/**
 * P1_LE09
 * Entwickelt und getestet mit JDK 13.
 * Diese Klasse enthält Methoden, um einen als Argument übergebenen Pfad als
 * Datei oder Verzeichnis zu erkennen und Informationen zu diesem Objekt anzuzeigen. 
 *
 * @author Johannes Rave, Medieninformatik
 * @version 1.0 1.6.2020
 */

import java.io.*;

public class FileAttribute {
    public static void erfasseDatei(String d) {

        File datei = new File(d);
        if (!datei.exists()) {
            System.err.println("Datei oder Pfad nicht gefunden. Abbruch.");
            return;
        }
        if (datei.isFile()) {
            long size = -1;
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(datei))){
                size = bis.available();
            } catch (IOException e){
                System.err.println("Datei kann nicht geöffnet werden.");
            }

            System.out.println();
            System.out.println(datei.getName() + " ist eine Datei im Verzeichnis "+"\\"+datei.getParent()+"\\");
            System.out.println("Größe: "+size+" Bytes");
            System.out.println();
            System.out.println("Lesbar:..........."+datei.canRead());
            System.out.println("Schreibbar:......."+datei.canWrite());
            System.out.println("Ausführbar:......."+datei.canExecute());

            System.out.println("Pfad: "+datei.getAbsolutePath());
            System.out.println();
            
        } else if (datei.isDirectory()) {
            System.out.println(datei.getName() + " ist ein Verzeichnis.");
            System.out.println();
        }
    }
    
    public static void main (String[] args){
        erfasseDatei(args[0]);
    }
}
