package dp;

public class IsSubsequence {

	public static void main(String[] args) {

		String s = "abc";
		String t = "ahbgdc";
		//1nd soln with LCS
		char[] X = s.toCharArray();
		char[] Y = t.toCharArray();
		int m = X.length;
		int n = Y.length;
		if(s.length() == lcs(X, Y, m, n))
			System.out.println("Is SubSequence " + "true");
		else
			System.out.println("Is SubSequence " + "false");
		
		//2nd soln
		System.out.println(isSubsequence(s, t));

	}

	static boolean isSubsequence(String s, String t) {
		int i = 0;
		for (int j = 0; i < s.length() && j < t.length(); j++) {
			if (s.charAt(i) == t.charAt(j))
				++i;
		}
		return i == s.length();
	}
		
	static boolean isSubsequenceRec(String s, String t) {
	    return helper(s, t, 0, 0);
	}

	static boolean helper(String s, String t, int s_start, int t_start){
	    if(s_start == s.length()){
	        return true;
	    }else if(t_start == t.length()){
	        return false;
	    }
	    while(s.charAt(s_start) != t.charAt(t_start++)){
	        if(t_start == t.length()){
	            return false;
	        }
	    }
	    return helper(s, t, s_start + 1, t_start);
	}
	
	static int lcs(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (X[m - 1] == Y[n - 1]) {
			return 1 + lcs(X, Y, m - 1, n - 1);
		}else
			return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
	}
}
