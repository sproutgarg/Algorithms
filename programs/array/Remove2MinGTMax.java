package array;

/**
 * 
 * @author ankugarg
 * @question 
Given an unsorted array, trim the array such that twice of minimum is greater than maximum in the trimmed array. 
Elements should be removed either end of the array.

Number of removals should be minimum.

Examples:

arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}
Output: 4
We need to remove 4 elements (4, 5, 100, 200)
so that 2*min becomes more than max.


arr[] = {4, 7, 5, 6}
Output: 0
We don't need to remove any element as 
4*2 > 7 (Note that min = 4, max = 8)

arr[] = {20, 7, 5, 6}
Output: 1
We need to remove 20 so that 2*min becomes
more than max

arr[] = {20, 4, 1, 3}
Output: 3
We need to remove any three elements from ends
like 20, 4, 1 or 4, 1, 3 or 20, 3, 1 or 20, 4, 1
 */
public class Remove2MinGTMax {

	public static int getMin(int[] a, int l, int h){
		int min = a[l];
		for(int i=l;i<=h;i++){
			if(min > a[i]){
				min = a[i];
			}
		}
		return min;
	}

	public static int getMax(int[] a, int l, int h){
		int max = a[l];
		for(int i=l;i<=h;i++){
			if(max < a[i]){
				max = a[i];
			}
		}
		return max;
	}
	
	public static int algo1(int[] arr, int l, int h){
		if(l>=h) return 0;
		int min = getMin(arr, l, h);
		int max = getMax(arr, l, h);
		if(2*min > max){
			return 0;
		}
		return Math.min(algo1(arr, l+1, h), algo1(arr, l, h-1)) + 1;
	}
	
	public static void main(String...args){
		int[] arr1 = new int[] {20, 4, 1, 3};
		System.out.println("min elements to be removed : " + algo1(arr1, 0, arr1.length-1));
		int[] arr2 = new int[] {4, 5, 100, 9, 10, 11, 12, 15, 200};
		System.out.println("min elements to be removed : " + algo1(arr2, 0, arr2.length-1));
		int[] arr3 = new int[] {4, 7, 5, 6};
		System.out.println("min elements to be removed : " + algo1(arr3, 0, arr3.length-1));
		int[] arr4 = new int[] {20, 7, 5, 6};
		System.out.println("min elements to be removed : " + algo1(arr4, 0, arr4.length-1));
	}
}