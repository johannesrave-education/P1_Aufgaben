import java.util.Random;

public class Auto {
    public int Farbkennziffer;
    public double Gewicht;
    public String Modellname;

    public Auto(int f, double g, String m){
        Farbkennziffer = f;
        Gewicht = g;
        Modellname = m;
    };

    public static void main(String[] args) {
        int[] farbe = {39, 7, 90};
        double[] gewicht = {1.2, 1.4, 2.8};
        String[] modell = {"Tick", "Trick", "Track"};
        Random ran = new Random();

        Auto[] Autohaus = new Auto[420];

        for (int i = 0; i < Autohaus.length; i++){
            int f = farbe[ran.nextInt(farbe.length)];
            double g = gewicht[ran.nextInt(gewicht.length)];
            String m = modell[ran.nextInt(modell.length)];
            Autohaus[i] = new Auto(f,g,m);
        }

        for (int i = 0; i < Autohaus.length; i++){
            Auto auto = Autohaus[i];
            System.out.println(
                    "Farbkennziffer: " + auto.Farbkennziffer +
                    " Gewicht: " + auto.Gewicht +
                    " Modellname: " + auto.Modellname
            );
        }
    }
}
