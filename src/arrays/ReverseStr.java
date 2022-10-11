package arrays;

public class ReverseStr {

	  final int MAX = 100;
	  final int NIL = -1;
	  String ss1 = "AGGTAB";
	  String ss2 = "GXTXAYB";
	  final int m = ss1.length();
	  final int n = ss2.length();
	 
	  int lookup[][] = new int[m][n];
	 
	  /* Function to initialize NIL values in lookup table */
	  void _initialize(int m, int n)
	  {
	    for (int i = 0; i < m; i++)
	    	for (int j = 0; j < n; i++)
	        lookup[i][j] = NIL;
	  }
	
	  /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	  int lcs( char[] X, char[] Y, int m, int n )
	  {
	    if (m == 0 || n == 0)
	      return 0;
	    if(lookup[m][n] == NIL){
	    	if (X[m-1] == Y[n-1])
	    	{
	    		lookup[m][n] = 1 + lcs(X, Y, m-1, n-1);
	  	      return lookup[m][n];
	    	}
	  	    else
	  	      return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
	    }
	    return lookup[m][n];
	  }
	    
	 
	  /* Utility function to get max of 2 integers */
	  int max(int a, int b)
	  {
	    return (a > b)? a : b;
	  }
	 
	  public static void main(String[] args)
	  {
		  ReverseStr lcs = new ReverseStr();
	    String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	    lcs._initialize(m, n);
	    System.out.println("Length of LCS is" + " " +
	                                  lcs.lcs( X, Y, m, n ) );
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static void main(String[] args) {

		String str = "ikkkihhfkrioosppphna";
		
		reverse(str, str.length()-1);
		
		
		String Str = new String("Geeks-for-Geeks");
		 
        // Split above string in at-most two strings  
        for (String val: Str.split("-"))
            System.out.println(val);
 
        System.out.println("");
   
        
		
		
		
	}
	
	static void reverse(String str, int len){
		if(len>=0){
			System.out.print(str.charAt(len));
			reverse(str, len-1);
		}
	}
*/
}
