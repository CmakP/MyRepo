package algorithms.numbers;

/**
 * Find out middle index where sum of both ends are equal.
 */
public class FindMiddleIndex {

	public static void main(String a[]) {
        int[] num = { 2, 4, 4, 5, 4, 1 };
        try {
        	int index = findMiddleIndexMine(num);
            System.out.format("Starting from index 0, adding numbers till index %d is equal to "
            		+ "addition of numbers from index %d to %d", index, index + 1, num.length);
             
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

	public static int findMiddleIndex(int[] numbers) throws Exception {
		 
        int endIndex = numbers.length - 1;
        int startIndex = 0;
        int sumLeft = 0;
        int sumRight = 0;
        while (true) {
            if (sumLeft > sumRight) {
                sumRight += numbers[endIndex--];
            } else {
                sumLeft += numbers[startIndex++];
            }
            if (startIndex > endIndex) {
                if (sumLeft == sumRight) {
                    break;
                } else {
                    throw new Exception("Please pass proper array to match the requirement");
                }
            }
        }
        return endIndex;
    }
	
	public static int findMiddleIndexMine(int[] numbers) throws Exception {
		int total = 0;
		int target = 0;
		for(int i : numbers) {
			total += i;
		}
		target = total / 2;
		total = 0;
		for(int i = 0; i < numbers.length; i++) {
			total += numbers[i];
			if(total == target) {
				return i;
			} else if(total > target) {
				throw new Exception("Please pass proper array to match the requirement");
			}
		}
		return 0;
	}
}
