package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrintMinimum {

	public static void main(String[] args) {

		int arr[] = {3,9,5,3,6,7,10};
		printMinimum(arr);
		
		Integer input1 [] = {1,2,3,4,5};
		Integer input2 [] = {1,2,3,0,5};
		printMisingNumInArrays(input1, input2);
		
	}

	static void getMinNumber(int input[]){
		
		Set<Integer> num = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i : input){
			if(!num.add(i))
				map.put(i, map.get(new Integer(i)) + 1);
			else
				map.put(i, 1);
		}
		
	}
	static void printMinimum(int arr[]){
		
		Map<Integer, Integer> intMap = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			if(intMap.containsKey(arr[i]))
				intMap.put(arr[i], intMap.get(arr[i]) +1);
			else
				intMap.put(arr[i], 1);
		}
		
		for(Map.Entry<Integer, Integer> entry : intMap.entrySet())
			System.out.println("Key " + entry.getKey() + " Value " + entry.getValue());
	}
	
	static void printMisingNumInArrays(Integer input1[], Integer input2[]){
		
		Set set = new HashSet<>(Arrays.asList(input2));
		
		for(int i : input1)
			if(set.add(i))
				System.out.println("Missing number " + i );
	}
	
}
