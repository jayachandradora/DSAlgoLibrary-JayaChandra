package intv.low.level.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		String s = "LVIII";
		int output = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			int num = map.get(s.charAt(i));

			if (output <= num)
				output = output + num;
			else
				output = output - num;
		}

		System.out.println(output);
		
		TreeMap<Integer, String> numMap = new TreeMap<Integer, String>();
		  
        // Insert the values
        numMap.put(6, "Six");
        numMap.put(1, "One");
        numMap.put(5, "Five");
        numMap.put(3, "Three");
        numMap.put(8, "Eight");
        numMap.put(10, "Ten");
  
        // Print the Values of TreeMap
        System.out.println("TreeMap: " + numMap.toString());
  
        // Get the greatest key mapping of the Map
  
        // As here 11 is not available it returns 10 because ten is less than 11
        System.out.print("Floor Entry of Element 11 is: ");
        System.out.println(numMap.floorKey(11));
  
        // This will give null
        System.out.print("Floor Entry of Element 0 is: ");
        System.out.println(numMap.floorKey(7));
	}

}
