import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.TreeSet;

public class TelefonListe {
    private static ArrayList<String> liste = new ArrayList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        liste.add("MickeyMouse 25268443484");
        liste.add("Donatello 51513151512");
        liste.add("Goofy 44684646468");

        mainloop:while (true) {
            System.out.println("*** Willkommen zum virtuellen Telefonbuch!");
            System.out.println("Bitte wählen Sie eine Funktion mit den Zahlen 1 bis 6.");
            System.out.println("\n 1 - Telefonbuch anzeigen." +
                               "\n 2 - Eintrag hinzufügen." +
                               "\n 3 - Eintrag löschen." +
                               "\n 4 - Telefonbuch importieren." +
                               "\n 5 - Telefonbuch exportieren." +
                               "\n 6 - Programm beenden.");

            //Keyboardeingabe
            int eingabe = Integer.parseInt(in());
            System.out.println("*** Sie haben Funktion " + eingabe + " gewählt.");
            System.out.println();
            
            //Hauptmenü
            switch (eingabe) {
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
                    System.out.println("Das Programm wird beendet. Auf Wiederhören!");
                    in(false);
                    break mainloop;
                default:
                    System.out.println("Bitte geben Sie eine Zahl von 1 bis 6 ein.");
                    break;
            
            }   
        }
    }

    // Menü-Optionen:
    
    private static void anzeigen () {

        DecimalFormat df = new DecimalFormat("0000");
        System.out.println("*** Ihr Telefonbuch:");
        for (int i = 0; i<liste.size(); i++) {
            System.out.println(df.format(i+1) +" "+ liste.get(i));
        }
        System.out.println();
    }
    
    private static void eintragen () {
        System.out.println("*** Eintrag hinzufügen.");
        System.out.println("Bitte geben Sie den NAMEN für den Eintrag ein.");
        String name = in();
        System.out.println("Bitte geben Sie die NUMMER für den Eintrag ein.");
        String nummer = in();
        liste.add(name + " " + nummer);
        System.out.println();
    }

    private static void verwerfen() {
        System.out.println("*** Eintrag löschen.");
        System.out.println("Wählen Sie einen Eintrag durch Eingabe seiner Nummer.");
        anzeigen();
        int eintrag = Integer.parseInt(in());
        System.out.println("Möchten Sie diesen Eintrag wirklich löschen? J/N");
        System.out.println(liste.get(eintrag-1));
        switch(in()){
            case "j":
                liste.remove(eintrag-1);
                System.out.println("Eintrag wurde gelöscht.");
                break;
            default:
                System.out.println("Eintrag wurde nicht gelöscht.");
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
            System.out.println("An IO error occurred.");
            e.printStackTrace();
        }
        System.out.println();
    }
    
    // Sortieren und Duplikate löschen.
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
    private static void in (boolean close) {
        try {
            br.close();
        } catch (IOException e) {
            System.err.println("Fehler beim Schließen des Input-Streams!");
            e.printStackTrace();
        }
    }
}

