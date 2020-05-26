import java.util.*;

public class matchCombinations {

    private static int depth = 6;
    private static double[][] currentGame = new double [2][depth];
    private static List<double[][]> masterList = new ArrayList<double[][]>();
    private static int numberOfGames = 0;
    public static Set<List<Double>> possibleTables = new HashSet<List<Double>>();

    public static void main(String[] args) {

        branchTraverse(depth);

        System.out.println("Printing masterList:");
        for (double[][] game: masterList) {
            for (int i = 0; i < game[0].length; i++) {
                System.out.println(game[0][i] + ":" + game[1][i] + " | ");
            }
        }
        System.out.println();

        System.out.println("Printing unique tables:");
        calculateTable(masterList);
        for (Object table : possibleTables) {
            System.out.println(table);
        }

        System.out.println("Total number of games: " + numberOfGames);
        System.out.println();
    }

    public static void branchTraverse(int depth){

        for (double i = 0d; i <= 1d; i = i + 0.5d) {

            // If last game has been played, add scores to list and go one level higher
            if (depth == 0){
                double[][] match = {currentGame[0].clone(),currentGame[1].clone()};
                masterList.add(match.clone());
                numberOfGames++;
                break;
            }
            System.out.println("Depth: " + i);

            // Add current score to tournament list
            currentGame[0][currentGame[0].length-depth] = i;
            currentGame[1][currentGame[1].length-depth] = 1 - i;

            // Recursively call loop one level lower (one game deeper in)
            branchTraverse(depth - 1);
        }
    }
    public static void calculateTable(List<double[][]> masterList) {

        System.out.println("Calculating tables:");
        for (double[][] game: masterList) {
            double teamA = game[0][0] + game[0][1] + game[0][2];
            double teamB = game[1][0] + game[0][3] + game[0][4];
            double teamC = game[1][1] + game[1][3] + game[0][5];
            double teamD = game[1][2] + game[1][4] + game[1][5];

            System.out.println("Team scores: ");
            System.out.println("Team A: " + teamA +
                    " : Team B: " + teamB +
                    " : Team C: " + teamC +
                    " : Team D: " + teamD);

            List<Double> scoreList = new ArrayList<>(List.of(teamA, teamB, teamC, teamD));
            Collections.sort(scoreList);
            Collections.reverse(scoreList);
            System.out.println(scoreList.toString());
//            TreeSet<Double> ts = new TreeSet<Double>(scoreList);
            possibleTables.add(scoreList);

            System.out.println();

        }

    }

}
