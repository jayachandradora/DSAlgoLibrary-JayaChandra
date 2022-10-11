package recursion;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.add(1);
		st.add(2);
		st.add(3);
		st.add(4);
		st.add(5);
		st.add(6);
		
		for(int in : st)
			System.out.print(in + " ");
		
		Stack<Integer> stTemp = reverseStack(st);
		for(int in : stTemp)
			System.out.print(in + " ");
	}

	static Stack<Integer> reverseStack(Stack<Integer> st){
		if(st.size() == 0)
			return st;
		
		solve(st);
		return st;
		
	}
	static void solve(Stack<Integer> st){
		if(st.size() == 1) {
			return;
		}
		int temp = st.pop();
		solve(st);
		st.add(temp);
	}
}
