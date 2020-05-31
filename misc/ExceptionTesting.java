import java.util.ArrayList;

public class ExceptionTesting {

    public static ArrayList<String> myTelList = new ArrayList<String>();

    public static long mult(long a, long b) throws Exception{
        long result = a * b;
        if (a>0 && b>0 && result<0){
            throw new Exception("Exception thrown.");
        }
        return result;
    }

    public static long longThrower() {
        long x = Long.MAX_VALUE;
        System.out.println(x + 1);
        return x + 1;
    }

    public static void main(String[] args) throws Exception {
        long x = (Long.MAX_VALUE);
        try {
            System.out.println();
        }
        catch (Exception e){

        }
        System.out.println(mult(x,3));
    }
}
