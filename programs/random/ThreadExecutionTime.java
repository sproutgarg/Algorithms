package random;

import java.lang.management.ManagementFactory;

public class ThreadExecutionTime {

	public static void main(String... args) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
		}
		long nanos = ManagementFactory.getThreadMXBean().getThreadCpuTime(
				Thread.currentThread().getId());
		System.out.println(nanos / 1000000000.0);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime / 1000.0);
	}
}