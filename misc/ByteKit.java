/**
 * ByteKit
 *
 * Einfache Klasse zur Umwandlung zwischen int, char und
 * vorzeichenlosen Bytes.
 */
public class ByteKit
{
  /**
   * Wandelt value (0 <= value <= 255) in ein byte um.
   */
  public static byte fromUnsignedInt(int value)
  {
    return (byte)value;
  }

  /**
   * Wandelt c in ein byte um. Das High-Byte wird ignoriert.
   */
  public static byte fromChar(char c)
  {
    return (byte)(c & 0xFF);
  }

  /**
   * Betrachtet value als vorzeichenloses byte und wandelt
   * es in eine Ganzzahl im Bereich 0..255 um.
   */
  public static int toUnsignedInt(byte value)
  {
    return (value & 0x7F) + (value < 0 ? 128 : 0);
  }

  /**
   * Betrachtet value als vorzeichenloses byte und wandelt
   * es in ein Unicode-Zeichen mit High-Byte 0 um.
   */
  public static char toChar(byte value)
  {
    return (char)toUnsignedInt(value);
  }

  /**
   * Liefert die Binaerdarstellung von value.
   */
  public static String toBitString(byte value) // hier geht ein byte rein, als parameter value, und wird dann als string a la "00010001" zurückgegeben
  {
    char[] chars = new char[8]; // neues Array, bestehend aus 8 chars
    int mask = 1; // ein "index" mit dem gleich das bit aus dem byte array ausgewählt wird
    for (int i = 0; i < 8; ++i) { // for loop von 0 bis 7, also die 8 bits im array
      chars[7 - i] = (value & mask) != 0 ? '1' : '0';
      // chars[7-i] schreibt die bits von rechts nach links ins array,
      // aber zuerst eigentlich "ternary operator"/dreifach operator:
      // wörtlich in etwa "wenn value oder mask den gleichen wert haben, gibt's ne 1, sonst ne 0 an der von chars [7-i] ausgewählten stelle im array.
      mask <<= 1;
      // dann wird die maske eine bitstelle nach links geschoben, also beispielsweise von


      // 00000001 nach
      // 00000010

      // 00010001
      // beim nächsten durchlauf des loops wird daher der wert an dieser stelle mit dem "value" verglichen

    } // als ergebnis des loops gibt's dann ein array im stil von [0][1][1][0][1][0][1][0]
    return new String(chars); // das array wird in einen string gecastet, komfortablerweise reiht das einfach die chars aus dem array aneinander
  }
}