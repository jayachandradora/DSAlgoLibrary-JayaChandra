package arrays;

public class ShortestToChar {

	public static void main(String[] args) {
		String S = "loveleetcode";
		char C = 'e';

		for (int in : shortestToChar(S, C))
			System.out.print(in + "  ");
	}

	static int[] shortestToChar(String S, char C) {
		
		int n = S.length(); 
		int pos = -n;
		int res[] = new int[n];
		
		for (int i = 0; i < n; ++i) {
			if (S.charAt(i) == C)
				pos = i;
			res[i] = i - pos;
		}
		
		for (int i = pos - 1; i >= 0; --i) {
			if (S.charAt(i) == C)
				pos = i;
			res[i] = Math.min(res[i], pos - i);
		}
		return res;
	}

}
