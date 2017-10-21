package algorithms.numbers;
	import java.util.ArrayList;
	import java.util.List;
	 
	public class DuplicateNumber {
	 
	    public int findDuplicateNumber(List<Integer> numbers){
	         
	        int highestNumber = numbers.size() - 1;
	        int total = getSum(numbers);
//	        int duplicate = total - (highestNumber*(highestNumber+1)/2);
	        int duplicate = total - getSumToN(highestNumber);
	        return duplicate;
	    }
	    
	    // My Way - Recursive Fibonacci sequence
	    public int getSumToN(int n) {
	    	return n == 1 ? 1 : n + getSumToN(n - 1);
	    }
	    
	    public int getSum(List<Integer> numbers){         
	        int sum = 0;
	        for(int num:numbers){
	            sum += num;
	        }
	        return sum;
	    }
	     
	    public static void main(String a[]){
	        List<Integer> numbers = new ArrayList<Integer>();    
	        for(int i=1;i<30;i++){
	            numbers.add(i);
	        }
	        //add duplicate number into the list
	        numbers.add(5);
	        numbers.add(30);
	        numbers.add(31);
		        
	        DuplicateNumber dn = new DuplicateNumber();
	        System.out.println("Duplicate Number: "+ dn.findDuplicateNumber(numbers));
	    }
}
