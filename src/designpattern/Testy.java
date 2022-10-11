package designpattern;

import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Testy {
	
	public static void main(String args[]) {
		
		String str = "https://flexera1000-uat.flexnetoperations.com/flexnet";
		System.out.println(".........   " + str.substring(0, str.indexOf("/flexnet")));
		
		Base64.Encoder encoder = Base64.getEncoder();
        String str1 = encoder.encodeToString(("ashyam@flexerasoftware.com").getBytes());
        
        System.out.println("EncodedToken " + str1+"sS/64H0668leYYmylrXrKA==");
        
        Base64.Decoder decode = Base64.getDecoder();
        System.out.println("----  "+ decode.decode(str));
		
		int arr[] = {1,1,1,2,3,4,5,5,5};
		
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)-> b.getValue() - a.getValue());
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());		
		queue.add(5);
		queue.add(1);
		queue.add(3);
		queue.add(10);
		queue.add(11);
		
		System.out.println("pq " + queue);
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int in : arr)
			map.put(in, map.getOrDefault(in, 0)+1);
		
		pq.addAll(map.entrySet());
		
		int count =0;
		while(count <2) {
			System.out.println(pq.poll().getKey());
			count++;
		}
		
		System.out.println("index of "+"jayaaaaaa".indexOf("aaa", 4));
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
	}
}

class IntC implements Comparator<Integer>{
	
	@Override
	public int compare(Integer a, Integer b) {
		return b -a;
	}
}
