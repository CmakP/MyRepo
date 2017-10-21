package algorithms.numbers;
import java.util.Arrays;

public class PrimeNumber {

	public PrimeNumber() {}

	public static void main(String[] args) {
		PrimeNumber prime = new PrimeNumber();
        System.out.println(prime.isPrimeSieve(1777));
  	//	System.out.println(prime.isPrimeBetter(23));
		System.out.println(prime.isPrimeBest(23));
	}
	
	//global array just to keep track of it in this example,
	//but you can easily do this within another function.

	//set up the primesieve
	public String fillSieve(int n) {
		// will contain true or false values for the first 10,000 integers
		boolean[] primes = new boolean[n + 1];

	    Arrays.fill(primes, true);        // assume all integers are prime.
	    primes[0] = primes[1] = false;       // we know 0 and 1 are not prime.
	    System.out.println("Prime numbers up to " + n + ":");
	    for (int i=2; i<= n; i++) {           
	      //if the number is prime,
	        //then go through all its multiples and make their values false.
	        if(primes[i]) {
	        	System.out.print(i + " ");
	            for (int j = 2; i*j <= n; j++) {
	                primes[i*j] = false;
	            }
	        }
	    }
	    return "\n" + n + " is " + (primes[n] == true ? "" : "not ") + "a prime number.";
	}

	public String isPrimeSieve(int n) {
	    return fillSieve(n);
	}

	//checks whether an int is prime or not. Checks all the numbers.
	boolean isPrimeBasic(int n) {
	    for(int i=2; i < n; i++) {
	        if(n%i == 0)
	            return false;
	    }
	    return true;
	}
	
	//checks whether an int is prime or not. 
	//Consider that if 2 divides some integer n, then (n/2) divides n as well. 
	boolean isPrimeBetter(int n) {
	    for(int i=2; 2*i < n; i++) {
	        System.out.print(i + " ");
	    	if(n%i == 0)
	            return false;
	    }
	    return true;
	}
	
	//checks whether an int is prime or not. Checks only 2 and the odds.
	boolean isPrimeBest(int n) {
	    //check if n is a multiple of 2
	    if (n%2 ==0 ) return false;
	    //if not, then just check the odds
	    for(int i=3; i*i <= n; i+=2) {
	        System.out.print(i + " ");
	        if(n%i == 0)
	            return false;
	    }
	    return true;
	}
}
