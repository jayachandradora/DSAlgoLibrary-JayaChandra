package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class VectorDemo {

	public static void main(String[] args) {

		int arr[] = {1,4,2,4,5,9,7};
		List<Integer> vc = new CopyOnWriteArrayList<Integer>();
		vc.add(3);
		vc.add(2);
		vc.add(7);
		vc.add(4);
		vc.add(1);
		vc.add(8);
		vc.add(8);
		Arrays.sort(arr);
		Collections.sort(vc);
		
		for(int i : vc)
			System.out.println(i);
		
		for (int i : arr)
			System.out.print(i);
	}

}
