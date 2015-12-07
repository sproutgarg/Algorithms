/**
 * 
 */
package array;

/**
 * @author ankugarg
 * @question Search in a row wise and column wise sorted matrix Given an n x n
 *           matrix, where every row and column is sorted in increasing order.
 *           Given a number x, how to decide whether this x is in the matrix.
 *           The designed algorithm should have linear time complexity.
 */
public class SearchSortedMatrix {

	/**
	 * @param args
	 */
	public static int searchRow(int[][] m, int key) {
		// do binary search to find the row having the search key
		int l = 0;
		int h = m.length - 1;
		int mid = -1;
		while (l <= h) {
			mid = (l + h) / 2;
			int start = m[mid][0];
			int end = m[mid][m[mid].length - 1];
			if (start <= key && key <= end) {
				return mid;
			} else if (start > key) {
				h = mid - 1;
			} else if (end < key) {
				l = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * returns -1 if the key is not present in the given column else returns the
	 * column index of the key
	 */
	public static int searchColumnInRow(int[][] m, int key, int r) {
		// do binary search to find the column having the search key in given
		// 'r' row
		int l = 0;
		int h = m[r].length - 1;
		int mid = -1;
		while (l <= h) {
			mid = (l + h) / 2;
			int element = m[r][mid];
			if (element == key) {
				return mid;
			} else if (element > key) {
				h = mid - 1;
			} else if (element < key) {
				l = mid + 1;
			}
		}
		return -1;
	}

	/*
	 * time complexity : O(log(rows) + log(columns_in_that_row))
	 */
	public static int algo(int[][] m, int key) {
		int r = searchRow(m, key);
		if (r >= 0) {
			System.out.println("key may be present in row number : " + r);
			return searchColumnInRow(m, key, r);
		}
		return r;
	}

	public static void main(String[] args) {
		tc1();
	}

	public static void tc1() {
		int[][] m = new int[][] { { 1, 2, 3 }, { 4, 6, 8 }, { 10, 20, 30 } };
		int key = 9;
		System.out.println("key present in column number : " + algo(m, key));
	}

}