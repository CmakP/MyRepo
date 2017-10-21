package algorithms.numbers;

/*
 * If n is a positive integer and x is any real number, then x corresponds to repeated 
 * multiplication. x*x*...*x (n times)
 * We can call this x raised to the power of n, x to the power of n or simply x to the n.
 * Here, x is the base and n is the exponent or the power.
 */
public class NumberToPower {

	public static void main(String[] args) {
		NumberToPower.pow(2, 3);
	}
	
	public static void pow(int base, int exponent) {
        System.out.println((int) Math.pow(base, exponent));
	}
}
