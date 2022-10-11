package threaddemo;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableExample implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		Random randomGenerator = new Random();
		Integer intgerNumber = randomGenerator.nextInt(5);
		Thread.sleep(1000);

		return intgerNumber;
	}
}

public class CallableFutureTest {

	public static void main(String[] args) throws Exception {

		FutureTask<Integer>[] ftask = new FutureTask[5];

		for (int i = 0; i < 5; i++) {
			Callable<Integer> cal = new CallableExample();
			ftask[i] = new FutureTask<>(cal);

			Thread t = new Thread(ftask[i]);
			t.start();
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(ftask[i].get());
		}
	}
}
