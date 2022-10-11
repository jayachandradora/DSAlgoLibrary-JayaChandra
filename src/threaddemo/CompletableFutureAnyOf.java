package threaddemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureAnyOf {

	public static void main(String args[]){
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(2);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Result of Future 1";
		});
		
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(4);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Result of Future 2";
		});

		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Result of Future 3";
		});

		CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);
		
		try {
			System.out.println(anyOfFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} // Result of Future 2
		
		CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(future1, future2, future3);
		try {
			allOfFuture.get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(allOfFuture.isDone());
		System.out.println(future1.isDone());
		System.out.println(future1.isDone());
	}
}
