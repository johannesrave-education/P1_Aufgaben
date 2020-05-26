// Beispiele zur Lerneinheit 04
// Autor: H. Loose, 2017

public class OperatorenErweitert {
	public static void main(String [] args) {
		int a = 1, b = -1, c = 127, d = 7;
		float s = 1.f, t = -1.f;
		int x = 1;
		float f = 1.f;
		// Die Daten und ihre Binärdarstellung
		System.out.println("a = " + a + " --> " + Integer.toHexString(a) + "  b = " + b + " --> " + Integer.toHexString(b));
		System.out.println("c = " + c + " --> " + Integer.toHexString(c) + "  d = " + d + " --> " + Integer.toHexString(d));
		System.out.println("s = " + s + " --> " + Integer.toHexString(Float.floatToIntBits(s)));
		System.out.println("t = " + t + " --> " + Integer.toHexString(Float.floatToIntBits(t)));
		System.out.println();
		System.out.println("Arithmetische Operationen mit Ganzen Zahlen:");
		System.out.println("a + b = " + (a + b) + "  c / d = " + (c / d) + "  c % d = " + (c % d));
		// System.out.println("c / (a+b) = " + c / (a+b)); // Division durch 0
		x = a++; 	System.out.println("x = a++ = " + x + "  a = " + a);
		x = ++a; 	System.out.println("x = ++a = " + x + "  a = " + a);
		x = a--; 	System.out.println("x = a-- = " + x + "  a = " + a);
		x = --a; 	System.out.println("x = --a = " + x + "  a = " + a);
		x = a++/a; 	System.out.println("x = a++/a = " + x + "  a = " + a);
		x = a/a++; 	System.out.println("x = a/a++ = " + x + "  a = " + a);
		x = a++/a; 	System.out.println("x = a++/a = " + x + "  a = " + a);
		x = a/a++; 	System.out.println("x = a/a++ = " + x + "  a = " + a);
		x = ++a/a; 	System.out.println("x = ++a/a = " + x + "  a = " + a);
		x = a/++a; 	System.out.println("x = a/++a = " + x + "  a = " + a);
		System.out.println("Arithmetische Operationen mit Gebrochenen Zahlen:");
		System.out.println("s + t = " + (s + t) + "  s / t = " + (s / t));
		System.out.println("s / 0 = " + s / 0); // Division durch 0
		System.out.println("2 / 3 * 3.14 = " + (2 / 3 * 3.14) + "\n2 * 3.14 / 3 = " + (2 * 3.14 / 3));
		System.out.println("Bitweise Operationen mit Ganzen Zahlen -- Verschiebungen:");
		a = 1;
		System.out.println("a << 1 = " + (a << 1) + "  a << 8 = " + (a << 8));
		System.out.println("c >> 1 = " + (c >> 1) + "  c >> 3 = " + (c >> 3));
		System.out.println("Bitweise Operationen mit Ganzen Zahlen -- Maskierungen:");
		int g = 297463;
		System.out.println("g = " + g + " --> " + Integer.toHexString(g) + "   ~g = " + ~g + " --> " + Integer.toHexString(~g));
		System.out.println("g & c = " + (g & c) + "  g | c = " + (g | c));
		System.out.println("g & ~c = " + (g & ~c) + "  g | ~c = " + (g | ~c));
		System.out.println("~g & c = " + (~g & c) + "  ~g | c = " + (~g | c));
		System.out.println("Logische und Vergleichs-Operationen:");
		boolean tr = true, fs = false;
		System.out.println("tr = " + tr + "   fs = " + fs);
		System.out.println("a < b = " + (a < b) + "   a > b = " + (a > b));
		System.out.println("a < b && tr = " + ((a < b) && tr) + "   a > b  || tr = " + ((a > b) || tr));
		System.out.println("a < b && fs = " + ((a < b) && fs) + "   a > b  || fs = " + ((a > b) || fs));
		System.out.println("Zuweisungen:");
		x = 2; x = x * 2 + 5; System.out.println("x = " + x);
		x = 2; x *= 2 + 5; 	  System.out.println("x = " + x); // x = x * (2 + 5)
		x = 2; s += x = x * 2 + 5; System.out.println("x = " + x + "   s = " + s);
		///////////////////////////////////////////////////////////////////////////////////////////
		int bitmuster = 4151345;
		a = 1;
		System.out.println("bitmuster = " + bitmuster + " --> " + Integer.toHexString(bitmuster));
		// Setzen des vorletzten Bits
		bitmuster = bitmuster | (a << 1);
		System.out.println("bitmuster = " + bitmuster + " --> " + Integer.toHexString(bitmuster));
		// Löschen des 12. Bits
		bitmuster = bitmuster & ~(a << 11);
		System.out.println("bitmuster = " + bitmuster + " --> " + Integer.toHexString(bitmuster));

	}
}

/*
     erg = op1 op op2     Bsp: c = a + b
     1. typ der operanden überpüfen auf gleichheit
        - ungleich: wird der operand des kleineren Datentyps in den größeren konvertiert
        --> Werte von a und b werden addiert
     2. ergebnisdatentyp konvertiert in typ c und danach wird zugewiesen, --- > c kopiert

     Operatorentypen:
        unären Operatoren - op operand, operand op: -, ++, --, !, ~,
        binären Operatoren -  op1 op op2 : +, - , *, /, %, &&, ||, &, |, ^, <<, >>, >>>,
                      ==, <, >, =,    ,    ,

      Reihenfolge:
      				c = a + b - c ;
      				c = 1000000.0 + 1 - 1000000.0 --> 0
      				c = 1000000.0 - 1000000.0 + 1 --> 1
      				c = 127 + 1 - 127
      				c = 127 - 127 + 1

      				z = x = y += 3;

      Inkrement:
         x = ++a;     --> a = a + 1;
                          x = a;
         x = a++;     --> x = a;
                          a = a + 1;
	  Tautologien
		a & 1 = a				a & 0 = 0
		a | 1 =	1				a | 0 = a
*/