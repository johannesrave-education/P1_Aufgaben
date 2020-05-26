public class Labyrinth {
    static String labA =
            "XXXXXXXXXX" +
            "XXXXXXXXXX" +
            "XXXXXXXXXX" +
            "XXXXXXXXXX" +
            "XXXX   XXX" +
            "XXXX   XXX" +
            "XXXXXX XXX" +
            "XXXXXX XXX" +
            "XXXXXX    " +
            "XXXXXXXXXX";

    static String labB =
            "XXXXXX XXX" +
            "XXXXX  XXX" +
            "XXXXX XXXX" +
            "XXXXX XXXX" +
            "XX  *  XXX" +
            "XX X   XXX" +
            "X  XXX XXX" +
            "XXXXXX XXX" +
            "XXXXXX   X" +
            "XXXXXXXXXX";

    public static void main (String[] args){

        System.out.println("Länge des Strings: " + labA.length());

        printLab(labArray(labB, 10));
        findeWeg(labArray(labB, 10),4,4);

    }


    public static void findeWeg(char[][] lab, int x, int y){

        lab[x][y] = '*';

        if (x > (lab.length-2) || x < 1 || y > (lab[0].length-2) || y < 1){
            printLab(lab);
            return;
        }

        int[][] nesw = {{x-1,y},{x,y+1},{x+1,y},{x,y-1}};
        for (int[] dir : nesw){
            if(lab[dir[0]][dir[1]] != 'X' && lab[dir[0]][dir[1]] != '*') {
                System.out.println("Going to " + dir[0] + "/" + dir[1]);
                findeWeg(lab, dir[0], dir[1]);
            }
        }
    }


    public static char[][] labArray(String labString, int rows){
        int columns = (labString.length()/rows);
        char[][] lab = new char[rows][columns];

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                lab[r][c] = labString.charAt(r*rows + c);
                //System.out.printf("["+lab[r][c]+"]");
            }
            //System.out.println();
        }
        return lab;
    }

    public static void printLab(char[][] lab){
        int rows = lab.length;
        int columns = lab[0].length;

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                if (lab[r][c] == '*')
                    System.out.printf("["+GREEN_BOLD_BRIGHT+lab[r][c]+RESET+"]");
                else
                    System.out.printf("["+lab[r][c]+"]");
            }
            System.out.println();
        }
    }

    public static char[][] labArray2(String labString){
        String[] rows = labA.split("\n");
        char[][] lab = new char[rows.length][rows[0].length()];
        for (String row: rows){
            row.toCharArray();
        }

        return lab;
    }


    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}
