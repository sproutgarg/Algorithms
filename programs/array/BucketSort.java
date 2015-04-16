package array;

/**
 * 
 * @author ankugarg
 * @question
Bucket sort is mainly useful when input is uniformly distributed over a range. For example, consider the following problem. 
Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly distributed across the range. How do we sort the numbers efficiently?

A simple way is to apply a comparison based sorting algorithm. The lower bound for Comparison based sorting algorithm (Merge Sort, Heap Sort, Quick-Sort .. etc) is \Omega(nLogn), i.e., they cannot do better than nLogn.
Can we sort the array in linear time? Counting sort can not be applied here as we use keys as index in counting sort. Here keys are floating point numbers. 
The idea is to use bucket sort. Following is bucket algorithm.

bucketSort(arr[], n)
1) Create n empty buckets (Or lists). --> O(n)
2) Do following for every array element arr[i].  
.......a) Insert arr[i] into bucket[n*array[i]]  --> O(1)
3) Sort individual buckets using insertion sort.   --> O(n) [in doubt ?] try using different algo for sorting or ordering or use ordered data structure like treeSet
4) Concatenate all sorted buckets.   --> O(n)
 *
 */
public class BucketSort {

}
