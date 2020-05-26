/**
 * P1_LE05
 * @author Johannes Rave, Medieninformatik
 * @version 1.0 2.5.2020
 */

public class TestBerechnen {
    public static void main(String[] args) {

        int radius = 10;

        if (args.length > 0) {
            radius = Integer.parseInt(args[0]);
            System.out.println("Es wurde ein Radius eingegeben.");
        } else {
            System.out.println("Es wurde kein Radius-Argument eingegeben.");
        }

        System.out.println("Berechnungen erfolgen mit einem Radius von " + radius + " Metern.");

        Berechnungen.berechneUmfang(radius);
        Berechnungen.berechneFlaeche(radius);
    }
}
