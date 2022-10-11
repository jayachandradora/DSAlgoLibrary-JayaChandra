package designpattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyURL {

	Map<Integer, String> map = new HashMap<>();
	Random r = new Random();
	int key = r.nextInt(10000);

	public String encode(String longUrl) {
		while (map.containsKey(key))
			key = r.nextInt(100);

		map.put(key, longUrl);
		return "http://tinyurl.com/" + key;
	}

	public String decode(String shortUrl) {
		return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	}

	public static void main(String[] args) {

		TinyURL tiny = new TinyURL();
		String shortURL = tiny.encode("https://leetcode.com/submissions/detail/271543406/");
		
		System.out.println("shortURL " + shortURL);
		System.out.println("Long URL " + tiny.decode(shortURL));
	}

}
