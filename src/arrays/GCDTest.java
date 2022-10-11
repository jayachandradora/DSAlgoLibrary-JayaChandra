package arrays;

public class GCDTest {

	public static void main(String[] args) {

		System.out.println("GCD " +gcd(21,7));
		
		for(int i =0; i<10; i+=2)
			System.out.print(i + "  ");
	}

	static int gcd(int a, int b){
		if(b == 0)
			return a;
		else 
			return gcd(b, a%b);
	}
}
