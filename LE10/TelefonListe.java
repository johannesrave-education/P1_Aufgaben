/**
 * P1_LE09
 * Entwickelt und getestet mit JDK 13.
 * Diese Klasse enthält Methoden, um ein Telefonbuch zu verwalten.
 * Durch die vielen System.out-Beschreibungen werden alle Funktionen erklärt.
 *
 * @author Johannes Rave, Medieninformatik
 * @version 1.0 2.6.2020
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.TreeSet;

public class TelefonListe {
    private static ArrayList<String> liste = new ArrayList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        //setEncoding("Cp850");
        liste.add("MickeyMouse 25268443484");
        liste.add("Donatello 51513151512");
        liste.add("Goofy 44684646468");
        
        // Hauptmenü
        mainloop:while (true) {
            System.out.println("*** Willkommen zum virtuellen Telefonbuch!");
            System.out.println("Bitte waehlen Sie eine Funktion mit den Zahlen 1 bis 6.");
            System.out.println("\n 1 - Telefonbuch anzeigen." +
                               "\n 2 - Eintrag hinzufuegen." +
                               "\n 3 - Eintrag loeschen." +
                               "\n 4 - Telefonbuch importieren." +
                               "\n 5 - Telefonbuch exportieren." +
                               "\n 6 - Programm beenden.");

            int auswahl = 0;
            String eingabe = in(); //Keyboardeingabe
            try{
                auswahl = Integer.parseInt(eingabe);
                if (auswahl<0 || auswahl>6) throw new NumberFormatException ();
                System.out.println("*** Sie haben Funktion " + auswahl + " gewaehlt.");
            } catch(NumberFormatException e) {
                System.out.println("Bitte eine Nummer von 1 bis 6 eingeben und mit Enter bestaetigen.");    
            }
            System.out.println();
            
            // Methodenauswahl per switch-statement
            switch (auswahl) {
                case 1:
                    anzeigen();
                    break;
                case 2:
                    eintragen();
                    break;
                case 3:
                    verwerfen();
                    break;
                case 4:
                    ladeListe();
                    break;
                case 5:
                    speichereListe();
                    break;
                case 6:
                    System.out.println("Das Programm wird beendet. Auf Wiederhoeren!");
                    in(false);
                    break mainloop;
                default:
                    System.out.println();
                    break;
            }   
        }
    }

    // Methoden fuer Menue-Optionen:
    private static void anzeigen () {
        DecimalFormat df = new DecimalFormat("0000");
        System.out.println("*** Ihr Telefonbuch:");
        for (int i = 0; i<liste.size(); i++) {
            System.out.println(df.format(i+1) +" "+ liste.get(i));
        }
        System.out.println();
    }
    
    private static void eintragen () {
        System.out.println("*** Eintrag hinzufuegen.");
        System.out.println("Bitte geben Sie den NAMEN fuer den Eintrag ein.");
        String name = in();
        System.out.println("Bitte geben Sie die NUMMER fuer den Eintrag ein.");
        String nummer = in();
        liste.add(name + " " + nummer);
        System.out.println();
    }

    private static void verwerfen() {
        System.out.println("*** Eintrag loeschen.");
        System.out.println("Waehlen Sie einen Eintrag durch Eingabe seiner Nummer.");
        anzeigen();
        int eintrag = Integer.parseInt(in())-1;
        System.out.println("Moechten Sie diesen Eintrag wirklich loeschen? J/N");
        System.out.println(liste.get(eintrag));
        switch(in()){
            case "j":
                liste.remove(eintrag);
                System.out.println("Eintrag wurde geloescht.");
                break;
            default:
                System.out.println("Eintrag wurde nicht geloescht.");
                break;
        }
        System.out.println();
    }

    private static void ladeListe() {
        System.out.println("*** Telefonbuch importieren.");
        try (BufferedReader telefonbuch = new BufferedReader(new FileReader("telefonbuch"))){
            int lineCount = 0;
            String line;
            while ((line = telefonbuch.readLine()) != null){
                liste.add(line);
                lineCount++;
            }
            sortiere();
            System.out.println("Telefonbuch wurde aus Datei importiert und sortiert.");            
        } catch (IOException e) {
            System.out.println("An IO error occurred.");
            e.printStackTrace();
        }
        System.out.println();
    }
    
    private static void speichereListe() {
        System.out.println("*** Telefonbuch exportieren.");
        try (BufferedWriter datei = new BufferedWriter(new FileWriter("telefonbuch"))){
            for (String eintrag:liste){
                datei.write(eintrag+"\n");
            }
        System.out.println("Telefonbuch in Datei exportiert.");
        } catch (IOException e) {
            System.out.println("Ausgabefehler aufgetreten.");
            e.printStackTrace();
            return;
        }
        System.out.println();
    }
    
    // Hilfsmethoden:
    // Sortieren und Duplikate loeschen.
    private static void sortiere(){
        TreeSet<String> hs = new TreeSet<>();
        hs.addAll(liste);
        liste = new ArrayList<>(hs);
    }

    // Methode zur Keyboardeingabe
    private static String in () {
        try {
            String line = br.readLine();
            return line;
        } catch (IOException e) {
            System.err.println("Eingabe fehlerhaft. Bitte das Programm erneut starten.");
            e.printStackTrace();
            return "Keine Eingabe.";
        }
    }
    // Methode zum Schließen des Datenstroms von System.in
    private static void in (boolean close) {
        try {
            br.close();
        } catch (IOException e) {
            System.err.println("Fehler beim Schließen des Input-Streams!");
            e.printStackTrace();
        }
    }
    
    // Methode zum Umstellen des Stream-Encodings, so dass auf Windows CMD
    // auch Umlaute dargestellt werden. Das hat bei mir leider trotz langem Testen 
    // nicht funktioniert. In Eclipse oder IntelliJ werden die Umlaute auf der Konsole 
    // dargestellt. Da ich nicht wusste, wie diese Datei dann verwandt wird habe ich 
    // zur Sicherheit auf "ae","oe" und "ue" umgestellt.  
        
    private static void setEncoding(String encoding){
        String os = System.getProperty("os.name");
        if (os.contains("Windows")){
            try {
                PrintStream ps = new PrintStream(System.out, true, encoding);
                System.setOut(ps);
                System.out.println("Encoding wurde umgestellt, in der Hoffnung\n" +
                                   "dass Windows CMD nun Umlaute darstellt.");
                
                ps.print("Hier ein direkter Print vom OUT-STREAM  oeaeue");
            } catch (UnsupportedEncodingException e){
                System.out.println("Encoding konnte nicht umgestellt werden.\n" +
                                   "Umlaute werden u.U. falsch dargestellt.");
            }
        }
    }
}

