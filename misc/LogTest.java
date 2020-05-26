public class LogTest {
    public static void main(String[] args) {

        int x = 300;

        System.out.println("Log("+x+"):"+Math.log(x));

        for (double i = 0.0; i < 10; i = i + 0.1) {

            System.out.println("Log("+i+"):"+Math.log(i));

        }

        for (double i = 0.0; i < 10; i = i + 0.1) {

            System.out.println("Log10("+i+"):"+Math.log10(i));

        }
    }
}
