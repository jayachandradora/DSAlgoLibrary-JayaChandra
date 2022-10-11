package arrays;

import java.util.Arrays;


//https://www.geeksforgeeks.org/deep-shallow-lazy-copy-java-examples/
public class ShallowAndDeepCopy {

	private int data[];

	public ShallowAndDeepCopy(int values[]) {

		data = new int[values.length]; // deep copy
		for (int i = 0; i < values.length; i++)
			data[i] = values[i];
		
		// data = values; //shallow copy 
	}

	public void showData() {
		System.out.println(Arrays.toString(data));
	}

	public static void main(String[] args) {

		int values[] = { 1, 4, 5 };

		ShallowAndDeepCopy sd = new ShallowAndDeepCopy(values);

		sd.showData();

		values[1] = 40;

		sd.showData();

	}
}
