package hackerrank;

import java.util.Scanner;

/*
Watson gives an array A1,A2…AN to Sherlock. Then he asks him to find if there exists an element in the array, such that, the sum of elements on it’s left is equal to the sum of elements on it’s right. If there are no elements to left/right, then sum is considered to be zero.
Formally, find an i, such that, A1+A2…Ai-1 = Ai+1+Ai+2…AN.

Input Format
The first line contains T, the number of test cases. For each test case, the first line contains N, the number of elements in the array A. The second line for each testcase contains N space separated integers, denoting the array A.

Output Format
For each test case, print YES if there exists an element in the array, such that, the sum of elements on it’s left is equal to the sum of elements on it’s right, else print NO.

Constraints
1 ≤ T ≤ 10
1 ≤ N ≤ 105
1 ≤ Ai ≤ 2*104 for 1 ≤ i ≤ N

Sample Input

2
3
1 2 3
4
1 2 3 3

Sample Output

NO
YES

Explanation
For test case 1, no such index exists.
For test case 2, A[1]+A[2] = A[4], therefore index 3 satisfies.
 */
public class SherlockArray {

	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			int _n = n+2;
			long array_sum = 0;
			//SENTINAL ARRAY 
			long[] arr = new long[_n];
			arr[0]=0;
			arr[_n-1]=0;
			for(int j=1;j<=n;j++){
				arr[j] = sc.nextLong();
				array_sum += arr[j];
			}
			System.out.println(checkBalance(array_sum, arr));
		}
	}
	public static String checkBalance(long array_sum, long[] arr){
		long leftSum = 0;
		long rightSum = array_sum;
		for(int i=1;i<arr.length-1; i++){
			leftSum += arr[i-1];
			rightSum -= arr[i];
			if(leftSum == rightSum){
				return "YES";
			}
		}
		return "NO";
	}
}
