package array;

import java.math.BigInteger;

/**
 * Question:
 * Find the largest modulo 7 subarray in a given array of positive elements
 * @author ankugarg
 * Example:
 * 1 2 4 5 1 2 3 

use kadane's algorithm to find the largest sum subarray

tweak it to have updation of sum only when sum is modulo 

2 3 1 7 => 2,3,1 [6]

20 30 10 70 
20 50 60 130
6  1  4  4


2 1 1 6  => 6   [6]

3 0 0 5 4  => 3,0,0,5,4    [5]

3 0 0 5 5 => 3,0,0,5,5      [6]

 *
 */
public class Modulo7 {

	
	//O(n*n)
	public static int largestModulo7(int[] arr){
		BigInteger[] _arr = new BigInteger[arr.length];
		final BigInteger SEVEN = new BigInteger("1804289384");
		for(int i=0;i<arr.length;i++){
			_arr[i] = new BigInteger(Integer.toString(arr[i]));
		}

		int max = 0, sum = 0;
		for(int i=0;i<_arr.length;i++){
			sum = 0;
			for(int j=i;j<_arr.length; j++){
				sum += _arr[j].mod(SEVEN).intValue();
				if(sum % SEVEN.intValue() > max){
					max = sum%SEVEN.intValue();
				}
			}
		}
		return max;
	}
	public static void main(String...args){
		int [] arr = new int[]{2,1,1,6};
		System.out.println(largestModulo7(arr));
		System.out.println(largestModulo7(new int[]{3,0,0,5,4}));
		System.out.println(largestModulo7(new int[]{2,3,1,7}));
		System.out.println(largestModulo7(new int[]{3,0,0,5,5}));
		int[] deb = new int[]{846930887,1681692778,1714636916,1957747794,424238336,719885387,1649760493,596516650,1189641422,1025202363,1350490028,783368691,1102520060,2044897764,1967513927,1365180541,1540383427,304089173,1303455737,35005212,521595369,294702568,1726956430,336465783,861021531,278722863,233665124,2145174068,468703136,1101513930,1801979803,1315634023,635723059,1369133070,1125898168,1059961394,2089018457,628175012,1656478043,1131176230,1653377374,859484422,1914544920,608413785,756898538,1734575199,1973594325,149798316,2038664371,1129566414};
		System.out.println("size of deb : " + deb.length);
		System.out.println(largestModulo7(deb));
	}
}
