package hackerrank;
import java.util.Scanner;
/*
 Insertion Sort is a simple sorting technique which was covered in previous challenges. Sometimes, arrays may be too large for us to wait around for insertion sort to finish. Is there some other way we can calculate the number of times Insertion Sort shifts each elements when sorting an array?

If ki is the number of elements over which ith element of the array has to shift then total number of shift will be k1 + k2 + � + kN.

Input:
The first line contains the number of test cases T. T test cases follow. The first line for each case contains N, the number of elements to be sorted. The next line contains N integers a[1],a[2]�,a[N].

Output:
Output T lines, containing the required answer for each test case.

Constraints:
1 <= T <= 5
1 <= N <= 100000
1 <= a[i] <= 1000000

Sample Input:

2  
5  
1 1 1 2 2  
5  
2 1 3 1 2
Sample Output:

0  
4   
Explanation
First test case is already sorted therefore there�s no need to shift any element. In second case it will proceed in following way.

Array: 2 1 3 1 2 -> 1 2 3 1 2 -> 1 1 2 3 2 -> 1 1 2 2 3
Moves:   -        1       -    2         -  1            = 4
 */
public class InsertionSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[] ar = new int[n];
            for(int j=0;j<n;j++){
                ar[j]=in.nextInt();
                //System.err.println(ar[j]);
            }
            long c = insertionSort(ar);      
            System.out.println(c);
        }
    }
    
    public static long insertionSort(int[] arr){
    	long shifts = 0;
    	for(int j = 1; j < arr.length; j++){
    		int key = arr[j];
    		int i = j-1;
    		while((i>-1)&&(arr[i]>key)){
    			arr[i+1] = arr[i];
    			i--;
    			shifts++;
    			//System.out.print(shifts+"-->");display(arr);
    		}
    		arr[i+1] = key;
    	}
    	return shifts;
    }
    
    public static void display(int[] arr){
    	for(int i: arr){
    		System.out.print(i+" ");
    	}
    	System.out.println();
    }
}
