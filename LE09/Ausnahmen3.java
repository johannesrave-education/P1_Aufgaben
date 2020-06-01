class MyException extends Exception {
	public MyException() { super(); }
	public MyException(String message) { super(message); }
}

public class Ausnahmen3 {

	public static int dividiere(int a, int b) throws Exception {
		int erg = 0;
		if (b != 0)
			erg = a / b;
		else
//			System.err.println("Der Nenner ist 0!");
			throw new Exception("Der Nenner ist 0!");
		return erg;
	}


	public static void main(String[] args) {

		int erg = 0, a = 1, b = 1;
		// TODO Auto-generated method stub
		try {
			erg = dividiere( a, b);
			System.out.println( a + " / " + b + " = " + erg);
			b = 0;
			erg = dividiere( a, b);
			System.out.println( a + " / " + b + " = " + erg);
		}
		catch (MyException e) {
			System.err.println("My: " + e.getMessage());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			System.out.println("Ende des Programms");
		}
	}

}

/* int dividiere(int a, int b)

 - Sichere Blöcke

*/