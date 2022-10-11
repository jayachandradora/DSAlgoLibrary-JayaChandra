package intv.dp;

//LCS big brother soln
public class EditDistanceLCS {

	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";
		char X[] = str1.toCharArray();
		char Y[] = str2.toCharArray();
		int m = X.length;
		int n = Y.length;
		System.out.println(editDist(X, Y, m, n)); // Soln for 3 operation 
		
		//Soln for 2 operation Insert and delete.
		System.out.println(editDistanceWith2Ops(str1, str2));
	}
	// This soln for 3 operations insert, delete & replace
	static int editDist(char X[], char Y[], int m, int n) {
		// If first string is empty, insert all characters of second string
		if (m == 0)
			return n;

		// If second string is empty, remove all characters of first string
		if (n == 0)
			return m;

		// last character matched then simply ignore
		if (X[m - 1] == Y[n - 1])
			return editDist(X, Y, m - 1, n - 1);

		// If last characters are not same, consider all three
		// operations on last character of first string, recursively
		// compute minimum cost for all three operations and take
		// minimum of three values.
		return 1 + min(editDist(X, Y, m, n - 1), // Insert
				editDist(X, Y, m - 1, n), // Remove
				editDist(X, Y, m - 1, n - 1) // Replace
		);

	}

	static int min(int x, int y, int z) {
		if (x <= y && x <= z)
			return x;
		if (y <= x && y <= z)
			return y;
		else
			return z;
	}

	// Edit distance(2 operations) with delete, insert operations.  
	static int editDistanceWith2Ops(String X, String Y) { 
        // Find LCS  
        int m = X.length(), n = Y.length(); 
        int L[][] = new int[m + 1][n + 1]; 
        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= n; j++) { 
                if (i == 0 || j == 0) { 
                    L[i][j] = 0; 
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) { 
                    L[i][j] = L[i - 1][j - 1] + 1; 
                } else { 
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]); 
                } 
            } 
        } 
        int lcs = L[m][n]; 
  
        // Edit distance is delete operations + insert operations.  
        return (m - lcs) + (n - lcs); 
    } 
	

}
