package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Sid is obsessed about reading short stories. Being a CS student, he is doing some interesting frequency analysis with the books. He has two short story books. He chooses strings having length a from the first book and strings having length b from the second one. The strings are such that the difference of length is <= 1

i.e.

|a-b|<=1, where |x| represents the absolute value of x.
He believes that both the strings should be anagrams based on his experiment. Your challenge is to help him find the minimum number of characters of the first string he needs to change to make it an anagram of the second string. He can neither add a character nor delete a character from the first string. Only replacement of the original characters with the new ones is allowed.

Input Format

The first line will contain an integer T representing the number of test cases. Each test case will contain a string having length (a+b) which will be concatenation of both the strings described above in the problem. The string will only contain small letters and there will be no spaces in the string.

Output Format

An integer corresponding to each test case is printed in a different line i.e., the number of changes required for each test case. Print �-1� if it is not possible.

Constraints

1<=T<=100
length of input string i.e. 1<=a+b<=10000

Sample Input

5
aaabbb
ab
abc
mnop
xyyx
Sample Output

3
1
-1
2
0 
Explanation

In fifth test case, first string will be �xy� while second string will be �yx� . so a = 2 and b = 2, where a and b are length of strings. As we can see that a and b are following relation

|a-b|<=1
and both strings are anagrams.So number of changes required = 0.
 */
public class SidAnagram {

	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			String str = sc.next();
			System.out.println(minChange(str));
		}
	}
	public static int minChange(String str){
		str = str.toLowerCase();
		int[] alphabets = new int [26];
		Arrays.fill(alphabets, 0);
		if(str.length() % 2 != 0){
			return -1;
		}else{
			String a = str.substring(0, str.length()/2);
			String b = str.substring(str.length()/2);
			//System.out.println(a+","+b);
			char[] ach = a.toCharArray();
			char[] bch = b.toCharArray();
			
			
			for(int i=0;i<ach.length;i++){
				alphabets[ach[i]-'a']++;
				alphabets[bch[i]-'a']--;
			}
			int count = 0;
			int alpha = 97;
			for(int i : alphabets){
				//System.out.print((char)alpha+":"+i+",");
				if(i>0){
					count +=i;
				}
				alpha++;
			}
			System.out.println();
			if(count > 0 ){
				return count;
			}else{
				return -1;
			}
		}
	}
}
/*
can be easily solved in O(N),
use 2 arrays for storing occurence of the alphabet and then compare the 2 arrays of length 26.
all done in O(N).
*/