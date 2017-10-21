package hackerrank;

public class NumbersMood {

	public static void main(String[] args) {
		System.out.println(numbers_mood(5));
	}
	private static int totalNum = 0;
	
	static String numbers_mood(int number) {
	
        int firstNum = number%10;
        totalNum += firstNum * firstNum;
        int secondNum = number/10;
        
        
        if (secondNum >= 10) {
        	numbers_mood(secondNum);
        } 
        else if (secondNum > 0) {
        	totalNum += secondNum * secondNum; 
        }
        
        if (totalNum == 1) {
        	return "Happy";
        }
        else if (totalNum == 4) {
        	return "Sad";
        }
        else {
        	int total = totalNum;
        	totalNum = 0;
        	return numbers_mood(total);
        }
    }
}
