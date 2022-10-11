package recursion;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

	public static void main(String[] args) {

		Stack<Integer> st = new Stack<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(4);
				add(5);
				add(6);
			}
		};

		for (int in : deleteMiddle(st))
			System.out.print(in + " ");
		
		System.out.println(removeKdigits("1234567890", 9));
	}

	
	 public static String removeKdigits(String num, int k) {
	        
		 	if(k == 0)
	            return num;
	        
	        Stack<Character> st = new Stack<Character>();
	        StringBuilder sb = new StringBuilder();
	        
	        for(char digit : num.toCharArray()){
	            if(st.isEmpty()){
	                st.push(digit);
	                sb.append(digit);
	            }else{
	                if(st.peek()>digit && k !=0){
	                    st.pop();
	                    k--;
	                    sb.deleteCharAt(sb.length()-1);  
	                }
	                st.push(digit);
	                sb.append(digit);
	            }
	        }
	        
	        //incase k !< 0
	        while(k !=0){
	            sb.deleteCharAt(sb.length()-1); 
	            k--;
	        }
	        
	        
	        //Remove leading zeros
	        int i = 0; 
		    while (i < sb.length() && sb.charAt(i) == '0') 
		        i++; 
		        
		    sb.replace(0, i, ""); 
	        return sb.toString().length() == 0 || sb.toString() == "" ? "0" :  sb.toString();
	        
	    }
	static Stack<Integer> deleteMiddle(Stack<Integer> st) {
		
		if (st.size() == 0)
			return st;
		
		int k = st.size() / 2 + 1;
		
		solve(st, k);
		
		return st;
	}

	private static void solve(Stack<Integer> st, int k) {

		if (k == 1) {
			st.pop();
			return;
		}

		int temp = st.pop();
		solve(st, k - 1);
		st.push(temp);
		return;
	}
}
