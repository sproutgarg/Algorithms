package string;

import java.io.IOException;

public class PrintReverseString {
	
	public static void main(String...args) throws IOException{
		String input = "";
		java.io.InputStreamReader in = new java.io.InputStreamReader(System.in);
		int ch;
		while((ch =  in.read()) != -1){
			input +=(char)ch;
			System.out.println(input);
		}
	}
}