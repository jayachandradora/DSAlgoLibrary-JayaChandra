package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeString {

	public static void main(String[] args) {
		System.out.println(reorganizeString("abab"));

	}

	public static String reorganizeString(String s) {
		
		Map<Character, Integer> map = new HashMap<>();
		Queue<Pair1> queue = new PriorityQueue<>((a, b) -> b.number - a.number);
		StringBuilder output = new StringBuilder();

		for (Character ch : s.toCharArray())
			map.put(ch, map.getOrDefault(ch, 0) + 1);

		for (Map.Entry<Character, Integer> entry : map.entrySet())
			queue.add(new Pair1(entry.getValue(), entry.getKey()));

		while (queue.size() > 1) {
			Pair1 p1 = queue.poll();
			Pair1 p2 = queue.poll();

			output.append(p1.ch);
			output.append(p2.ch);

			if (p1.number > 1) {
				p1.setNumber(p1.getNumber() - 1);
				queue.add(p1);
			}

			if (p2.number > 1) {
				p2.setNumber(p2.getNumber() - 1);
				queue.add(p2);
			}
		}

		if (queue!= null && queue.size() ==1 && queue.peek().number == 1)
			return output.append(queue.poll().ch).toString();
		
		if(queue.size() == 0)
			return output.toString();
		
		return "";
	}

}

class Pair1 {
	int number;
	char ch;

	Pair1(int number, char ch) {
		this.number = number;
		this.ch = ch;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

}