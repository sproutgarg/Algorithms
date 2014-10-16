package hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Given two integers: L and R,

find the maximal values of A xor B given, L <= A <= B <= R

Input Format
The input contains two lines, L is present in the first line. 
R in the second line.

Constraints
1 <= L <= R <= 1000

Output Format
The maximal value as mentioned in the problem statement.

Sample Input

1
10
Sample Output

15
Explanation

The maximum value can be obtained for A = 5 and B = 10,

1010 xor 0101 = 1111 hence 15.
 */
public class MaximumXOR {
/*
 * Complete the function below.
 */

    static int maxXor(int l, int r) {
    	int max = 0;
    	for(int x = l; x<=r; x++){
    		for(int y=x; y<=r; y++){
    			if(max < (x^y)){
    				max = x^y;
    			}
    		}
    	}
    	return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }
}