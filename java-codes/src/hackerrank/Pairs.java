package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Given N integers, count the number of pairs of integers whose difference is K.

Input Format 
The 1st line contains N & K (integers). 
The 2nd line contains N numbers of the set. All the N numbers are distinct.

Output Format 
An integer that tells the number of pairs of integers whose difference is K.

Constraints: 
N <= 105 
0 < K < 109 
Each integer will be greater than 0 and at least K smaller than 231-1

Sample Input #00:

5 2  
1 5 3 4 2  
Sample Output #00:

3
Sample Input #01:

10 1  
363374326 364147530 61825163 1073065718 1281246024 1399469912 428047635 491595254 879792181 1069262793B 
Sample Output #01:

0
 */
public class Pairs {
    static int pairs(int[] a,int k) {
      /* Complete this function */
    	int count =0;
    	for(int i=0;i<a.length-1;i++){
    		for(int j=i+1;j<a.length;j++){
    			if(Math.abs(a[i]-a[j]) == k){
    				count++;
    			}
    		}
    	}
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}