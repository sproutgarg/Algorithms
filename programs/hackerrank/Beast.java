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

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int tc=in.nextInt();
        for(int i=0;i<tc;++i){
            int num=in.nextInt();
            int reme=(num%15)%3;
            int five=0;
            if(reme==1)
                five=10;
            else if(reme==2)
                five=5;
            int three=num-five;
            int pt=three/3;
            int pf=five/5;
            if(five<0 || three<0)
                System.out.print("-1");
            else{
                for(int j=0;j<pt;++j)
                    System.out.print("555");
                for(int k=0;k<pf;++k)
                    System.out.print("33333");
            }
            System.out.println();
        }
    }
}
    /**
     * big test data are taking too long (> 5 seconds)
     */
     
   /** www.github.com/Pulkit07
      * Problem solved by using a simpler algorithm.
      * Now each test is taking maximum 2.27 sec.
      * /
