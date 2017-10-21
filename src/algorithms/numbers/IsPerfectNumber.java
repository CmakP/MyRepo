package algorithms.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 A perfect number is a positive integer that is equal to the sum
of its proper positive divisors, that is, the sum of its positive
divisors excluding the number itself. Equivalently, a perfect number
is a number that is half the sum of all of its positive divisors.
The first perfect number is 6, because 1, 2 and 3 are its proper
positive divisors, and 1 + 2 + 3 = 6. Equivalently, the number 6
is equal to half the sum of all its positive divisors:
		( 1 + 2 + 3 + 6 ) / 2 = 6.
 */
public class IsPerfectNumber {

	public IsPerfectNumber() {}
	
	public static void main(String a[]){
        IsPerfectNumber perfectNum = new IsPerfectNumber();
        int number = 27;
        System.out.format("%n%d divisors are: %s",number, perfectNum.isPerfectNumber(number));
    }
	
	 public List<Integer> isPerfectNumber(int number){
         
		 	List<Integer> divisors = new ArrayList<Integer>();
	        int temp = 0;
	        for(int i=1;i<=number/2;i++){
	            if(number%i == 0){
	                temp += i;
	                divisors.add(i);
	            }
	        }
	        String result = "";
	        if(temp != number){
	            result = "NOT ";
	            divisors.clear();
	        } 
	        System.out.format("%d is %sa perfect number.", number, result);
	        return divisors;
	    }
}
