package matrix;

import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=ngjl9cvUJqQ
//https://www.youtube.com/watch?v=rJ9NFK9s_mI&ab_channel=PrakashShukla
public class ValidSudoku {

	static boolean validSudoku(char board[][]) {

		Set<String> visited = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!visited.add(board[i][j] + "row" + i) || !visited.add(board[i][j] + "columun" + j))
						return false;
					if (!visited.add(board[i][j] + "box" + (i / 3) * 3 + j / 3))
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(validSudoku(board));

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(reverseInteger(321));
	}

	public static boolean isPalindrome(String s) {

		if (s == null || s.length() == 0)
			return true;

		int l = 0, r = s.length() - 1;

		while (l < r) {
			if (!Character.isLetterOrDigit(s.charAt(l))) {
				++l;
			} else if (!Character.isLetterOrDigit(s.charAt(r))) {
				--r;
			} else if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
				return false;
			} else {
				++l;
				--r;
			}
		}
		return true;
	}

	static int reverseInteger(int x) {
		int pop = 0;
		int rev = 0;
		while (x != 0) {
			pop = x % 10;
			x = x / 10;
			rev = rev * 10 + pop;
		}

		return rev;
	}
}
