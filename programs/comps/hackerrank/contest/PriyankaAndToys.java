/**
 * 
 */
package hackerrank.contest;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ankugarg
 * @question : Your submission will run against only preliminary test cases.
 *           Full test cases will run at the end of the day. Problem Statement
 * 
 *           Little Priyanka visited a kids' shop. There are N toys and their
 *           weight is represented by an array W=[w1,w2,…,wN]. Each toy costs 1
 *           unit, and if she buys a toy with weight w′, then she can get all
 *           other toys whose weight lies between [w′,w′+4] (both inclusive)
 *           free of cost.
 * 
 *           Input Format
 * 
 *           The first line contains an integer N i.e. number of toys. Next line
 *           will contain N integers, w1,w2,…,wN, representing the weight array.
 * 
 *           Output Format
 * 
 *           Minimum units with which Priyanka could buy all of toys.
 * 
 *           Constraints 1≤N≤105 0≤wi≤104,where i∈[1,N] Sample Input
 * 
 *           5 1 2 3 17 10 Sample Output
 * 
 *           3 Explanation
 * 
 *           She buys 1st toy with weight 1 for 1 unit and gets 2nd and 3rd toy
 *           for free since their weight lies between [1,5]. And she has to buy
 *           last two toys separately.
 *
 */
public class PriyankaAndToys {

	private static int partition(int[] arr, int low, int high){
		int pivot = low;
		int i = low; //do not assign low + 1, because it bars from entering in the while loop when the array sample is say 35,45
		// in which case pivot = 0, i=1, j=1 and we will swap pivot and j which is not correct since j was not given the chance to update itself 
		int j = high;
		while(i < j){
			while(arr[i] <= arr[pivot] && i < high)	i++;
			while(arr[j] > arr[pivot])	j--;
			if(i < j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		if(pivot != j){
			int temp = arr[j];
			arr[j] = arr[pivot];
			arr[pivot] = temp;
		}
		return j;
	}
	public static void quickSort(int[] arr, int low, int high){
		if(low < high){
			int breakPoint = partition(arr, low, high);
			quickSort(arr, low, breakPoint - 1);
			quickSort(arr, breakPoint + 1, high);
		}
	}
	
	public static void printArray(int[] arr){
		for(int i : arr)	System.out.print(i + "  ");
	}

	public static void algo(int[] toyWeight) {
		int cost = 0;
		if(toyWeight.length == 0){
			return;
		}
		cost = 1;
		int weight = toyWeight[0];
		for (int i = 1; i < toyWeight.length; i++) {
			if(toyWeight[i] - weight <= 4){
				continue;
			}else{
				weight = toyWeight[i];
				cost++;
			}
		}
		System.out.println("cost : " +cost);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testQuickSort();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] toys = new int[n];
		for(int i = 0;i < n; i++){
			toys[i] = sc.nextInt();
		}
		java.util.Arrays.sort(toys);
		algo(toys);
	}
	private static void testQuickSort(){
		int[] arr = new int[]{160, 150, 140, 135, 35};
		printArray(arr);
		quickSort(arr, 0, arr.length-1);
		System.out.println("\nafter sorting");
		printArray(arr);
	}
}
