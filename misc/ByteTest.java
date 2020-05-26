public class ByteTest {
    public static void main(String[] args) {
        int x = 102;
        System.out.println(ByteKit.fromUnsignedInt(x));

        byte b = (byte) x;
        System.out.println("BitString of x: " + ByteKit.toBitString(b));
        
        System.out.println("HexString of x: " + Integer.toHexString(x));

        System.out.println(1+2+4+8+16+32+64);

        System.out.println("Integer.toString: " + String.format("%1$032d", Integer.parseInt(Integer.toString(x,2))));

        //0x%08X%n"
    }
}

/*

0 --> 033313133
0000000000000000

-18 --> 0 --> 18

0111111

0000000
1111110
0000001

two complement


-128 bis +127

01111111
<--
10000000

0999
1000
*/

