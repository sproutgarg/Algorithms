package string;

public class Util {

	/**
	 * KMP Algorithm TC : O(n)
	 * @param p  length = n
	 * @param s  length = m
	 * @return false if 's' is not present in 'p'
	 * return true if present
	 */
	public static boolean subString(String p, String s){
		return false;
	}
	
	/**
	 * TC : O(a.length * c.length) QUADRATIC
	 * SC : O(n)
	 * Let say a="abc", b="b", c="xyz"
	 * @param a : string where replacement has to happen
	 * @param b : substring to be replaced within a 
	 * @param c : replacing substring
	 * @return
	 */
	public static char[] replace(char[] a, char[] b, char[] c){
		char[] r = new char[a.length * c.length];
		char[] temp = new char[a.length];
		int j=0;//b's index
		int l=0;//r's index
		int t=0;//temp's index
		for(int i=0; i < a.length; i++){
			temp[t++] = a[i];
			if(a[i] == b[j]){
				j++;
				if(j==b.length){//match found
					//copy 'c' to 'r'
					for(char ch : c){
						r[l++] = ch;
					}
					//reset temp's index
					t=0;
					j=0;
				}
			}else{				//match not found
				//copy 'a' aka 'temp' to 'r'
				for(int k=0;k<t;k++){
					r[l++] = temp[k];
				}
				//reset b's index
				j=0;
				t=0;
			}
		}
		//copy remaining string of 'a' aka 'temp' to 'r'
		for(int k=0;k<t;k++){
			r[l++] = temp[k];
		}
		return r;
	}
	
	public static void main(String...arg){
		char[] a = {'a', 'b', 'c', 'b', 'd'};
		char[] b = {'b'};
		char[] c = {'x', 'y', 'z'};
		for(char ch : replace(a, b, c)){
			System.out.print(ch);
		}
	}
}