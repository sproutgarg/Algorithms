package random;

import java.math.BigInteger;

public class BinaryINput {
	public static void main(String...args){
		String s1 = "10101";
		String s2 = "10010";
		int x = Integer.parseInt(s1, 2);
		int y = Integer.parseInt(s2, 2);
		System.out.println(x+" OR "+y+"="+(x|y));
		double max = Math.pow(2, 1000);
		BigInteger n1 = new BigInteger(s1, 2);
		n1.shiftRight(1);// doesn't changes the object instead returns new BigInteger object
		BigInteger n2 = new BigInteger(s2, 2);
		BigInteger or = n1.or(n2);
		System.out.println(n1.toString()+" | "+n2.toString()+" = "+or.toString());
		System.out.println(countOnes(n1));
	}
	public static int countOnes(BigInteger n){
		int ones = 0;
		while(!n.equals(BigInteger.ZERO)){
			if((n.and(BigInteger.ONE)).equals(BigInteger.ONE)){
				ones++;
			}
			n = n.shiftRight(1);
		}
		return ones;
	}
}
