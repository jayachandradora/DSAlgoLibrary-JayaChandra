package stack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {

	public static void main(String args[]) {

		//System.out.println(reverseParentheses("(u(love)i)"));
		
		LocalDate dd = LocalDate.parse("2020-01-01");
		LocalDate now = LocalDate.now();
		while((dd.getYear() <= now.getYear() || dd.getMonthValue()<= now.getMonthValue()
				|| dd.getDayOfMonth() <= now.getDayOfMonth()) && (dd.getYear() != now.getYear()) ) {
			
			dd = dd.plusDays(60);
			System.out.println(dd);
			//System.out.println("Date " + dd.getYear() + "-" + dd.getMonth() + "-" + dd.getDayOfMonth());
		}

		System.out.println("langes date " + dd);
		
		List<Integer> re1 = new ArrayList<>();
		re1.add(1);
		re1.add(5);
		List<Integer> re2 = new ArrayList<>();
		re2.add(1);
		re2.add(3);
		re2.add(7);
		List<Integer> re3 = new ArrayList<>();
		re3.add(2);
		re3.add(4);
		re3.add(3);
		re3.add(6);
		List<List<Integer>> list = new ArrayList<>();
		list.add(re1);
		list.add(re2);
		list.add(re3);
		System.out.println(mergeKList(list));
	}
	
	public static List<Integer> mergeKList(List<List<Integer>> list){
		List<Integer> resList = new ArrayList<>();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) ->  q - p);
		for(List<Integer> ls : list) {
			for(Integer in : ls)
				pq.add(in);
		}
		int size = pq.size();
		for(int i =0; i<size; i++)
			resList.add(pq.poll());
		
		return resList;
	}

	public static String reverseParentheses(String s) {

		Stack<StringBuilder> st = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			
			if (c == '(') {

				st.push(sb);
				sb = new StringBuilder();

			} else if (c == ')') {

				String str = sb.reverse().toString();
				sb = st.pop();
				sb.append(str);

			} else
				sb.append(c);
		}
		
		return sb.toString();
	}
	
	public static void dateRange() {
		LocalDate date = LocalDate.now().minusDays(300);
		//System.out.println("Month " + LocalDate.of(2021, 01, 01).plusDays(60).get);
		System.out.println("Year" + date.getYear());
	}
	
	public static String addToCurrentDate(String format,int day,int month,int year){

        DateFormat dateFormat = new SimpleDateFormat(format);

        Calendar calendarInstance = Calendar.getInstance();
        calendarInstance.add(Calendar.YEAR, year);
        calendarInstance.add(Calendar.MONTH, month);
        calendarInstance.add(Calendar.DATE, day);
        return dateFormat.format(calendarInstance.getTime());
    }
}
