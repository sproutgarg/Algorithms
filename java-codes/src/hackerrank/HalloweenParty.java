package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/*
Alex is attending a Halloween party with his girlfriend Silvia. At the party, Silvia spots a giant chocolate bar. If the chocolate can be served as only 1 x 1 sized pieces and Alex can cut the chocolate bar exactly K times, what is the maximum number of chocolate pieces Alex can cut and give Silvia?

Input Format
The first line contains an integer T, the number of test cases. T lines follow.
Each line contains an integer K

Output Format
T lines. Each line contains an integer that denotes the maximum number of pieces that can be obtained for each test case.

Constraints
1<=T<=10
2<=K<=107

Note
Chocolate needed to be served in size of 1 x 1 size pieces.
Alex can�t relocate any of the pieces. Neither he can place any piece on top of other.

Sample Input #00

4
5
6
7
8
Sample Output #00

6
9
12
16
Explanation
The explanation below is for the first two test-cases. The rest of them follow a similar logic.

For the first test-case where K = 5,You need 3 Horizontal and 2 vertical cuts. 
 */
public class HalloweenParty {

	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			System.out.println(calculateChocolates(sc.nextLong()));
		}
	}
	public static long calculateChocolates(long cuts){
		long chocos = (cuts/2)*(cuts-(cuts/2));
		return chocos;
	}
}
