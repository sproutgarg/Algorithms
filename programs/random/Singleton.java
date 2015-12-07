package random;

/**
 * @question : write a singleton class
 * @author ankugarg
 * @Concept:
 * A Singleton class' instance remains unchanged through out the life cycle of application
 * that means applications can have only one object of that class
 * 
 */
public class Singleton {

	private Singleton(){
	}

	private static Singleton s;
	/**
	 * Static blocks are loaded into static memory 
	 * when compiler first comes across the class name
	 * and it remains loaded till the end of the application 
	 */
	static{
		s = new Singleton();
	}

	public static Singleton getSingleton(){
		return s;
	}

	public static void main(String[] args){
		System.out.println(Singleton.getSingleton());
		System.out.println(Singleton.getSingleton());
		System.out.println(Singleton.getSingleton());
	}
}