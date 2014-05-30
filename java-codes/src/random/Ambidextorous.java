package random;

// objective: add the multiplication table of 2 numbers up to 10 counts.
/*
 * for example : numbers are 2, 3 then
 * add 2*n(1..10) and 3*n(1..10)
 * to give the final total 
 * 
 */

public class Ambidextorous{

	int sum;
	int n;
	int m;
	public Ambidextorous() {
		// TODO Auto-generated constructor stub
		sum = 0;
		n = 2;
		m = 3;
	}
	
	public void calculate() throws InterruptedException{
		Runnable nCalulator = new Runnable() {			
			@Override
			public void run() {
				int subTotal = 0;
				int pahada = 0;
				for(int i=1;i<=10;i++){
					pahada = (n*i);
					subTotal += pahada;
					//synchronized (this) {
						sum += pahada;
						System.out.println("Sum now = "+sum+"  @ "+ Thread.currentThread().getName());
					//}
				}
				System.out.println("sub total = "+subTotal+" @ "+Thread.currentThread().getName());
			}
		};

		Thread nTable = new Thread(nCalulator, "N-Calculator");
		
		Runnable mCalculator = new Runnable(){
			@Override
			public void run() {
				int pahada = 0;
				int subTotal = 0;
				for(int i=1;i<=10;i++){
					pahada = (m*i);
					subTotal += pahada;
					//synchronized (this) {
						sum += pahada;
						System.out.println("Sum now = "+sum+"  @ "+ Thread.currentThread().getName());
					//}
				}
				System.out.println("sub total = "+subTotal+" @ "+Thread.currentThread().getName());
			}
		};
		Thread mTable = new Thread(mCalculator, "M-Calculator");
		
		nTable.start();
		mTable.start();
		nTable.join();
		mTable.join();
		System.out.println("Sum now = "+sum+"  @ "+ Thread.currentThread().getName());
	}

	public static void main(String...args) throws InterruptedException{
		Ambidextorous amd = new Ambidextorous();
		amd.calculate();
	}
}
