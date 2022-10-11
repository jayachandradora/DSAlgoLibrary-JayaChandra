package logstash;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//https://stackoverflow.com/questions/35504385/run-logstash-in-java-program
public class LogstashBatFileTest {
	public static void main(String[] args) {

		Future<Process> future = CompletableFuture.supplyAsync(()-> asyncMethod());
		try {
			Thread.sleep(150);
			Process process = future.get();
			process.destroy();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
	}

	public static Process asyncMethod() {
		String cmd = "cmd /c start D:\\logstash-6.5.4\\JDFiles\\LogStash_UATPCS_Local.bat";

		Process logstashProcess = null;
		try {
			logstashProcess = Runtime.getRuntime().exec(cmd);
			System.out.println(logstashProcess.info().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return logstashProcess;
	}
}
