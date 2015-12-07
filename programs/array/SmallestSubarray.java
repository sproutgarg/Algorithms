package array;

/**
 * @author ankugarg
 *
 */
/**
 * @question Given an array of integers and a number x, find the smallest
 *           subarray with sum greater than the given value. 
 *           Examples: arr[] = {1, 4, 45, 6, 0, 19} x = 51 
 *           Output: 3 Minimum length subarray is  {4, 45, 6}
 * 
 *           arr[] = {1, 10, 5, 2, 7} x = 9 Output: 1 Minimum length subarray is
 *           {10}
 * 
 *           arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250} x = 280 Output: 4
 *           Minimum length subarray is {100, 1, 0, 200}
 *
 */
public class SmallestSubarray {

	/**
	 * TC : O(n)
	 * @param arr
	 * @param x
	 * @return length of min subarray
	 * 
	 *  this algo is for arrays containing only POSITIVE numbers
	 */
	public static int algoPositive(int[] arr, int x){
		int minLength = arr.length;
		int start=0, end=0, sum = 0;
		while(start < arr.length && end < arr.length){
			while(sum <= x && end < arr.length){
				sum += arr[end++];
			}
			while(sum > x && start < arr.length){
				if(end - start< minLength){
					minLength = end - start;
					if (minLength == 1)
						return minLength;
				}
				sum -= arr[start++];
			}
		}
		// -1 to tell the caller that there is no such subarray 
		if(minLength == arr.length)
			return -1;
		return minLength;
	}

	/**
	 * TC : O(n)
	 * @param arr
	 * @param x
	 * @return
	 */
	public static int algoGeneral(int[] arr, int x){
		int minLength = arr.length;
		int start=0, end=1, sum = arr[0];
		while(start < arr.length && end < arr.length){
			
			while(sum <= x && end < arr.length){
				//this condition tells that the current streak of elements can be thrown away directly
				// as arr[end] itself is greater than all previously tracked elements
				if(sum + arr[end] < arr[end]){
					start = end;
					sum = 0;
				}
				sum += arr[end++];
			}
			while(sum > x && start < arr.length){
				if(end - start< minLength){
					minLength = end - start;
					if (minLength == 1)
						return minLength;
				}
				sum -= arr[start++];
			}
		}
		// -1 to tell the caller that there is no such subarray 
		if(minLength == arr.length)
			return -1;
		return minLength;
	}
	public static void main(String[] args) {
		System.out.println("algoPositive  : min length of sub-array :" + algoPositive(new int[]{1, 4, 45, 6, 0, 19}, 51));
		System.out.println("algoPositive  : min length of sub-array :" + algoPositive(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 240));
		System.out.println("algoPositive  : min length of sub-array :" + algoPositive(new int[]{-1, -4, 45, 6, -10, -19}, 50));
		System.out.println("algoPositive  : min length of sub-array :" + algoPositive(new int[]{2,-5,10,-100}, 5));
		System.out.println();
		System.out.println("algoGeneral  : min length of sub-array :" + algoGeneral(new int[]{1, 4, 45, 6, 0, 19}, 51));
		System.out.println("algoGeneral  : min length of sub-array :" + algoGeneral(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 240));
		System.out.println("algoGeneral  : min length of sub-array :" + algoGeneral(new int[]{-1, -4, 45, 6, -10, -19}, 50));
		System.out.println("algoGeneral  : min length of sub-array :" + algoGeneral(new int[]{2,-5,10,-100}, 5));

	}

}
