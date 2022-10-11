package logstash;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://stackoverflow.com/questions/35504385/run-logstash-in-java-program
public class LogstashTest {
	//ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "logstash -f D:\\logstash-6.5.4\\bin\\sql.conf");
	public static void main(String[] args) {

		try {
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"D:\\logstash-6.5.4\\bin\" && logstash -f Talend_SQL.conf --config.reload.automatic");
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line1;
			while (true) {
				line1 = r.readLine();
				if (line1 == null) {
					break;
				}
				System.out.println(line1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	//@Async
	public void asyncMethod() {
		System.out.println("  @Async\r\n" + 
				"");
	}
}
