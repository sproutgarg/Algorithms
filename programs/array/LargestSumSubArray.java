package array;

public class LargestSumSubArray {

	/**
	 * @param arr of -ve, +ve integers
	 * find the largest sum which exists as subarray, and print 
	 * largest sum, indices of the sub array.
	 * 
	 * 
	 * Approach to Solution:
	 * 1. find the largest sum which exists as subarray
	 * 2. then mark the indices of that sub array 
	 * 
	 * TC : O(n), n is the length of array
	 */
	public static void largestSumSubArray(int[] arr){
		if(arr.length == 0){
			return;
		}
		int max_so_far = 0;
		int max_current = 0;
		int start = 0;
		int end = 0;
		int temp = 0;
		//scan the array for all negative integer case
		max_so_far = arr[0];
		int i;
		for(i=0;i<arr.length && arr[i] < 0;i++){
			if(max_so_far < arr[i]){
				max_so_far = arr[i];
				start = i;
				end = i;
			}
		}
		if(i == arr.length){//that means all negative integers are present in array
			System.out.println("max sum : " +max_so_far+", start = "+start+", end = "+end);
			return;
		}
		//reseting reusable variable
		max_so_far = 0;
		start = 0;
		end = 0;
		
		//only for array having atleast 1 positive integer
		for(int j=0;j<arr.length;j++){
			max_current +=arr[j];
			if(max_current < 0){
				max_current = 0;
				temp = j + 1;
			}
			if(max_so_far < max_current){
				start = temp;
				end = j;
				max_so_far = max_current;
			}
		}
		System.out.println("max sum : " + max_so_far+", start = "+start+", end = "+end);
	}
	public static void main(String...args){
		int[] a1= {211, 30, -10, 34, -2, 5};
		int[] a2= {-11, -22, -3, -4, -5};
		largestSumSubArray(a1);
		largestSumSubArray(a2);
	}
}