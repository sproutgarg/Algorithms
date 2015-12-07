package mathematical;

public class Factorial {
	private static final int MAX = 200; 
	private int[] result;
	private int n;
	private int x;
	Factorial(int _n){
		if(n < 0){
			throw new IllegalArgumentException("Factorial cannot be calculated to negative integers");
		}
		this.n = _n;
		result = new int[MAX];
		x = 0;
		result[0] = 1;
	}
	public String calculate(){
		for(int i = 2; i <= n; i++){
			int carry = 0;
			int j;
			for(j = 0; j <= x || carry > 0; j++){
				int f = i * result[j];
				result[j] = (carry + f) % 10;
				carry = (carry + f) / 10;
			}
			x = j-1;
		}
		
		StringBuffer str = getString();
		
		return str.reverse().toString();
	}
	
	public StringBuffer getString(){
		StringBuffer str = new StringBuffer("");
		for(int i = 0; i <= x; i++){
			str.append(result[i]);
		}
		return str;
	}
	
	public static void main(String..._args){
		System.out.println(new Factorial(10).calculate());
		System.out.println(new Factorial(20).calculate());
		System.out.println(new Factorial(30).calculate());
		System.out.println(new Factorial(40).calculate());
		System.out.println(new Factorial(50).calculate());
		System.out.println(new Factorial(60).calculate());
		System.out.println(new Factorial(70).calculate());
		System.out.println(new Factorial(80).calculate());
		System.out.println(new Factorial(90).calculate());
		System.out.println(new Factorial(100).calculate());
	}	
}
/*
 * 1. why cannot Java arrays be initialized with long size, why only int size is allowed ?
 * 2. what happens when N itself cannot be stored in primitive data types ? what is underline implementation of BigInteger in those cases ?
 * 
 */