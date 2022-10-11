package ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TTest {

	public static void main(String[] args) {

		int nums[] = { 1,3,4,2,2};
		
		System.out.println(findDuplicate(nums));
		
		char ch = '2';
		System.out.println("charater " + ch);
		
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);

		for(int i=0;i<list.size();i++)
			list.remove(i);
		
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String,Integer>>(
				(a, b) -> b.getValue() - a.getValue());
		
		
		String vowel = "aeiouAEIOU";
		if(vowel.indexOf("ou")>=0)
			System.out.println("vowel " + vowel.indexOf("ou"));
		else
			System.out.println("consonent " + vowel.indexOf('n') );
		
		
		String Str = new String("Welcome to geeksforgeeks");
		System.out.println(Str.substring(10));
		
		System.out.println(Str.substring(10, 16));
		
		
		Integer obj = new Integer(10);
		System.out.println(obj.toString(5, 2));
		
		
		List<String> lst = new ArrayList<>();
		lst.add("jaya");
		lst.add("mahi");
		lst.add("mahi");
		lst.add("jaya");
		lst.add("mahi");
		lst.add("mahi");
		lst.add("Suji");
		lst.add("jaya");
		lst.add("jaya");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String str : lst) {
			if(!map.containsKey(str))
				map.put(str, 1);
			else
				map.put(str, map.getOrDefault(str, 0)+1);
			
		}
		
		for(Map.Entry<String, Integer> record : map.entrySet())
			pq.add(record);
			
		System.out.println(pq.peek().getKey());
	}
	
	public static int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }
        
        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }
}
