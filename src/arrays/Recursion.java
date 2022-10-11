package arrays;

public class Recursion {

	public static void main(String[] args) {

		System.out.println("Print factorial " + Recursion.fact(3));
	}
	static int fact(int n)
	{
		int temp =0;
	    // wrong base case (it may cause
	    // stack overflow).
	    if (n <= 1) {
	        return 1;
	    }else{
	    	temp = n*fact(n-1);
	    	System.out.println("Print Number " + temp + "   Parameter " + n);
	        return temp ;
	    }
	}
}
