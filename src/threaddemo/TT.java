package threaddemo;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class TT {

	public static void main(String[] args) {
		Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		// Arrays.stream(array).filter(i->i>5).forEach(i->System.out.println(i));
		Arrays.stream(array).parallel().forEach(i -> System.out.print(i + " "));
		System.out.println();
		Arrays.stream(array).sequential().forEach(i -> System.out.print(i + " "));
		
		System.out.println("Main thread: " + Thread.currentThread());
        Timer timer = new Timer();
        final long start = System.currentTimeMillis();
        timer.schedule(new TimerTask() {
            @Override
            public void run () {
                System.out.print("Task invoked: " +(System.currentTimeMillis() - start) + " ms");
                System.out.println(" - " + Thread.currentThread());
                timer.cancel();
            }
        }, 1000);
	}
}
