package sorting;

public class JumblingRotation {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		int d = 3;
		int gcd = new JumblingRotation().gcd(arr.length, d);
		
		int n = 12;
		int temp =0;
		int j=0;
		int k=0;
		
		for(int i=0; i<gcd; i++){
			 temp = arr[i];
			 j = i;
			
			while( 1 != 0){
				 k = j + d;
				 if(k >= n)
					 k = k - n;
				 if(k==i)
					 break;
				 
				 arr[j] = arr[k];
				 j = k;
				 
			}
			arr[j] = temp;		
		}
		
	}
	
	public int gcd(int a, int b)
	{
	  if(a == 0 || b == 0) return a+b; // base case
	  return gcd(b,a%b);
	}

}
