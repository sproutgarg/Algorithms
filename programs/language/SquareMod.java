package language;

import java.math.BigInteger;

public class SquareMod {
	public static void main(String[] args){
		long lStartTime = System.nanoTime();
		//some tasks

		BigInteger n = new BigInteger("2070");
		final BigInteger CONSTANT_ADDITION = new BigInteger("45");
		final BigInteger CONSTANT_MOD = new BigInteger("1000000007");
		 
		long LIMIT0 = 100L;
		long LIMIT1 = 10000L;
		long LIMIT2 = 100000000L;
		n = new BigInteger("45");
		for(long i = 3; i <=100L; i++){
			n = (n.pow(2).add(CONSTANT_ADDITION).mod(CONSTANT_MOD)); 
		}
		System.out.println("F(10000)="+n);
		long lEndTime = System.nanoTime();
		double difference = ((double)lEndTime - lStartTime)/1000000000f;
		System.out.println("Elapsed nanoSeconds: " + difference);
	}
	/**
	 * 2070
4284900
18360368010000
F(10000)=246750277
Elapsed nanoSeconds: 0.012862972

	 */

}
