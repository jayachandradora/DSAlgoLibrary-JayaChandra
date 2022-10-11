package practice;

public class AddBinary {

	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		String a = "11", b = "1";
		System.out.println(ab.addBinary1(a, b));
	}
	
	public String addBinary1(String a, String b) {
		
		StringBuilder sum = new StringBuilder();
		
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		
		while (i >= 0 || j >= 0 || carry == 1) {
			
			int digitA = i < 0 ? 0 : a.charAt(i--) - '0';
			int digitB = j < 0 ? 0 : b.charAt(j--) - '0';
			
			sum.insert(0, (digitA + digitB + carry) % 2);
			
			carry = (digitA + digitB + carry) / 2;
		}
		return sum.toString();
	}
	
	public String addBinary(String a, String b) {
	    StringBuilder sb = new StringBuilder();
	 
	    int i=a.length()-1;
	    int j=b.length()-1;
	 
	    int carry = 0;
	 
	    while(i>=0 || j>=0){
	        int sum=0;
	 
	        if(i>=0 && a.charAt(i)=='1'){
	            sum++;    
	        }
	 
	        if(j>=0 && b.charAt(j)=='1'){
	            sum++;
	        }
	 
	        sum += carry;
	 
	        if(sum>=2){
	            carry=1;
	        }else{
	            carry=0;
	        }
	 
	        sb.insert(0,  (char) ((sum%2) + '0'));
	 
	        i--;
	        j--;
	    }
	 
	    if(carry==1)
	        sb.insert(0, '1');
	 
	    return sb.toString();
	}
}
