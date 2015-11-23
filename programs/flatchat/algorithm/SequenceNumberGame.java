package flatchat.algorithm;

import java.math.BigInteger;

public class SequenceNumberGame {
	
	public static void main(String[] args) {
		long lStartTime = System.nanoTime();
		
		final BigInteger CONSTANT_ADDITION = new BigInteger("45");
		final BigInteger CONSTANT_MOD = new BigInteger("1000000007");
		// You are given F(2) = 45, F(4) = 4284990, F(100) = 26365463243.
		
		final BigInteger F_100 = new BigInteger("26365463243");
		final long N1 = 10000L;
		final long N2 = 100000000L;
		BigInteger n = F_100;
		for(long i = 101; i <= N1; i++){
			n = (n.pow(2).add(CONSTANT_ADDITION).mod(CONSTANT_MOD)); 
		}
		System.out.println("F(10000)="+n);
		
		for(long i = N1; i <= N2; i++){
			n = (n.pow(2).add(CONSTANT_ADDITION).mod(CONSTANT_MOD)); 
		}
		System.out.println("F(100000000)="+n);
		
		long lEndTime = System.nanoTime();
		double elapsedTime = ((double)lEndTime - lStartTime)/1000000000f;
		System.out.println("Elapsed Seconds: " + elapsedTime);
//		F(10000)=882761082
//		F(100000000)=665649875
//		Elapsed Seconds: 11.572281569
	}
}