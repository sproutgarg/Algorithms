package hit_and_try;

public class FileTesting {

	public static void main(String...args){
		try{
			java.io.FileWriter fw = new java.io.FileWriter("c:\\neft_logged");
			String str="abcdef";
			fw.write("handle() called here\n");
			fw.write("stacktrace = "+str);
			fw.close();
		}
		catch(Exception E){
			E.printStackTrace();
		}
	}
}
