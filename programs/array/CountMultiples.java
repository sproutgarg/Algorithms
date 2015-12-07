/**
 * 
 */
package array;

/**
 * @author ankugarg
 * @question Given an unsorted integer (positive values only) array of size ‘n’,
 *           we can form a group of two or three, the group should be such that
 *           the sum of all elements in that group is a multiple of 3. Count all
 *           possible number of groups that can be generated in this way.
 * 
 *           Input: arr[] = {3, 6, 7, 2, 9} Output: 8 // Groups are {3,6},
 *           {3,9}, {9,6}, {7,2}, {3,6,9}, // {3,7,2}, {7,2,6}, {7,2,9}
 * 
 * 
 *           Input: arr[] = {2, 1, 3, 4} Output: 4 // Groups are {2,1}, {2,4},
 *           {2,1,3}, {2,4,3}
 */
public class CountMultiples {

	/**
	 * TC : O(n)
	 * 
	 * @param arr
	 * @param n
	 * @return
	 * 
	 *         concept : The idea is to see remainder of every element when
	 *         divided by 3. A set of elements can form a group only if sun of
	 *         their remainders is multiple of 3. Since the task is to enumerate
	 *         groups, we count all elements with different remainders.
	 */
	public static long getTotalCombinations(int[] arr, int n) {
		// count the number of elements for all possible remainders for the
		// given 'n'
		long[] r = new long[n];
		java.util.Arrays.fill(r, 0);
		for (int i = 0; i < arr.length; i++) {
			r[arr[i] % n]++;
		}

		// specific for n=3
		// group size 2
		// a. both with 0 remainder
		long c1 = util.Math.nCr(r[0], 2);
		// b. one each from 1 remainder and 2 remainder
		long c2 = util.Math.nCr(r[1], 1) * util.Math.nCr(r[2], 1);
		// group size 3
		// a. all from 0 remainder
		long c3 = util.Math.nCr(r[0], 3);
		// b. all from 1 remainder
		long c4 = util.Math.nCr(r[1], 3);
		// c. all from 2 remainder
		long c5 = util.Math.nCr(r[2], 3);
		// d. one each from 0,1,2 remainder
		long c6 = util.Math.nCr(r[0], 1) * util.Math.nCr(r[1], 1)
				* util.Math.nCr(r[2], 1);

		return c1 + c2 + c3 + c4 + c5 + c6;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 6, 7, 2, 9 };
		System.out.println("TC1 : number of groups whose sum is multiple of 3 : "
				+ getTotalCombinations(arr, 3));
		System.out.println("TC2 : number of groups whose sum is multiple of 3 : "
				+ getTotalCombinations(new int[] { 2, 1, 3, 4 }, 3));
	}

}
