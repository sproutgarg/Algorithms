package string;

/**
 * @question :
 * given a binary string consisting of only 1s  and 0s,
 * this string also contains multiple placeholder say ? randomly positioned to hold 1 or 0
 * write a program that takes such input and prints all possible 
 * binary strings possible as a result of replacement of '?' by 1 or 0.
 * 
 * @author ankugarg
 *
 */
public class Debendra {
	public static void combinations(StringBuilder bs, int i){
		while(i <= bs.length()-1 && bs.charAt(i) != '?'){
			i++;
		}
		if(i >= bs.length()){
			System.out.println(bs);
			return;
		}
		StringBuilder bs0 = new StringBuilder(bs);
		bs0.setCharAt(i, '0');
		StringBuilder bs1 = new StringBuilder(bs);
		bs1.setCharAt(i, '1');
		combinations(bs0, i + 1);
		combinations(bs1, i + 1);
	}
	public static void main(String...args){
		StringBuilder s1 = new StringBuilder("11");
		StringBuilder s2 = new StringBuilder("????");
		StringBuilder s3 = new StringBuilder("?");
		StringBuilder s4 = new StringBuilder("");
		StringBuilder s5 = new StringBuilder("?0?");
		combinations(s1,0);
	}
}