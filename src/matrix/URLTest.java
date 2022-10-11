package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class URLTest {

	public static void main(String[] args) {

		/*URL url;
		try {
			url = new URL("https://ecs-uat.flexnetoperations.com/registry/api/v1/downloadpackages/rs_dp_id_008");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// Set Headers
			conn.setRequestProperty("x-publisherid", "1102");
			conn.setRequestProperty("accept", "application/json");
			conn.setReadTimeout(60 * 100000);
			conn.setConnectTimeout(60 * 10000000);
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Request Failed. HTTP Error Code: " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer jsonString = new StringBuffer();
			String line;
			
			while ((line = br.readLine()) != null) {
				jsonString.append(line);
			}

			System.out.println(jsonString.toString());
			br.close();
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		System.out.println(test("jaya", "jaya"));
		System.out.println(count("jaay", "jaya"));

	}

	
	static boolean test(String s1, String s2) {
		
		if(s1.length() != s2.length())
			return false;
		
		char ch[] = s1.toCharArray();
		char ch1[] = s2.toCharArray();
		
		Arrays.sort(ch);
		Arrays.sort(ch1);
		
		if(Arrays.equals(ch, ch1))
			return true;
		else
			return false;
	}
	
	static int count(String str, String st) {
		int count = 0;
		int n = st.length();
		if(str.length() < st.length())
			return count;
		
		for(int i=0; i<=str.length() -n; i++) {
			String temp = str.substring(i, n+i);
			if(test(temp, st))
				count++;
		}
			
		return count;
	}
}
