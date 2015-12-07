package hackerrank.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/*
 This problem is a programming version of Problem 1 from projecteuler.net

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below N.

Input Format 
First line contains T that denotes the number of test cases. This is followed by T lines, each containing an integer, N.

Output Format 
For each test case, print an integer that denotes the sum of all the multiples of 3 or 5 below N.

Constraints 
1≤T≤105 
1≤N≤109

Sample Input

2
10
100
Sample Output

23
2318
 */
public class Multiples {
	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
		Map<Long, Long> cache = new HashMap<Long, Long>();
		TreeSet<Long> keys = new TreeSet<Long>();
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			long sum = 0;
			long n = sc.nextLong();
			Long _n = keys.lower(n);
			if(_n != null){
				sum = cache.get(_n);
			}else{
				_n = 0L;
			}
			for(long j=_n;j<n;j++){
				if(j%3==0){
					sum +=j;
				}else if(j%5 == 0){
					sum +=j;
				}
			}
			keys.add(n);
			cache.put(n, sum);
			
		/*	int j=3;
			int fiveMultiples = 5;
			while(j<n){
				sum += j;
				if(fiveMultiples < j){
					if(fiveMultiples % 3 != 0){
						sum += fiveMultiples;
					}
					fiveMultiples += 5;
				}
				j = j + 3;
			}
			j = j - 3;
			
			while(j<n){
				if(j%5 == 0){
					sum += j;
					break;
				}
				j++;
			}*/
			System.out.println(sum);
		}
		System.out.println("cache=>"+cache);
		System.out.println("keys"+keys);
		
	}
	/*
	 * pythonic way
		def summ(a, b):
    		return b*((a-1)//b)*((a-1)//b+1)/2
    	sum(a,3)+sum(a,5)-sum(a,15)
	 */
}