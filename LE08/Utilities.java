public class Utilities {
    public static void main(String[] args){
        System.out.printf(Fakultaet(12) + "");
        System.out.println();
        System.out.printf(Potenz(3,0) + "");
    }

    public static int Fakultaet(int n){
        if (n == 1){
            System.out.printf("1 = ");
            return 1;
        }
        if (n == 0) {
            System.out.printf("Fakultät(0) ist 0.");
            return -1;
        }
        else {
            System.out.printf(n+ " * ");
            return n*Fakultaet(n-1);
        }
    }

    public static int Potenz(int x, int n ){
        if (n == 1) {
            System.out.printf(x+ " = ");
            return x;
        }
        if (n == 0) {
            System.out.printf("Potenz("+x+",0) ist ");
            return 1;
        }
        else {
            System.out.printf(x+ " * ");
            return x * Potenz(x, n - 1);
        }
    }
}
