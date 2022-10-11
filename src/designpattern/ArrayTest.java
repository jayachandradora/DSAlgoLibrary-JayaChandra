package designpattern;

import java.util.HashSet;

public class ArrayTest {

	static final int NO_OF_CHARS = 256;

	static int longestUniqueSubsttr(String str) {
		int n = str.length();
		int cur_len = 1; // length of current substring
		int max_len = 1; // result
		int prev_index; // previous index
		int i;
		int visited[] = new int[NO_OF_CHARS];

		/*
		 * Initialize the visited array as -1, -1 is used to indicate that
		 * character has not been visited yet.
		 */
		for (i = 0; i < NO_OF_CHARS; i++) {
			visited[i] = -1;
		}

		/*
		 * Mark first character as visited by storing the index of first
		 * character in visited array.
		 */
		visited[str.charAt(0)] = 0;

		/*
		 * Start from the second character. First character is already processed
		 * (cur_len and max_len are initialized as 1, and visited[str[0]] is set
		 */
		for (i = 1; i < n; i++) {
			prev_index = visited[str.charAt(i)];

			/*
			 * If the current character is not present in the already processed
			 * substring or it is not part of the current NRCS, then do
			 * cur_len++
			 */
			if (prev_index == -1 || i - cur_len > prev_index)
				cur_len++;

			/*
			 * If the current character is present in currently considered NRCS,
			 * then update NRCS to start from the next character of previous
			 * instance.
			 */
			else {
				/*
				 * Also, when we are changing the NRCS, we should also check
				 * whether length of the previous NRCS was greater than max_len
				 * or not.
				 */
				if (cur_len > max_len)
					max_len = cur_len;

				cur_len = i - prev_index;
			}

			// update the index of current character
			visited[str.charAt(i)] = i;
		}

		// Compare the length of last NRCS with max_len and
		// update max_len if needed
		if (cur_len > max_len)
			max_len = cur_len;

		return max_len;
	}

	public static int lengthOfLongestSubstring(String s) {
	    if(s==null||s.length()==0){
	        return 0;
	    }
	    int result = 0;
	    int k=0;
	    HashSet<Character> set = new HashSet<Character>();
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(!set.contains(c)){
	            set.add(c);
	            result = Math.max(result, set.size());
	        }else{
	            while(k<i){
	                if(s.charAt(k)==c){
	                    k++;
	                    break;
	                }else{
	                    set.remove(s.charAt(k));
	                    k++;
	                }
	            }
	        }  
	    }
	 
	    return result;
	}
	/* Driver program to test above function */
	public static void main(String[] args) {
		String str = "java2novice";
		
		System.out.println("Longest str " + lengthOfLongestSubstring(str));
		System.out.println("The input string is " + str);
		int len = longestUniqueSubsttr(str);
		System.out.println("The length of " + "the longest non repeating character is " + len);
		
		/*int arr[] = {-2,1,-3,4,-1,2,1,-5};
		System.out.println(maxSubArray(arr));*/
		
		System.out.println( "count " + countAndSay(1211));
		
	}

	
		static int maxSubArray(int[] A) {
			int max = A[0];
			int[] sum = new int[A.length];
			sum[0] = A[0];
	 
			for (int i = 1; i < A.length; i++) {
				sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
				max = Math.max(max, sum[i]);
			}
	 
			return max;
		}
		
		 public int maxSubArray1(int[] A) {
		       int newsum=A[0];
		       int max=A[0];
		       for(int i=1;i<A.length;i++){
		           newsum=Math.max(newsum+A[i],A[i]);
		           max= Math.max(max, newsum);
		       }
		       return max;
		    }
		 static String countAndSay(int n) {
				if (n <= 0)
					return null;
			 
				String result = "1";
				int i = 1;
			 
				while (i < n) {
					StringBuilder sb = new StringBuilder();
					int count = 1;
					for (int j = 1; j < result.length(); j++) {
						if (result.charAt(j) == result.charAt(j - 1)) {
							count++;
						} else {
							sb.append(count);
							sb.append(result.charAt(j - 1));
							count = 1;
						}
					}
			 
					sb.append(count);
					sb.append(result.charAt(result.length() - 1));
					result = sb.toString();
					i++;
				}
			 
				return result;
			}
}

