package hackerrank;
/*
Devendra loves the XOR operation very much which is denoted by ∧ sign in most of the programming languages. He has a list A of N numbers and he wants to know the answers of M queries. Each query will be denoted by three numbers i.e. K,P,R .

For query K,P and R, he has to print the value of the KPRsum which can be described as given below. As the value of the KPRsum can be large. So, print it modulus (109+7).

KPRsum=∑i=PR−1∑j=i+1R(K⊕(A[i]⊕A[j]))

Input Format
The first line contains an integer N, i.e., the number of the elements in the list. List is numbered from 1 to N.
Next line will contain N space seperated integers.
Third line will contain a number M i.e. number of queries followed by M lines each containing integers K,P&R.

Output Format
Print M lines, ith line will be answer of ith query. Answer will be 0 in case of P=R.

Constraints
1≤N≤105
1≤A[i]≤106
1≤M≤105
0≤K≤106
1≤P≤R≤N

Sample Input

3
1 2 3
2
1 1 3
2 1 3

Sample Output

5
4

Explanation

For first query, it will will be
(1⊕(1⊕2))+(1⊕(1⊕3))+(1⊕(2⊕3))=5
 */
import java.util.Scanner;

public class XORLove {
	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int _n = n+1;
		long[] A = new long[_n];
		
		for(int i=1;i<_n;i++){
			A[i] = sc.nextLong();
		}
		int m = sc.nextInt();
		for(int i=0;i<m;i++){
			int k = sc.nextInt();
			int p = sc.nextInt();
			int r = sc.nextInt();
			if(p==r){
				System.out.println("0");
			}else{
				System.out.println(kprSum(A, k, p, r));
			}
		}
	}
	public static long kprSum(long[] A, int k, int p, int r){
		long PRIME = 1000000007;
		long sum = 0;
		for(int i = p;i<= r-1;i++){
			for(int j =i+1;j<=r;j++){
				sum += k ^ (A[i] ^ A[j]) ; 
			}
		}
		return sum%PRIME;
	}
}
