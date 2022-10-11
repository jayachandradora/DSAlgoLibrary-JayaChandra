package javademo.programming;

public class StringPalindrome {

	public static void main(String[] args) {

		String str = "aabaa";
		char ch [] = str.toCharArray();
		for(int i=0; i<ch.length/2; i++){
			char temp = ch[i];
			ch[i] = ch[ch.length-i-1];
			ch[ch.length-i-1] = temp;
		}
		
		String reverseStr = new String(ch);
		System.out.println(reverseStr);
		if(reverseStr.equals(str))
			System.out.println("Palinedrome");
		else
			System.out.println("Not a Palinedrome");
	}
}
