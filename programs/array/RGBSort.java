package array;

/**
 * @question : An array contains 3 types of ball colored red, blue, green
 * in an unordered fashion, write a program to sort them such that 
 * same color balls appear in a contiguous sequence
 * @author ankugarg 
 */
public class RGBSort {
	
	/**
	 * Applying quick sort partitioning algorithms
	 * @param arr
	 */
	public static void sort(char[] arr){
		int rEnd = partition(arr, 'r',  0, arr.length-1);
		System.out.println(rEnd);
		System.err.println(partition(arr, 'g', rEnd, arr.length-1));
	}
	private static int partition(char[] arr, char ch, int low, int high){
		
		int pivot = low;
		int i = low + 1;
		int j=high;
		while(i<=j){
			while(arr[i] == ch){
				i++;
			}
			while(arr[j] != ch){
				j--;
			}
			if(i<j){
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		if(i > j){
			char temp = arr[j];
			arr[j] = arr[pivot];
			arr[pivot] = temp;
		}
		return j;
	}
	
	public static void main(String...arg){
		char[] balls = {'b', 'r', 'b', 'g', 'r', 'b', 'g', 'g', 'r', 'g'};
		displayArray(balls);
		sort(balls);
		displayArray(balls);
	}
	private static void displayArray(char[] arr){
		for(char ch : arr){
			System.out.print(ch + " ");
		}
		System.out.println();
	}

}