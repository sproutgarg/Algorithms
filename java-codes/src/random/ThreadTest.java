package random;

class Car implements Runnable{
	public synchronized void brake(){
		System.out.println("brake");
		System.out.println("thread name = " + Thread.currentThread().getName());
		try{
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			System.out.println("brake woke up");
		}
	}
	public synchronized void accelerate(){
		System.out.println("accelerate");
		System.out.println("thread name = " + Thread.currentThread().getName());
	}
	@Override
	public void run() {
		brake();
	}
}

public class ThreadTest {
	public static void main(String...qwe){
		Car c = new Car();
		Thread t1 = new Thread(c, "thread-1");
		Thread t2 = new Thread(c, "thread-2");
		t1.start();
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			System.out.println("main thread awake now");
		}
		c.accelerate();
	}
}