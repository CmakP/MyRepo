package algorithms.numbers;

public class ReverseNumber {

	public static void main(String[] args) {
		ReverseNumber reverse = new ReverseNumber();
        System.out.println(reverse.rev(1234567890));
	}

	public long rev(long number) {
		long reverse = 0;
		int digits = 0;
	    while(number != 0) {
	    	digits++;
	    	reverse = (reverse * 10) + (number % 10);
	    	number = number/10;
        }
	    System.out.println("Total number of digits: " + digits);
	    return reverse;       	
	}
}
