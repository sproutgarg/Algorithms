/**
 * 
 */
package array;

/**
 * @author ankugarg
 * @question Find the number of zeroes Given an array of 1s and 0s which has all
 *           1s first followed by all 0s. Find the number of 0s. Count the
 *           number of zeroes in the given array. 
 *           Examples:
 * 
 *           Input: arr[] = {1, 1, 1, 1, 0, 0} Output: 2
 * 
 *           Input: arr[] = {1, 0, 0, 0, 0} Output: 4
 * 
 *           Input: arr[] = {0, 0, 0} Output: 3
 * 
 *           Input: arr[] = {1, 1, 1, 1} Output: 0
 */
public class ZerosCount {

	/**
	 * TC :O(LogN) where N is length of array
	 * @param arr
	 * @return
	 */
	public static int algo(int[] arr) {
		int count = 0;
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		boolean foundStartPoint = false;
		while(low <= high){
			mid = (low + high)/2;
			if(arr[mid] == 0 && (mid == 0 || arr[mid-1] == 1)){
				foundStartPoint = true;
				break;
			}
			if(arr[mid] == 1){
				low = mid + 1;
			}else if(arr[mid] == 0){
				high = mid - 1;
			}
		}
		if(foundStartPoint){
			count = arr.length - mid;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 1, 1, 1, 0, 0};
		System.out.println(algo(arr));
		System.out.println(algo(new int[]{1, 0, 0, 0, 0}));
		System.out.println(algo(new int[]{0, 0, 0}));
		System.out.println(algo(new int[]{1, 1, 1, 1}));
	}
}
