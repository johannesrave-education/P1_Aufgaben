public class PowersOf2 {
    public static void main(String[] args) {
        for (int i = -16; i <= 16; i++){
            System.out.printf("2^%s = %.6f%n", i, Math.pow(2, i));
        }
    }
}
