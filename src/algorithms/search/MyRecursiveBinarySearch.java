package algorithms.search;

public class MyRecursiveBinarySearch {

	 public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {
         
		    if (start < end) {
	            int mid = start + (end - start) / 2; 
	            if (key < sortedArray[mid]) {
	            	 //Note: in non-recursive start <= end is used and mid -1
	        	    
	                return recursiveBinarySearch(sortedArray, start, mid, key);  
	                 
	            } else if (key > sortedArray[mid]) {
	                return recursiveBinarySearch(sortedArray, mid+1, end , key);
	                 
	            } else {
	                return mid;  
	            }
	        }
	        return end == 0 ? -1 : -end; 
	    }
	 
	    public static void main(String[] args) {
	         
	    	int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
	    	int index1 = recursiveBinarySearch(arr,0,arr.length,3);
	    	System.out.println(index1);
	        int[] arr1 = {2,45,234,567,876,900,976,999};
	        int index = recursiveBinarySearch(arr1,0,arr1.length,45);
	        System.out.println("Found 45 at "+index+" index");
	        index = recursiveBinarySearch(arr1,0,arr1.length,999);
	        System.out.println("Found 999 at "+index+" index");
	        index = recursiveBinarySearch(arr1,0,arr1.length,876);
	        System.out.println("Found 876 at "+index+" index");
	    }
}
