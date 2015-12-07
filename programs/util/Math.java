package util;
/**
 * @author ankugarg
 *
 */
public class Math {

	/**
	 * TC : O(n)
	 * @param n
	 * @return
	 */
	public static long factorial(long n){
		long f = 1L;
		//n! for n<0 is undefined, but still returning '0' for sake of easiness
		if(n<0) return 0L;
		if(n==0 || n==1) return f;
		
		while(n > 1){
			f *= n--;
		}
		return f;
	}
	
	/**
	 * TC : O(n)
	 * @param n
	 * @param r
	 * @return
	 */
	public static long nCr(long n, long r){
		//will return zero if below standard condition is not met
		if(r < 0 || n < 0 || n < r) return 0L;
		long numerator = factorial(n);
		long denominator = factorial(n-r) * factorial(r);
		return numerator/denominator;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("factorial : " + factorial(6));
		System.out.println("nCr : " + nCr(3, 3));
	}

}
