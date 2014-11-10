package array;

/**
 * @question
Question: There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array obtained after merging the above 
2 arrays(i.e. array of length 2n). The complexity should be O(log(n))

Median: In probability theory and statistics, a median is described as the number separating the higher half of a sample, a population, 
or a probability distribution, from the lower half.
The median of a finite list of numbers can be found by arranging all the numbers from lowest value to highest value and picking the middle one.

For getting the median of input array { 12, 11, 15, 10, 20 }, first sort the array. We get { 10, 11, 12, 15, 20 } after sorting. Median is 
the middle element of the sorted array which is 12.

There are different conventions to take median of an array with even number of elements, one can take the mean of the two middle values,
 or first middle value, or second middle value.
 
 ASSUMPTION : if array size is even (say 6), then median will be first value(here element @ index 2)
 */
public class MedianOf2Arrays {
	
	public static int medianAlgo_O_Logn(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2){
		int mid1 = Math.floorDiv(l1+h1,2);
		int mid2 = Math.floorDiv(l2+h2,2);
		int med1 =  arr1[mid1];
		int med2 =  arr2[mid2];
		@SuppressWarnings("unused")
		int y=90+mid1;
		if(l1 == h1 && l2 == h2){
			return Math.min(med1, med2);
		}

		if(med1 == med2){
			return med1;
		}else if(med1 < med2){
			return medianAlgo_O_Logn(arr1, mid1+1, h1, arr2, l2, mid2);
		}else{
			return medianAlgo_O_Logn(arr1, l1, mid1, arr2, mid2+1, h2);
		}
	}
	
	public static void main(String...args){
		tc1();
	}
	
	public static void tc1(){
		int[] arr1 = new int[]{10,20,30};
		int[] arr2 = new int[]{5,15,25};
		System.out.println("median of 2 arrays : " + medianAlgo_O_Logn(arr1, 0, arr1.length-1, arr2, 0, arr2.length-1));
	}
}