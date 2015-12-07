package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/*
 * You are given two integer arrays, A and B, each containing N integers. The size of the array is less than or equal to 1000. You are free to permute the order of the elements in the arrays.

Now here’s the real question - is there an arrangement of the arrays, such that, Ai+Bi ≥ K for all i, where Ai denotes the ith element in the array A.


Input Format
The first line contains an integer, T, the number of test-cases. T test cases follow. Each test case has the following format:

The first line contains two integers, N and K. The second line contains N space separated integers, denoting A array. The third line describes B array in a same format.

Output Format
For each test case, if such an arrangement exists output “YES”, otherwise “NO” (without quotes).


Constraints
1 <= T <= 10
1 <= N <= 1000
1 <= K <= 109
0 <= Ai, Bi ≤ 109


Sample Input

2
3 10
2 1 3
7 8 9
4 5
1 2 2 1
3 3 3 4


Sample Output

YES
NO

Explanation

The first input has 3 elements in Array A and Array B, we see that the one of the arrangements, 3 2 1 and 7 8 9 has each pair of elements (3+7, 2 + 8 and 9 + 1) summing upto 10 and hence the answer is “YES”.

The second input has B array with three 3s. So, we need at least three numbers in A that are greater than 1. As this is not the case, the answer is “NO”. 
 */
public class TwoArrays {
	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0){
			
			String nk = sc.nextLine();
			nk = nk.trim();
			String[] val = nk.split(" ");
			int n = Integer.parseInt(val[0]);
			int k = Integer.parseInt(val[1]);
			int[] a = new int[n];
			int[] b = new int[n];
			//sc.nextLine();
			String aStr = sc.nextLine();
			aStr =  aStr.trim();
			String[] aVal = aStr.split(" ");
			String bStr = sc.nextLine();
			bStr = bStr.trim();
			String[] bVal = bStr.split(" ");
			for(int i=0; i<n; i++){
				a[i] = Integer.parseInt(aVal[i]);
				b[i] = Integer.parseInt(bVal[i]);
			}
			
			Arrays.sort(a);
			Arrays.sort(b);
			int count = 0;
			for(int i=0;i<n;i++){
				if(a[i] + b[n-1-i] >= k){
					count++;
				}
			}
			if(count == n){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			//System.out.println(t);
			//System.out.println(nk);
//			System.out.println(aStr);
			t--;
		}
	}
}
