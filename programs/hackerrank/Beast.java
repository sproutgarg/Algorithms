package hackerrank;

import java.util.Scanner;

/*
Sherlock Holmes is getting paranoid about Professor Moriarty, his archenemy. All his efforts to subdue Moriarty have been in vain. These days Sherlock is working on a problem with Dr. Watson. Watson mentioned that the CIA has been facing weird problems with their supercomputer, �The Beast�, recently.

This afternoon, Sherlock received a note from Moriarty, saying that he has infected �The Beast� with a virus. Moreover, the note had the number N printed on it. After doing some calculations, Sherlock figured out that the key to remove the virus is the largest �Decent� Number having N digits.

A �Decent� Number has -
1. Only 3 and 5 as its digits.
2. Number of times 3 appears is divisible by 5.
3. Number of times 5 appears is divisible by 3.

Meanwhile, the counter to destruction of �The Beast� is running very fast. Can you save �The Beast�, and find the key before Sherlock?

Input Format
The 1st line will contain an integer T, the number of test cases, followed by T lines, each line containing an integer N i.e. the number of digits in the number 

Output Format
Largest Decent number having N digits. If no such number exists, tell Sherlock that he is wrong and print �-1� 

Constraints
1<=T<=20
1<=N<=100000


Sample Input

4
1
3
5
11
Sample Output

-1
555
33333
55555533333
Explanation
For N=1 , there is no such number. 
For N=3, 555 is only possible number.
For N=5, 33333 is only possible number.
For N=11 , 55555533333 and all of permutations of digits are valid numbers, among them, the given number is the largest one.
 */
public class Beast {
	public static final String FIVE = "555";
	public static final String THREE = "33333";
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(solve(in.nextInt()));
        }
    }
    
    public static String solve(int n){
    	String decent = "-1";
    	System.out.println(n);
    	int fives = n;
    	int threes = 0;
    	while(threes <= n){
    		if(fives % 3==0 && threes % 5 == 0){
    			String str=display(fives,threes);
    			System.out.println(str);
    			return str;
    		}
    		threes += 5;
    		fives = n - threes;
    	}
    	return decent;
    }
    public static String display(int five, int three){
    	System.out.println(five+", "+three);
    	String str = "";
    	while(five > 0){
    		str += FIVE;
    		five = five - 3;
    	}
    	while(three > 0){
    		str += THREE;
    		three = three - 5;
    	}
    	System.out.println(str.length());
    	if(str.length()>0){
    		
    		return str;
    	}else{
    		return "-1";
    	}
    }
    /**
     * big test data are taking too long (> 5 seconds)
     */
    	
}
