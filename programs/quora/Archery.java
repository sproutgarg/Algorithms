package quora;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 * @author ankugarg
 * question 
 * Problem Statement

The Quora engineering team went to an archery offsite recently.

At the training corner, there was a target on the ground with a pile of arrows on it. 
Anna noticed that some of the arrows form the symbol 'Q' by intersecting the rings of the target.

The target is composed of N concentric circles and there are M arrows lying on it, 
each represented as a line segment.

The i-th circle is centered at the origin (0,0) and has radius Ri. 
The i-th arrow is a line segment with endpoints (x1i,y1i) and (x2i,y2i).

Now, Anna wonders if it is possible to write a program to quickly count the number of 'Q's formed. 
A 'Q' is defined as a pair of a circle and an arrow such that the arrow 
intersects the circumference of the circle exactly once.

For simplicity, no endpoint of an arrow will lie on any circle, and no arrow will be tangent to a circle.

Constraints

For 100% of the test data, 1≤N,M≤105
For 50% of the test data, 1≤N,M≤103
All the Ri are less than 106 and greater than 0

All the coordinates are less than 106 by absolute value

Input Format

Line 1: One integer N
Line 2: N integers, Ri (the radii of the circles)

Line 3: One integer M
Line 4...M+3: Line 3+i contains 4 integers: x1i, y1i, x2i, y2i, the coordinates of the endpoints of the i-th arrow.

Output Format

Line 1: One integer, the number of 'Q's.

Sample Input

4
1 2 3 4
3
1 -1 4 -3
2 1 1 2
1 -2 3 -4
Sample Output

5
 */
public class Archery {
	public static int getEncapsulatingCircle(BigInteger[] arr, BigInteger x){
		if(arr == null || arr.length ==0){
			return 0;
		}
		int mid;
		int low = 0;
		int high = arr.length - 1;
		while(low < high){
			mid = (low + high)/2;
			if(arr[mid].compareTo(x) < 0 && x.compareTo(arr[mid+1]) <= 0){
				return mid+1;
			}else if(arr[mid].compareTo(x) > 0){
				high = mid;
			}else if(arr[mid+1].compareTo(x) < 0){
				low = mid;
			}
		}
		return arr.length;
	}
	public static void main(String...args) throws FileNotFoundException{
		Scanner sc = new Scanner(new java.io.FileInputStream(new java.io.File("quora_/input15.txt")));
		int n = sc.nextInt();
		BigInteger arr[] = new BigInteger[n+2];
		arr[0] = BigInteger.ZERO;
		arr[n+1] = new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999");
		java.util.Set<BigInteger> s = new java.util.HashSet<BigInteger>();
		for(int i=1;i<=n;i++){
			BigInteger temp = new BigInteger(sc.next());
			arr[i] = temp.multiply(temp);
			if(!s.add(arr[i])){
				System.out.println("same radius detected for "+ temp);
			}
//			System.out.println(arr[i]);
		}
		java.util.Arrays.sort(arr);
		int m = sc.nextInt();
		int count = 0;
		for(int i=0;i<m;i++){
			BigInteger x1 = new BigInteger(sc.next());
			BigInteger y1 = new BigInteger(sc.next());
			BigInteger x2 = new BigInteger(sc.next());
			BigInteger y2 = new BigInteger(sc.next());
			
			BigInteger s1 = x1.multiply(x1).add(y1.multiply(y1));
			BigInteger s2 = x2.multiply(x2).add(y2.multiply(y2));
			if(s1.compareTo(BigInteger.ZERO)< 0 || s2.compareTo(BigInteger.ZERO)< 0){
				System.out.println("long overflow for points : " + x1+","+y1+"|"+x2+","+y2);
				continue;
			}
			if(s1==s2){
				continue;
			}
			BigInteger p = (s1.compareTo(s2) < 0 ) ? s1 : s2;
			BigInteger q = (s1.compareTo(s2) < 0 ) ? s2 : s1;
			
			int idx1 = getEncapsulatingCircle(arr, p);
			int idx2 = getEncapsulatingCircle(arr, q);
			
			count += java.lang.Math.abs(idx2 - idx1);
			
		}
		System.out.println(count);
	}
}

/**
Failed cases:
input:
(file)quora_/input15

output: 
332421414
1054495732
*/