package hackerrank.contest;
/*


You are given a list of N people who are attending ACM-ICPC World Finals. Each of them are either well versed in a topic or they are not. Find out the maximum number of topics a 2-people team can know. And also find out how many teams can know that maximum number of topics?

Input Format

The first line contains two integers N and M separated by a single space, where N represents the number of people, and M represents the number of topics. N lines follow.
Each line contains a binary string of length M. In this string, 1 indicates that the ith person knows a particular topic, and 0 indicates that the ith person does not know the topic.

Output Format

On the first line, print the maximum number of topics a 2-people team can know.
On the second line, print the number of teams that can know the maximum number of topics.

Constraints

2 ≤ N ≤ 3000 

1 ≤ M ≤ 1000

Sample Input

4 5
10101
11100
11010
00101

Sample Output

5
2

Explanation

(1, 3) and (3, 4) know all the 5 topics. So the maximal topics a 2-people team knows is 5, and only 2 teams can acheive this.


 */



import java.math.BigInteger;
import java.util.Scanner;
public class TopicMember {
	public static void main(String...arg){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		BigInteger[] arr = new BigInteger[n];
		for(int i=0;i<n;i++){
			arr[i] = new BigInteger(sc.next(), 2);
		}
		int max = 0;
		int count = 0;
		for(int i=0;i<n-1;i++){
			for(int j=i+1; j<n; j++){
				int or = countOnes(arr[i].or(arr[j]));
				
				if(max < or){
					max = or;
					count = 1;
				}else if(max == or){
					count++;
				}
				
			}
		}
		System.out.println(max);
		System.out.println(count);
	}
	public static int countOnes(BigInteger n){
		int ones = 0;
		while(!n.equals(BigInteger.ZERO)){
			if((n.and(BigInteger.ONE)).equals(BigInteger.ONE)){
				ones++;
			}
			n = n.shiftRight(1);
		}
		return ones;
	}
}
