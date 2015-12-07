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
	
	/**
	 * Divide and Conquer approach
	 * @param arr1
	 * @param l1
	 * @param h1
	 * @param arr2
	 * @param l2
	 * @param h2
	 * @return
	 * TC : O(logN)
	 */
	public static int medianAlgo_O_Logn(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2){

		//negative base case
		if(l1 > h1){
			return -1;
		}
		
		int mid1 = Math.floorDiv(l1+h1,2);
		int mid2 = Math.floorDiv(l2+h2,2);
		int med1 =  getMedian(arr1, l1, h1);
		int med2 =  getMedian(arr2, l2, h2);
		int length = h1-l1+1;

		if(l1 == h1 && l2 == h2){
			return (med1+med2)/2;
		}

		if(med1 == med2){
			return med1;
		}else if(h1-l1 == 1 && h2-l2 == 1){
			return (Math.max(arr1[l1], arr2[l2])+Math.min(arr1[h1], arr2[h2])) / 2;
		}
		else if(med1 < med2){
			if(length%2 == 0){
				return medianAlgo_O_Logn(arr1, mid1+1, h1, arr2, l2, mid2);
			}
			else{
				return medianAlgo_O_Logn(arr1, mid1, h1, arr2, l2, mid2);
			}
		}else{
			if(length%2 == 0){
				return medianAlgo_O_Logn(arr1, l1, mid1, arr2, mid2+1, h2);
			}
			else{
				return medianAlgo_O_Logn(arr1, l1, mid1, arr2, mid2, h2);
			}
		}
	}
	
	public static float medianAlgo_O_n(int[] arr1, int[] arr2){
		int count = 0;
		int previous = 0, current = 0;
		int i=0,j=0;
		while(count <= arr1.length && i < arr1.length && j < arr2.length){
			previous = current;
			if(arr1[i] < arr2[j]){
				current = arr1[i++];
			}
			else if(arr1[i] > arr2[j]){ 
				current = arr2[j++];
			}
			else{
				current = arr1[i];
				i++;
				j++;
			}
			count++;
		}
		return (previous+current)/2.0f;
	}
	
	public static int getMedian(int [] arr, int start, int end){
		if(start > end){
			return -1;
		}
		
		if(start == end){
			return arr[start];
		}
		int mid = (start +  (end-start)/2);
		if((end-start)%2 ==0 ){//ODD array size
			return arr[mid];
		}else{
			return (arr[mid]+arr[mid+1])/2;
		} 
	}
	
	public static void main(String...args){
		tc1();
		//tc2();
	}
	
	
	public static void tc2(){
		int[] arr1 = new int[]{10,20,30};
		int[] arr2 = new int[]{10,25,30,60};
		System.out.println("median1="+getMedian(arr1, 0, arr1.length-1));
		System.out.println("median2="+getMedian(arr2, 0, arr2.length-1));
	}
	
	public static void tc1(){
		int[] arr1 = new int[]{10,22,30,50};
		int[] arr2 = new int[]{5,15,25,70};
		System.out.println("median of 2 arrays : " + medianAlgo_O_Logn(arr1, 0, arr1.length-1, arr2, 0, arr2.length-1));
		
		//System.out.println("median of 2 arrays : " + medianAlgo_O_n(arr1, arr2));
	}
}
