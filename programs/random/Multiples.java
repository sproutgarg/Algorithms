package random;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * 
 * @author ankugarg
 * @question : Numbers ending in 3 have at least one multiple having all ones.
 *           for eg., 3 and 13 have amultiples like 111 and 111111 respectively.
 *           Given such a no. , find the smallest such multiple of that number.
 *           The multiple can exceed the range of int, long. You cannot use any
 *           complex data structure.
 */

public class Multiples {

	public static void algo(int n){
		int count=1, rem=1;
		if(n%10 != 3){
			return;
		}
		while(rem>0)
		{
		 rem= (rem*10+1)%n; 
		 count++;
		} 
		 while(count-->0){ System.out.print("1");}
		 System.out.println();
	}
	public static void main(String...args){
		algo(3);
		algo(13);
		algo(23);
		algo(24);
	}
	
}
