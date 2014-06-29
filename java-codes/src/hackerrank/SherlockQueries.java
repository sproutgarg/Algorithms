package hackerrank;
/*
 * 

Watson gives to Sherlock an array: A1,A2,⋯,AN. He also gives to Sherlock two another arrays: B1,B2,⋯,BM and C1,C2,⋯,CM.
Then Watson asks Sherlock to perform the following program:

for i = 1 to M do
    for j = 1 to N do
        if j % B[i] == 0 then
            A[j] = A[j] * C[i]
        endif
    end do
end do

Can you help Sherlock and tell him the resulting array A? You should print all the array elements modulo (109+7).

Input Format
The first line contains two integer numbers N and M. The next line contains N integers, the elements of array A. The next two lines contains M integers each, the elements of array B and C.

Output Format
Print N integers, the elements of array A after performing the program modulo (109+7).

Constraints
1≤N,M≤105
1≤B[i]≤N
1≤A[i],C[i]≤105

Sample Input

4 3
1 2 3 4
1 2 3
13 29 71

Sample Output

13 754 2769 1508    


 */

import java.math.BigInteger;
import java.util.Scanner;

public class SherlockQueries {
	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int _n = n+1;
		int _m = m+1;
		BigInteger[] A = new BigInteger[_n];
		long[] B = new long[_m];
		long[] C = new long[_m];
		System.out.println();
		System.out.println("n="+_n+",m="+_m);
		for(int i=1;i<_n;i++){
			A[i] = new BigInteger(sc.next());
			System.out.print("A="+A[i]+" ");
		}
		System.out.println();
		for(int i=1;i<_m;i++){
			B[i] = sc.nextLong();
			System.out.print("B="+B[i]+" ");
		}
		System.out.println();
		for(int i=1;i<_m;i++){
			C[i] = sc.nextLong();
			System.out.print("C="+C[i]+" ");
		}
		System.out.println();
		for(int i=1;i<_m;i++){
			for(int j=1;j<_n;j++){
				if(j % B[i] == 0){
					A[j] = A[j].multiply(new BigInteger(new Long(C[i]).toString()));
				}
			}
		}
		BigInteger PRIME = new BigInteger("1000000007");
		for(int i=1;i<_n;i++){
			System.out.print(A[i].mod(PRIME)+" ");
		}
	}
}
/*
 *input 1
100 100
84691 84 90310 38506 4420 60522 47731 94325 9896 96263 79445 97489 51951 31545 87475 53968 63438 78537 7775 94328 63340 28121 2156 75467 31502 36991 2643 31932 38409 24712 45895 28197 23355 79694 23857 36426 14575 81221 8580 74432 35902 16480 49218 34067 7354 33447 48152 99080 66466 33792 59980 4784 47202 90629 89200 74934 91757 3497 32501 29211 95728 96221 68417 27328 48511 44965 87010 6504 63982 63676 8399 23492 86568 95922 60016 38674 87940 48153 72167 1449 29302 28333 61868 24593 28607 11431 60717 99835 29355 62034 48772 86918 19022 30739 97925 39679 90081 77068 8325 70607
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
10003 41107 38238 98183 10212 37428 31258 29964 1515 11768 52977 80040 44374 81154 68546 99134 53541 51401 76763 82280 32737 41823 71826 35729 69609 90410 58949 34433 71449 29555 68825 92089 10898 76846 43377 96523 49262 53939 86542 37611 65157 26878 73517 84199 54882 11094 15819 22306 27307 22098 35844 1999 21410 38297 72455 93559 53974 5542 91151 71653 66013 15297 80206 63316 7965 73764 76456 14571 40720 81495 4979 97987 304 99876 4917 18256 44338 93737 68893 45904 58698 53310 97484 45368 1394 47611 11957 43269 58357 27176 54931 73541 38323 94685 85413 2024 16176 89291 52751 35740
*/