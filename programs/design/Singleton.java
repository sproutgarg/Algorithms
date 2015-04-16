package design;

public  final class Singleton {
	private Singleton(){}
	private static Singleton object = new Singleton();
	public static Singleton getInstance(){
		return object;
	}
}

class Test{
	public static void main(String...args){
		System.out.println(Singleton.getInstance());
	}
}