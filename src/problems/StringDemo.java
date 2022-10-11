package problems;

import java.util.HashMap;
import java.util.Map;

public class StringDemo {

	public static void main(String[] args) {

		

		
	}
	
	public static void findMaximumEvents(String[] eventDetails) {
	        /*
	         * Write your code here.
	         */
		Map values=new HashMap();
		for (String event : eventDetails) {

			String[] hours = event.split(" ");
			if (values.keySet().contains(hours[0])) {
				int endslot = (Integer) values.get(hours[0]);
				int input = Integer.parseInt(hours[1]);
				if (endslot > input) {
					values.put(endslot, input);
				}
			} else {
				values.put(hours[0], hours[1]);
			}
		}
	    
			
		 }

}
