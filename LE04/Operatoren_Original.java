
public class Operatoren_Original {
/************************************************/

/* Zuweisungsoperatoren */

public static void main (String [] args)
{
	int x = 2, y, z;

	x *= 3 + 2; 			System.out.println(x);

	x *= y = z = 4; 			System.out.println(x);

/* Elementare Arithmetikoperatoren */

	x = - 3 + 4 * 5 - 6; 		System.out.println(x);

	x =  3 + 4 % 5 - 6; 		System.out.println(x);

	x = - 3 * 4 %  - 6 / 5; 	System.out.println(x);

	x = (7 + 6 ) %  5 / 2; 	System.out.println(x);

/* Inkrementoperatoren */

	x = y = 1;

	z = x ++ -1; 			System.out.println(x);
						System.out.println(z);

	z += - x ++ + ++ y; 		System.out.println(x);
						System.out.println(z);

	z  = x / ++ x ;			System.out.println(z);
}
}

