/**
 * 
 */
package array;

/**
 * @author ankugarg
 * @question Kth smallest element in a row-wise and column-wise sorted 2D array
 *           | Set 1 Given an n x n matrix, where every row and column is sorted
 *           in non-decreasing order. Find the kth smallest element in the given
 *           2D array.
 * 
 *           For example, consider the following 2D array.
 * 
 *           10, 20, 30, 40 
 *           15, 25, 35, 45 
 *           24, 29, 37, 48 
 *           32, 33, 39, 50 
 *           
 *           The 3rd smallest element is 20 and 7th smallest element is 30
 */
public class KthSmallestElementInMatrix {

	private static int findSmallestElementRowIndex(int[][] arr, int[] index){
		int smallestElementRowIndex = -1;
		int smallestElement = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			if(index[i] < arr[i].length && arr[i][index[i]] < smallestElement){
				smallestElement = arr[i][index[i]];
				smallestElementRowIndex = i;
			}
		}
		return smallestElementRowIndex;
	}
	
	/**
	 * TC : O(nk) ; n for finding smallest element row index and we do this for k times
	 * can be easily reduced to O(kLogn), by using min heap for fetching smallest element
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int algo(int[][]arr, int k){
		int element = arr[0][0];
		//indexer for tracking column wise elements while comparing values to get smallest element
		int[] index = new int[arr.length];
		java.util.Arrays.fill(index, 0);
		
		while(k > 0){
			int smallestElementRowIndex = findSmallestElementRowIndex(arr, index);
			if(smallestElementRowIndex >= 0 && smallestElementRowIndex < arr.length){
				element = arr[smallestElementRowIndex][index[smallestElementRowIndex]];
				index[smallestElementRowIndex]++;
			}
			k--;
		}
		return element;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = new int[][]{
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{24, 29, 37, 48},
				{32, 33, 39, 50}
		};
		System.out.println("kth smallest element : " + algo(arr, 0));
		
	}

}
