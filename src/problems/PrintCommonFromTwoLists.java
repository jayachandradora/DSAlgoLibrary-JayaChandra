package problems;

import java.util.ArrayList;
import java.util.List;

public class PrintCommonFromTwoLists {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);

		List<Integer> list3 = new ArrayList<Integer>(list2);
		list3.retainAll(list1);
		System.out.println("" + list3);

		//2nd approach.
		
		List list = new ArrayList();
		list.add(1);
		list.add(3);
		list.add(6);
		list.add(7);
		list.add(9);
		
		List list4 = new ArrayList();
		list4.add(2);
		list4.add(5);
		list4.add(6);
		list4.add(1);
		
		//Get the common elements between list1 and list2
		list4.removeAll(list);
		System.out.println("Common Elements are : "+list4);
	}

}
