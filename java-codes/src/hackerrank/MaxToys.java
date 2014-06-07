package hackerrank;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
Mark and Jane are very happy after having their first kid. Their son is very fond of toys, so Mark wants to buy some. There are N different toys lying in front of him, tagged with their prices, but he has only $K. He wants to maximize the number of toys he buys with this money.

Now, you are Mark’s best friend and have to help him buy as many toys as possible.

Input Format
The first line will contain two inputs N and K, followed by a line containing N integers separated by a single space indicating the products’ prices.

Output Format
Maximum number of toys Mark can buy for his son.

Constraints
1<=N<=105
1<=K<=109
1<=price of any toy<=109
A toy can’t be bought multiple times.

Sample Input

7 50
1 12 5 111 200 1000 10

Sample Output

4

Explanation

He can buy only 4 toys at most. These toys have the following prices: 1,12,5,10.
 */
public class MaxToys {
    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt(),k=stdin.nextInt();
        
        PriorityQueue<Integer> priceList = new PriorityQueue<Integer>();//n, integerComparator);
        for(int i=0;i<n;i++) 
        		priceList.add(stdin.nextInt());
        int sum = 0;
        int count = 0;
        
        while(!priceList.isEmpty()){
        	int price = priceList.poll();
        	if(sum + price <= k ){
        		sum += price;
        		count++;
        	}else{
        		break;
        	}
        }
        System.out.println(count);
    }
}
