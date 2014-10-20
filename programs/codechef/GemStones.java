package codechef;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GemStones {

	public static void main(String...args){

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//Integer.parseInt(sc.nextLine());
		//System.out.println(n);
		sc.nextLine();
		Set<String> gemElement = new HashSet<>(Arrays.asList(sc.nextLine().split("")));
		//System.out.println(gemElement);
		while(n-->1){
			Set<String> s = new HashSet<>(Arrays.asList(sc.nextLine().split("")));
			//System.out.println(s);
			gemElement.retainAll(s);
		}
		System.out.println(gemElement.size() - 1);
		sc.close();
		
		
		/*String str1 = "abcdde";
		String str2 = "baccd";
		String str3 = "eeabg";
		
		Set<String> s1 = new HashSet<String>(Arrays.asList(str1.split("")));

		Set<String> s2 = new HashSet<String>(Arrays.asList(str2.split("")));
		
		Set<String> s3 = new HashSet<String>(Arrays.asList(str3.split("")));

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		Set<String> gemElements = new HashSet<>(s1);
		gemElements.retainAll(s2);
		gemElements.retainAll(s3);
		System.out.println(gemElements);
		System.out.println(gemElements.size() - 1);
		/*
		System.out.println(Collections.disjoint(s1, s2));
		Set<String> common = new HashSet<String>(s1);
		common.retainAll(s2);
		System.out.println(common);
		String rock ="asjdo";
		String[] str = rock.split("");
		List<String> l = Arrays.asList(str);
		Set s = new HashSet(l);
		System.out.println(l);
		System.out.println(s);*/		
	}
}