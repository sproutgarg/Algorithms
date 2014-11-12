/**
 * 
 */
package array;

/**
 * @author ankugarg
 * @question 
Given an array of positive and negative numbers, find if there is a subarray with 0 sum.

Examples:

Input: {4, 2, -3, 1, 6}
Output: true 
There is a subarray with zero sum from index 1 to 3.

Input: {4, 2, 0, 1, 6}
Output: true 
There is a subarray with zero sum from index 2 to 2.

Input: {-3, 2, 3, 1, 6}
Output: false
There is no subarray with zero sum.
 */
public class Subarray0Sum {

	
	public static boolean algo(int[] arr){
		int sum = 0;
		java.util.HashSet<Integer> sumSet = new java.util.HashSet<Integer>();
		for(int i =0;i<arr.length;i++){
			sum += arr[i];
			if(!sumSet.add(sum)){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[]{4, 2, -3, 1, 6};
		System.out.println("have sub array with zero sum = " + algo(arr1));
		
		int[] arr2 = new int[]{4, 2, 0, 1, 6};
		System.out.println("have sub array with zero sum = " + algo(arr2));

		int[] arr3 = new int[]{-3, 2, 3, 1, 6};
		System.out.println("have sub array with zero sum = " + algo(arr3));

	}

}
