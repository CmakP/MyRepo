package algorithms.sort;

public class MyBubbleSort {

	  // logic to sort the elements
    public static void bubble_srt(int array[]) {
        int n = array.length - 1;
        int k;
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }
            printNumbers(array);
        }
    }
 
    private static void swapNumbers(int i, int j, int[] array) {
 
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 
    private static void printNumbers(int[] input) {
         
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }
 
    public static void main(String[] args) {
        int[] input = { 4, 2, 9, 6, 20, 23, 12, 3, 5, 7, 11, 14, 34, 0, 1 };
        bubble_srt(input);
 
    }
}
