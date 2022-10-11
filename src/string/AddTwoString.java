package string;

public class AddTwoString {

	public static void main(String[] args) {
		System.out.println(addStrings("22", "199"));
		System.out.println(addBinary("101", "1"));
		System.out.println(minFlipsMonoIncr("00110001"));
	}
	
	public static int minFlipsMonoIncr(String s) {
        int oneCnt = 0;
        int res = 0;
        
        for(char c : s.toCharArray()){
            if(c=='1')
                oneCnt++;
            else
                res = Math.min(res+1, oneCnt);
        }
        return res;
    }

	
	 public static String addBinary(String a, String b) {
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

	public static String addStrings(String num1, String num2) {
		String ans = "";

		int it1 = num1.length() - 1;
		int it2 = num2.length() - 1;
		int carry = 0;
		int sum = 0;
		while (it1 >= 0 && it2 >= 0) {
			int digit1 = num1.charAt(it1) - '0';
			int digit2 = num2.charAt(it2) - '0';
			sum = digit1 + digit2 + carry;
			carry = sum / 10;
			sum = sum % 10;
			ans = sum + ans;
			it1--;
			it2--;
		}

		while (it1 >= 0) {
			int digit1 = num1.charAt(it1) - '0';
			sum = digit1 + carry;
			carry = sum / 10;
			sum = sum % 10;

			ans = sum + ans;

			it1--;
		}

		while (it2 >= 0) {
			int digit2 = num2.charAt(it2) - '0';
			sum = digit2 + carry;
			carry = sum / 10;
			sum = sum % 10;
			ans = sum + ans;

			it2--;
		}

		if (carry == 1) {
			ans = "1" + ans;
		}

		return ans;

	}
}
