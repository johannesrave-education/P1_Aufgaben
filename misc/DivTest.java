public class DivTest {
    public static void main(String[] args) {

        int x = 300;

        System.out.println(Math.floorDiv(x, 256));
        System.out.println(x - Math.floorDiv(x, 256) * 256);
        System.out.println(x % 256);
    }
}
