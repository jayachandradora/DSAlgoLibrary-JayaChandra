package test1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

// Custom Executors service, accept callable as input.
// return type future object

public class Test {

	public static void main(String[] args) {

		int arr[] = { 5, 6, 2, 7, 4 };
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int in : arr)
			pq.add(in);

		int fist = pq.poll() - 1;
		int sec = pq.poll() - 1;

		int res = fist * sec;

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "mitu");
		map.put(2, "mitu1");
		map.put(3, "mitu2");

		map.replace(3, "mitu3");

		Set<String> set = new HashSet<>();
		set.add("mitu");
		set.add("mitu1");
		set.add("mitu2");

		Collection<String> col = new ArrayList<String>();
		col.add("mitu");
		col.add("mitu1");
		set.removeAll(col);
		System.out.println(set);
		System.out.println(map.values());
		System.out.println(map.keySet());

		map.clear();
		System.out.println("Clear" + map.keySet());

		map.putIfAbsent(0, "mitu0");
		System.out.println(map.keySet());
		List<String> lst = new ArrayList<String>();
		lst.add("mahi");
		lst.add("Sujii");

		set.addAll(lst);

		System.out.println(set);
		System.out.println(set.containsAll(lst));
		Object[] str = set.toArray();
		System.out.println(map.keySet().toString());

		for (Map.Entry<Integer, String> res1 : map.entrySet())
			System.out.println(res1.getValue());

		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
		while (itr.hasNext())
			System.out.println(itr.next().getValue());

		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		String bstr = Integer.toBinaryString(5);
		int ones = 0;
		int zeros = 0;
		for (char ch : bstr.toCharArray())
			if (ch == '1')
				ones++;
			else
				zeros++;

		System.out.println(ones + " " + zeros);
		
		System.out.println(runLengthCoding("aaaaabbbbbccd"));

	}

	public static String runLengthCoding(String str) {
		if (str.length() == 0)
			return null;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			while (i < str.length()-1 && str.charAt(i) == str.charAt(i + 1)) {
				count++;
				i++;
			}
			sb.append(str.charAt(i));
			sb.append(count);
		}

		return sb.toString();
	}

}

class ExectuorServiceDemo<T> {

	int capacity = 0;
	List<T> taskList = null;

	public ExectuorServiceDemo(int size) {
		this.capacity = size;
		taskList = new ArrayList<T>(size);
	}

	public Future<T> submit(Callable<T> task) throws Exception {

		if (taskList.size() != capacity) {

			return (Future<T>) task.call();

		} else {
			this.wait(1000);
		}
		return null;
	}

}

class Task<T> implements Callable<T> {

	List<T> taskList = null;

	Task(List<T> pTaskList, int size) {
		this.taskList = pTaskList;
	}

	@Override
	public T call() throws Exception {
		return taskList.get(0);
	}

}

interface ExecutorService<T> {
	public void submit(T t);
}