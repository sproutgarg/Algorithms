package hackerrank.contest;

import java.math.BigInteger;
import java.util.Scanner;

/*
This problem is a programming version of Problem 3 from projecteuler.net

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of a given number N?

Input Format 
First line contains T, the number of test cases. This is followed by T lines each containing an integer N.

Output Format 
For each test case, display the largest prime factor of N.

Constraints 
1≤T≤10 
10≤N≤1012
 */
public class LargestPrimeFactor {
	public static final BigInteger TWO = new BigInteger("2");
	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			BigInteger n = new BigInteger(sc.next());
			BigInteger j = new BigInteger("2");
			BigInteger max = BigInteger.ONE;
			BigInteger limit = n.divide(TWO);
			//System.out.println(limit.toString());
			while(j.compareTo(n) < 0){
				 j = j.add(BigInteger.ONE);
				 //System.out.println(j.toString()+","+max.toString()+"-->"+j.isProbablePrime(100000)+"&&"+n.remainder(j).equals(BigInteger.ZERO)+"&&"+max.compareTo(j));
				 if(j.isProbablePrime(100000) && n.remainder(j).equals(BigInteger.ZERO) && max.compareTo(j) < 0){
					// System.out.println(max.toString());
					 max = j;
				 }
			}
			System.out.println(max.toString());
		}
	}
}