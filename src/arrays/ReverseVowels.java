package arrays;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

	public static void main(String[] args) {

		
		String str = "hello";
		char list[] = str.toCharArray();
		Set<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		
		for (int i = 0, j = list.length - 1; i < j;) {
			if (!set.contains(list[i])) {
				i++;
				continue;
			}
			if (!set.contains(list[j])) {
				j--;
				continue;
			}
			char temp = list[i];
			list[i] = list[j];
			list[j] = temp;
			i++;
			j--;
		}
		System.out.println(String.valueOf(list));
			
	}

}
