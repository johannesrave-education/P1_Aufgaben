import java.io.*;

public class copy {

    public static void main(String[] args) {
        System.out.println("Starte Prozess.");
        kopiereDateiByteweise(args[0], args[1]);
        kopiereDateiZeilenweise(args[0], args[1]);
    }
    
    public static void kopiereDateiZeilenweise(String oFile, String tFile) {
        System.out.println();
        try {
            System.out.println("Öffne Datei " + oFile);
            BufferedReader originalFile =
                    new BufferedReader(
                    new FileReader(oFile));

            System.out.println("Erstelle Datei " + tFile);
            BufferedWriter targetFile =
                    new BufferedWriter(
                    new FileWriter(tFile));

            int lineCount = 0;
            while (originalFile.readLine() != null) {
                lineCount++;
            }
            System.out.println("Datei " + oFile + " hat " + lineCount + " Zeilen.");
            originalFile.close();
            originalFile =
                    new BufferedReader(
                    new FileReader(oFile));

            System.out.println("Kopiere Datei " + oFile + " zeilenweise nach " + tFile + ".");
            for (int i = 0; i < lineCount; i++) {
                targetFile.write(originalFile.readLine());
            }
            originalFile.close();
            targetFile.close();
            System.out.println("*** Vorgang beendet. ***");
            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println("Die Eingabedatei wurde nicht gefunden.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ein Ein- oder Ausgabefehler ist aufgetreten.");
            e.printStackTrace();
        }
    }
    
    public static void kopiereDateiByteweise(String oFile, String tFile){
        System.out.println();
        try {
            System.out.println("Öffne Datei "+oFile);
            BufferedInputStream originalFile =
                    new BufferedInputStream(
                    new FileInputStream(oFile));

            System.out.println("Erstelle Datei "+tFile);
            BufferedOutputStream targetFile =
                    new BufferedOutputStream(
                    new FileOutputStream(tFile));

            long byteCount = originalFile.available();
            System.out.println("Datei "+oFile+" hat "+byteCount+" Bytes.");

            System.out.println("Kopiere Datei "+oFile+" byteweise nach "+tFile+".");
            for (long i = 0; i < byteCount; i++){
                targetFile.write(originalFile.read());
            }
            originalFile.close();
            targetFile.close();
            System.out.println("*** Vorgang beendet. ***");
            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println("Die Eingabedatei wurde nicht gefunden.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ein Ein- oder Ausgabefehler ist aufgetreten.");
            e.printStackTrace();
        }
    }
}
