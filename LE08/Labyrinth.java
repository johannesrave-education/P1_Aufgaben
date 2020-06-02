/**
 * P1_LE08
 * Entwickelt und getestet mit JDK 13.
 * Diese Klasse enthält Methoden, um die beiliegenden Text-Dateien einzulesen, 
 * daraus eine Spielbrett zu bauen (implementiert als char-Array),
 * auf dem Spielbrett von einem beliebigen freien Feld aus einen Ausweg aus dem Labyrinth zu finden und
 * das Labyrinth mit dem eingezeichneten Fluchtweg farbig auf der Konsole zu drucken.
 *
 * @author Johannes Rave, Medieninformatik
 * @version 1.1 1.6.2020
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labyrinth {

    public static String[] liesKarte(String fileName){
        try {
            BufferedReader levelFile =
                    new BufferedReader(
                    new FileReader(fileName));
            int lineCount = 0;
            while (levelFile.readLine() != null){
                lineCount++;
            }
            levelFile.close();
            
            String[] labArray = new String[lineCount];
            levelFile =
                    new BufferedReader(
                    new FileReader(fileName));
            for (int i = 0; i < lineCount; i++){
                labArray[i] = levelFile.readLine();
                //System.out.println(labArray[i]);
            }
            levelFile.close();
            return labArray;
            
        } catch (IOException e) {
            System.out.println("An IO error occurred.");
            e.printStackTrace();
        }
        return new String[0];
    }

    public static char[][] baueKarte(String labString, int rows){
        int columns = (labString.length()/rows);
        char[][] karte = new char[rows][columns];

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                karte[r][c] = labString.charAt(r*rows + c);
            }
        }
        return karte;
    }

    public static char[][] baueKarte(String[] labArray){
        int rows = labArray.length;
        int columns = labArray[0].length();
        char[][] karte = new char[rows][columns];

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                karte[r][c] = labArray[r].charAt(c);
            }
        }
        return karte;
    }
    

    public static boolean aufDerSuche = false;

    public static void  findeWeg(char[][] karte, int x, int y){
        aufDerSuche = true;
        findeAlgo(karte, x , y);
    }

    public static void findeAlgo(char[][] karte, int x, int y){

        karte[x][y] = '*';

        if (x > (karte.length-2) || x < 1 || y > (karte[0].length-2) || y < 1){
            druckeKarte(karte);
            aufDerSuche = false;
            return;
        }
        int[][] nesw = {{x-1,y},{x,y+1},{x+1,y},{x,y-1}};
        for (int[] dir : nesw){
            if(aufDerSuche && karte[dir[0]][dir[1]] != 'X' && karte[dir[0]][dir[1]] != '*') {
                System.out.println("Gehe nach " + dir[0] + "/" + dir[1]);
                findeAlgo(karte, dir[0], dir[1]);
            }
        }
    }

    public static void druckeKarte(char[][] karte){
        
        // Farbige Konsolendarstellung, funktioniert evtl nicht mit Windows-CMD
        String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        String RESET = "\033[0m";  // Text Reset
        
        int rows = karte.length;
        int columns = karte[0].length;

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                if (karte[r][c] == '*')
                    System.out.printf("["+GREEN_BOLD_BRIGHT+ karte[r][c]+RESET+"]");
                else
                    System.out.printf("["+ karte[r][c]+"]");
            }
            System.out.println();
        }
    }

    public static char[][] labArray2(String labString){
        String[] rows = labString.split("\n");
        char[][] lab = new char[rows.length][rows[0].length()];
        for (String row: rows){
            row.toCharArray();
        }
        return lab;
    }

    public static void main (String[] args){
        char[][] labyrinth;

        System.out.print("\n\n*** Labyrinth A\n\n");
        labyrinth = baueKarte(liesKarte("LE08\\labA.txt"));
        System.out.println();
        findeWeg(labyrinth, 4, 4);

        System.out.print("\n\n*** Labyrinth B\n");
        labyrinth = baueKarte(liesKarte("LE08\\labB.txt"));
        System.out.println();
        findeWeg(labyrinth, 4, 4);

        System.out.print("\n\n*** Labyrinth C\n");
        labyrinth = baueKarte(liesKarte("LE08\\labC.txt"));
        System.out.println();
        findeWeg(labyrinth, 4, 6);
       // druckeKarte(labyrinth);
    }
}
