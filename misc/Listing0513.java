/* Listing0513 */

public class Listing0513
{
  public static void main(String[] args)
  {
    for (int i = 0; i < 256; ++i) {
      System.out.print("i=" + i);
      byte b = ByteKit.fromUnsignedInt(i);
      System.out.print(" b=" + ByteKit.toBitString(b));
      char c = ByteKit.toChar(b);
      System.out.print(" c=" + (c >= 32 ? c : '.'));
      System.out.println();
    }
  }
}