package dp;

public class UglyNumber {
	/**
	 * the below algorithm is not accurate, as it gives 14 also as an ugly number
	 * TC = O(N) 
	 * SC = O(N)
	 * @param N
	 */
	public static void generateUglyNumber(final int N){
		int i2 = 1;
		int i3 = 1;
		int i5 = 1;
		int[] uglyNumber = new int[N];
		uglyNumber[0] = 1;
		int next_multiple_of_2 = 2;
		int next_multiple_of_3 = 3;
		int next_multiple_of_5 = 5;
		int nextNumber;
		for(int i=1;i<N;i++){
			nextNumber = java.lang.Math.min(java.lang.Math.min(next_multiple_of_2, next_multiple_of_3), next_multiple_of_5);
			
			uglyNumber[i] = nextNumber;
			System.out.println("u#"+i+" = "+uglyNumber[i]);
			
			if(nextNumber == next_multiple_of_2){
				i2++;
				next_multiple_of_2 = i2 * 2;
			}
			if(nextNumber == next_multiple_of_3){
				i3++;
				next_multiple_of_3 = i3 * 3;
			}
			if(nextNumber == next_multiple_of_5){
				i5++;
				next_multiple_of_5 = i5 * 5;
			}
		}
	}
	public static void main(String...args){
		generateUglyNumber(20);
	}
}
