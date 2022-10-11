package sorting;

public class RecursionTest {

	public static void main(String[] args) {

		//System.out.println(new RecursionTest().factorial(3)); // Invoke first
																// time
		//System.out.println("substract " + new RecursionTest().substractOne(3));
		
		System.out.println("GCD   " + new RecursionTest().gcd1(90, 10));
	}

	public int factorial(int x) {
		if (x == 1)
			return 1;
		else
			return x * factorial(x - 1);
	}

	

	public int substractOne(int count){
		if(count <= 1){
			return 1;
		} else {
			 return count + substractOne(count - 1) + substractOne(count - 2);
		}
	}
	
	public int gcd(int a, int b)
	{
	  if(a == 0 || b == 0) return a+b; // base case
	  return gcd(b,a%b);
	}
	
	public int gcd1(int a, int b)
	{
	  if( b == 0) return a; // base case
	  return gcd1(b,a%b);
	}
}
