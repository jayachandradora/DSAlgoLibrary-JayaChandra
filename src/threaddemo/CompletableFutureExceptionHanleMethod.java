package threaddemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExceptionHanleMethod {

	public static void main(String[] args) {

		Integer age = -1;

		CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
			if (age < 0) 
				throw new IllegalArgumentException("Age can not be negative");
			if (age > 18) 
				return "Adult";
			else 
				return "Child";
		}).handle((res, ex) -> {
			if (ex != null) {
				System.out.println("Oops! We have an exception - " + ex.getMessage());
				return "Unknown!";
			}
			return res;
		});

		try {
			System.out.println("Maturity : " + maturityFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
